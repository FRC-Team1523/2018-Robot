
package frc.team1523.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.commands.AutoDrive;
import frc.team1523.robot.subsystems.Arm;
import frc.team1523.robot.subsystems.DriveTrain;
import frc.team1523.robot.subsystems.Encoders;
import frc.team1523.robot.subsystems.Pneumatics;

public class Robot extends IterativeRobot {

    public static OI oi;
    public static DriveTrain driveTrain;
    public static Encoders encoders;
    public static Arm arm;
    public static Pneumatics pneumatics;
    public static Compressor compressor;


    public static AutoDrive autoDrive;


    @Override
    public void robotInit() {
        oi = new OI();
        driveTrain = new DriveTrain();
        arm = new Arm();
        encoders = new Encoders();

        pneumatics = new Pneumatics();
        compressor = new Compressor(RobotMap.COMPRESSOR);
        compressor.setClosedLoopControl(true);
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