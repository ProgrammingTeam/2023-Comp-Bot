// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Grabber;

public class autoCubeorCone extends CommandBase {
  private Grabber m_Grabber;
  private int m_AutoCubeorCone;
  boolean coneCubechooser; 
  /** Creates a new autoCubeorCone. */
  public autoCubeorCone(Grabber autoGrab, int autoPickup) {
    m_Grabber = autoGrab;
    m_AutoCubeorCone = autoPickup;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Grabber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (m_AutoCubeorCone) {
      case 1: coneCubechooser = true;
      break;
      default: coneCubechooser = false;
      break;
    }
    m_Grabber.openGrabber(coneCubechooser);
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
