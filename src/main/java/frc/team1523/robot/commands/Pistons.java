package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.Robot;

public class Pistons extends Command {
    public Pistons() {
        requires(Robot.pneumatics);
    }

    @Override
    protected void initialize() {
        Robot.pneumatics.resetPistons();
    }

    @Override
    protected void execute() {
        if (Robot.oi.gamepad.getAButton()) {
            Robot.pneumatics.togglePistons();
        }
        SmartDashboard.putBoolean("Activated:", Robot.pneumatics.activated);
    }


    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }
}
