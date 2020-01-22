package org.usfirst.frc.team4486.robot.commands;

import org.usfirst.frc.team4486.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {

	boolean finished = false;
	double angle = 0;
	
    public AutoTurn(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.initAutoTurn(this.angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	finished = Robot.drive.autoTurn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.endAutoTurn();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.endAutoTurn();

    }
}
