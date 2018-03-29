package frc.team1523.robot.auto.right;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team1523.robot.Robot;
import frc.team1523.robot.auto.AutoDrive;
import frc.team1523.robot.auto.AutoTurn;

class AutoClose extends CommandGroup {
    AutoClose(double driveSpeed, double turnSpeed) {
        requires(Robot.driveTrain);

        addSequential(new AutoDrive(driveSpeed, 60)); // Drive to switch midpoint
        addSequential(new AutoTurn(-90)); // Turn to face switch
        addSequential(new AutoDrive(driveSpeed, 22)); // Drive into switch
    }
}
