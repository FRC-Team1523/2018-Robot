package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team1523.robot.Robot;

/**
 * Sets raw power to intake lifter
 */
public class LifterAuto extends InstantCommand {
    public enum LifterState {
        kUp,
        kStop,
        kDown,
    }

    private LifterState state;

    public LifterAuto(LifterState state) {
        requires(Robot.lifter);
        this.state = state;
    }

    @Override
    protected void initialize() {
        // Up
        if (state == LifterState.kUp) {
            Robot.lifter.raise();
        } else {
            Robot.lifter.lower();
        }
    }

}
