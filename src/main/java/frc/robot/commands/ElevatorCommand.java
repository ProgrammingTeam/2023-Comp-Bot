// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

public class ElevatorCommand extends CommandBase {
  private Elevator m_Elevator;
  private final int m_direction;
  double elevatorSpeed;

  /** Creates a new ElevatorCommand. */
  public ElevatorCommand(Elevator system, int indicater) {
    m_Elevator = system;
    m_direction = indicater;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Elevator.setMotors(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    switch (m_direction) {

      case 1:
        elevatorSpeed = Constants.elevatorUpSpeed;
        break;
      case 2:
        elevatorSpeed = -Constants.elevatorDownSpeed;
        break;
      default:
        elevatorSpeed = 0.0;
        break;

    }
    m_Elevator.setMotors(elevatorSpeed);
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
