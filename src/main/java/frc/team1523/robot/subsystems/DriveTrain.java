package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.Constants;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.TankDrive;

public class DriveTrain extends Subsystem {

    private Talon left_front = new Talon(RobotMap.DRIVE_LEFT_FRONT);
    private Talon left_rear = new Talon(RobotMap.DRIVE_LEFT_REAR);
    private Talon right_front = new Talon(RobotMap.DRIVE_RIGHT_FRONT);
    private Spark right_rear = new Spark(RobotMap.DRIVE_RIGHT_REAR);

    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
        left_front.setInverted(true);
        left_rear.setInverted(true);
    }

    /**
     * Sets the speed of the tank drive motors
     *
     * @param left  the left motor speed
     * @param right the right motor speed
     */
    public void setMotors(double left, double right) {
        left = clamp(left);
        right = clamp(right);

        left_front.set(left);
        left_rear.set(left*1.7);

        right_front.set(left);
        right_rear.set(left);
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