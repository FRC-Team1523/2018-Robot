package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team1523.robot.Robot;

public class AutoGrab extends InstantCommand {
    public enum GrabState {
        kGrab,
        kRelease,
    }

    public AutoGrab(GrabState state) {
        requires(Robot.driveTrain);
        if (state == GrabState.kGrab) {
            Robot.armGrabber.grab();
        } else {
            Robot.armGrabber.release();
        }
    }
}
