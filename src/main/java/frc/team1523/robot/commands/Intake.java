package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command {

    private IntakeThread intakeThread;

    public Intake() {
        requires(Robot.intaker);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (Robot.oi.gamepad.getYButtonPressed()) {
            if (intakeThread != null) {
                intakeThread.interrupt();
                Robot.intaker.stopMotor();
            }
            intakeThread = new IntakeThread();
            intakeThread.run();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.armGrabber.cleanUp();
    }
}
