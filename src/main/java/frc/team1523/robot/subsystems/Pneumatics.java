package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.Pistons;

public class Pneumatics extends Subsystem {

   // private Solenoid s1 = new Solenoid(RobotMap.SOLENOID_1);
   // private Solenoid s2 = new Solenoid();
    public DoubleSolenoid shift = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_0 , RobotMap.SOLENOID_1);
   /* private DoubleSolenoid grabber = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_2 , RobotMap.SOLENOID_3);
    private DoubleSolenoid intake = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_4 , RobotMap.SOLENOID_5);
    private DoubleSolenoid winchLock = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_6 , RobotMap.SOLENOID_7); */

    public DoubleSolenoid.Value shiftUpdate = DoubleSolenoid.Value.kOff;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Pistons());
        shift.set(DoubleSolenoid.Value.kOff);
       /* grabber.set(DoubleSolenoid.Value.kOff);
        intake.set(DoubleSolenoid.Value.kOff);
        winchLock.set(DoubleSolenoid.Value.kOff); */
       // resetPistons();
    }

    private void updateShift() {
        shift.set(shiftUpdate);
    }

    public void toggleShift(){
        if(shiftUpdate == DoubleSolenoid.Value.kOff) {
            shiftUpdate = DoubleSolenoid.Value.kForward;
            updateShift();
        } else if(shiftUpdate == DoubleSolenoid.Value.kForward){
            shiftUpdate = DoubleSolenoid.Value.kReverse;
            updateShift();
        } else if(shiftUpdate == DoubleSolenoid.Value.kReverse){
            shiftUpdate = DoubleSolenoid.Value.kForward;
            updateShift();
        }
    }

    public void resetShift(){
        shiftUpdate = DoubleSolenoid.Value.kReverse;
        updateShift();
    }



  /*  public void resetPistons() {
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
    */
}
