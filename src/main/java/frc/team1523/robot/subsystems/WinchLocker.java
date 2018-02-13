package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.WinchLock;
//import frc.team1523.robot.commands.WinchLock;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class WinchLocker extends Subsystem {
    private DoubleSolenoid winch = new DoubleSolenoid(RobotMap.PCM_0, RobotMap.WINCH_LOCK_A, RobotMap.WINCH_LOCK_B);
    private DoubleSolenoid.Value value = kOff;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new WinchLock());
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

    private void update(DoubleSolenoid.Value newValue) {
        value = newValue;
        winch.set(newValue);
    }

    public void cleanUp() {
        update(kReverse);
    }
}
