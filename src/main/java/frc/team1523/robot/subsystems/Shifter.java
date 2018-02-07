package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.Shift;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kOff;

public class Shifter extends Subsystem {
    private DoubleSolenoid shifter = new DoubleSolenoid(RobotMap.PCM_0, RobotMap.SOLENOID_0, RobotMap.SOLENOID_1);
    private DoubleSolenoid.Value value = kOff;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Shift());
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
        shifter.set(value);
    }

    public void cleanUp() {
        value = DoubleSolenoid.Value.kReverse;
        update();
    }
}
