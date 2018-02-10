package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.Constants;
import frc.team1523.robot.Robot;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.Intake;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kOff;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

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


    public void activate() {
        value = kForward;
        update();
    }

    public static int Time = 2;

    private void update() {
        intake.set(value);
        if (Robot.intaker.rightSwitch.get() && Robot.intaker.leftSwitch.get()) {
            intakeMotor.set(Constants.INTAKE_SPEED);
            Timer.delay(Time);
            Robot.intaker.cleanUp();
            Timer.delay(Time);
            Robot.intaker.stopIntake();
        }
    }

    public void stopIntake() {
        intakeMotor.set(0);
    }


    public void cleanUp() {
        value = DoubleSolenoid.Value.kReverse;
        update();
    }
}
