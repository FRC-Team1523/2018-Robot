
package frc.team1523.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.commands.AutoDrive;
import frc.team1523.robot.commands.PCMStickyClearCommand;
import frc.team1523.robot.subsystems.*;

import static frc.team1523.robot.Constants.*;
import static frc.team1523.robot.RobotMap.*;


public class Robot extends IterativeRobot {

    public static OI oi;
    public static DriveTrain driveTrain;
    public static Encoders encoders;
    public static ArmRaiser armRaiser;
    public static ArmGrabber armGrabber;
    public static Shifter shifter;
    public static Intaker intaker;
    public static WinchLocker winchLocker;
    public static WinchController winchController;
    @SuppressWarnings("FieldCanBeLocal")
    public static Compressor compressor;

    public static AHRS ahrs;

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();


    @Override
    public void robotInit() {
        oi = new OI();
        driveTrain = new DriveTrain();
        armRaiser = new ArmRaiser();
        encoders = new Encoders();
        armGrabber = new ArmGrabber();
        shifter = new Shifter();
        intaker = new Intaker();
        winchController = new WinchController();
        winchLocker = new WinchLocker();

        compressor = new Compressor(COMPRESSOR);
        compressor.setClosedLoopControl(true);

        SmartDashboard.putData(new PCMStickyClearCommand());

        CameraServer.getInstance().startAutomaticCapture(0);

        try {
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }

        chooser.addObject("Drive forward", new AutoDrive(0.25, 500));
        chooser.addDefault("Nothing", null);
        SmartDashboard.putData("Auto", chooser);
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Encoder 1", encoders.left.getDistance());
        SmartDashboard.putNumber("Encoder 2", encoders.right.getDistance());
//        System.out.println(counter.getDistance());
//        SmartDashboard.putNumber("Get", counter.get());
//        SmartDashboard.putNumber("Period", counter.getPeriod());
//        SmartDashboard.putNumber("Distance", counter.getDistance());
//        SmartDashboard.putNumber("Rate", counter.getRate());
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}