package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.team1523.robot.Robot;

import static frc.team1523.robot.RobotMap.*;

public class ArmPIDCommand extends PIDCommand { // This system extends PIDSubsystem

    private Spark armSpark = new Spark(ARM_SPARK);

    public double setpoint = 0;

    private static double minAngle = 154.4;
    private static double maxAngle = 283.0;

    public static double switchPos = 196;
    public static double scalePos = 277;

    public static double cubeIntakePos = 162;


    // P: 0.03, I: 0.002, D: 0.0
    public ArmPIDCommand(double startPoint) {
        // 0.03, 0.002, 0.005
//        super("ArmPIDCommand", 0.04, 0.001, 0);
        super("ArmPIDCommand", 0.03, 0.002, 0);
        getPIDController().setPercentTolerance(3);

        getPIDController().setContinuous(false);

        setInputRange(minAngle, maxAngle);

        getPIDController().setOutputRange(-.2, .6);// -.2, .6

        getPIDController().setSetpoint(startPoint);
        setpoint = startPoint;
    }

    private double clamp(double value) {
        return Math.max(minAngle, Math.min(maxAngle, value));
    }

    public void setSetpoint(double setpoint) {
        this.setpoint = clamp(setpoint);
        getPIDController().setSetpoint(this.setpoint);
    }

    public void enable() {
        getPIDController().enable();
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
        armSpark.set(-output);
    }

    // TODO: Fix this
    public void execute() {
        if (Robot.oi.joystick.getRawButton(9)) {
            setSetpoint(switchPos);
            return;
        }
        if (Robot.oi.joystick.getRawButton(10)) {
            setSetpoint(scalePos);
            return;
        }
        if (Robot.oi.joystick.getRawButton(11)) {
            setSetpoint(0);
            return;
        }


        double rightBumper = Robot.oi.gamepad.getRawAxis(BUMPER_ANALOG_RIGHT);
        double leftBumper = Robot.oi.gamepad.getRawAxis(BUMPER_ANALOG_LEFT);

        if (rightBumper > 0.05) {
            setSetpoint(setpoint + (0.85 * rightBumper));
        } else if (leftBumper > 0.05) {
            setSetpoint(setpoint - (0.7 * leftBumper));
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}