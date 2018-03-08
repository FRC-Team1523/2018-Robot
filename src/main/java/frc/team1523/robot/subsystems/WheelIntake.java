package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.WheelIntakeCommand;

import static frc.team1523.robot.RobotMap.ARM_INTAKE_MOTOR_1;
import static frc.team1523.robot.RobotMap.ARM_INTAKE_MOTOR_2;

public class WheelIntake extends Subsystem {
    private Spark intakeMotor1 = new Spark(ARM_INTAKE_MOTOR_1);
    private Spark intakeMotor2 = new Spark(ARM_INTAKE_MOTOR_2);

    public WheelIntake() {
        intakeMotor2.setInverted(true);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new WheelIntakeCommand());
        System.out.println("init");
    }

    public void setSpeed(double value) {
        intakeMotor1.set(value);
        intakeMotor2.set(value);
    }
}