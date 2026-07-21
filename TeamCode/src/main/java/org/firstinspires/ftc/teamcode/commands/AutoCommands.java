package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.localization.Pose;

import org.firstinspires.ftc.teamcode.subsystems.Subsystems;
import org.firstinspires.ftc.teamcode.subsystems.drive.Drive;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.subsystems.intake.IntakeConstants;
import org.firstinspires.ftc.teamcode.subsystems.pivot.Pivot;
import org.firstinspires.ftc.teamcode.subsystems.pivot.PivotConstants;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;



@Config
public class AutoCommands {
    /*
    Available Commands:

    Drivetrain (Replace distance with a number):
    DriveCommands.forward(subsystems.drive(), distance),
    DriveCommands.backward(subsystems.drive(), distance),
    DriveCommands.strafeLeft(subsystems.drive(), distance),
    DriveCommands.strafeRight(subsystems.drive(), distance),

    (Replace angle with a number):
    DriveCommands.turn(subsystems.drive(), angle),

    Pivot (Replace PRESET with a valid Pivot preset):
    Pivot.setPosition(subsystems.pivot(), PivotConstants.PRESET),
    Pivot.setPosition(subsystems.pivot(), () -> PivotConstants.PRESET),
    Pivot.score(subsystems.pivot),

    Claw (Replace position with a number):
    Claw.open(subsystems.claw()),
    Claw.close(subsystems.claw()),

    Claw.setPosition(subsystems.claw(), () -> position);

    Motor Intake (Replace power with a number):
    Intake.setPower(subsystems.intake(), power),
    Intake.setPower(subsystems.intake(), () -> power),

    Servo Intake (Replace power with a number):
    ServoIntake.setPower(subsystems.servoIntake(), power),
    ServoIntake.setPower(subsystems.servoIntake(), () -> power),

    Wrist (Replace PRESET with a valid Wrist preset):
    Wrist.setPosition(subsystems.wrist(), WristPresets.PRESET),
    Wrist.setPosition(subsystems.wrist(), () -> WristPresets.PRESET),

    */

    public static Command blueAuto(Subsystems subsystems) {
        return Commands.sequence(
                DriveCommands.setPose(subsystems.drive(), () -> new Pose(0, 0, Math.toRadians(-90))),
                Commands.parallel(
                        DriveCommands.forward(subsystems.drive(), 50),
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH)
                ),
                DriveCommands.strafeLeft(subsystems.drive(),15),
                DriveCommands.forward(subsystems.drive(),14),
                Intake.setPower(subsystems.intake(), IntakeConstants.OUTTAKE_POWER).withTimeout(0.5),
                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(), 6),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED)
                ),
                DriveCommands.strafeRight(subsystems.drive(),10),
                Commands.parallel(
                        DriveCommands.forward(subsystems.drive(), 3),
                        Intake.setPower(subsystems.intake(), IntakeConstants.INTAKE_POWER).withTimeout(0.2)
                ),
                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(),4),
                        Intake.setPower(subsystems.intake(), IntakeConstants.INTAKE_POWER).withTimeout(0.3),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.HIGH)
                ),
                Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(0.2),
                Commands.parallel(
                        Intake.setPower(subsystems.intake(),0).withTimeout(0.1),
                        DriveCommands.strafeLeft(subsystems.drive(), 10)
                ),
                DriveCommands.forward(subsystems.drive(),6),
                Intake.setPower(subsystems.intake(),IntakeConstants.OUTTAKE_POWER).withTimeout(0.3),
                DriveCommands.backward(subsystems.drive(), 6),
                Commands.parallel(
                        DriveCommands.strafeRight(subsystems.drive(), 10),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED),
                        Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(0.5)
                ),
                Commands.parallel(
                        DriveCommands.forward(subsystems.drive(),4),
                        Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(0.1)
                ),
                Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(0.1),
                DriveCommands.backward(subsystems.drive(),12),
                DriveCommands.turn(subsystems.drive(), 45),
                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(),10),
                        Intake.setPower(subsystems.intake(),0).withTimeout(0.4)
                )
        );
    }

    public static Command redAuto(Subsystems subsystems) {
        return Commands.sequence(
                DriveCommands.setPose(subsystems.drive(), () -> new Pose(0, 0, Math.toRadians(-90))),
                Commands.parallel(
                        DriveCommands.forward(subsystems.drive(), 50),
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH)
                ),
                DriveCommands.strafeRight(subsystems.drive(),11),
                DriveCommands.forward(subsystems.drive(),14),
                Intake.setPower(subsystems.intake(), IntakeConstants.OUTTAKE_POWER).withTimeout(0.5),
                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(), 6),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED)
                ),
                DriveCommands.strafeLeft(subsystems.drive(),10),
                Commands.parallel(
                        DriveCommands.forward(subsystems.drive(), 2),
                        Intake.setPower(subsystems.intake(), IntakeConstants.INTAKE_POWER).withTimeout(0.2)
                ),
                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(),4),
                        Intake.setPower(subsystems.intake(), IntakeConstants.INTAKE_POWER).withTimeout(0.3),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.HIGH)
                ),
                Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(0.2),
                Commands.parallel(
                        Intake.setPower(subsystems.intake(),0).withTimeout(0.1),
                        DriveCommands.strafeRight(subsystems.drive(), 10)
                ),
                DriveCommands.forward(subsystems.drive(),6),
                Intake.setPower(subsystems.intake(),IntakeConstants.OUTTAKE_POWER).withTimeout(0.2),
                DriveCommands.backward(subsystems.drive(), 6),
                Commands.parallel(
                        DriveCommands.strafeLeft(subsystems.drive(), 10),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED),
                        Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(0.5)
                ),
                Commands.parallel(
                        DriveCommands.forward(subsystems.drive(),3),
                        Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(0.1)
                ),
                Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(0.1),
                DriveCommands.backward(subsystems.drive(),10),
                DriveCommands.turn(subsystems.drive(), 315),
                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(),12),
                        Intake.setPower(subsystems.intake(),0).withTimeout(0.4)
                )
        );
    }
}