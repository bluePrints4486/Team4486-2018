package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.OI;
import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.commands.*;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	 DifferentialDrive drive;
	 
	public DriveSubsystem(){
		WPI_TalonSRX leftTalon1 = new WPI_TalonSRX(RobotMap.LEFT_DRIVE_1);
		WPI_TalonSRX leftTalon2 = new WPI_TalonSRX(RobotMap.LEFT_DRIVE_2);
		WPI_TalonSRX leftTalon3 = new WPI_TalonSRX(RobotMap.LEFT_DRIVE_3);
		
		WPI_TalonSRX rightTalon1 = new WPI_TalonSRX(RobotMap.RIGHT_DRIVE_1);
		WPI_TalonSRX rightTalon2 = new WPI_TalonSRX(RobotMap.RIGHT_DRIVE_2);
		WPI_TalonSRX rightTalon3 = new WPI_TalonSRX(RobotMap.RIGHT_DRIVE_3);
		
		SpeedControllerGroup scRight = new SpeedControllerGroup(rightTalon1,rightTalon2,rightTalon3);
		
		SpeedControllerGroup scLeft = new SpeedControllerGroup(leftTalon1,leftTalon2,leftTalon3); 
		
		//VictorSP doubleRightMotor = new VictorSP(RobotMap.DOUBLE_RIGHT_MOTOR);
		//VictorSP singleRightMotor = new VictorSP(RobotMap.SINGLE_RIGHT_MOTOR);
		
		//SpeedControllerGroup scRight = new SpeedControllerGroup(doubleRightMotor,singleRightMotor);
		
		//VictorSP doubleLeftMotor = new VictorSP(RobotMap.DOUBLE_LEFT_MOTOR);
		//VictorSP singleLeftMotor = new VictorSP(RobotMap.SINGLE_LEFT_MOTOR);
		
		//SpeedControllerGroup scLeft = new SpeedControllerGroup(doubleLeftMotor,singleLeftMotor); 
				
	drive  = new DifferentialDrive(scLeft,scRight);
	
	drive.setMaxOutput(.6);
	
	}
	
	public void drive(){
		drive.tankDrive(OI.driver.getY(), OI.driver.getThrottle());
		
		
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new Drive());
    	
    }
}
