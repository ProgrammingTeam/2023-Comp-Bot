// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class AutoArm extends CommandBase {
  private Arm m_Arm;
  private final int m_AutoArmMovment;
  boolean armLocation;
  /** Creates a new AutoArm. */
  public AutoArm(Arm AutoArm, int autMove) {
    m_Arm = AutoArm;
    m_AutoArmMovment = autMove;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (m_AutoArmMovment) {
      case 1: armLocation = true;
      break;
      default: armLocation = false;
      break;
    }
    m_Arm.openGrabber(armLocation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
