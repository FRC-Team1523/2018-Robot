package frc.team1523.robot.commands;

import frc.team1523.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class WinchLock extends Command {
    public WinchLock() {
        requires(Robot.winchLocker);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (Robot.oi.joystick.getRawButton(7)) {
//            Robot.winchLocker.toggle();
            Robot.winchLocker.setLocked();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.winchLocker.cleanUp();
    }
}
