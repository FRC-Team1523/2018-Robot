package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team1523.robot.Robot;

public class ResetEncodersCommand extends InstantCommand {
    public ResetEncodersCommand() {
        super("Reset encoders");
    }

    @Override
    public synchronized void start() {
        Robot.driveTrain.reset();
    }
}
