package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.Pistons;

public class Pneumatics extends Subsystem {

    Solenoid s1 = new Solenoid(RobotMap.SOLENOID_1);
    Solenoid s2 = new Solenoid(RobotMap.SOLENOID_2);

    public boolean activated = false;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Pistons());
        resetPistons();
    }

    public void resetPistons(){
        activated = false;
        s1.set(false);
        s2.set(false);
    }

    public void pistonsOn(){
        activated = true;
        s1.set(true);
        s2.set(true);
    }

}
