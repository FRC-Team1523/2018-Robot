
package frc.team1523.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.commands.*;
import frc.team1523.robot.subsystems.*;

import static frc.team1523.robot.RobotMap.*;


public class Robot extends IterativeRobot {

    public static OI oi;
    public static DriveTrain driveTrain;
    public static Encoders encoders;
    public static ArmRaiser armRaiser;
    public static ArmGrabber armGrabber;
    public static Shifter shifter;
    public static Intaker intaker;
    public static WheelIntake wheelIntake;
    public static WinchLocker winchLocker;
    public static WinchController winchController;
    @SuppressWarnings("FieldCanBeLocal")
    public static Compressor compressor;

    public static CTREMagneticEncoder armEncoder;
    public static ArmPIDCommand armPIDCommand;
    //    public static SetArmSetpoint armSetpointer;
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
        wheelIntake = new WheelIntake();
        winchController = new WinchController();
        winchLocker = new WinchLocker();

        compressor = new Compressor(COMPRESSOR);
        compressor.setClosedLoopControl(true);

        SmartDashboard.putData(new PCMStickyClearCommand());
        SmartDashboard.putData(new ResetEncodersCommand());

        CameraServer.getInstance().startAutomaticCapture(0);
        CameraServer.getInstance().startAutomaticCapture(1);

        try {
            ahrs = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }

        chooser.addObject("Drive forward", new AutoDrive(0.55, 650));
        chooser.addObject("Grab open", new AutoGrab(AutoGrab.GrabState.kRelease));
        chooser.addObject("Grab close", new AutoGrab(AutoGrab.GrabState.kGrab));
        chooser.addObject("Turn 45", new AutoTurn(0.25, 45));
        chooser.addObject("Turn 90", new AutoTurn(0.25, 90));
        chooser.addObject("Turn 360", new AutoTurn(0.35, 360));
        chooser.addObject("Arm Raise", new AutoRaise(200));
        chooser.addObject("Sequence", new Sequential());
        chooser.addObject("Center Cube", new AutoCenterCubeCommand(20));
        chooser.addDefault("Nothing", null);
        SmartDashboard.putData("Auto", chooser);

        armEncoder = new CTREMagneticEncoder(4);

        armPIDCommand = new ArmPIDCommand(360 - armEncoder.getPWMAngle());
//        armPIDCommand.setSetpoint(200);

//        armSetpointer = new SetArmSetpoint(200);
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        armPIDCommand.disable();
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();

        // Not called automatically from PIDCommand
        armPIDCommand.execute();


        SmartDashboard.putNumber("Encoder Left", encoders.left.getDistance());
        SmartDashboard.putNumber("Encoder Right", encoders.right.getDistance());
        SmartDashboard.putBoolean("Reduce", Robot.oi.joystick.getRawButton(2));

//        Robot.ahrs.get
        SmartDashboard.putNumber("Angle", Robot.ahrs.getAngle());
//        SmartDashboard.putNumber("Roll", Robot.ahrs.getRoll());
//        SmartDashboard.putNumber("Yaw", Robot.ahrs.getYaw());
//        SmartDashboard.putNumber("Pitch", Robot.ahrs.getPitch());

        SmartDashboard.putBoolean("Target", armPIDCommand.onTarget());

//        double set = SmartDashboard.getNumber("Setpoint", 0.0);
//        armPIDCommand.setSetpoint(set);

        SmartDashboard.putNumber("Arm Angle", 360 - armEncoder.getPWMAngle());
        SmartDashboard.putNumber("Setpoint", armPIDCommand.setpoint);
//        System.out.println(SmartDashboard.getNumber("INPUT", 0));
    }

    private void updateArmSetpoint() {
        armPIDCommand.setSetpoint(360 - armEncoder.getPWMAngle());
    }

    @Override
    public void autonomousInit() {
        updateArmSetpoint();
        armPIDCommand.enable();
        //        autonomousCommand.start();
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
        updateArmSetpoint();
        armPIDCommand.enable();
    }



    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}