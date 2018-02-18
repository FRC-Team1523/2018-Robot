package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team1523.robot.Robot;

public class Sequential extends CommandGroup {
    public Sequential() {
        requires(Robot.driveTrain);
        requires(Robot.armGrabber);
//        addParallel(new AutoDrive(0.50, 600));
//        addParallel(new AutoRaise(0.45, 1.5));
        addSequential(new Command() {
            @Override
            protected boolean isFinished() {
                Robot.armGrabber.grab();
                return true;
            }
        });
        addSequential(new AutoDrive(0.65, 1400));
        addSequential(new WaitCommand(0.5));
        addSequential(new AutoTurn(0.35 , -90));
        addParallel(new AutoDrive(0.3, 275));
        addParallel(new AutoRaise(0.56, 1.75));
        addSequential(new AutoDrive(0.33, -75));
    }
}
