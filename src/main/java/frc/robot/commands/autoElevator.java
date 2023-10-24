// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

public class autoElevator extends CommandBase {
  private Elevator m_Elevator;
  private final int m_autoDirection;
  double autoSpeed;
  double Enc_Position;
  double max_Position = 5;
  boolean metDistance = false;

  /** Creates a new autoElevator. */
  public autoElevator(Elevator autoSystem, int autoIndicater) {
    m_Elevator = autoSystem;
    m_autoDirection = autoIndicater;
    addRequirements(m_Elevator);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Elevator.setMotors(0);
    m_Elevator.Enc_Left.setPosition(0);
 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  
    Enc_Position = m_Elevator.Enc_Left.getPosition();

    switch (m_autoDirection) {

      case 1: autoSpeed = Constants.elevatorUpSpeed;
              metDistance = Enc_Position <= -max_Position;
              break;
      case 2: autoSpeed = -Constants.elevatorDownSpeed;
              metDistance = Enc_Position >= max_Position;
              break;
      default: autoSpeed = 0.0;
              break;
    }
    m_Elevator.setMotors(autoSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   m_Elevator.setMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (metDistance);
  }
}
