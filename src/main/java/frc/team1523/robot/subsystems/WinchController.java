package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.Winch;

import static frc.team1523.robot.Constants.WINCH_SPEED;
import static frc.team1523.robot.RobotMap.WINCH_SPARK;

public class WinchController extends Subsystem {
    private Spark winchSpark = new Spark(WINCH_SPARK);

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Winch());
    }

    public void move(Joystick joystick, XboxController gamepad) {
        // Right up
        boolean trigger = joystick.getRawButton(1);
        boolean reverse_trigger = joystick.getRawButton(8);
        boolean rightBumper = gamepad.getBumper(GenericHID.Hand.kRight);
        boolean leftBumper = gamepad.getBumper(GenericHID.Hand.kLeft);
        boolean backButton = gamepad.getRawButton(7);
        if (trigger) { // up
            winchSpark.set(WINCH_SPEED);
        } else if (reverse_trigger) {
            winchSpark.set(-WINCH_SPEED);
        } else {
            winchSpark.set(0.0);
        }
    }
}