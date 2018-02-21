package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.OI;
import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.commands.*;

import com.ctre.CANTalon;

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
		CANTalon leftTalon1 = new CANTalon(RobotMap.LEFT_DRIVE_1);
		CANTalon leftTalon2 = new CANTalon(RobotMap.LEFT_DRIVE_2);
		CANTalon leftTalon3 = new CANTalon(RobotMap.LEFT_DRIVE_3);
		
		CANTalon rightTalon1 = new CANTalon(RobotMap.RIGHT_DRIVE_1);
		CANTalon rightTalon2 = new CANTalon(RobotMap.RIGHT_DRIVE_2);
		CANTalon rightTalon3 = new CANTalon(RobotMap.RIGHT_DRIVE_3);
		
		SpeedControllerGroup scRight = new SpeedControllerGroup((SpeedController)rightTalon1,
				(SpeedController)rightTalon2,(SpeedController)rightTalon3);
		
		SpeedControllerGroup scLeft = new SpeedControllerGroup((SpeedController)leftTalon1,
				(SpeedController)leftTalon2,(SpeedController)leftTalon3); 
		
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
