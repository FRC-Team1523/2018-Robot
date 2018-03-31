package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team1523.robot.Robot;

/**
 * Sets state of the intake arms
 */
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
        // Backward
        if (state == GrabState.kRelease) {
            Robot.intakeGrabber.grab();
        } else {
            Robot.intakeGrabber.release();
        }
    }
}
