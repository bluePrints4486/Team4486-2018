package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.commands.StopIntake;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BoxIntakeSubsystem extends Subsystem {
	
	
	VictorSP doubleIntakeMotor = new VictorSP (RobotMap.DOUBLE_INTAKE_MOTOR);
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void autoIntake(double speed){
		
		doubleIntakeMotor.set(speed);
	}
	
	public void runIntake(){
		
		doubleIntakeMotor.set(.25);
	}
	
	public void runOutake(){
		doubleIntakeMotor.set(-.25);
	}
	
	public void stopIntake(){
			doubleIntakeMotor.set(0);
		}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new StopIntake());
    	
		}
}
    
    


