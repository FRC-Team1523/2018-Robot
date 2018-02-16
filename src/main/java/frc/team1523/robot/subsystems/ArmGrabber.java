package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.ArmGrab;
import static frc.team1523.robot.RobotMap.*;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class ArmGrabber extends Subsystem {
    private DoubleSolenoid grabber = new DoubleSolenoid(PCM_0, GRABBER_A, GRABBER_B);
    private DoubleSolenoid.Value value = kOff;

    @Override
    public void initDefaultCommand() { setDefaultCommand(new ArmGrab()); }

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

    public void grab() {
        update(kForward);
    }

    public void release() {
        update(kReverse);
    }

    private void update(DoubleSolenoid.Value newValue) {
        value = newValue;
        grabber.set(value);
    }

    public void cleanUp() {
        update(kReverse);
    }
}
