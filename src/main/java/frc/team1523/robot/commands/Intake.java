package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

public class Intake extends Command {
    public Intake() {
        requires(Robot.intaker);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (Robot.oi.gamepad.getRawButton(6)) {
            Robot.intaker.activate();
        } else if (Robot.oi.gamepad.getRawButton(5)) {
            Robot.intaker.startMotor();
        } else if (Robot.oi.gamepad.getRawButton(9)) {
            Robot.intaker.stopMotor();
        } else if (Robot.oi.gamepad.getRawButton(10)) {
            Robot.intaker.pullIn();
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
