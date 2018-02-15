package frc.team1523.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import static frc.team1523.robot.RobotMap.*;

public class OI {
    public Joystick joystick = new Joystick(JOYSTICK_USB_PORT);
    public XboxController gamepad = new XboxController(GAMEPAD_USB_PORT);
}
