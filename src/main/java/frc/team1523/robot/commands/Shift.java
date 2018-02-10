package frc.team1523.robot.commands;

import frc.team1523.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class Shift extends Command {
    public Shift() {
        requires(Robot.armGrabber);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (Robot.oi.gamepad.getRawButtonPressed(3)) {
            Robot.shifter.down();
        } else if (Robot.oi.gamepad.getRawButtonPressed(4)) {
            Robot.shifter.up();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.shifter.cleanUp();
    }
}
