package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.Constants;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.Winch;

public class WinchController extends Subsystem {
    private Spark winchSpark = new Spark(RobotMap.WINCH_SPARK);

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Winch());
    }

    public void move(Joystick joystick, XboxController gamepad) {
        // Right up
        boolean trigger = joystick.getRawButton(1);
        boolean rightBumper = gamepad.getBumper(GenericHID.Hand.kRight);
        boolean leftBumper = gamepad.getBumper(GenericHID.Hand.kLeft);
        if (trigger) { // up
            winchSpark.set(-Constants.WINCH_SPEED);
        } else if (leftBumper) { // down
            winchSpark.set(Constants.WINCH_SPEED);
        } else {
            winchSpark.set(0.0);
        }
    }
}
