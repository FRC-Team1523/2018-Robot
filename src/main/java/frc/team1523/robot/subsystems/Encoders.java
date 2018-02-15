package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Collection of all motor encoders
 */
public class Encoders extends Subsystem {
    public Encoder left;
    public Encoder right;

    @Override
    public void initDefaultCommand() {
        left = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
        right = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
        right.setReverseDirection(true);
        // TODO: Set distance per pulse value
    }
}
