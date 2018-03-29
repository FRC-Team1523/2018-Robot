package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team1523.robot.Robot;

/**
 * Sets raw power to intake lifter
 */
public class LifterAuto extends InstantCommand {
    private LifterState state;

    public LifterAuto(LifterState state) {
        requires(Robot.lifter);
        this.state = state;
    }

    @Override
    protected void initialize() {
        if (state == LifterState.kUp) {
            Robot.lifter.setSpeed(1);
        } else if (state == LifterState.kStop) {
            Robot.lifter.setSpeed(0);
        } else {
            Robot.lifter.setSpeed(-1);
        }
    }

    public enum LifterState {
        kUp,
        kStop,
        kDown,
    }
}
