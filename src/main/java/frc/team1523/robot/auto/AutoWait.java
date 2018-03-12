package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team1523.robot.Robot;

public class AutoWait extends CommandGroup {
    public AutoWait(double speed, double distance) {
        requires(Robot.driveTrain);

//        addSequential(new WaitCommand(9));
        addSequential(new AutoDumpStartRight(speed, distance));
    }
}
