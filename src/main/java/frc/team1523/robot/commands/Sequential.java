package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team1523.robot.Robot;

public class Sequential extends CommandGroup {
    public Sequential() {
        requires(Robot.driveTrain);
        requires(Robot.armGrabber);
        requires(Robot.armRaiser);


        // 234.08
//        addSequential(new AutoDrive(0.35, 208.08));
//        addSequential(new AutoTurn(0.4, 90.4));
////        addSequential(new AutoRaise(ArmPIDCommand.scalePos));
//        addSequential(new AutoDrive(0.35, 193.79));
//        addSequential(new AutoTurn(0.4, -97.95));
//        addSequential(new AutoDrive(0.35, 59.2));

        addSequential(new AutoTurn(0.35, 45));
        addSequential(new AutoDrive(0.55, 15));
    }
}
