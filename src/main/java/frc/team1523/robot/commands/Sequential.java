package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team1523.robot.Robot;

public class Sequential extends CommandGroup {
    public Sequential() {
        requires(Robot.driveTrain);
        addSequential(new AutoDrive(0.5, 150));
        addSequential(new WaitCommand(2));
        addSequential(new AutoDrive(0.5, 150));
    }
}
