package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team1523.robot.Robot;

public class AutoRaise extends CommandGroup {
    public AutoRaise(double power, double duration) {
        // TOOD: Fix this
        requires(Robot.armRaiser);
        requires(Robot.armGrabber);
        addSequential(new Command() {
            @Override
            protected boolean isFinished() {
                Robot.armGrabber.grab();
                return true;
            }
        });
        addSequential(new Command() {
            @Override
            protected boolean isFinished() {
                Robot.armRaiser.setPower(power);
                return true;
            }
        });
        addSequential(new WaitCommand(duration));
        addSequential(new Command() {
            @Override
            protected boolean isFinished() {
                Robot.armRaiser.setPower(0);
                return true;
            }
        });
        addSequential(new Command() {
            @Override
            protected boolean isFinished() {
                Robot.armGrabber.release();
                return true;
            }
        });
//        addSequential(new AutoArmPower(power));
//        addSequential(new AutoArmPower(0.0));
    }
}
