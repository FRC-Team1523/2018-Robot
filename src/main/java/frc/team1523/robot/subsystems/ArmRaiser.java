package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.Constants;
import frc.team1523.robot.Robot;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.ArmRaiseCommand;

/**
 * Controls armRaiser to lift the power cubes
 */
public class ArmRaiser extends Subsystem {
    private Spark armSpark = new Spark(RobotMap.ARM_SPARK);
    private DigitalInput rotationSensor;


    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ArmRaiseCommand());
//        rotationSensor = new DigitalInput(3);
    }

    public void move(XboxController gamepad) {
        // Right up
        double rightBumper = gamepad.getRawAxis(RobotMap.BUMPER_ANALOG_RIGHT);
        double leftBumper = gamepad.getRawAxis(RobotMap.BUMPER_ANALOG_LEFT);
        if (rightBumper >= Constants.ANALOG_BUMPER_DEADBAND) {
            armSpark.set(-rightBumper);
        } else if (leftBumper >= Constants.ANALOG_BUMPER_DEADBAND) {
            armSpark.set(leftBumper);
        } else {
            armSpark.set(0.0);
        }
    }
}
