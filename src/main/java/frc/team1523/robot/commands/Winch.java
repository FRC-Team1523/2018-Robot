package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

public class Winch extends Command {
    public Winch() {
         requires(Robot.winchController);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.winchController.move(Robot.oi.gamepad);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
