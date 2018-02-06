package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;
import frc.team1523.robot.subsystems.Pneumatics;

public class Pistons extends Command {
    public Pistons() {
        requires(Robot.pneumatics);
    }

    @Override
    protected void initialize() {
        Robot.pneumatics.shiftUpdate = DoubleSolenoid.Value.kOff;
        Robot.pneumatics.shift.set(Robot.pneumatics.shiftUpdate);
    }

    @Override
    protected void execute() {
        if (Robot.oi.gamepad.getAButtonPressed()) {
            Robot.pneumatics.toggleShift();
        }
    }


    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.pneumatics.resetShift();
    }
}
