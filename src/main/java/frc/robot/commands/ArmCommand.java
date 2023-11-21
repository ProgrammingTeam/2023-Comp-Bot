// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmCommand extends CommandBase {
  private Arm m_Arm;
  private final int m_armMovment;
  boolean armUp;

  /** Creates a new ArmCommand. */
  public ArmCommand(Arm SubArm, int moveArm) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Arm = SubArm;
    m_armMovment = moveArm;
    addRequirements(m_Arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (m_armMovment) {
      case 1:
        armUp = true;
        break;

      default:
        armUp = false;
        break;
    }
    SmartDashboard.putBoolean("is the arm up ", armUp);
    m_Arm.openGrabber(armUp);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
