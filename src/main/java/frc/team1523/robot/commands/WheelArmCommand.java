package frc.team1523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

public class WheelArmCommand extends Command {
    public WheelArmCommand() {
        requires(Robot.wheelIntakeArm);
    }

    /**
     * Called repeatedly as command is running
     */

    @Override
    protected void execute() {
        double leftArmMove = Robot.oi.gamepad.getRawAxis(0);
//        double leftArmSpin = -Robot.oi.gamepad.getRawAxis(1);
        if (Math.abs(leftArmMove) >= 0.03) {
            Robot.wheelIntakeArm.setRight(squared(leftArmMove));
            Robot.wheelIntakeArm.setLeft(squared(leftArmMove));
        } else {
            Robot.wheelIntakeArm.setLeft(0);
        }
//        if (Math.abs(leftArmSpin) >= 0.03) {
//            Robot.wheelIntake.setLeft(squared(leftArmSpin));
//        } else {
//            Robot.wheelIntake.setLeft(0);
//        }

//        double rightArmMove = -Robot.oi.gamepad.getRawAxis(4);
        double rightArmSpin = -Robot.oi.gamepad.getRawAxis(5);
//        if (Math.abs(rightArmMove) >= 0.03) {
//            Robot.wheelIntakeArm.setRight(squared(rightArmMove));
//        } else {
//            Robot.wheelIntakeArm.setRight(0);
//        }
        if (Math.abs(rightArmSpin) >= 0.03) {
            Robot.wheelIntake.setRight(squared(rightArmSpin));
            Robot.wheelIntake.setLeft(squared(rightArmSpin));
        } else {
            Robot.wheelIntake.setRight(0);
        }

//        double speed = Robot.oi.gamepad.getRawAxis(0);
//        if (Math.abs(speed) >= 0.03) {
//            Robot.wheelIntakeArm.setSpeed(squared(speed));
//        } else {
//            Robot.wheelIntakeArm.setSpeed(0);
//        }
    }

    private double squared(double input) {
        // Make sure to keep the sign so the direction you input is not changed by squaring it
        if (input > 0) {
            return input * input;
        } else {
            return -(input * input);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}