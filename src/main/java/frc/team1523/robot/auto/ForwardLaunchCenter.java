package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team1523.robot.Robot;

public class ForwardLaunchCenter extends CommandGroup {
    public ForwardLaunchCenter(double speed, double distance, double distance2) {
        requires(Robot.driveTrain);
        requires(Robot.wheelIntake);

        addSequential(new AutoDrive(speed, distance));
        addSequential(new WaitCommand(.8));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kLaunch));
        addSequential(new WaitCommand(.5));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));

        addSequential(new AutoDrive(speed, distance2));

        addSequential(new WaitCommand(.5));
        addSequential(new AutoSpin(.75, -17));


        addSequential(new LifterAuto(LifterAuto.LifterState.kDown));
        addSequential(new WaitCommand(.32));

        addSequential(new LifterAuto(LifterAuto.LifterState.kStop));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kGrab));
        addSequential(new AutoDrive(speed, 25));
        addSequential(new WaitCommand(1.5));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));

        addSequential(new AutoDrive(speed, distance2));

        addSequential(new WaitCommand(.5));
        addSequential(new AutoSpin(.75, 11.5));

        // Raise
        addSequential(new LifterAuto(LifterAuto.LifterState.kUp));
        addSequential(new WaitCommand(.9));
        addSequential(new LifterAuto(LifterAuto.LifterState.kStop));

        addSequential(new AutoDrive(speed, 18));
        addSequential(new WaitCommand(.6));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kLaunch));
        addSequential(new WaitCommand(.5));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));
    }
}
