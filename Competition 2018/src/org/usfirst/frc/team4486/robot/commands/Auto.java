package org.usfirst.frc.team4486.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Auto extends CommandGroup {

	String scoreLocation;
	String field;
	
	double highGoalDriveDistance = 320;
	double lowGoalDriveDistance = 160;
	double turnLeftAngle = -88;
	double turnRightAngle = 88;
	double driveForwardDistance = 25;
	double highDriveForwardDistance = 18;
	double defaultAutoDriveForward = 130;
	double centerDriveForward = 97;
	//32.3
	//79.7
	double centerDriveForward1 = 32.3;
	double centerDriveForward2 = 65.6;

	//52 to center 60L 44R
	double centerLeftTraverseDistance = 65;
	double centerRightTraverseDistance = 49;
	
	double raiseWinchSpeed = .8;
	double holdWinchSpeed = .1;
	double raiseWinchHighTime = 3.5;
	double raiseWinchLowTime = 1;
	double holdWinchTime = 4;
	
	
    public Auto() {
    	scoreLocation = SmartDashboard.getString("Auto Selector","Default");
    	field = DriverStation.getInstance().getGameSpecificMessage();
    	System.out.println(field);
    	switch(field){
    	case"L":
    		if(scoreLocation.charAt(0) == 'L'){
    			
    	    	
    	    	addSequential(new AutoMove(lowGoalDriveDistance));
    	    	addSequential(new AutoTurn(turnRightAngle));
    	    	
    	    	addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchLowTime));
    	    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(driveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    			
    			
    		}else if(scoreLocation.charAt(1) == 'L'){
    			
    			addSequential(new AutoMove(highGoalDriveDistance));
    	    	addSequential(new AutoTurn(turnRightAngle));
    	    	
    	    	addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchHighTime));
    	    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(highDriveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    	    	addSequential(new AutoMove(-7));
    			
    		}else{
    			addSequential(new AutoMove(defaultAutoDriveForward));
    		}
    		break;
    	case"C":
    		if(scoreLocation.charAt(0) == 'L'){
    	    	
    	    	addSequential(new AutoMove(centerDriveForward1));
    			addSequential(new AutoTurn(turnLeftAngle));
    			addSequential(new AutoMove(centerLeftTraverseDistance));
    			addSequential(new AutoTurn(turnRightAngle));
    			addSequential(new AutoMove(centerDriveForward2));
    			
    			addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchLowTime));    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(driveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    			
    		}else if(scoreLocation.charAt(1) == 'R'){
    			addSequential(new AutoMove(centerDriveForward1));
    			addSequential(new AutoTurn(turnRightAngle));
    			addSequential(new AutoMove(centerRightTraverseDistance));
    			addSequential(new AutoTurn(turnLeftAngle));
    			addSequential(new AutoMove(centerDriveForward2));
    			
    			addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchLowTime));    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(driveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    		}
    		break;
    	case"R":
    		if(scoreLocation.charAt(0) == 'R'){
    			
    			
    	    	addSequential(new AutoMove(lowGoalDriveDistance));
    	    	addSequential(new AutoTurn(turnLeftAngle));
    	    	
    	    	addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchLowTime));
    	    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(driveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    	    	
    		}else if(scoreLocation.charAt(1) == 'R'){
    			addSequential(new AutoMove(highGoalDriveDistance));
    	    	addSequential(new AutoTurn(turnLeftAngle));
    	    	
    	    	addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchHighTime));
    	    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(highDriveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    	    	addSequential(new AutoMove(-7));

    			
    		}else{
    			addSequential(new AutoMove(defaultAutoDriveForward));
    		}
    		break;
    	default:
    		addSequential(new AutoMove(defaultAutoDriveForward));
    		break;
    	}
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
