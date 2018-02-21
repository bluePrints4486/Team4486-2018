package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.commands.StopIntake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BoxIntakeSubsystem extends Subsystem {
	
	WPI_TalonSRX leftMotor = new WPI_TalonSRX(RobotMap.PICKUP_LEFT);
	WPI_TalonSRX rightMotor = new WPI_TalonSRX(RobotMap.PICKUP_RIGHT);
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void runIntake(){
		leftMotor.set( 1);
		rightMotor.set(-1);
		
	}
	
	public void runOutake(){
		leftMotor.set( -1);
		rightMotor.set( 1);
	}
	
	public void stopIntake(){
		leftMotor.set( 0);
		rightMotor.set( 0);
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new StopIntake());
    	
		}
}
    
    


