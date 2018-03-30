package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team1523.robot.Robot;

/**
 * Autonomous group, 2 cube, center start
 * Delivers cube to switch directly ahead and picks up cube from stack and delivers
 */
public class AutoApproachRight extends CommandGroup {
    public AutoApproachRight(double speed) {
        requires(Robot.driveTrain);
        requires(Robot.wheelIntake);

        // Forward and move right
        addSequential(new AutoDrive(speed, 18));
        addSequential(new AutoSpin(.75, -3.5));
        addSequential(new WaitCommand(.3));
        addSequential(new AutoDrive(speed, 39));
        addSequential(new WaitCommand(.5));

        // Last leg
        addSequential(new AutoSpin(.75, 8.6));
        addSequential(new AutoDrive(speed, 35));
    }
}
