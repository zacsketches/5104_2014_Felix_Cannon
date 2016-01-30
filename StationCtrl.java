package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;

public class StationCtrl {
    
    public static DriverStation ds = DriverStation.getInstance();
    public static DriverStationLCD LCD = DriverStationLCD.getInstance();
    private static Console console = RobotTemplate.console;
    
    public static void display(){
        double R = (100 * (console.motorRight.getSpeed()));
        double L = (100 * (console.motorLeft.getSpeed()));

        LCD.clear();
        LCD.println(DriverStationLCD.Line.kUser1, 1, "Speed(RM): " + R + " %");
        LCD.println(DriverStationLCD.Line.kUser2, 1, "Speed(LM): " + L + " %");
        LCD.println(DriverStationLCD.Line.kUser3, 1, "Loaded/Firing: " + console.load.get() + "/" + console.fire.getSmartDashboardType());
        LCD.println(DriverStationLCD.Line.kUser4, 1, "Battery Volt: " + ds.getBatteryVoltage());
        LCD.println(DriverStationLCD.Line.kUser6, 1, "DS-UI: Felix[Ver]2.0 | " + ds.getTeamNumber());
        LCD.updateLCD();
    }
    
    public static void disabled(){
        LCD.clear();
        LCD.println(DriverStationLCD.Line.kUser3, 1, "== ROBOT DISABLED ==");
        LCD.println(DriverStationLCD.Line.kUser6, 1, "DS-UI: Felix[Ver]1.5");
        LCD.updateLCD();
    }
    
    
}
