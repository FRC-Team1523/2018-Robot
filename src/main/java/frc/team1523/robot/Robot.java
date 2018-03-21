
package frc.team1523.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.auto.*;
import frc.team1523.robot.auto.left.AutoSwitchSideLeft;
import frc.team1523.robot.auto.right.AutoSwitchSideRight;
import frc.team1523.robot.commands.ArmPIDCommand;
import frc.team1523.robot.commands.PCMStickyClearCommand;
import frc.team1523.robot.commands.ResetEncodersCommand;
import frc.team1523.robot.subsystems.*;
import openrio.powerup.MatchData;

import static frc.team1523.robot.RobotMap.COMPRESSOR;


public class Robot extends IterativeRobot {

    public static OI oi;
    public static DriveTrain driveTrain;
    public static Encoders encoders;
    public static ArmRaiser armRaiser;
    public static ArmGrabber armGrabber;
    public static Shifter shifter;
    public static WinchLocker winchLocker;
    public static WheelIntake wheelIntake;
    public static WinchController winchController;
    @SuppressWarnings("FieldCanBeLocal")
    public static Compressor compressor;

    public static CTREMagneticEncoder armEncoder;
    public static ArmPIDCommand armPIDCommand;
    //    public static SetArmSetpoint armSetpointer;
    public static AHRS ahrs;

    private static MatchData.OwnedSide ownedSwitchSide;

    AutoDrive autoDrive;

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

        chooser.addObject("Drive forward", autoDrive);
        chooser.addObject("Switch - Left start", new AutoSwitchSideLeft(0.4, 0.22));
        chooser.addObject("Switch - Right start", new AutoSwitchSideRight(0.4, 0.22));
        chooser.addObject("Auto drive - right", new AutoDumpStartRight(0.6, 100));
        chooser.addObject("Auto drive - left", new AutoDumpStartLeft(0.6, 100));
//        chooser.addObject("Grab open", new AutoGrab(AutoGrab.GrabState.kRelease));
//        chooser.addObject("Grab close", new AutoGrab(AutoGrab.GrabState.kGrab));
//        chooser.addObject("Turn 45", new AutoTurn(0.25, 45));
//        chooser.addObject("Turn 90", new AutoTurn(0.25, 90));
//        chooser.addObject("Turn 360", new AutoTurn(0.35, 360));
//        chooser.addObject("Arm Raise", new AutoRaise(200));
//        chooser.addObject("Sequence", new Sequential());
//        chooser.addObject("Center Cube", new AutoCenterCubeCommand(20));
        chooser.addDefault("Nothing", new WaitCommand(0));
        SmartDashboard.putData("Auto", chooser);

        armEncoder = new CTREMagneticEncoder(4);
        armPIDCommand = new ArmPIDCommand(armEncoder.getPWMAngle());

        autoDrive = new AutoDrive(0.6, 100);
//        armPIDCommand.setSetpoint(200);

//        armSetpointer = new SetArmSetpoint(200);
    }

    public static MatchData.OwnedSide getOwnedSide() {
        if (ownedSwitchSide == null) {
            MatchData.OwnedSide side = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
            if (side != MatchData.OwnedSide.UNKNOWN) {
                ownedSwitchSide = side;
            }
            return side;
        } else {
            return ownedSwitchSide;
        }
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
//        armPIDCommand.disable();
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();

        // Not called automatically from PIDCommand
        armPIDCommand.execute();


        SmartDashboard.putNumber("Encoder left", encoders.left.getDistance());
        SmartDashboard.putNumber("Encoder Right", encoders.right.getDistance());

        SmartDashboard.putNumber("Angle", Robot.ahrs.getAngle());

//        SmartDashboard.putBoolean("Target", armPIDCommand.onTarget());

//        double set = SmartDashboard.getNumber("Setpoint", 0.0);
//        armPIDCommand.setSetpoint(set);
//        SmartDashboard.putNumber("Pitch", ahrs.getPitch());
//        SmartDashboard.putNumber("Yaw", ahrs.getYaw());
//        SmartDashboard.putNumber("Roll", ahrs.getRoll());
        SmartDashboard.putNumber("Angle-Roll", ahrs.getAngle() / ahrs.getRoll());

        SmartDashboard.putNumber("Arm Angle", armEncoder.getPWMAngle());
///        SmartDashboard.putNumber("Setpoint", armPIDCommand.setpoint);
    }

    private void updateArmSetpoint() {
//        armPIDCommand.setSetpoint(armEncoder.getPWMAngle());
    }

    @Override
    public void autonomousInit() {
        updateArmSetpoint();
//        armPIDCommand.enable();
        //        autonomousCommand.start();
        autonomousCommand = chooser.getSelected();
        if (autonomousCommand != null) {
            autonomousCommand.start();
        } else {
            autonomousCommand = autoDrive;
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
//        armPIDCommand.enable();
    }


    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}