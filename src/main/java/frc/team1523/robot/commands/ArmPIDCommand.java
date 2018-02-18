package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.Robot;

import static frc.team1523.robot.RobotMap.*;

public class ArmPIDCommand extends PIDCommand { // This system extends PIDSubsystem

    public Spark armSpark = new Spark(ARM_SPARK);

    public double setpoint = 0;

    private double minAngle = 154.4;
    private double maxAngle = 289.2;

    private double armDownPos = 0;
    private double witchPos = 25;
    private double wallPos = 15;
    private double scalePos = 100;


    // P: 0.04, I: 0.003, D: 0.002
    public ArmPIDCommand(double startPoint) {
        super("ArmPIDCommand", 0.04, 0.003, 0.002);
        getPIDController().setPercentTolerance(10);

        getPIDController().setContinuous(false);

        setInputRange(minAngle, maxAngle);

        getPIDController().setOutputRange(-.2, .6);// -1, 1

        getPIDController().setSetpoint(startPoint);
        setpoint = startPoint;

        getPIDController().enable();
    }


    public void setSetpoint(double setpoint) {
        if (setpoint <= maxAngle && setpoint >= minAngle) {
            this.setpoint = setpoint;
            getPIDController().setSetpoint(setpoint);
        }
    }

    public void disable() {
        getPIDController().disable();
    }

    public boolean onTarget() {
        return getPIDController().onTarget();
    }

    protected double returnPIDInput() {
        return 360 - Robot.armEncoder.getPWMAngle();
    }

    protected void usePIDOutput(double output) {
        System.out.println("Setting pid " + output);
        armSpark.set(-output);
    }

    //    @Override
    public void execute() {
        double rightBumper = Robot.oi.gamepad.getRawAxis(BUMPER_ANALOG_RIGHT);
        double leftBumper = Robot.oi.gamepad.getRawAxis(BUMPER_ANALOG_LEFT);
        System.out.println("UPDATE " + rightBumper);


        if (rightBumper > 0.05) {
            setSetpoint(setpoint + (0.75 * rightBumper));
        } else if (leftBumper > 0.05) {
            setSetpoint(setpoint - (0.75 * leftBumper));
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}