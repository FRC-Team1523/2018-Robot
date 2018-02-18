package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

public class ArmRaiseCommand extends Command {
    public ArmRaiseCommand() {
        requires(Robot.armRaiser);
    }

    @Override
    protected void initialize() {

    }

    /**
     * Called repeatedly as command is running
     */
    @Override
    protected void execute() {
//        Robot.armRaiser.move(Robot.oi.gamepad);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}