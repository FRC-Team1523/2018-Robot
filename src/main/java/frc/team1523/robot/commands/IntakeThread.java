package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.team1523.robot.Robot;

class IntakeThread extends Thread {

    /**
     * manually push piston
     * limit switches closed = activate motor
     * wait 1 second
     * automatically retract piston
     * manually turn off motor
     */

    @Override
    public void run() {
        Robot.intaker.activate();
        Robot.intaker.startMotor();
//        doDelay();
        Timer.delay(1);
        Robot.intaker.cleanUp();
//        if (Robot.intaker.rightSwitch.get() && Robot.intaker.leftSwitch.get()) {
//            Robot.intaker.startMotor();
//            doDelay();
//            Robot.intaker.cleanUp();
//        }
    }
}
