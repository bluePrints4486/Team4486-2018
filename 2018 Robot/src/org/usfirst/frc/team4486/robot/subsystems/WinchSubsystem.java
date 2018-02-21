package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.OI;
import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.commands.MoveWinch;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	WPI_TalonSRX winchMotor1 = new WPI_TalonSRX(RobotMap.WINCH_1);
	WPI_TalonSRX winchMotor2 = new WPI_TalonSRX(RobotMap.WINCH_2);
	
	public void moveWinch(){
		
		winchMotor1.set(-OI.manipulator.getY());
		winchMotor2.set(-OI.manipulator.getY());
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new MoveWinch());
    }
}

