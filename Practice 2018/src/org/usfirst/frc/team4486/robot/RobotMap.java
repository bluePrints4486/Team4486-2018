package org.usfirst.frc.team4486.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//IO ports
	public static final int ENCODER_A = 0;
	public static final int ENCODER_B = 1;

	
	//drive speed controllers
	public static final int DOUBLE_RIGHT_MOTOR = 0;
	public static final int DOUBLE_LEFT_MOTOR = 1;
	public static final int SINGLE_RIGHT_MOTOR = 2;
	public static final int SINGLE_LEFT_MOTOR = 3;
	
	//winch speed controllrs/ Intake Outake
	
	public static final int DOUBLE_WINCH_MOTOR = 4;
	
	public static final int DRIVER_JOYSTICK = 0;
	public static final int MANIPULATOR_JOYSTICK = 1;
	
	public static final int DOUBLE_INTAKE_MOTOR = 5;
	public static final int CLIMBER_DOUBLE_WINCH_MOTOR = 6;
	
	//Buttons
	public static final int INTAKE_BUTTON = 1;
	public static final int OUTTAKE_BUTTON = 2;
	public static final int CLIMB_BUTTON = 3;
	
	public static final int TURBO_BUTTON = 8;

}
