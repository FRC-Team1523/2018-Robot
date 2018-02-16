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
            Robot.armGrabber.release();
        } else if (Robot.oi.gamepad.getYButtonPressed()) {
            Robot.armGrabber.grab();
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
