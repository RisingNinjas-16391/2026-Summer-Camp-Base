package org.firstinspires.ftc.teamcode.subsystems.servo_intake;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.lib.controller.SquIDController;
import org.firstinspires.ftc.teamcode.lib.ftclib.hardware.motors.CRServo;
import org.firstinspires.ftc.teamcode.lib.ftclib.hardware.motors.MotorEx;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ServoIntake extends SubsystemBase {
    private final Telemetry telemetry;

    private final CRServo leftServo;
    private final CRServo rightServo;

    private double kSetpoint = ServoIntakeConstants.setpoint;

    public ServoIntake(HardwareMap hwMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        leftServo = new CRServo(hwMap, "leftIntake");
        rightServo = new CRServo(hwMap, "rightIntake");

        leftServo.setInverted(true);
        rightServo.setInverted(false);
    }

    @Override
    public void periodic() {
        try {
            if (kSetpoint != ServoIntakeConstants.setpoint) {
                kSetpoint = ServoIntakeConstants.setpoint;
                setPower(kSetpoint);
            }
        } catch (Exception ignored) {

        }
    }

    private void setPower(double power) {
        leftServo.set(power);
        rightServo.set(power);
    }

    public static Command setPower(ServoIntake servoIntake, DoubleSupplier power) {
        return Commands.run(() -> servoIntake.setPower(power.getAsDouble()), servoIntake);
    }
}
