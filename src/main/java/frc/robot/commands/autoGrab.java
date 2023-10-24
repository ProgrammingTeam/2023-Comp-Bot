// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Grabber;

public class autoGrab extends CommandBase {
  private Grabber m_autoGrab;
  private int m_autoinorout;
  private double autoGrabbySpeed;
  /** Creates a new autoGrab. */
  public autoGrab(Grabber autoGrab, int autoinnerOrOuter) {
    m_autoGrab = autoGrab;
    m_autoinorout = autoinnerOrOuter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_autoGrab);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (m_autoinorout) {
      case 1: autoGrabbySpeed = Constants.grabberMotorSpeed;
      break;
      case 2: autoGrabbySpeed = -Constants.grabberMotorSpeed;
      break;
      default: autoGrabbySpeed = 0;
      break;  
    } 
    m_autoGrab.setMotors(autoGrabbySpeed);
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
