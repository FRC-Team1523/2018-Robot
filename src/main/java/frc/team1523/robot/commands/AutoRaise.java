package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

public class AutoRaise extends Command {
    private double angle;

    public AutoRaise(double angle) {
        this.angle = angle;
    }

    @Override
    protected void initialize() {
        Robot.armPIDCommand.setSetpoint(angle);
    }

    @Override
    public boolean isFinished() {
        return Robot.armPIDCommand.onTarget();
    }
}