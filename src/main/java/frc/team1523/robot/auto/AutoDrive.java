package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

/**
 * Automatically drive the robot a given distance at a given speed
 * TODO: Use both encoders
 */
public class AutoDrive extends Command {
    private double distance;
    private double speed;
    private boolean finished;

    public AutoDrive(double speed, double distance) {
        requires(Robot.driveTrain);
        this.distance = distance;
        this.speed = speed;
        finished = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.driveTrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // Drive Backwards
        if (distance < 0) {
            // If the encoders have not reached the right distance
            if (Robot.encoders.right.getDistance() > distance) {
                // Drive backwards
                Robot.driveTrain.drive(-speed, -speed);
            } else {
                //Stop
                finished = true;
            }
            // Drive Forwards
        } else {
            // If the encoders have not reached the right distance
            if (Robot.encoders.left.getDistance() < distance) {
                // Drive forwards
                Robot.driveTrain.drive(speed, speed);
            } else {
                // Stop
                finished = true;
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