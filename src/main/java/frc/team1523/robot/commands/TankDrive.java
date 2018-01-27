package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Constants;
import frc.team1523.robot.Robot;

public class TankDrive extends Command {
    public TankDrive() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {

    }

    /**
     * Called repeatedly as command is running
     */
    @Override
    protected void execute() {
        Robot.driveTrain.drive(Robot.oi.joystick);
    }

    private double adaptiveDeadband(double value) {
        if (Math.abs(value) < Constants.DEAD_ZONE) {
            return 0;
        }

        if (value > 0) {
            return (value - Constants.DEAD_ZONE) / (1 - Constants.DEAD_ZONE);
        } else {
            return -(Math.abs(value) - Constants.DEAD_ZONE) / (1 - Constants.DEAD_ZONE);
        }
    }

    private double boringDeadband(double value) {
        if (Math.abs(value) < Constants.DEAD_ZONE) {
            return 0;
        } else {
            return value;
        }
    }

    private double square(double speed) {
        return Math.copySign(Math.pow(speed, 2), speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {

    }
}
