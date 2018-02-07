package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.ArmGrab;
import frc.team1523.robot.commands.WinchLock;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kOff;

public class WinchLocker extends Subsystem {
    private DoubleSolenoid whinch = new DoubleSolenoid(RobotMap.PCM_0, RobotMap.SOLENOID_2, RobotMap.SOLENOID_3);
    private DoubleSolenoid.Value value = kOff;

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new WinchLock());
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
        whinch.set(value);
    }

    public void cleanUp() {
        value = DoubleSolenoid.Value.kReverse;
        update();
    }
}
