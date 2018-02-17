package frc.team1523.robot.commands;

import frc.team1523.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class ArmGrab extends Command {
    public ArmGrab() {
        requires(Robot.armGrabber);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (Robot.oi.gamepad.getXButtonPressed()) {
            Robot.armGrabber.grab();
        } else if (Robot.oi.gamepad.getBButtonPressed()) {
            Robot.armGrabber.release();
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
