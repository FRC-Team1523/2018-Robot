package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team1523.robot.Robot;

/**
 * Sets raw power to intake lifter
 */
public class LifterAutoPowered extends InstantCommand {
    private LifterState state;
    private double power;

    public LifterAutoPowered(LifterState state, double power) {
        requires(Robot.lifter);
        this.state = state;
        this.power = power;
    }

    @Override
    protected void initialize() {
        if (state == LifterState.kUp) {
            Robot.lifter.setSpeed(power);
        } else if (state == LifterState.kStop) {
            Robot.lifter.setSpeed(0);
        } else {
            Robot.lifter.setSpeed(-power);
        }
    }

    public enum LifterState {
        kUp,
        kStop,
        kDown,
    }
}
