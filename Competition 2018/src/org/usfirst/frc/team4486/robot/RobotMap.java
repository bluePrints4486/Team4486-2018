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
	
	//CAN ports
	public static final int LEFT_DRIVE_1 = 4;
	public static final int LEFT_DRIVE_2 = 5;
	public static final int LEFT_DRIVE_3 = 6;
	
	public static final int RIGHT_DRIVE_1 = 7;
	public static final int RIGHT_DRIVE_2 = 8;
	public static final int RIGHT_DRIVE_3 = 9;
	
	public static final int WINCH_1 = 10;
	public static final int WINCH_2 = 11;
	
	public static final int PICKUP_LEFT = 1;
	public static final int PICKUP_RIGHT = 12;
	
	public static final int CLIMBING_WINCH_1 = 2;
	public static final int CLIMBING_WINCH_2 = 3;
	
	//Joystick ports
	public static final int DRIVER_JOYSTICK = 0;
	public static final int MANIPULATOR_JOYSTICK = 1;
	
	//Buttons
	public static final int INTAKE_BUTTON = 1;
	public static final int OUTTAKE_BUTTON = 2;
	public static final int CLIMB_BUTTON = 3;
	public static final int AUX_CLIMB_BUTTON = 5;
	public static final int TURBO_BUTTON = 8;
	
	//IO ports
		public static final int ENCODER_A = 0;
		public static final int ENCODER_B = 1;
}
