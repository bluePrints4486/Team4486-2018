package org.usfirst.frc.team4486.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Auto extends CommandGroup {

	String scoreLocation;
	String robotPosition;
	double highGoalDriveDistance = 200;
	double lowGoalDriveDistance = 100;
	double turnLeftAngle = -88;
	double turnRightAngle = 88;
	double driveForwardDistance = 15;
	double defaultAutoDriveForward = 200;
	double centerDriveForward = 90;
	double centerLeftTraverseDistance = 56;
	double centerRightTraverseDistance = 56;
	
	double raiseWinchSpeed = -.8;
	double holdWinchSpeed = -.1;
	double raiseWinchHighTime = 3;
	double raiseWinchLowTime = 1;
	double holdWinchTime = 2;
	
	
    public Auto() {
    	scoreLocation = DriverStation.getInstance().getGameSpecificMessage();
    	robotPosition = SmartDashboard.getString("Auto Selector","Default");
    	System.out.println(robotPosition);
    	switch(robotPosition){
    	case"L":
    		if(scoreLocation.charAt(1) == 'L'){
    			addSequential(new AutoMove(highGoalDriveDistance));
    	    	addSequential(new AutoTurn(turnRightAngle));
    	    	
    	    	addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchHighTime));
    	    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(driveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    		}else if(scoreLocation.charAt(0) == 'L'){
    			addSequential(new AutoMove(lowGoalDriveDistance));
    	    	addSequential(new AutoTurn(turnRightAngle));
    	    	
    	    	addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchLowTime));
    	    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(driveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    		}else{
    			addSequential(new AutoMove(defaultAutoDriveForward));
    		}
    		break;
    	case"C":
    		if(scoreLocation.charAt(0) == 'L'){
    			/*
    			addSequential(new AutoMove(centerDriveForward));
    			addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchLowTime));    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(driveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    			*/
    			addSequential(new AutoMove(centerDriveForward/2));
    			addSequential(new AutoTurn(turnLeftAngle));
    			addSequential(new AutoMove(centerLeftTraverseDistance));
    			addSequential(new AutoTurn(turnRightAngle));
    			addSequential(new AutoMove(centerDriveForward/2));
    			
    			addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchLowTime));    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(driveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    			
    		}else if(scoreLocation.charAt(0) == 'R'){
    			addSequential(new AutoMove(centerDriveForward/2));
    			addSequential(new AutoTurn(turnRightAngle));
    			addSequential(new AutoMove(centerRightTraverseDistance));
    			addSequential(new AutoTurn(turnLeftAngle));
    			addSequential(new AutoMove(centerDriveForward/2));
    			
    			addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchLowTime));    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(driveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    		}
    		break;
    	case"R":
    		if(scoreLocation.charAt(1) == 'R'){
    			addSequential(new AutoMove(highGoalDriveDistance));
    	    	addSequential(new AutoTurn(turnLeftAngle));
    	    	
    	    	addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchHighTime));
    	    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(driveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    			
    		}else if(scoreLocation.charAt(0) == 'R'){
    			addSequential(new AutoMove(lowGoalDriveDistance));
    	    	addSequential(new AutoTurn(turnLeftAngle));
    	    	
    	    	addSequential(new AutoWinch(raiseWinchSpeed,raiseWinchLowTime));
    	    	
    	    	addParallel(new AutoWinch(holdWinchSpeed,holdWinchTime));
    	    	addSequential(new AutoMove(driveForwardDistance));
    	    	addSequential(new AutoPickup(-1,1));
    			
    		}else{
    			addSequential(new AutoMove(defaultAutoDriveForward));
    		}
    		break;
    	case"F":
    		addSequential(new AutoMove(100));
    		addSequential(new AutoTurn(180));
    		break;
    	case"T":
    		addSequential(new AutoTurn(90));
    		addSequential(new AutoMove(1));
    		break;
    	default:
    		
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
