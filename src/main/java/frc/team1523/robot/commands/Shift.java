package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class Shift extends Command {
    public Shift() {
        requires(Robot.shifter);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (Robot.oi.joystick.getRawButtonPressed(3)) {
            SmartDashboard.putBoolean("Shift", true);
            Robot.shifter.downShift();
        } else if (Robot.oi.joystick.getRawButtonPressed(4)) {
            SmartDashboard.putBoolean("Shift", false );
            Robot.shifter.upShift();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.shifter.cleanUp();
    }
}
