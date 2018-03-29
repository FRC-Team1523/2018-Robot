package frc.team1523.robot;

import edu.wpi.first.wpilibj.command.Command;
import openrio.powerup.MatchData;

public class AutoSideWrapper extends Command {
    private Command leftCommand;
    private Command rightCommand;
    private Command activeCommand;
    private MatchData.GameFeature targetFeature;

    public AutoSideWrapper(Command left, Command right, MatchData.GameFeature feature) {
        leftCommand = left;
        rightCommand = right;
        targetFeature = feature;
    }

    // Or start()
    @Override
    protected void initialize() {
        MatchData.OwnedSide side = MatchData.getOwnedSide(targetFeature);
        if (side == MatchData.OwnedSide.LEFT) {
            activeCommand = leftCommand;
        } else if (side == MatchData.OwnedSide.RIGHT) {
            activeCommand = rightCommand;
        }
        activeCommand.start();
    }

    @Override
    protected boolean isFinished() {
        return activeCommand.isCompleted();
    }
}
