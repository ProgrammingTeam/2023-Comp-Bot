// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.GrabCommand;
import frc.robot.commands.GrabCubeOrCone;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.Autonomous;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Grabber;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_DriveTrain = new DriveTrain();
  private final Elevator m_elevator = new Elevator();
  private final Grabber m_Grabber = new Grabber();
  private final Arm m_Arm = new Arm();
  public final static Joystick m_joysL = new Joystick(Constants.leftjoystickport);
  public final Joystick m_joysR = new Joystick(Constants.rightjoystickport);
  // public static Boolean slowMode = false;

  // Compressor phCompressor = new Compressor(10, PneumaticsModuleType.REVPH);

  // boolean enabled = phCompressor.isEnabled();

  // private final SequentialCommandGroup m_autonomousCommand = new
  // Autonomous(m_elevator);
  // private final SequentialCommandGroup m_autonomousDrive = new Autonomous();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final XboxController m_driverController = new XboxController(OperatorConstants.kDriverControllerPort);

  public JoystickButton Y = new JoystickButton(m_driverController, 4);
  public JoystickButton A = new JoystickButton(m_driverController, 1);
  public JoystickButton X = new JoystickButton(m_driverController, 3);
  public JoystickButton B = new JoystickButton(m_driverController, 2);
  public JoystickButton LB = new JoystickButton(m_driverController, 5);
  public JoystickButton RB = new JoystickButton(m_driverController, 6);
  public JoystickButton JBRight = new JoystickButton(m_driverController, 10);
  public JoystickButton JBLeft = new JoystickButton(m_driverController, 9);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    m_DriveTrain
        .setDefaultCommand(new DriveCommand(m_DriveTrain, () -> -m_joysL.getRawAxis(1), () -> -m_joysR.getRawAxis(0)));
    configureBindings();

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    Y.whileTrue(new ElevatorCommand(m_elevator, 1));
    A.whileTrue(new ElevatorCommand(m_elevator, 2));
    Y.whileFalse(new ElevatorCommand(m_elevator, 0));
    A.whileFalse(new ElevatorCommand(m_elevator, 0));

    X.whileTrue(new GrabCommand(m_Grabber, 1));
    B.whileTrue(new GrabCommand(m_Grabber, 2));
    X.whileFalse(new GrabCommand(m_Grabber, 0));
    B.whileFalse(new GrabCommand(m_Grabber, 0));

    LB.onTrue(new GrabCubeOrCone(m_Grabber, 1));
    RB.onTrue(new GrabCubeOrCone(m_Grabber, 2));

    JBLeft.onTrue(new ArmCommand(m_Arm, 1));
    JBRight.onTrue(new ArmCommand(m_Arm, 2));

    /*
     * if (m_joysL.getRawButtonPressed(1) && !slowMode) {
     * slowMode = true;
     * }
     * else if (m_joysL.getRawButtonPressed(1) && slowMode){
     * slowMode = false;
     * }
     */

    // m_driverController.button(1).whileTrue(new ElevatorCommand(m_elevator, 2));
    // m_driverController.buttongetRawButton(4)(new ElevatorCommand(m_elevator,1));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is
    // pressed,
    // cancelling on release.
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * 
   * @return
   */
  // public Command getAutonomousCommand() {
  // return m_autonomousCommand;
  // An example command will be run in autonomous

  Command getDriveCommand() {
    final SequentialCommandGroup m_autonomousDrive = new Autonomous(m_Arm, m_DriveTrain, m_Grabber);
    return m_autonomousDrive;

  }
}
