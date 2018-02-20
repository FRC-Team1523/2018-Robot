package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

public class AutoCenterCubeCommand extends Command {
    private double maxDistance;
    private boolean finished = false;

    public AutoCenterCubeCommand(double maxDistance) {
        this.maxDistance = maxDistance;
        requires(Robot.driveTrain);
        requires(Robot.intaker);
    }

    @Override
    protected void initialize() {
        Robot.driveTrain.reset();
    }

    /**
     * Called repeatedly as command is running
     */
    @Override
    protected void execute() {
        boolean left = Robot.intaker.leftSwitch.get();
        boolean right = Robot.intaker.rightSwitch.get();
        double distanceTraveled = Robot.encoders.left.getDistance();

        if (distanceTraveled > maxDistance) {
            Robot.driveTrain.stopMotors();
            finished = true;
        } else if (!left && !right) {
            Robot.driveTrain.drive(0.25, 0.25);
        } else if (left && !right) {
            Robot.driveTrain.drive(0.25, 0.35);
        } else if (!left && right) {
            Robot.driveTrain.drive(0.35, 0.25);
        }
//        Robot.armRaiser.move(Robot.oi.gamepad);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}