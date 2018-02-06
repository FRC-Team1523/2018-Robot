package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.Pistons;

public class Pneumatics extends Subsystem {

    public DoubleSolenoid shift = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_0 , RobotMap.SOLENOID_1);
   /* private DoubleSolenoid grabber = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_2 , RobotMap.SOLENOID_3);
    private DoubleSolenoid intake = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_4 , RobotMap.SOLENOID_5);
    private DoubleSolenoid winchLock = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_6 , RobotMap.SOLENOID_7);*/

    public DoubleSolenoid.Value shiftUpdate = DoubleSolenoid.Value.kOff;
   /* public DoubleSolenoid.Value shiftUpdate = DoubleSolenoid.Value.kOff;
    public DoubleSolenoid.Value shiftUpdate = DoubleSolenoid.Value.kOff;
    public DoubleSolenoid.Value shiftUpdate = DoubleSolenoid.Value.kOff;*/

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Pistons());
        shift.set(DoubleSolenoid.Value.kOff);
       /* grabber.set(DoubleSolenoid.Value.kOff);
        intake.set(DoubleSolenoid.Value.kOff);
        winchLock.set(DoubleSolenoid.Value.kOff);*/
    }

    private void updateShift() {
        shift.set(shiftUpdate);
    }

    /*private void updateGrabber(){
        grabber.set(grabberUpdate);
    }

    private void updateIntake(){
        intake.set(intakeUpdate);
    }

    private void updateWinch(){
        winchLock.set(winchUpdate);
    }*/

    //Shift
    public void toggleShift(){
        switch (shiftUpdate){
            case kOff:
                shiftUpdate = DoubleSolenoid.Value.kForward;
                break;
            case kForward:
                shiftUpdate = DoubleSolenoid.Value.kReverse;
                break;
            case kReverse:
                shiftUpdate = DoubleSolenoid.Value.kForward;
                break;
        }
        updateShift();
    }

    //Shift reset
    public void resetShift(){
        shiftUpdate = DoubleSolenoid.Value.kReverse;
        updateShift();
    }

    /* public void toggleGrabber(){
        if(grabberUpdate == DoubleSolenoid.Value.kOff) {
            grabberUpdate = DoubleSolenoid.Value.kForward;
        } else if(grabberUpdate == DoubleSolenoid.Value.kForward){
            grabberUpdate = DoubleSolenoid.Value.kReverse;
        } else if(grabberUpdate == DoubleSolenoid.Value.kReverse){
            grabberUpdate = DoubleSolenoid.Value.kForward;
        }
        toggleGrabber();
    } */



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
