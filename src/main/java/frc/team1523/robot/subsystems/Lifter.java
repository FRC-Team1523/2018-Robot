package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.LifterCommand;

public class Lifter extends Subsystem {
//    private Spark motor = new Spark(LIFTER_MOTOR);

    public Lifter() {
        /*intakeMotor2.setInverted(true);*/
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new LifterCommand());
    }

    public void setSpeed(double value) {
//        motor.set(value);
    }
}