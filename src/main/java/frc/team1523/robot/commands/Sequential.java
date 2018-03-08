package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team1523.robot.Robot;
import frc.team1523.robot.auto.AutoDrive;
import frc.team1523.robot.auto.AutoTurn;

public class Sequential extends CommandGroup {
    public Sequential() {
        requires(Robot.driveTrain);
        requires(Robot.armGrabber);

        addSequential(new AutoDrive(0.35, 24));
        addSequential(new AutoTurn(0.35, -90));
        addSequential(new AutoDrive(0.35, 10));
        addSequential(new AutoTurn(0.35, -90));
        addSequential(new Command() {
            @Override
            protected boolean isFinished() {
                Robot.intaker.activate();
                return true;
            }
        });
        addSequential(new WaitCommand(2));
        addSequential(new Command() {
            @Override
            protected boolean isFinished() {
                Robot.intaker.pullIn();
                return true;
            }
        });

//        addSequential(new AutoDrive(0.3, 60));
//        addSequential(new AutoRaise(200));
//        addSequential(new AutoDrive(0.3, -60));
//        addSequential(new AutoRaise(0));

    }
}
