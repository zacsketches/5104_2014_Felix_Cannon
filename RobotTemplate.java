package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;

public class RobotTemplate extends IterativeRobot {

   public static Console console = new Console();
    public Timer autonomousTimer;
    public DriverStationLCD LCD;
    
    public void robotInit() {
        System.out.println("## ****** ROBOT IS READY ****** ##");
        console.init();
        LCD = DriverStationLCD.getInstance();
        LCD.clear();
    }

    public void disabledInit() {

    }

    public void autonomousInit() {
        
    }
    
    public void autonomousPeriodic() {
        
    }
    
    public void teleopInit() {
        LCD.clear();
        console.teleopInit();
    }
    
    public void teleopPeriodic() {
        console.run();    
    }
    
    public void testPeriodic() {
        
    }

    public void disabledPeriodic() {
        console.disabled();
    }
}
