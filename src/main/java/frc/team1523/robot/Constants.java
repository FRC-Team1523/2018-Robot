package frc.team1523.robot;

public class Constants {
    private static double ENCODER_REVOLUTION = 360;
    private static double WHEEL_DIAMETER = 7.25;
    public static double PULSES_PER_INCH = 1440; // 360 * 4x
    //    public static double WHEEL_INCH = 108.649774484;
    public static double WHEEL_INCH = ENCODER_REVOLUTION / (Math.PI * WHEEL_DIAMETER);
    public static double INTAKE_SPEED = .25;

    public static double ANALOG_BUMPER_DEADBAND = 0.03;
    public static double WINCH_SPEED = 1.0;

    public static double TURN_MULTIPLIER = 0.75;

    public static double ARM_MUTLIPLIER = 0.8;

    public static double AUTO_TURN_SPEED = 0.25;
}
