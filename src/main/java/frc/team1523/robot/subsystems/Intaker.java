package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.Intake;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;
import static frc.team1523.robot.Constants.INTAKE_SPEED;
import static frc.team1523.robot.RobotMap.*;

public class Intaker extends Subsystem {
    private DoubleSolenoid intake = new DoubleSolenoid(PCM_0, INTAKE_A, INTAKE_B);

    private Spark intakeMotor = new Spark(INTAKE_MOTOR);

    public DigitalInput leftSwitch;
    public DigitalInput rightSwitch;


    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Intake());
        intakeMotor.setInverted(true);
        leftSwitch = new DigitalInput(LIMIT_SWITCH_LEFT);
        rightSwitch = new DigitalInput(LIMIT_SWITCH_RIGHT);
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
