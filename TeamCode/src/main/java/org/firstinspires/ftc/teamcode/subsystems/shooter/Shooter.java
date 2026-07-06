package org.firstinspires.ftc.teamcode.subsystems.shooter;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.lib.ftclib.hardware.motors.MotorEx;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final Telemetry telemetry;

    private final MotorEx shooter;

    public Shooter(HardwareMap hwMap, Telemetry telemetry) {
        this.telemetry = telemetry;

        shooter = new MotorEx(hwMap, "shooter");
    }

    @Override
    public void periodic() {
        try {
//            telemetry.addLine("Intake");
        } catch (Exception ignored) {

        }
    }

    public void setPower(double power) {
        shooter.set(power);
    }

    public static Command setPower(Shooter shooter, DoubleSupplier power) {
        return Commands.run(() -> shooter.setPower(power.getAsDouble()), shooter);
    }

    public static Command setPowerTelop(Shooter shooter, DoubleSupplier power) {
        return Commands.run(() -> shooter.setPower(power.getAsDouble()), shooter).finallyDo(() -> shooter.setPower(0));
    }

    public static Command setPower(Shooter shooter, double power) {
        return setPower(shooter, () -> power);
    }
}
