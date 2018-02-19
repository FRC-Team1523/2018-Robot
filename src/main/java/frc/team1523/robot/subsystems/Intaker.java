package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import static frc.team1523.robot.Constants.*;
import static frc.team1523.robot.RobotMap.*;
import frc.team1523.robot.commands.Intake;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class Intaker extends Subsystem {
    private DoubleSolenoid intake = new DoubleSolenoid(PCM_0, INTAKE_A, INTAKE_B);

    private Spark intakeMotor = new Spark(INTAKE_MOTOR);

    public DigitalInput leftSwitch;
    public DigitalInput rightSwitch;


    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Intake());
//        leftSwitch = new DigitalInput(0);
//        rightSwitch = new DigitalInput(1);
    }

    public void startMotor() {
        intakeMotor.set(INTAKE_SPEED);
    }

    public void activate() {
        update(kForward);
    }

    private void update(DoubleSolenoid.Value newValue) {
        intake.set(newValue);
    }

    public void stopMotor() {
        intakeMotor.set(0);
    }

    public void pullIn() {
        update(kReverse);
    }

    public void cleanUp() {
        update(kReverse);
        stopMotor();
    }
}
