package frc.team1523.robot.commands;

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
        doDelay();
        Robot.intaker.cleanUp();
//        if (Robot.intaker.rightSwitch.get() && Robot.intaker.leftSwitch.get()) {
//            Robot.intaker.startMotor();
//            doDelay();
//            Robot.intaker.cleanUp();
//        }
    }

    private void doDelay() {
        try {
            int delay = 2000;
            Thread.sleep(delay);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
