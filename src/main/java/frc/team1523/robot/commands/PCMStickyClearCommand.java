package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team1523.robot.Robot;

public class PCMStickyClearCommand extends InstantCommand {
    public PCMStickyClearCommand() {
        super("Clear fault");
    }

    @Override
    public synchronized void start() {
        Robot.compressor.clearAllPCMStickyFaults();
        PowerDistributionPanel powerPanel = new PowerDistributionPanel();
        powerPanel.clearStickyFaults();
    }
}
