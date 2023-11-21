// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Grabber extends SubsystemBase {

  // Grabber Motors
  public final CANSparkMax leftGrabMotor = new CANSparkMax(Constants.grabL, MotorType.kBrushless);
  public final CANSparkMax rightGrabMotor = new CANSparkMax(Constants.grabR, MotorType.kBrushless);

  // Grabber Pneumatic Solenoid Valve
  public final DoubleSolenoid grippy = new DoubleSolenoid(10, PneumaticsModuleType.REVPH, Constants.pneumaticsOut,
      Constants.pneumaticsIn);

  /** Creates a new Grabber. */
  public Grabber() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotors(double grabberSpeed) {
    // This method activates Grabber wheels
    leftGrabMotor.set(-grabberSpeed);
    rightGrabMotor.set(grabberSpeed);
  }

  public void openGrabber(boolean openClose) {
    // This method activates Grabber pneumatic piston
    // kForward will Close the Grabber Claw
    // kReverse will Open the Grabber Claw
    if (openClose) {
      grippy.set(Value.kForward);
    } else {
      grippy.set(Value.kReverse);
    }
  }
}
