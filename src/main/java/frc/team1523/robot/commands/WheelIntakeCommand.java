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
        if (Robot.oi.gamepad.getPOV() == 270) { // Left
            Robot.wheelIntake.setSpeed(1);
        } else if (Robot.oi.gamepad.getPOV() == 90) { // Right
            Robot.wheelIntake.setSpeed(-1);
        } else {
            Robot.wheelIntake.setSpeed(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
