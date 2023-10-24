// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** Add your docs here. */
public class joystickOI {
    public static Joystick joys = new Joystick(1);

    public static final JoystickButton BTrigger = new JoystickButton(joys, 1);
	public static final JoystickButton TB = new JoystickButton(joys, 2);
	public static final JoystickButton TL = new JoystickButton(joys, 3);
	public static final JoystickButton TR = new JoystickButton(joys, 4);
	public static final JoystickButton L1 = new JoystickButton(joys, 5);
	public static final JoystickButton L2 = new JoystickButton(joys, 6);
	public static final JoystickButton L3 = new JoystickButton(joys, 7);
	public static final JoystickButton L4 = new JoystickButton(joys, 8);
	public static final JoystickButton L5 = new JoystickButton(joys, 9);
	public static final JoystickButton L6 = new JoystickButton(joys, 10);
    public static final JoystickButton R1 = new JoystickButton(joys, 11);
	public static final JoystickButton R2= new JoystickButton(joys, 12);
	public static final JoystickButton R3 = new JoystickButton(joys, 13);
	public static final JoystickButton R4 = new JoystickButton(joys, 14);
	public static final JoystickButton R5 = new JoystickButton(joys, 15);
	public static final JoystickButton R6 = new JoystickButton(joys, 16);

    public static double X_Axis(){
        return joys.getRawAxis(0);
    }
    public static double Y_Axis(){
        return joys.getRawAxis(1);
    }
    public static double Z_Axis(){
        return joys.getRawAxis(2);
    
    }public static double slider(){
        return joys.getRawAxis(3);
    }

    
}
