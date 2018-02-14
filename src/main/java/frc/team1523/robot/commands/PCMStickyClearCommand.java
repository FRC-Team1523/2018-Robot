package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team1523.robot.Robot;

public class PCMStickyClearCommand extends InstantCommand {
    public PCMStickyClearCommand() {
        super("Clear PCM Sticky Faults");
        Robot.compressor.clearAllPCMStickyFaults();
    }
}
