package org.usfirst.frc.team4486.robot;

import edu.wpi.first.wpilibj.PIDOutput;

public class PIDOutputDummy implements PIDOutput{

	private double pidValue = 0;
	
	@Override
	public void pidWrite(double output) {
		
		pidValue = output;
	}

	public double getSpeed(){
		return(this.pidValue);
	}
	
}
