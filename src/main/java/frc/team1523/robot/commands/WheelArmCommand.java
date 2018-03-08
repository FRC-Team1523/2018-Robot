package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

public class WheelArmCommand extends Command {
    public WheelArmCommand() {
        requires(Robot.wheelIntakeArm);
    }

    /**
     * Called repeatedly as command is running
     */

    @Override
    protected void execute() {
        double speed = Robot.oi.gamepad.getRawAxis(0);
        if (Math.abs(speed) >= 0.03) {
            Robot.wheelIntakeArm.setSpeed(squared(speed));
        } else {
            Robot.wheelIntakeArm.setSpeed(0);
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
