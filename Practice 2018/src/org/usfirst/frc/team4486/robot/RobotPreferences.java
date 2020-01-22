package org.usfirst.frc.team4486.robot;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {
	
	Preferences prefs;
	
	public static double gyro_p;
	public static double gyro_I;
	public static double gyro_D;
	//gyro
	public static double encoder_p;
	public static double encoder_I;
	public static double encoder_D;
	
	RobotPreferences(){
		prefs = Preferences.getInstance();
		
		gyro_p = prefs.getDouble("Gyro P", .3);
		gyro_I = prefs.getDouble("Gyro I", .004);
		gyro_D = prefs.getDouble("Gyro D", .3);
		// gyro
		encoder_p = prefs.getDouble("Encoder P", .2);
		encoder_I = prefs.getDouble("Encoder I", .004);
		encoder_D = prefs.getDouble("Encoder D", 1.3);
		
	}
	
	public void update(){
		
		gyro_p = prefs.getDouble("Gyro P", .3);
		gyro_I = prefs.getDouble("Gyro I", .004);
		gyro_D = prefs.getDouble("Gyro D", .3);
		// gyro
		encoder_p = prefs.getDouble("Encoder P", .2);
		encoder_I = prefs.getDouble("Encoder I", .004);
		encoder_D = prefs.getDouble("Encoder D", 1.3);
	}
	
	public double getGyroP(){
		return prefs.getDouble("Gyro P", .06);
	}
	
	public double getGyroI(){
		return prefs.getDouble("Gyro I", .004);
	}
	
	public double getGyroD(){
		return prefs.getDouble("Gyro D", .1);
	}
	
	public double getEncoderP(){
		return prefs.getDouble("Encoder P", .2);
	}
	
	public double getEncoderI(){
		return prefs.getDouble("Encoder I", .004);
	}
	
	public double getEncoderD(){
		return prefs.getDouble("Encoder D", 1);
	}
	

}
