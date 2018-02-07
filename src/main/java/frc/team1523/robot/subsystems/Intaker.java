package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.Intake;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kOff;

public class Intaker extends Subsystem {
    private DoubleSolenoid intake = new DoubleSolenoid(RobotMap.PCM_0, RobotMap.SOLENOID_4, RobotMap.SOLENOID_5);
    private DoubleSolenoid.Value value = kOff;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Intake());
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
    }

    public void cleanUp() {
        value = DoubleSolenoid.Value.kReverse;
        update();
    }
}
