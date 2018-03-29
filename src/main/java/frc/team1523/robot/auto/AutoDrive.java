package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

/**
 * Automatically drive the robot a given distance at a given speed
 * TODO: Use both encoders
 */
public class AutoDrive extends Command {
    private double distance;
    private double leftSpeed;
    private double rightSpeed;
    private boolean finished;

    public AutoDrive(double speed, double distance) {
        requires(Robot.driveTrain);
        this.distance = distance;
        this.leftSpeed = speed;
        this.rightSpeed = speed;
        finished = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.driveTrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double rightEncoder = Robot.encoders.right.getDistance();
        double leftEncoder = Robot.encoders.left.getDistance();

        // Drive Backwards
        if (distance < 0) {
            boolean rightFinished = true;
            boolean leftFinished = true;

            // If the encoders have not reached the right distance
            if (rightEncoder > distance) {
                // Drive backwards
                rightFinished = false;
            }
            if (leftEncoder > distance) {
                leftFinished = false;
            }

            if (leftEncoder > rightEncoder) {
                leftSpeed *= -.05;
                rightSpeed *= .05;
            }

            if (leftFinished && rightFinished) {
                finished = true;
            } else {
                Robot.driveTrain.drive(-leftSpeed, -rightSpeed);
            }

            // Drive Forwards
        } else {
            // If the encoders have not reached the right distance
            boolean rightFinished = true;
            boolean leftFinished = true;

            // If the encoders have not reached the right distance
            if (rightEncoder > distance) {
                // Drive backwards
                rightFinished = false;
            }
            if (leftEncoder > distance) {
                leftFinished = false;
            }

            if (leftEncoder > rightEncoder) {
                leftSpeed *= .05;
                rightSpeed *= -.05;
            }

            if (leftFinished && rightFinished) {
                finished = true;
            } else {
                Robot.driveTrain.drive(-leftSpeed, -rightSpeed);
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.driveTrain.stopMotors();
        Robot.driveTrain.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}