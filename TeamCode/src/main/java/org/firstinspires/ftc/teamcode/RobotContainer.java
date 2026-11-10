package org.firstinspires.ftc.teamcode;

import com.pedropathing.localization.Pose;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.commands.AutoCommands;
import org.firstinspires.ftc.teamcode.commands.DriveCommands;
import org.firstinspires.ftc.teamcode.commands.auto.PoseStorage;
import org.firstinspires.ftc.teamcode.lib.wpilib.CommandGamepad;
import org.firstinspires.ftc.teamcode.opmodes.OpModeConstants;
import org.firstinspires.ftc.teamcode.subsystems.Subsystems;
import org.firstinspires.ftc.teamcode.subsystems.claw.Claw;
import org.firstinspires.ftc.teamcode.subsystems.claw.ClawConstants;
import org.firstinspires.ftc.teamcode.subsystems.drive.Drive;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.subsystems.intake.IntakeConstants;
import org.firstinspires.ftc.teamcode.subsystems.pivot.Pivot;
import org.firstinspires.ftc.teamcode.subsystems.pivot.PivotConstants;
import org.firstinspires.ftc.teamcode.subsystems.shooter.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.shooter.ShooterConstants;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class RobotContainer {
    private final Drive drive;
    private final Pivot pivot;
    private final Intake intake;
    private final Shooter shooter;
    private final Claw claw;
    private final Subsystems subsystems;

    private final CommandGamepad driverController;

    public RobotContainer(HardwareMap hwMap, Telemetry telemetry, Gamepad gamepad1, Gamepad gamepad2, OpModeConstants autoNum) {
        drive = new Drive(hwMap, telemetry);
        pivot = new Pivot(hwMap, telemetry);
        intake = new Intake(hwMap, telemetry);
        shooter = new Shooter(hwMap, telemetry);

        subsystems = new Subsystems(drive, pivot, intake, shooter);

        driverController = new CommandGamepad(gamepad1);

        if (autoNum == OpModeConstants.TELEOP) {
            setDefaultCommands();
            configureButtonBindings();
        } else {
            getAutoCommand(autoNum);
        }
    }

    public void setDefaultCommands(){
        drive.setDefaultCommand(
                Commands.sequence(
//                        DriveCommands.setPose(drive, () -> PoseStorage.currentPose),
                        DriveCommands.joystickDrive(
                                drive,
                                () -> DriveCommands.signSquare(-driverController.getLeftY()),
                                () -> DriveCommands.signSquare(-driverController.getLeftX()),
                                () -> DriveCommands.signSquare(-driverController.getRightX()))
                )

        );
    }

    public void configureButtonBindings() {
        driverController.a().onTrue(Pivot.setPosition(pivot, ()->PivotConstants.FEED));
        driverController.b().onTrue(Pivot.setPosition(pivot, ()->PivotConstants.L1));
        driverController.y().onTrue(Pivot.setPosition(pivot, ()->PivotConstants.L2));
        driverController.x().onTrue(Pivot.setPosition(pivot, ()->PivotConstants.L3));
        driverController.rightBumper().onTrue(Pivot.setPosition(pivot, ()->PivotConstants.L4));
        driverController.leftBumper().onTrue(Pivot.setPosition(pivot, ()->PivotConstants.L5));
        driverController.dpadUp().onTrue(Pivot.setPosition(pivot, ()->PivotConstants.CLIMB));




        driverController.start().onTrue(Pivot.resetPosition(pivot));
        driverController.back().onTrue(DriveCommands.setPose(subsystems.drive(), () -> new Pose(0, 0, 0)));


        driverController.rightTrigger().onTrue(Intake.setPower(intake, () -> IntakeConstants.INTAKE_POWER)).onFalse(Intake.setPower(intake, () -> 0.0).withTimeout(0.0));

        driverController.leftTrigger().onTrue(Intake.setPower(intake, () -> IntakeConstants.OUTTAKE_POWER)).onFalse(Intake.setPower(intake, () -> 0.0).withTimeout(0.0));



        driverController.back().onTrue(DriveCommands.setPose(drive, Pose::new));


    }

    public Command getAutoCommand(OpModeConstants auto) {
        return switch (auto) {
            case BLUE_AUTO -> AutoCommands.blueAuto(subsystems);
            case RED_AUTO -> AutoCommands. redAuto(subsystems);
            default -> Commands.none();
        };
    }

    public Pose getDrivePose() {
        return drive.getPose();
    }
}