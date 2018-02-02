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

    private Spark left_front = new Spark(RobotMap.DRIVE_LEFT_FRONT);
//    private Spark left_rear = new Spark(RobotMap.DRIVE_LEFT_REAR);
    private Spark right_front = new Spark(RobotMap.DRIVE_RIGHT_FRONT);
//    private Spark right_rear = new Spark(RobotMap.DRIVE_RIGHT_REAR);

//    private SpeedControllerGroup group_left = new SpeedControllerGroup(left_front, left_rear);
//    private SpeedControllerGroup group_right = new SpeedControllerGroup(right_front, right_rear);

    private SpeedControllerGroup group_left = new SpeedControllerGroup(left_front);
    private SpeedControllerGroup group_right = new SpeedControllerGroup(right_front);

    private DifferentialDrive drive = new DifferentialDrive(group_left, group_right);

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