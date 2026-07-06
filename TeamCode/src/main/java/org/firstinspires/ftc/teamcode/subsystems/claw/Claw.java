package org.firstinspires.ftc.teamcode.subsystems.claw;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.lib.ftclib.hardware.ServoEx;
import org.firstinspires.ftc.teamcode.lib.ftclib.hardware.motors.CRServo;
import org.firstinspires.ftc.teamcode.subsystems.servo_intake.ServoIntakeConstants;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase {
    private final Telemetry telemetry;

    private final Servo claw;

    private double kSetpoint = ClawConstants.setpoint;

    public Claw(HardwareMap hwMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        claw = hwMap.get(Servo.class, "claw");

    }

    @Override
    public void periodic() {
        try {
            if (kSetpoint != ClawConstants.setpoint) {
                kSetpoint = ClawConstants.setpoint;
                setPosition(kSetpoint);
            }
        } catch (Exception ignored) {

        }
    }

    private void setPosition(double position) {
        claw.setPosition(position);
    }

    public static Command setPosition(Claw claw, DoubleSupplier power) {
        return Commands.run(() -> claw.setPosition(power.getAsDouble()), claw);
    }

    public static Command setPosition(Claw claw, double power) {
        return setPosition(claw, () -> power);
    }

    public static Command open(Claw claw) {
        return setPosition(claw, () -> ClawConstants.OPEN);
    }

    public static Command close(Claw claw) {
        return setPosition(claw, () -> ClawConstants.CLOSE);
    }
}
