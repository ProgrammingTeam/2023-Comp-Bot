// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {

  // Arm Pneumatic Solenoid Valve
  public final DoubleSolenoid pushArm = new DoubleSolenoid(10, PneumaticsModuleType.REVPH, Constants.armOut, Constants.armStowed);
  
  /** Creates a new Arm. */
  public Arm() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void openGrabber(boolean armMotion) {
    // This method activates Arm pneumatic piston
    // kForward will Extend the Arm
    // kReverse will Retract the Arm
    if (armMotion) {
      pushArm.set(Value.kForward);
    }
    else {
      pushArm.set(Value.kReverse);
    }
  }
}