
package frc.team1523.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.commands.AutoDrive;
import frc.team1523.robot.commands.PCMStickyClearCommand;
import frc.team1523.robot.subsystems.*;


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

    public static AutoDrive autoDrive;


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

        compressor = new Compressor(RobotMap.COMPRESSOR);
        compressor.setClosedLoopControl(true);

        SmartDashboard.putData(new PCMStickyClearCommand());

        CameraServer.getInstance().startAutomaticCapture(0);
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
//        System.out.println(Robot.oi.joystick.getRawButton(7));
    }

    @Override
    public void autonomousInit() {
//        autoDrive = new AutoDrive(0.25, 5 * Constants.WHEEL_INCH);
//        autoDrive.start();
//        autonomousCommand = chooser.getSelected();
//        if (autonomousCommand != null) {
//            autonomousCommand.start();
//        }
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