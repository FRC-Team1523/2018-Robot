package frc.team1523.robot.auto;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1523.robot.Robot;

import static frc.team1523.robot.Constants.*;


/**
 * Turn robot a set amount of degrees at a fixed speed using navx data. DO NOT USE USE
 * WARNING: THIS USES INEXPLICABLE BLACK MAGIC DO NOT USE UNLESS YOU KNOW WHAT YOU ARE DOING
 */
public class AutoTurn extends Command {
    private double degrees;
    private double start;
    private boolean finished;

    public AutoTurn(double degrees) {
        requires(Robot.driveTrain);
        this.start = Robot.ahrs.getAngle();
        this.degrees = degrees;
        finished = false;
    }

    @Override
    protected void initialize() {
        Robot.driveTrain.reset();
        Robot.shifter.downShift();
        Robot.ahrs.zeroYaw();
    }

    @Override
    protected void execute() {
        if (degrees - start > 0) { // positive
            if (Robot.ahrs.getAngle() < degrees) {
                Robot.driveTrain.drive(AUTO_TURN_SPEED, -AUTO_TURN_SPEED);
            } else {
                finished = true;
            }
        } else { // negative
            if (Robot.ahrs.getAngle() > degrees - start) {
                Robot.driveTrain.drive(-AUTO_TURN_SPEED, AUTO_TURN_SPEED);
            } else {
                finished = true;
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return finished;
    }
}
