// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
//  import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import frc.robot.util.Constants.IntakeToggle;
import frc.robot.util.Pneumatics.*;
import frc.robot.util.sensors.*;
import frc.robot.util.sensors.Limelight.LightMode;
import frc.robot.Autonomous.*;

/** This is a demo program showing how to use Mecanum control with the RobotDrive class. */
public class Robot extends TimedRobot {
  public static IntakeToggle currentIntakeState;

  @Override
  public void robotInit() {
    Gyro.init();
    Drive.init();
    HangingMove.init();
    Indexer.init();
    Intake.init();
    LiftSystem.init();
    Shooter.init();
    WallOfWheels.init();
    TeleopControl.init();
    Pneumatics.init();
    Pneumatics.controlCompressor(CompressorState.ENABLED);
    
    Limelight.setLedMode(LightMode.OFF);
    //Limelight.initUSBCamera();
    currentIntakeState = IntakeToggle.STOP;

  }
  
  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    // m_autoSelected = "kCustomAuto"; //m_chooser.getSelected();
    //                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    // System.out.println("Auto selected: " + m_autoSelected);
    if(TeleopControl.driver.getThrottle() > 0.75){
    Routine.init();
    }
    else if (TeleopControl.driver.getThrottle() < 0.25){
    TrenchAuto.init();
    }
  }

  @Override
  public void autonomousPeriodic() {
    Routine.run();
    // if(TeleopControl.driver.getThrottle() > 0.75){
    //  Routine.run();
    //   //Routine.debugAuto();
    // }
    // else if (TeleopControl.driver.getThrottle() < 0.25){
    //   TrenchAuto.start();
    //   //Routine.debugAuto();
    //   //Indexer.debugIndexer();
    // }
    // else if(TeleopControl.driver.getThrottle() <= 0.75 && TeleopControl.driver.getThrottle() >= 0.25){
    //  // Routine.run();
    //   Routine.debugAuto();
    // }
    // switch (m_autoSelected) {
    //   case kCustomAuto:
    //     // Put custom auto code herea
    //     //break;
    //   case kDefaultAuto:
        
    //   default:
    //     // Put default auto code here
    //     startCompetition();
    //     SmartDashboard.putString("POOOOOOOOOOO","POOOOOOOOOOOOOOOOOOOO");
    //     Routine.run();
    //     break;
    // }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    TeleopControl.run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  @Override
  public void disabledPeriodic(){
    //SmartDashboard.putNumber("Throttle Value", TeleopControl.driver.getThrottle());
    //SmartDashboard.updateValues();
  }

  @Override
  public void disabledInit(){
    
  }
}
