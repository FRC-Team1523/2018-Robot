package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.Constants;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.Intake;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kOff;

public class Intaker extends Subsystem {

    private DoubleSolenoid intake = new DoubleSolenoid(RobotMap.PCM_0, RobotMap.SOLENOID_4, RobotMap.SOLENOID_5);
    private DoubleSolenoid.Value value = kOff;

    private Spark intakeMotor = new Spark(RobotMap.INTAKE_MOTOR);

    public DigitalInput leftSwitch;
    public DigitalInput rightSwitch;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Intake());
        leftSwitch = new DigitalInput(0);
        rightSwitch = new DigitalInput(1);
    }

    public void toggle() {
        switch (value) {
            case kOff:
                value = DoubleSolenoid.Value.kForward;
                break;
            case kForward:
                value = DoubleSolenoid.Value.kReverse;
                break;
            case kReverse:
                value = DoubleSolenoid.Value.kForward;
                break;
        }
        update();
    }

    private void update() {
        intake.set(value);
        if(leftSwitch.get() && rightSwitch.get()){
            intakeMotor.set(Constants.INTAKE_SPEED);
        } else
            stopIntake();

    }

    public void stopIntake(){
        intakeMotor.set(0);
    }


    public void cleanUp() {
        value = DoubleSolenoid.Value.kReverse;
        stopIntake();
        update();
    }
}
