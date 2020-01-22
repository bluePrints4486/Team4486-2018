package org.usfirst.frc.team4486.robot.subsystems;

import org.usfirst.frc.team4486.robot.OI;
import org.usfirst.frc.team4486.robot.PIDOutputDummy;
import org.usfirst.frc.team4486.robot.Robot;
import org.usfirst.frc.team4486.robot.RobotMap;
import org.usfirst.frc.team4486.robot.RobotPreferences;
import org.usfirst.frc.team4486.robot.commands.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	 DifferentialDrive drive;
	 ADXRS450_Gyro gyro;
	 Encoder encoder;
	 
	 PIDOutputDummy gyroOutput;
	 PIDOutputDummy encoderOutput;
	 
	 PIDController gyroPID;
	 PIDController encoderPID;
	 
	 int gyroCounter;
	 int encoderCounter;
	 
	public DriveSubsystem(){
		VictorSP doubleRightMotor = new VictorSP(RobotMap.DOUBLE_RIGHT_MOTOR);
		VictorSP singleRightMotor = new VictorSP(RobotMap.SINGLE_RIGHT_MOTOR);
		
		SpeedControllerGroup scRight = new SpeedControllerGroup(doubleRightMotor,singleRightMotor);
		
		VictorSP doubleLeftMotor = new VictorSP(RobotMap.DOUBLE_LEFT_MOTOR);
		VictorSP singleLeftMotor = new VictorSP(RobotMap.SINGLE_LEFT_MOTOR);
		
		SpeedControllerGroup scLeft = new SpeedControllerGroup(doubleLeftMotor,singleLeftMotor); 
				
		drive  = new DifferentialDrive(scLeft,scRight);
	
		gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
		gyro.calibrate();
		gyro.setPIDSourceType(PIDSourceType.kDisplacement);
	
		encoderOutput = new PIDOutputDummy();
		gyroOutput = new PIDOutputDummy();
	
		encoder = new Encoder(RobotMap.ENCODER_A,RobotMap.ENCODER_B,false,Encoder.EncodingType.k4X);
		encoder.setDistancePerPulse(0.1472);
		encoder.setPIDSourceType(PIDSourceType.kDisplacement);
	//.06,.002,.2
		gyroPID = new PIDController(Robot.prefs.getGyroP(),Robot.prefs.getGyroI(),Robot.prefs.getGyroD(),gyro,gyroOutput);
		encoderPID = new PIDController(Robot.prefs.getEncoderP(),Robot.prefs.getEncoderI(),Robot.prefs.getEncoderD(),encoder,encoderOutput);
	
		encoderPID.setPercentTolerance(1);
		encoderPID.setInputRange(-300, 300);
		encoderPID.setContinuous();
	
		//1
		gyroPID.setPercentTolerance(1);
		gyroPID.setInputRange(-180, 180);
		gyroPID.setContinuous(false);
		
		drive.setMaxOutput(.5);
		
	
	}
	
	public void drive(){
		
		if(OI.turboButton.get()){
			
			drive.setMaxOutput(.70);
		}else{
			drive.setMaxOutput(.60);
		}
		drive.tankDrive(OI.driver.getY(), OI.driver.getThrottle());
		
		
	}
	
	
	public void initAutoTurn(double angle){
		gyroPID.setPID(Robot.prefs.getGyroP(),Robot.prefs.getGyroI(),Robot.prefs.getGyroD());
		encoderPID.setPID(Robot.prefs.getEncoderP(),Robot.prefs.getEncoderI(),Robot.prefs.getEncoderD());
		gyro.reset();
		gyroPID.enable();
		gyroPID.setSetpoint(angle);
		gyroCounter = 0;
		
	}
	
	public boolean autoTurn(){
		
		drive.tankDrive(-gyroOutput.getSpeed(), gyroOutput.getSpeed());
		
		if(gyroPID.onTarget()){
			gyroCounter++;
		}
		
		return(gyroPID.onTarget()&&gyroCounter>40);
	}
	
	public void endAutoTurn(){
		gyroCounter = 0;
		drive.tankDrive(0,0);
		gyroPID.disable();
	}
	
	public void initAutoMove(double distance){
		gyroPID.setPID(Robot.prefs.getGyroP(),Robot.prefs.getGyroI(),Robot.prefs.getGyroD());
		encoderPID.setPID(Robot.prefs.getEncoderP(),Robot.prefs.getEncoderI(),Robot.prefs.getEncoderD());
		gyro.reset();
		gyroPID.enable();
		gyroPID.setSetpoint(0);
		
		encoder.reset();
		encoderPID.enable();
		encoderPID.setSetpoint(distance);
		
		encoderCounter = 0;
	}
	
	public boolean autoMove(){
		//
		drive.arcadeDrive(-encoderOutput.getSpeed(), -gyroOutput.getSpeed());
		
		if(encoderPID.onTarget()){
			encoderCounter++;
		}
		
		return(encoderPID.onTarget()&&encoderCounter>40);
	}
	
	public void endAutoMove(){
		encoderCounter = 0;
		drive.tankDrive(0,0);
		encoderPID.disable();
		gyroPID.disable();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new Drive());
    	
    }
}
