package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team1523.robot.Robot;

import static frc.team1523.robot.RobotMap.LIFTER_MOTOR;

public class LifterCommand extends PIDCommand { // This system extends PIDSubsystem

    public double setpoint = 0;
    private Spark lifterMotor = new Spark(LIFTER_MOTOR);

    //    private double minAngle = 154.4;
//    private double maxAngle = 289.2;
    private double minAngle = 62;
    private double maxAngle = 186.2;

//    private double switchPos = 196;
//    private double scalePos = 277;

    private double switchPos = 78;
    private double scalePos = 192;


    // P: 0.04, I: 0.003, D: 0.002
    public LifterCommand(double startPoint) {
//        super("LifterCommand", 0.06, 0.003, 0.004);
        super("LifterCommand", 0, 0, 0);
        getPIDController().setPercentTolerance(10);

        getPIDController().setContinuous(false);

        setInputRange(minAngle, maxAngle);

        getPIDController().setOutputRange(-.4, .7);

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
        return Robot.armEncoder.getPWMAngle();
    }

    protected void usePIDOutput(double output) {
        lifterMotor.set(-output);
    }

    // TODO: Fix this
    public void execute() {
        SmartDashboard.putData(this);

        double input = Robot.oi.gamepad.getRawAxis(1);

        if (Math.abs(input) > 0.05) {
            setSetpoint(setpoint + input);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}

//public class LifterCommand extends Command {
//    public LifterCommand() {
//        requires(Robot.lifter);
//    }
//
//    /**
//     * Called repeatedly as command is running
//     */
//
//    @Override
//    protected void execute() {
//        double speed = Robot.oi.gamepad.getRawAxis(1);
//        if (Math.abs(speed) >= 0.03) {
//            Robot.lifter.setSpeed(squared(speed*.9));
//        } else {
//            Robot.lifter.setSpeed(0);
//        }
//    }
//
//    private double squared(double input) {
//        // Make sure to keep the sign so the direction you input is not changed by squaring it
//        if (input > 0) {
//            return input * input;
//        } else {
//            return -(input * input);
//        }
//    }
//
//    @Override
//    protected boolean isFinished() {
//        return false;
//    }
//}