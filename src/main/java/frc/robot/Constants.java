// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final int FrontL = 1;
  public static final int RearL = 2;
  public static final int FrontR = 3;
  public static final int RearR = 4;


  public static final int leftjoystickport = 1;
  public static final int rightjoystickport = 2;
 
  //Don't use 5 for CANID
  public static final int elevatorMotorLeft = 6;
  public static final int elevatorMotorRight = 7;
  
  public static final int elevatorUpperLimitSwitch = 0;
  public static final int elevatorLowerLimitSwitch = 1;
  public static final double elevatorUpSpeed = 1.0;
  public static final double elevatorDownSpeed = 1.0;
  
  public static final int grabL = 8;
  public static final int grabR = 9;
  public static final int pneumaticsOut = 2;
  public static final int pneumaticsIn = 0;
  public static final double grabberMotorSpeed = 0.5;
  
  public static final int armMotor = 11;
 
  public static final int armStowed = 15;
  public static final int armOut = 13;
public static final double autoDrive = 0.1;
public static final double autoReverseDrive = 0.05;
public static final double autoBackDrive = 0.2;
public static final double turnLimiter = 0.75;
public static final double throttleSpeed = 0.5;

  public static boolean elevatorLimitSwitchesActivated = true;

}
