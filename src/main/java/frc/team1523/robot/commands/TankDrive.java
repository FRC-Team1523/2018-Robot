package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

public class TankDrive extends Command {
    public TankDrive() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {

    }

    /**
     * Called repeatedly as command is running
     */
    @Override
    protected void execute() {
        Robot.driveTrain.drive(Robot.oi.joystick);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
