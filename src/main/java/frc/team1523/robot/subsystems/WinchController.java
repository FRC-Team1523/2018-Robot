package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
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

    public void move(XboxController gamepad) {
        System.out.println(gamepad.getBumper(GenericHID.Hand.kRight));
        // Right up
        boolean rightBumper = gamepad.getBumper(GenericHID.Hand.kRight);
        boolean leftBumper = gamepad.getBumper(GenericHID.Hand.kLeft);
        if (rightBumper) {
            winchSpark.set(Constants.WINCH_SPEED);
        } else if (leftBumper) {
            winchSpark.set(-Constants.WINCH_SPEED);
        } else {
            winchSpark.set(0.0);
        }
    }
}
