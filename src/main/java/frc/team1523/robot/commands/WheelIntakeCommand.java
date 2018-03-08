package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

public class WheelIntakeCommand extends Command {
    public WheelIntakeCommand() {
        requires(Robot.wheelIntake);
    }

    /**
     * Called repeatedly as command is running
     */

    @Override
    protected void execute() {
        double speed = Robot.oi.gamepad.getRawAxis(5);
        if (Math.abs(speed) >= 0.03) {
            Robot.wheelIntake.setSpeed(squared(speed));
        } else {
            Robot.wheelIntake.setSpeed(0);
        }
    }

    private double squared(double input) {
        // Make sure to keep the sign so the direction you input is not changed by squaring it
        if (input > 0) {
            return input * input;
        } else {
            return -(input * input);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}