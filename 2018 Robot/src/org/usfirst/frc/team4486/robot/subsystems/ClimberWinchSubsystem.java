package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.OI;
import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.commands.StopClimber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimberWinchSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	WPI_TalonSRX winchMotor1 = new WPI_TalonSRX(RobotMap.CLIMBING_WINCH_1);
	WPI_TalonSRX winchMotor2 = new WPI_TalonSRX(RobotMap.CLIMBING_WINCH_2);
	
	public void moveWinch(){
		
		winchMotor1.set(1);
		winchMotor2.set(1);
	}
	
	public void stopWinch(){
		
		winchMotor1.set(0);
		winchMotor2.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new StopClimber());
    }
}

