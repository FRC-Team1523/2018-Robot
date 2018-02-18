package frc.team1523.robot;

//import org.usfirst.frc1523.TestRobot.Robot;
//import org.usfirst.frc1523.TestRobot.RobotMap;
//import org.usfirst.frc1523.TestRobot.commands.*;

import edu.wpi.first.wpilibj.Counter;
//import edu.wpi.first.wpilibj.Encoder;

/**
 * Driver for a CTRE Magnetic Encoder using DIO ports on the roborio.
 * <p>
 * When instantiated, it sets the quadrature distance from the absolute angle.
 * So, between 0 and 1 rotations. When reset, the distance goes to zero.
 * <p>
 * Internally, it uses a Counter to measure the PWM and a WPILib Encoder object
 * to measure the quadrature part.
 *
 * @author Narwhal
 */
public class CTREMagneticEncoder {
    // had to get this from a forum post by a CTR employee
    //private static final int PULSES_PER_REVOLUTION = 1024;

    //Encoder armEncoder;
    Counter pwmCounter;

    double offsetDegrees;

    /**
     * @param dataAPort DIO port with the "A" data line plugged in (pin 7 on the
     *                  armEncoder)
     * @param dataBPort DIO port with the "B" data line plugged in to it (pin 5 on the
     *                  armEncoder)
     * @param pwmPort   DIO port connected to pin 9 on the armEncoder, the PWM pin
     * @param inverted  whether or not the armEncoder is inverted
     */
    public CTREMagneticEncoder(int pwmPort) {
        pwmCounter = new Counter(pwmPort);
        pwmCounter.setSemiPeriodMode(true); //only count rising edges

        pwmCounter.setMaxPeriod(.01);  //10ms
        pwmCounter.setUpdateWhenEmpty(true);
        pwmCounter.setReverseDirection(false);
        //wait for the pwm signal to be counted
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        offsetDegrees = getPWMAngle();

    }

    public void clear() {
        //armEncoder.reset();
        offsetDegrees = 0;
    }

    //@Override
    public double getPWMAngle() {
        //from 1 to 4096 us
        return ((pwmCounter.getPeriod() - 1e-6) / 4095e-6) * 360;  //returns degrees
        //return ((pwmCounter.getPeriod() - 2.26e-6) / (2.26*256e-6)) * 360 ;  //returns degrees for AS5030
        //return 0;
    }

    //@Override
    public double getRawPWMValue() {
        return pwmCounter.getPeriod();
        //return 0;
    }

    public double getPWMPeriod() {
        return pwmCounter.getPeriod();
        //return 0;
    }

}

