package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
/*import frc.robot.commands.LockedMove;
import frc.robot.commands.Turn;*/

public class OI {
	/*
	Setup for Joystick class.
	This is every button and joystick on the controller that can be used in the code
	*/
	private static XboxController joy = new XboxController(0);

	public static final JoystickButton A = new JoystickButton(joy, 1);
	public static final JoystickButton B = new JoystickButton(joy, 2);
	public static final JoystickButton X = new JoystickButton(joy, 3);
	public static final JoystickButton Y = new JoystickButton(joy, 4);
	public static final JoystickButton LB = new JoystickButton(joy, 5);
	public static final JoystickButton RB = new JoystickButton(joy, 6);
	public static final JoystickButton BACK = new JoystickButton(joy, 7);
	public static final JoystickButton START = new JoystickButton(joy, 8);
	public static final JoystickButton LSB = new JoystickButton(joy, 9);
	public static final JoystickButton RSB = new JoystickButton(joy, 10);
	
/* 	public static final LTrigger LT = new LTrigger();
	public static final RTrigger RT = new RTrigger(); */

	// Left joystick X axis
	public static double LEFT_X_AXIS() {
        return joy.getRawAxis(0);
    }

	// Left joystick Y axis
    public static double LEFT_Y_AXIS() {
        return joy.getRawAxis(1);
    }

	public static double GetLT() {
		return joy.getRawAxis(2);
	}

	public static double GetRT() {
		return joy.getRawAxis(3);
	}

	// Right joystick X axis
    public static double RIGHT_X_AXIS() {
        return joy.getRawAxis(4);
    }

	// Right joystick Y axis
    public static double RIGHT_Y_AXIS() {
        return joy.getRawAxis(5);
    }
	
	public OI()
	{

	}
}

/* class LTrigger extends Trigger {
	public LTrigger() {}
	
	@Override
	public boolean get() {
		return OI.GetLT() > 0.9;
	}
}

class RTrigger extends Button {
	public RTrigger() {}
	
	@Override
	public boolean get() {
		return OI.GetRT() > 0.9;
	}
} */
