// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  public final CANSparkMax leftElevatorMotor = new CANSparkMax(Constants.elevatorMotorLeft, MotorType.kBrushless);
  public final CANSparkMax rightElevatorMotor = new CANSparkMax(Constants.elevatorMotorRight, MotorType.kBrushless);
  public final DigitalInput upperLimitSwitch = new DigitalInput(Constants.elevatorUpperLimitSwitch);
  public final DigitalInput lowerLimitSwitch = new DigitalInput(Constants.elevatorLowerLimitSwitch);
  public final RelativeEncoder Enc_Left = leftElevatorMotor.getEncoder();
  /** Creates a new Elevator. */
  public Elevator() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotors(double verticlespeed) {
    if (Constants.elevatorLimitSwitchesActivated){
      
      if (upperLimitSwitch.get()&&verticlespeed>0) {
      leftElevatorMotor.set(-verticlespeed);
      rightElevatorMotor.set(verticlespeed); 
      }
      
     else if(!upperLimitSwitch.get()&&verticlespeed>0) {
      leftElevatorMotor.set(0);
      rightElevatorMotor.set(0); 
      }
      
      else if(!lowerLimitSwitch.get()&&verticlespeed<0) {
      leftElevatorMotor.set(0);
      rightElevatorMotor.set(0); 
      }
      
      else if(lowerLimitSwitch.get()&&verticlespeed<0) {
      leftElevatorMotor.set(-verticlespeed);
      rightElevatorMotor.set(verticlespeed); 
      }
      
      else {
      leftElevatorMotor.set(0);
      rightElevatorMotor.set(0);
       }
    }
    else {
    leftElevatorMotor.set(-verticlespeed);
    rightElevatorMotor.set(verticlespeed); 
    }
  }
}
