package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.ArmCommand;

/**
 * Controls arm to lift the power cubes
 */
public class Arm extends Subsystem {
    private Spark ArmSpark = new Spark(0);

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ArmCommand());
    }

    public void move(XboxController stick) {
        // Right up
        double speed = 0.5;
        if (stick.getRawButton(6)) {
            ArmSpark.set(speed);
        } else if (stick.getRawButton(5)) {
            ArmSpark.set(-speed);
        } else {
            ArmSpark.set(0.0);
        }
    }
}
