package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.Constants;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.TankDrive;

public class DriveTrain extends Subsystem {

    private Spark leftFront = new Spark(RobotMap.DRIVE_LEFT_FRONT);
//    private Spark leftRear = new Spark(RobotMap.DRIVE_LEFT_REAR);
    private Spark rightFront = new Spark(RobotMap.DRIVE_RIGHT_FRONT);
//    private Spark rightRear = new Spark(RobotMap.DRIVE_RIGHT_REAR);

    private SpeedControllerGroup groupLeft = new SpeedControllerGroup(leftFront);
    private SpeedControllerGroup groupRight = new SpeedControllerGroup(rightFront);

    private DifferentialDrive drive = new DifferentialDrive(groupLeft, groupRight);

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    /**
     * Sets the speed of the tank drive motors
     *
     * @param stick the input joystick
     */
    public void drive(Joystick stick) {
        drive.arcadeDrive(-stick.getY(), -stick.getZ());
    }
}