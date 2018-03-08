package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.InplaceDifferentialDrive;
import frc.team1523.robot.Robot;
import frc.team1523.robot.commands.TankDrive;

import static frc.team1523.robot.Constants.*;
import static frc.team1523.robot.RobotMap.*;

/**
 * Controls tank drive
 */
public class DriveTrain extends Subsystem {

    private Spark leftMotor = new Spark(DRIVE_LEFT);
    private Spark rightMotor = new Spark(DRIVE_RIGHT);

    //        private DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);
    private InplaceDifferentialDrive drive = new InplaceDifferentialDrive(leftMotor, rightMotor);

    private double limitedJoystickYPos = 0;
    private double limitedJoystickYNeg = 0;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    private double ramp(double y) {
//        double changeY = y - limitedJoystickY;
//        if (changeY > limit) {
//            changeY = limit;
//        } else if (changeY < -limit) {
//            changeY = -limit;
//        }
//        limitedJoystickY += changeY;
//        return limitedJoystickY;
        double limit = 0.015;
        if (y > 0) {
            double changeY = y - limitedJoystickYPos;
            if (changeY > limit) {
                changeY = limit;
            } else if (changeY < -limit) {
                changeY = -limit;
            }
            limitedJoystickYPos += changeY;
            limitedJoystickYNeg = 0;
            return limitedJoystickYPos;
        } else {
            double changeY = y - limitedJoystickYNeg;
            if (changeY > limit) {
                changeY = limit;
            } else if (changeY < -limit) {
                changeY = -limit;
            }
            limitedJoystickYNeg += changeY;
            limitedJoystickYPos = 0;
            return limitedJoystickYNeg;
        }
    }

    /**
     * Sets the speed of the tank drive motors
     *
     * @param stick the input joystick
     */
    public void drive(Joystick stick) {
        double y = stick.getY();
        double z = stick.getZ();

        if (stick.getRawButton(2)) {
            y *= REDUCE_MULTIPLIER;
            z = z * TURN_REDUCE_MULTIPLIER;
        }

        if (Robot.shifter.isHigh()) {
            drive.arcadeDrive(y, -(z * TURN_MULTIPLIER));
        } else {
            drive.arcadeDrive(y, -z);
        }
//
//        rightMotor.setPeriodMultiplier()
//        drive.curvatureDrive(-stick.getY(), stick.getZ(), stick.getRawButton(2));
//        drive.inplaceDrive(stick.getY(), -stick.getZ(), stick.getX(), true);
    }

    private double squared(double input) {
        //Make sure to keep the sign so the direction you input is not changed by squaring it
        if (input > 0) {
            return input * input;
        } else {
            return -(input * input);
        }
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftMotor.set(-leftSpeed);
        rightMotor.set(rightSpeed);
    }

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