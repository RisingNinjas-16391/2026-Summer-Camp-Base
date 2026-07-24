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
import org.firstinspires.ftc.teamcode.subsystems.elevator.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.elevator.ElevatorConstants;
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
    private final Elevator elevator;
    private final Claw claw;
    private final Subsystems subsystems;

    private final CommandGamepad driverController;

    public RobotContainer(HardwareMap hwMap, Telemetry telemetry, Gamepad gamepad1, Gamepad gamepad2, OpModeConstants autoNum) {
        drive = new Drive(hwMap, telemetry);
        pivot = new Pivot(hwMap, telemetry);
        elevator = new Elevator(hwMap, telemetry);
        claw = new Claw(hwMap, telemetry);

        subsystems = new Subsystems(drive, pivot, elevator, claw);

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
                        DriveCommands.setPose(drive, () -> PoseStorage.currentPose),
                        DriveCommands.joystickDrive(
                                drive,
                                () -> DriveCommands.signSquare(-driverController.getLeftY()),
                                () -> DriveCommands.signSquare(-driverController.getLeftX()),
                                () -> DriveCommands.signSquare(-driverController.getRightX()))
                )

        );
    }

    public void configureButtonBindings() {

        driverController.a().onTrue(
                Commands.parallel(
                        Pivot.setPosition(pivot, ()-> PivotConstants.LEVEL1),
                        Elevator.setPosition(elevator,()-> ElevatorConstants.LEVEL1)
                        )
        );

        driverController.b().onTrue(
                Commands.parallel(
                        Pivot.setPosition(pivot, ()-> PivotConstants.LEVEL2),
                        Elevator.setPosition(elevator,()-> ElevatorConstants.LEVEL2)
                )
        );

        driverController.y().onTrue(
                Commands.parallel(
                        Pivot.setPosition(pivot, ()-> PivotConstants.LEVEL3),
                        Elevator.setPosition(elevator,()-> ElevatorConstants.LEVEL3)
                )
        );

        driverController.x().onTrue(
                Commands.parallel(
                        Pivot.setPosition(pivot, ()-> PivotConstants.LEVEL4),
                        Elevator.setPosition(elevator,()-> ElevatorConstants.LEVEL4)
                )
        );

        driverController.dpadRight().onTrue(
                Commands.parallel(
                        Pivot.setPosition(pivot, ()-> PivotConstants.LEVEL5),
                        Elevator.setPosition(elevator,()-> ElevatorConstants.LEVEL5)
                )
        );

        driverController.dpadUp().onTrue(
                Commands.parallel(
                        Pivot.setPosition(pivot, ()-> PivotConstants.CLIMB),
                        Elevator.setPosition(elevator,()-> ElevatorConstants.CLIMB)
                )
        );

        driverController.dpadDown().onTrue(
                Commands.parallel(
                        Pivot.setPosition(pivot, ()-> PivotConstants.FEED),
                        Elevator.setPosition(elevator,()-> ElevatorConstants.FEED)
                )
        );


        driverController.rightTrigger().onTrue(
                Commands.parallel(
                        Pivot.setPosition(pivot, PivotConstants.FEED),
                        Elevator.setPosition(elevator, () -> ElevatorConstants.FEED),
                        Claw.setPosition(claw, () -> ClawConstants.OPEN)
                )
        ).onFalse(
                Claw.setPosition(claw, () -> ClawConstants.CLOSE)
        );

        driverController.leftTrigger().onTrue(
                Claw.setPosition(claw, () -> ClawConstants.OPEN)
        );

        driverController.back().onTrue(DriveCommands.setPose(drive, Pose::new));

        driverController.start().onTrue(Pivot.resetPosition(pivot));

    }

    public Command getAutoCommand(OpModeConstants auto) {
        return switch (auto) {
            case BLUE_AUTO -> AutoCommands.blueAuto(subsystems);
            case RED_AUTO -> AutoCommands.redAuto(subsystems);
            default -> Commands.none();
        };
    }

    public Pose getDrivePose() {
        return drive.getPose();
    }
}