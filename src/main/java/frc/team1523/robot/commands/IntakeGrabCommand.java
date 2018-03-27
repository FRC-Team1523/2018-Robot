package frc.team1523.robot.commands;

import frc.team1523.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class IntakeGrabCommand extends Command {
    public IntakeGrabCommand() {
        requires(Robot.intakeGrabber);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (Robot.oi.gamepad.getBButtonPressed()) {
            Robot.intakeGrabber.grab();
        } else if (Robot.oi.gamepad.getXButtonPressed()) {
            Robot.intakeGrabber.release();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intakeGrabber.cleanUp();
    }
}
