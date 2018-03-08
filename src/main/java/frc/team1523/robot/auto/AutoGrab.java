package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team1523.robot.Robot;

public class AutoGrab extends InstantCommand {
    public enum GrabState {
        kGrab,
        kRelease,
    }

    private GrabState state;

    public AutoGrab(GrabState state) {
        requires(Robot.driveTrain);
        this.state = state;
    }

    @Override
    protected void initialize() {
        if (state == GrabState.kGrab) {
            Robot.armGrabber.grab();
        } else {
            Robot.armGrabber.release();
        }
    }
}
