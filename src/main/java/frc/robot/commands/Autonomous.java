// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Grabber;
import frc.robot.commands.wait;
/** The main autonomous command to pickup and deliver the soda to the box. */
public class Autonomous extends SequentialCommandGroup {
  
  /** Create a new autonomous command. */
// public Autonomous(Elevator subsystem) {
  //  Commands.sequence(new autoElevator(subsystem,1));
  //}
  /*public Autonomous(DriveTrain subsystem) {
    Commands.sequence(new autoDrive(subsystem, 1));
    
  }
*/
  public Autonomous (Arm m_Arm, DriveTrain m_drive, Grabber m_Grab) {
     addCommands(
      new AutoArm(m_Arm, 1),
      new wait(2),
      new autoDrive(m_drive, 1, 0),
      new wait(0.5),
      new autoGrab(m_Grab, 2),
      new wait(0.5),
      new autoGrab(m_Grab, 3),
      new autoDrive(m_drive, 2, -6),
      new AutoArm(m_Arm, 0),
      new autoDrive(m_drive, 2, -62));
    }
  
 // public Autonomous(DriveTrain subsystem) {
  //  Commands.sequence(new autoDrive(subsystem, 1));
  //}
}
