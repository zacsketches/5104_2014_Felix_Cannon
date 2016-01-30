package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;

public class Console {

    public CheesyVisionServer breakervision;
    public Talon motorLeft;
    public Talon motorRight;
    public RobotDriveSteering robotdrive;
    public Compressor compressor;
    public Joystick joystick;
    public Solenoid load;
    public Solenoid unload;
    public Relay fire;
    public static boolean isInverted;
    public static boolean toggle;
    public static boolean ftoggle;
    
    public void init() {
        motorLeft = new Talon(1);
        motorRight = new Talon(2);
        robotdrive = new RobotDriveSteering(motorLeft, motorRight);
        robotdrive.setInvertedMotor(RobotDriveSteering.MotorType.kRearLeft, true);
        robotdrive.setInvertedMotor(RobotDriveSteering.MotorType.kRearRight, true);
        compressor = new Compressor(1, 1);
        compressor.start();
        fire = new Relay(2);
        load = new Solenoid(1);
        unload = new Solenoid(2);
        joystick = new Joystick(1);
        isInverted = false;
        toggle = false;
        ftoggle = true;
        breakervision = CheesyVisionServer.getInstance();
        breakervision.setPort(1180);
        breakervision.start();
        System.out.println("[INFO] Robot Initialized");
    }    
    public void teleopInit() {
        breakervision.reset();
        breakervision.startSamplingCounts();
    }
    
    public void run() {
        robotdrive.arcadeDrive(joystick, true);
        StationCtrl.display();
        
        if (StationCtrl.ds.getDigitalIn(1)) {
            if (joystick.getRawButton(1)) {
                StationCtrl.ds.setDigitalOut(2, true);
            } else {
                StationCtrl.ds.setDigitalOut(2, false);
            }
        }
        
        if(joystick.getRawButton(6)){
            load.set(false);
            unload.set(true);
        } else {
            load.set(true);
            unload.set(false);
        }
        
        if (joystick.getRawButton(1)){
            fire.set(Relay.Value.kForward);
        }else{
            fire.set(Relay.Value.kOff);
        }
        
        
        
        if (joystick.getRawButton(7)) {
            isInverted = true;
        } else {
            isInverted = false;
        }
        
    }

    public void disabled() {
        breakervision.stopSamplingCounts();
    }
}
