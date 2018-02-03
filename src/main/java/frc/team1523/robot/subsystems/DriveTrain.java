package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.InplaceDifferentialDrive;
import frc.team1523.robot.Robot;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.TankDrive;

public class DriveTrain extends Subsystem {

    private Spark leftMotor = new Spark(RobotMap.DRIVE_LEFT);
    private Spark rightMotor = new Spark(RobotMap.DRIVE_RIGHT);

    //    private DifferentialDrive drive = new DifferentialDrive(groupLeft, groupRight);
    private InplaceDifferentialDrive drive = new InplaceDifferentialDrive(leftMotor, rightMotor);

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
//        drive.arcadeDrive(-stick.getY(), stick.getZ());
//        drive.curvatureDrive(-stick.getY(), stick.getZ(), stick.getRawButton(2));
        drive.inplaceDrive(-stick.getY(), stick.getZ(), stick.getX(), true);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftMotor.set(leftSpeed);
        rightMotor.set(-rightSpeed);
    }

    /**
     * Sets drive motor encoder distances to zero
     */
    public void reset() {
        Robot.encoders.left.reset();
        Robot.encoders.right.reset();

    }

    /**
     * Stops all drive motors
     */
    public void stopMotors() {
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }

}