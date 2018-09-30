package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;
import frc.team1523.robot.auto.LifterAutoPowered;
import frc.team1523.robot.auto.MoveIntakeTimed;

public class LifterCommand extends Command {
    public LifterCommand() {
        requires(Robot.lifter);
    }

    /**
     * Called repeatedly as command is running
     */

    @Override
    protected void execute() {
        if (Robot.oi.gamepad.getYButtonPressed()) {
            Robot.lifter.raise();
        } else if (Robot.oi.gamepad.getAButtonPressed()) {
            Robot.lifter.lower();
        }

    }


    @Override
    protected boolean isFinished() {
        return false;
    }
}