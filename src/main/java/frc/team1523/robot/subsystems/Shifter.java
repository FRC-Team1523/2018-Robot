package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import static frc.team1523.robot.RobotMap.*;
import frc.team1523.robot.commands.Shift;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class Shifter extends Subsystem {
    private DoubleSolenoid shifter = new DoubleSolenoid(PCM_0, SHIFTER_A, SHIFTER_B);
    private DoubleSolenoid.Value value = kOff;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Shift());
        downShift();
    }

    public void toggle() {
        switch (value) {
            case kOff:
                update(kForward);
                break;
            case kForward:
                update(kReverse);
                break;
            case kReverse:
                update(kForward);
                break;
        }
    }

    public void upShift() {
        update(kForward);
    }

    public void downShift() {
        update(kReverse);
    }

    private void update(DoubleSolenoid.Value newValue) {
        value = newValue;
        shifter.set(newValue);
    }

    public boolean isHigh() {
        return value == kForward;
    }

    public void cleanUp() {
        update(kReverse);
    }
}
