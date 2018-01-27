package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.Constants;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.TankDrive;

public class DriveTrain extends Subsystem {

    private Talon left_front = new Talon(RobotMap.DRIVE_LEFT_FRONT);
    private Talon left_rear = new Talon(RobotMap.DRIVE_LEFT_REAR);
    private Talon right_front = new Talon(RobotMap.DRIVE_RIGHT_FRONT);
    private Talon right_rear = new Talon(RobotMap.DRIVE_RIGHT_REAR);

    private SpeedControllerGroup group_left = new SpeedControllerGroup(left_front, left_rear);
    private SpeedControllerGroup group_right = new SpeedControllerGroup(right_front, right_rear);

    private DifferentialDrive drive = new DifferentialDrive(group_left, group_right);

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

    /**
     * Clamp the speed so as to not exceed the maximum supported values of the motors
     *
     * @param speed the raw speed
     * @return the clamped speed
     */
    private double clamp(double speed) {
        return Math.max(Constants.DRIVE_MOTOR_MIN, Math.min(Constants.DRIVE_MOTOR_MAX, speed));
    }
}