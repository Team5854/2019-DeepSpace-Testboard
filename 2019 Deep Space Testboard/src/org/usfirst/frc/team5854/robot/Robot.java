/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5854.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private Joystick joystick = new Joystick(0);
	private VictorSP victor0 = new VictorSP(0);
	private VictorSP victor1 = new VictorSP(1);
	private Compressor compressor = new Compressor(0);
	private DoubleSolenoid solenoid = new DoubleSolenoid(1,2);
	
	public void robotInit() {
	compressor.setClosedLoopControl(true);
	solenoid.set(DoubleSolenoid.Value.kOff);
	}
		
    public void autonomousInit() {
    	
    }
	
	public void autonomousPeriodic() {
		
		}
	
	public void teleopPeriodic() {
	}

	public void testPeriodic() {
		
		//This section controls the SOLENOID//
		
		if(joystick.getRawButton(0)) {
			solenoid.set(DoubleSolenoid.Value.kForward);
		} else if(joystick.getRawButton(1)) {
			solenoid.set(DoubleSolenoid.Value.kReverse);
		} else { 
			solenoid.set(DoubleSolenoid.Value.kOff);
		}
		
		//This section controls the VictorSP's//
		
		if(joystick.getRawButton(2)) {
			victor0.set(.8);
			victor1.set(.8);
		} else if(joystick.getRawButton(3)) {
			victor0.set(-.8);
			victor1.set(-.8);
		} else {
			victor0.set(0);
			victor1.set(0);
		}
	
	}
	
}

