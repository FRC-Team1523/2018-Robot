//package frc.team1523.robot.auto;
//
//import edu.wpi.first.wpilibj.command.CommandGroup;
//import edu.wpi.first.wpilibj.command.WaitCommand;
//import frc.team1523.robot.Robot;
//
///**
// * Autonomous group, 2 cube, right start
// * Delivers cube to switch directly ahead and picks up cube from stack and delivers
//
// */
//public class ForwardLaunchLeft extends CommandGroup {
//    public ForwardLaunchLeft(double speed, double distance, double distance2) {
//        requires(Robot.driveTrain);
//        requires(Robot.wheelIntake);
//
//        addSequential(new AutoDrive(speed, distance));
//        addSequential(new WaitCommand(.7));
//        addSequential(new IntakeAuto(IntakeAuto.GrabState.kLaunch));
//        addSequential(new WaitCommand(.5));
//        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));
//
//        addSequential(new AutoDrive(speed, distance2));
//
//        addSequential(new WaitCommand(.5));
//        addSequential(new AutoSpin(.75, 9));
//
//
//        addSequential(new LifterAuto(LifterAuto.LifterState.kDown));
//        addSequential(new WaitCommand(.22));
//
//        addSequential(new LifterAuto(LifterAuto.LifterState.kStop));
//        addSequential(new IntakeAuto(IntakeAuto.GrabState.kGrab));
//        addSequential(new AutoDrive(speed, 25));
//        addSequential(new WaitCommand(1.5));
//        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));
//
//        addSequential(new AutoDrive(speed, distance2));
//
//        addSequential(new WaitCommand(.5));
//        addSequential(new AutoSpin(.75, -9));
//
//        // Raise
//        addSequential(new LifterAuto(LifterAuto.LifterState.kUp));
//        addSequential(new WaitCommand(.9));
//        addSequential(new LifterAuto(LifterAuto.LifterState.kStop));
//
//        // Forward and launch
//
//        addSequential(new AutoDrive(speed, 18));
//        addSequential(new WaitCommand(.8));
//        addSequential(new IntakeAuto(IntakeAuto.GrabState.kLaunch));
//        addSequential(new WaitCommand(.5));
//        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));
//
//        // Reverse (three cube)
//    }
//}
//

package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.team1523.robot.Robot;

/**
 * Autonomous group, 2 cube, left start
 * Delivers cube to switch directly ahead and picks up cube from stack and delivers
 */
public class ForwardLaunchLeft extends CommandGroup {
    public ForwardLaunchLeft(double speed, double distance, double distance2) {
        requires(Robot.driveTrain);
        requires(Robot.wheelIntake);

        addSequential(new AutoDrive(speed, distance));
        addSequential(new WaitCommand(.7));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kLaunch));
        addSequential(new WaitCommand(.5));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));

        addSequential(new AutoDrive(speed, distance2));

        addSequential(new WaitCommand(.5));
        addSequential(new AutoSpin(.75, -17));


        addSequential(new LifterAuto(LifterAuto.LifterState.kDown));
        addSequential(new WaitCommand(.26));

        addSequential(new LifterAuto(LifterAuto.LifterState.kStop));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kGrab));
        addSequential(new AutoDrive(speed, 25));
        addSequential(new WaitCommand(1.5));
        addSequential(new IntakeAuto(IntakeAuto.GrabState.kStop));

        addSequential(new AutoDrive(speed, distance2));

        addSequential(new WaitCommand(.5));
        addSequential(new AutoSpin(.75, 7.5));

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
