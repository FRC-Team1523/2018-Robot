package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.Constants;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.Intake;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class Intaker extends Subsystem {
    private DoubleSolenoid intake = new DoubleSolenoid(RobotMap.PCM_0, RobotMap.SOLENOID_4, RobotMap.SOLENOID_5);
    private DoubleSolenoid.Value value = kOff;

    private Spark intakeMotor = new Spark(RobotMap.INTAKE_MOTOR);

    public DigitalInput leftSwitch;
    public DigitalInput rightSwitch;


    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Intake());
//        leftSwitch = new DigitalInput(0);
//        rightSwitch = new DigitalInput(1);
    }

    public void startMotor() {
        intakeMotor.set(Constants.INTAKE_SPEED);
    }

    public void activate() {
        update(kForward);
    }

    private void update(DoubleSolenoid.Value newValue) {
        value = newValue;
        intake.set(value);
    }

    public void stopMotor() {
        intakeMotor.set(0);
    }


    public void cleanUp() {
        update(kReverse);
    }
}
