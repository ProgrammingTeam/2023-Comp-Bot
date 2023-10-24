// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Grabber;
public class GrabCommand extends CommandBase {
private Grabber m_Grabber;
private final int m_inOrOut;


double grabbySpeed;
  /** Creates a new GrabCommand. */
  public GrabCommand(Grabber grabs, int innerOrOuter) {
  m_Grabber = grabs;
  m_inOrOut = innerOrOuter;   

// Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Grabber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Grabber.setMotors(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (m_inOrOut) {
  case 1: grabbySpeed = Constants.grabberMotorSpeed;
  break;
  case 2: grabbySpeed = -Constants.grabberMotorSpeed;
  break;
  default: grabbySpeed = 0;
  break;     
    }
    m_Grabber.setMotors(grabbySpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
