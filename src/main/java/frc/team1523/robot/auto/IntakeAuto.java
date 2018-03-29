package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team1523.robot.Robot;

/**
 * Sets raw power intake wheels
 */
public class IntakeAuto extends InstantCommand {
    public enum GrabState {
        kLaunch,
        kStop,
        kGrab,
    }

    private GrabState state;

    public IntakeAuto(GrabState state) {
        requires(Robot.wheelIntake);
        this.state = state;
    }

    @Override
    protected void initialize() {
        if (state == GrabState.kLaunch) {
            Robot.wheelIntake.setSpeed(1);
        } else if (state == GrabState.kStop) {
            Robot.wheelIntake.setSpeed(0);
        } else {
            Robot.wheelIntake.setSpeed(-1);
        }
    }
}
