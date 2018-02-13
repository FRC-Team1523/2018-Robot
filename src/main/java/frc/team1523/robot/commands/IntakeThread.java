package frc.team1523.robot.commands;

import frc.team1523.robot.Robot;

public class IntakeThread extends Thread {

    public int delay = 2000;

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
        doDelay();
        Robot.intaker.cleanUp();
//        if (Robot.intaker.rightSwitch.get() && Robot.intaker.leftSwitch.get()) {
//            Robot.intaker.startMotor();
//            doDelay();
//            Robot.intaker.cleanUp();
//        }
    }

    public void doDelay() {
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}