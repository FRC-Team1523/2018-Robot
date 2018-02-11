package frc.team1523.robot.subsystems;

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
    private Spark ArmSpark = new Spark(RobotMap.ARM_SPARK);

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ArmRaiseCommand());
    }

    public void move(XboxController gamepad) {
        // Right up
        double rightBumper = gamepad.getRawAxis(RobotMap.BUMPER_ANALOG_RIGHT);
        double leftBumper = gamepad.getRawAxis(RobotMap.BUMPER_ANALOG_LEFT);
        if (rightBumper >= Constants.ANGALOG_BUMPER_DEADBAND) {
            ArmSpark.set(-rightBumper);
        } else if (leftBumper >= Constants.ANGALOG_BUMPER_DEADBAND) {
            ArmSpark.set(leftBumper);
        } else {
            ArmSpark.set(0.0);
        }
    }
}
