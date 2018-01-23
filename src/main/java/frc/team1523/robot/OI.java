package frc.team1523.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class OI {
    public Joystick joystick = new Joystick(RobotMap.JOYSTICK_USB_PORT);
    public XboxController gamepad = new XboxController(RobotMap.GAMEPAD_USB_PORT);
}
