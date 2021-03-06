package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.OI;
import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.commands.MoveWinch;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	VictorSP doubleWinchMotor = new VictorSP(RobotMap.DOUBLE_WINCH_MOTOR);
	public void moveWinch(){
		
		doubleWinchMotor.set(-OI.manipulator.getY());
	}
	
	public void autoMove(double speed){
		doubleWinchMotor.set(speed);
	}
	
	public void stopWinch(){
		doubleWinchMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveWinch());
    }
}

