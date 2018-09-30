package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.LifterCommand;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import static frc.team1523.robot.RobotMap.*;

public class Lifter extends Subsystem {
    private DoubleSolenoid lifter = new DoubleSolenoid(PCM_0, LIFTER_A, LIFTER_B);

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new LifterCommand());
        raise();
    }


    public void raise() {
        update(kForward);
    }

    public void lower() {
        update(kReverse);
    }

    private void update(DoubleSolenoid.Value newValue) {
        lifter.set(newValue);
    }
}