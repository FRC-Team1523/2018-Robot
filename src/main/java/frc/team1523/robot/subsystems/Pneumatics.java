package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.Pistons;

public class Pneumatics extends Subsystem {

    private Solenoid s1 = new Solenoid(RobotMap.SOLENOID_1);
    private Solenoid s2 = new Solenoid(RobotMap.SOLENOID_2);

    public boolean activated = false;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Pistons());
        resetPistons();
    }

    private void updatePistons() {
        s1.set(activated);
        s2.set(activated);
    }

    public void resetPistons() {
        activated = false;
        updatePistons();
    }

    public void enablePistons() {
        activated = true;
        updatePistons();
    }

    public void disablePistons() {
        activated = false;
        updatePistons();
    }

    public void togglePistons() {
        activated = !activated;
        updatePistons();
    }
}
