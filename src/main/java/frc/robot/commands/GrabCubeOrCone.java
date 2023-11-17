// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Grabber;

public class GrabCubeOrCone extends CommandBase {
  private Grabber m_coneOrCube;
  private final int m_selector;
  boolean openClaw;
  /** Creates a new GrabCubeOrCone. */
  public GrabCubeOrCone(Grabber coneOrCube, int selector) {
    m_coneOrCube = coneOrCube;
    m_selector = selector;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_coneOrCube);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch (m_selector) {
      case 1:  openClaw = true;
      break;
      
      default: openClaw = false;
      break;
    }
    SmartDashboard.putBoolean("Is the claw open ", openClaw);
    m_coneOrCube.openGrabber(openClaw);
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
