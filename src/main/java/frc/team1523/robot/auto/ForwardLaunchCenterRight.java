package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team1523.robot.Robot;

/**
 * Autonomous group, 2 cube, center start
 * Delivers cube to switch directly ahead and picks up cube from stack and delivers
 */
public class ForwardLaunchCenterRight extends CommandGroup {
    public ForwardLaunchCenterRight(double speed, double distance, double distance2) {
        requires(Robot.driveTrain);
        requires(Robot.wheelIntake);

        // Forward and move right
        addSequential(new AutoDrive(speed, 18));
        addSequential(new AutoSpin(.75, -3.5));
        addSequential(new WaitCommand(.3));
        addSequential(new AutoDrive(speed, 39));
        addSequential(new WaitCommand(.5));

        // Last leg
        addSequential(new AutoSpin(.75, 8.6));
        addSequential(new AutoDrive(speed, 30));
        addSequential(new WaitCommand(.15));

        // Launch
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kLaunch));
        addSequential(new WaitCommand(.5));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));

        // Back up
        addSequential(new AutoDrive(speed, distance2));
        addSequential(new WaitCommand(.7));

        addSequential(new AutoSpin(.7, 6.9));

        // Drop intake
        addSequential(new LifterAuto(LifterAuto.LifterState.kDown));
        addSequential(new WaitCommand(.32));
        addSequential(new LifterAuto(LifterAuto.LifterState.kStop));

        // Drive to pyramid
        addSequential(new AutoDrive(speed, 7));

        // Start intake
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kGrab));

        // Drive into pyramid
        addSequential(new AutoDrive(speed, 11.5));

        addSequential(new WaitCommand(.8));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));

        // Back up
        addSequential(new AutoDrive(speed, -12));
        addSequential(new WaitCommand(.7));

        // Turn to face switch
        addSequential(new AutoSpin(.7, -7.9));
        // Raise
        addSequential(new LifterAuto(LifterAuto.LifterState.kUp));
        addSequential(new WaitCommand(.9));
        addSequential(new LifterAuto(LifterAuto.LifterState.kStop));

        // Drive to switch
        addSequential(new AutoDrive(speed, 24));
        addSequential(new WaitCommand(.3));


        // Launch
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kLaunch));
        addSequential(new WaitCommand(.75));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));
    }
}
