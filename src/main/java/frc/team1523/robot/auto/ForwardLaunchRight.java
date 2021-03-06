package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team1523.robot.Robot;

/**
 * Autonomous group, 2 cube, right start
 * Delivers cube to switch directly ahead and picks up cube from stack and delivers

 */
public class ForwardLaunchRight extends CommandGroup {
    public ForwardLaunchRight(double speed, double distance, double distance2) {
        requires(Robot.driveTrain);
        requires(Robot.wheelIntake);

        addSequential(new AutoDrive(speed, distance));
        addSequential(new WaitCommand(.7));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kLaunch));
        addSequential(new WaitCommand(.5));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));

        addSequential(new AutoDrive(speed, distance2));

        addSequential(new WaitCommand(.5));
        addSequential(new AutoSpin(.75, 9));

        // Arm down
        addSequential(new LifterAuto(LifterAuto.LifterState.kDown));
        addSequential(new WaitCommand(.75));

        // Arm open
        addSequential(new AutoGrab(AutoGrab.GrabState.kRelease));
        addSequential(new WaitCommand(.75));



        // Arm close
        addSequential(new AutoGrab(AutoGrab.GrabState.kGrab));



        addSequential(new LifterAuto(LifterAuto.LifterState.kStop));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kGrab));
        addSequential(new AutoDrive(speed, 25));
        addSequential(new WaitCommand(1.5));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));

        addSequential(new AutoDrive(speed, distance2));

        addSequential(new WaitCommand(.5));
        addSequential(new AutoSpin(.75, -9));

        // Raise
        addSequential(new LifterAuto(LifterAuto.LifterState.kUp));
        addSequential(new WaitCommand(.9));

        // Forward and launch

        addSequential(new AutoDrive(speed, 18));
        addSequential(new WaitCommand(.8));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kLaunch));
        addSequential(new WaitCommand(.5));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));

        // Reverse (three cube)
    }
}
