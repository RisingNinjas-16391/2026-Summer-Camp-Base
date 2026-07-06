package org.firstinspires.ftc.teamcode.subsystems.pivot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.lib.controller.SquIDController;
import org.firstinspires.ftc.teamcode.lib.ftclib.hardware.motors.MotorEx;

import java.nio.channels.Pipe;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pivot extends SubsystemBase {
    private final Telemetry telemetry;

    private final MotorEx pivotMotor;

    private final SquIDController controller;

    private double kSetpoint;

    private double currentPosition = PivotConstants.initialPosition;
    private double desiredPosition = PivotConstants.initialPosition;

    private boolean isResetting = true;

    public Pivot(HardwareMap hwMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        pivotMotor = new MotorEx(hwMap, "pivot");

        pivotMotor.setInverted(false);

        pivotMotor.stopAndResetEncoder();

        controller = new SquIDController(0.1);

        kSetpoint = PivotConstants.setpoint;
    }

    @Override
    public void periodic() {
        try {
            currentPosition = pivotMotor.getCurrentPosition() * PivotConstants.ticksToRotations + PivotConstants.initialPosition;

            telemetry.addLine("Pivot");
            telemetry.addData("Pivot Position", currentPosition);
            telemetry.addData("Pivot Voltage", pivotMotor.getVoltage());
            telemetry.addData("Pivot Current", pivotMotor.getCurrent());
            telemetry.addData("Pivot Velocity", pivotMotor.getVelocity());

            // If setpoint on dashboard changes, update the setpoint
            if (kSetpoint != PivotConstants.setpoint) {
                kSetpoint = PivotConstants.setpoint;
                desiredPosition = kSetpoint;
            }

            if (!isResetting) {
                calculateVoltage(desiredPosition);
            }
        } catch (Exception ignored) {

        }
    }

    private void calculateVoltage(double position) {
        telemetry.addData("Pivot Desired Position", position);

        double output = controller.calculate(PivotConstants.kP, position, currentPosition) + PivotConstants.kG * Math.cos(currentPosition * 2 * Math.PI);
        pivotMotor.set(output);
    }

    private void setPosition(double position) {
        isResetting = false;
        desiredPosition = position;
    }

    private void resetMotor() {
        pivotMotor.stopAndResetEncoder();
    }

    public double getPosition() {
        return currentPosition;
    }

    public boolean isFinished() {
        return Math.abs(currentPosition - desiredPosition) < 0.05;
    }

    public double getCurrent() {
        return pivotMotor.getCurrent();
    }

    public double getVelocity() {
        return pivotMotor.getVelocity();
    }

    public static Command setPosition(Pivot pivot, DoubleSupplier position) {
        return Commands.run(() -> pivot.setPosition(position.getAsDouble()), pivot).until(pivot::isFinished);
    }

    public static Command setPosition(Pivot pivot, double position) {
        return setPosition(pivot, () -> position);
    }

    public static Command score(Pivot pivot) {
        return Commands.runOnce(() -> pivot.setPosition(pivot.getPosition() - 0.1)).andThen(Commands.waitUntil(pivot::isFinished));
    }

    private void setVoltage(double voltage) {
        isResetting = true;
        pivotMotor.setVoltage(voltage);
    }

    public static Command resetPosition(Pivot pivot) {
        return Commands.sequence(
                Commands.run(() -> pivot.setVoltage(PivotConstants.resetVoltage))
                        .until(() -> pivot.getCurrent() > PivotConstants.currentThreshold && Math.abs(pivot.getVelocity()) < 10),
                Commands.runOnce(() ->
                    pivot.setVoltage(0.0)),
                Commands.waitSeconds(0.5),
                Commands.runOnce(pivot::resetMotor));
    }
}
