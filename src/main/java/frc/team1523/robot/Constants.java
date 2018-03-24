package frc.team1523.robot;

public class Constants {
    // 4 is the kx encoder resolution
    private static double ENCODER_REVOLUTION = 360;
    private static double WHEEL_DIAMETER = 7.25;
    public static double WHEEL_REVOLUTION = (Math.PI * WHEEL_DIAMETER) / ENCODER_REVOLUTION;

    public static double ANALOG_BUMPER_DEADBAND = 0.03;
    public static double WINCH_SPEED = 1.0;

    public static double TURN_MULTIPLIER = 0.75;

    public static double ARM_MUTLIPLIER = 0.8;

    public static double AUTO_TURN_SPEED = 0.5;

    public static double REDUCE_MULTIPLIER = 0.77;
    public static double TURN_REDUCE_MULTIPLIER = 0.78;
}
