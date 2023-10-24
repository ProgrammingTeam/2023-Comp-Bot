// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase {
  private final DriveTrain m_drive;
  private final Supplier<Double> m_speedL, m_speedR;

  /** Creates a new ArcadeDrive. */
  public DriveCommand(DriveTrain drive, Supplier<Double> speedL, Supplier<Double> speedR) {
    m_speedL = speedL;
    m_speedR = speedR;
    m_drive = drive;
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drive.setMotors(0,0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //double leftStickY = joystickOI.Y_Axis();
  //Robot.drive.setLeftMotors(leftStickY);
    double Speed = m_speedL.get();
    double Rotation = m_speedR.get();

    m_drive.setMotors(Speed, Rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.setMotors(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
