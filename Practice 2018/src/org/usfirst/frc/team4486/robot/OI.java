package org.usfirst.frc.team4486.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.commands.ExampleCommand;
import org.usfirst.frc.team4486.robot.commands.RunClimber;
import org.usfirst.frc.team4486.robot.commands.RunIntake;
import org.usfirst.frc.team4486.robot.commands.RunOutake;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public static Joystick driver = new Joystick(RobotMap.DRIVER_JOYSTICK);
	public static Joystick manipulator = new Joystick(RobotMap.MANIPULATOR_JOYSTICK);
	
	public static JoystickButton intakeButton = new JoystickButton(manipulator,RobotMap.INTAKE_BUTTON);
	public static JoystickButton outakeButton = new JoystickButton(manipulator,RobotMap.OUTTAKE_BUTTON);
	public static JoystickButton climbButton = new JoystickButton(manipulator,RobotMap.CLIMB_BUTTON);
	
	public static JoystickButton turboButton = new JoystickButton(driver,RobotMap.TURBO_BUTTON);

	
	public OI(){
		
		intakeButton.whileHeld(new RunIntake());
		outakeButton.whileHeld(new RunOutake());
		climbButton.whileHeld(new RunClimber());
	}
	
}
      

