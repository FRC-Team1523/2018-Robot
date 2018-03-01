package frc.team1523.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.InplaceDifferentialDrive;
import frc.team1523.robot.Robot;
import frc.team1523.robot.commands.TankDrive;

import static frc.team1523.robot.RobotMap.*;
import static frc.team1523.robot.Constants.*;

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
        double limit = 0.01;
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

//        y = ramp(y);

        double squared = squared(y);

//        squared = ramp(squared);

        if (stick.getRawButton(2)) {
            squared *= REDUCE_MULTIPLIER;
        }

        if (Robot.shifter.isHigh()) {
            drive.arcadeDrive(squared, -(z * TURN_MULTIPLIER));
        } else {
            drive.arcadeDrive(squared, -(z));
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