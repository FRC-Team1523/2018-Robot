package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.commands.ArmRaiseCommand;

/**
 * Controls armRaiser to lift the power cubes
 */
public class ArmRaiser extends Subsystem {
    public DigitalInput rotationSensorL;
    
    private Spark ArmSpark = new Spark(0);

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new ArmRaiseCommand());
        rotationSensorL = new DigitalInput(3);
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
