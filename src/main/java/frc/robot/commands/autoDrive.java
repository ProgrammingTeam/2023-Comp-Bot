// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class autoDrive extends CommandBase {
  private final DriveTrain m_DriveTrain;
  private final int autoDirection;
  double autoDriveSpeed;
  double reverseDriveSpeed;
  double drive_Enc_position;
  double driveRight_Enc_position;
  double maxLeftDrive_position = 6;
  double maxReverseLeftDrive_position = -61;
  double maxRighttDrive_position = 16;
  boolean metDriveDistance;

  /** Creates a new autoDrive. */
  public autoDrive(DriveTrain automonusDrive, int driveDirection, int rev_dist) {
    m_DriveTrain = automonusDrive;
    maxReverseLeftDrive_position = rev_dist;
    autoDirection = driveDirection;

    addRequirements(m_DriveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_DriveTrain.setMotors(0, 0);
    m_DriveTrain.Enc_moveLeft.setPosition(0);
    m_DriveTrain.Enc_moveRight.setPosition(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive_Enc_position = m_DriveTrain.Enc_moveLeft.getPosition();
    driveRight_Enc_position = m_DriveTrain.Enc_moveRight.getPosition();
    switch (autoDirection) {

      case 1:
        autoDriveSpeed = Constants.autoDrive;
        reverseDriveSpeed = 0;
        metDriveDistance = drive_Enc_position >= maxLeftDrive_position;
        break;
      case 2:
        autoDriveSpeed = -Constants.autoBackDrive;
        metDriveDistance = drive_Enc_position <= maxReverseLeftDrive_position;
        break;
      case 3:
        autoDriveSpeed = 0;
        reverseDriveSpeed = -Constants.autoReverseDrive;
        break;
      case 4:
        autoDriveSpeed = 0;
        reverseDriveSpeed = Constants.autoReverseDrive;
        break;
      default:
        autoDriveSpeed = 0;
        reverseDriveSpeed = 0;
        break;
    }
    m_DriveTrain.setMotors(autoDriveSpeed, reverseDriveSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveTrain.setMotors(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (metDriveDistance);
  }
}
