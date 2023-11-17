// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveTrain extends SubsystemBase {
  public final CANSparkMax FrontLeft = new CANSparkMax(Constants.FrontL, MotorType.kBrushless);
  public final CANSparkMax FrontRight = new CANSparkMax(Constants.FrontR, MotorType.kBrushless);
  private final CANSparkMax RearLeft = new CANSparkMax(Constants.RearL, MotorType.kBrushless);
  private final CANSparkMax RearRight = new CANSparkMax(Constants.RearR, MotorType.kBrushless);
  
  
  public final RelativeEncoder Enc_moveLeft = FrontLeft.getEncoder();
   public final RelativeEncoder Enc_moveRight = FrontRight.getEncoder(); 
    
  
  private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(
    FrontLeft,RearLeft);
  private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(
    FrontRight,RearRight);
   
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  private double speedThrottle = 1.0;
  private boolean throttleOn;
  
  // Creates a new DriveTrain.
  public DriveTrain() {
    m_rightMotors.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //setDefaultCommand(new ArcadeDrive());
  }
  
  public void setMotors(double speed, double rotation) {
    //m_drive.tankDrive(speedL, speedR);
    if (RobotContainer.m_joysL.getRawButton(1)) {
      throttleOn = true;
    }
    else {
      throttleOn = false;
    }
    
    if (throttleOn){
      speedThrottle = Constants.throttleSpeed;
    }
    else {
      speedThrottle = 1.0;
    }

    m_drive.curvatureDrive(speed*speedThrottle, rotation*Constants.turnLimiter*speedThrottle, true);

    SmartDashboard.putNumber("Drive Encoder", Enc_moveLeft.getPosition());
    SmartDashboard.putBoolean("Slow Mode Activated", throttleOn);
 //   SmartDashboard.putBoolean("Slow Mode Activated", RobotContainer.slowMode);

/*     FrontLeft.set(speedL);
    RearLeft.set(speedL);
    FrontRight.set(speedR);
    RearRight.set(speedR); */
  }

 
}
