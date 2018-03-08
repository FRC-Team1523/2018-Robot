package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.WheelArmCommand;

import static frc.team1523.robot.RobotMap.*;

public class WheelArmSubsystem extends Subsystem {
    private Spark intakeMotor1 = new Spark(ARM_INTAKE_ARM_MOTOR_1);
    private Spark intakeMotor2 = new Spark(ARM_INTAKE_ARM_MOTOR_2);

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new WheelArmCommand());
    }

    public void setLeft(double value) {
        intakeMotor1.set(value);
    }

    public void setRight(double value) {
        intakeMotor2.set(value);
    }
}