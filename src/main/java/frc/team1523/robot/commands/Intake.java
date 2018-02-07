package frc.team1523.robot.commands;

import frc.team1523.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class Intake extends Command {
    public Intake() {
        requires(Robot.intaker);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (Robot.oi.gamepad.getBButtonPressed()) {
            Robot.intaker.toggle();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.armGrabber.cleanUp();
    }
}
