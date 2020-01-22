package org.usfirst.frc.team4486.robot.commands;

import org.usfirst.frc.team4486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoMove extends Command {

	boolean finished = false;
	double distance;
	
    public AutoMove(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.initAutoMove(distance);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	finished = Robot.drive.autoMove();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.endAutoMove();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.endAutoMove();
    }
}
