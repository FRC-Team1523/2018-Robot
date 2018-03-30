package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;
import frc.team1523.robot.auto.LifterAutoPowered;
import frc.team1523.robot.auto.MoveIntakeTimed;

public class LifterCommand extends Command {
    private MoveIntakeTimed moveIntakeCommand;
    public LifterCommand() {
        requires(Robot.lifter);
    }

    /**
     * Called repeatedly as command is running
     */

    @Override
    protected void execute() {
        if (Robot.oi.gamepad.getYButtonPressed()) {
            moveIntakeCommand = new MoveIntakeTimed(
                    LifterAutoPowered.LifterState.kDown,
                    0.75,
                    1.5,
                    LifterAutoPowered.LifterState.kStop,
                    0.0
            );
            moveIntakeCommand.start();
        }

        double speed = Robot.oi.gamepad.getRawAxis(1);
        if (Math.abs(speed) >= 0.03) {
            Robot.lifter.setSpeed(squared(speed*.9));
        } else {
            Robot.lifter.setSpeed(0);
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