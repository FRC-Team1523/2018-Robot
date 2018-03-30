package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team1523.robot.Robot;

public class MoveIntakeTimed extends CommandGroup {
    public MoveIntakeTimed(LifterAutoPowered.LifterState startState, double startPower, double time, LifterAutoPowered.LifterState endState, double endPower) {
        requires(Robot.lifter);
        addSequential(new LifterAutoPowered(startState, startPower));
        addSequential(new WaitCommand(time));
        addSequential(new LifterAutoPowered(endState, endPower));
    }
}
