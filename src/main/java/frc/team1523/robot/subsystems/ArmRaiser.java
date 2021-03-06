package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.ArmRaiseCommand;
import static frc.team1523.robot.Constants.*;
import static frc.team1523.robot.RobotMap.*;

/**
 * Controls armRaiser to lift the power cubes
 */
public class ArmRaiser extends Subsystem {
//    public Spark armSpark = new Spark(ARM_SPARK);
    private DigitalInput rotationSensor;


    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ArmRaiseCommand());
//        rotationSensor = new DigitalInput(3);
    }

    private static double clamp(double value) {
        return Math.min(.5, Math.max(-1, value));
    }

    public void setPower(double power) {
//        armSpark.set(-power);
    }

    public void move(XboxController gamepad) {
        // TODO: PID
        // Right up
//        double rightBumper = gamepad.getRawAxis(BUMPER_ANALOG_RIGHT);
//        double leftBumper = gamepad.getRawAxis(BUMPER_ANALOG_LEFT);
//        if (rightBumper >= ANALOG_BUMPER_DEADBAND) {
//            armSpark.set(clamp(-((rightBumper * rightBumper) * ARM_MUTLIPLIER)));
//        } else if (leftBumper >= ANALOG_BUMPER_DEADBAND) {
//            armSpark.set(clamp((leftBumper * leftBumper) * ARM_MUTLIPLIER));
//        } else {
//            armSpark.set(0.0);
//        }
    }
}
