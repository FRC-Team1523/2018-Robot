package frc.team1523.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1523.robot.RobotMap;
import frc.team1523.robot.commands.Pistons;

public class Pneumatics extends Subsystem {

    public DoubleSolenoid shift = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_0 , RobotMap.SOLENOID_1);
    public DoubleSolenoid grabber = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_2 , RobotMap.SOLENOID_3);
    public DoubleSolenoid intake = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_4 , RobotMap.SOLENOID_5);
    public DoubleSolenoid winchLock = new DoubleSolenoid(RobotMap.P_C_M_0 ,RobotMap.SOLENOID_6 , RobotMap.SOLENOID_7);

    public DoubleSolenoid.Value shiftUpdate = DoubleSolenoid.Value.kOff;
    public DoubleSolenoid.Value grabberUpdate = DoubleSolenoid.Value.kOff;
    public DoubleSolenoid.Value intakeUpdate = DoubleSolenoid.Value.kOff;
    public DoubleSolenoid.Value winchUpdate = DoubleSolenoid.Value.kOff;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Pistons());
        shift.set(DoubleSolenoid.Value.kOff);
        grabber.set(DoubleSolenoid.Value.kOff);
        intake.set(DoubleSolenoid.Value.kOff);
        winchLock.set(DoubleSolenoid.Value.kOff);
    }

    private void updateShift() {
        shift.set(shiftUpdate);
    }

    private void updateGrabber(){
        grabber.set(grabberUpdate);
    }

    private void updateIntake(){
        intake.set(intakeUpdate);
    }

    private void updateWinch(){
        winchLock.set(winchUpdate);
    }

    //Shift
    public void toggleGrabber(){
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
        updateGrabber();
    }

    public void toggleIntake(){
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
        updateIntake();
    }

    public void toggleWinch(){
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
        updateWinch();
    }

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

    public void resetGrabber(){
        grabberUpdate = DoubleSolenoid.Value.kReverse;
        updateGrabber();
    }

    public void resetIntake(){
        intakeUpdate = DoubleSolenoid.Value.kReverse;
        updateIntake();
    }

    public void resetWinch(){
        winchUpdate = DoubleSolenoid.Value.kReverse;
        updateWinch();
    }

}
