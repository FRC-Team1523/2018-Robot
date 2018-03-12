package frc.team1523.robot.auto.right;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team1523.robot.Robot;
import frc.team1523.robot.auto.AutoDrive;
import frc.team1523.robot.auto.AutoTurn;
import openrio.powerup.MatchData;

public class AutoSwitchSideRight extends CommandGroup {
    public AutoSwitchSideRight(double driveSpeed, double turnSpeed) {
        requires(Robot.driveTrain);
        requires(Robot.armGrabber);

        addSequential(new AutoDrive(driveSpeed, 192)); // Drive past switch
        addSequential(new AutoTurn(turnSpeed, -90)); // Turn toward switch
        addSequential(new Command() {
            Command command;
            @Override
            public void start() {
                MatchData.OwnedSide side = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
                if (side == MatchData.OwnedSide.LEFT) {
                    command = new AutoClose(driveSpeed, turnSpeed);
                    command.start();
                } else if (side == MatchData.OwnedSide.RIGHT) {
                    command = new AutoFar(driveSpeed, turnSpeed);
                    command.start();
                }
            }
            @Override
            protected boolean isFinished() {
                return command.isCompleted();
            }
        });
    }
}
