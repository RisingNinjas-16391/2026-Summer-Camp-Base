package org.firstinspires.ftc.teamcode.commands;



import static org.firstinspires.ftc.teamcode.subsystems.intake.IntakeConstants.INTAKE_POWER;
import static org.firstinspires.ftc.teamcode.subsystems.intake.IntakeConstants.OUTTAKE_POWER;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.localization.Pose;

import org.firstinspires.ftc.teamcode.subsystems.Subsystems;
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
                Pivot.setPosition(subsystems.pivot(), () -> PivotConstants.HIGH),
                DriveCommands.forward(subsystems.drive(), 60)
                        .withTimeout(0),
                Commands.waitSeconds(2),
                DriveCommands.strafeLeft(subsystems.drive(),15)
                        .withTimeout(0),
                Commands.waitSeconds(1.25),
                DriveCommands.forward(subsystems.drive(),4)
                        .withTimeout(0),
                Commands.waitSeconds(.5),
                Intake.setPower(subsystems.intake(), () -> OUTTAKE_POWER)
                        .withTimeout(0),
                Commands.waitSeconds(.75),
                Intake.setPower(subsystems.intake(),0)
                                .withTimeout(0),
                Commands.waitSeconds(0),
                DriveCommands.backward(subsystems.drive(),4)
                        .withTimeout(0),
                Commands.waitSeconds(.5),
                Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED)
                        .withTimeout(0),
                Commands.waitSeconds(.25),
                DriveCommands.strafeRight(subsystems.drive(),12)
                        .withTimeout(0),
                Commands.waitSeconds(1.25),
                Intake.setPower(subsystems.intake(),INTAKE_POWER)
                        .withTimeout(0),
                Commands.waitSeconds(1),
                Intake.setPower(subsystems.intake(),0)
                        .withTimeout(0),
                Pivot.setPosition(subsystems.pivot(), () -> PivotConstants.HIGH)
                        .withTimeout(0),
                DriveCommands.strafeLeft(subsystems.drive(),12)
                        .withTimeout(0),
                Commands.waitSeconds(1.25),
                DriveCommands.forward(subsystems.drive(),4)
                        .withTimeout(0),
                Intake.setPower(subsystems.intake(),OUTTAKE_POWER)
                        .withTimeout(0),
                Commands.waitSeconds(1),
                Intake.setPower(subsystems.intake(),0)
                        .withTimeout(0),
                DriveCommands.backward(subsystems.drive(),4)
                        .withTimeout(0),
                Commands.waitSeconds(.5),
                Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED)
                        .withTimeout(0),
                Commands.waitSeconds(.25),
                DriveCommands.strafeRight(subsystems.drive(),12)
                        .withTimeout(0),
                Commands.waitSeconds(1.25),
                Intake.setPower(subsystems.intake(),INTAKE_POWER)
                        .withTimeout(0),
                Commands.waitSeconds(1),
                Intake.setPower(subsystems.intake(),0)
                        .withTimeout(0),
                Pivot.setPosition(subsystems.pivot(), () -> PivotConstants.HIGH)
                        .withTimeout(0),
                DriveCommands.strafeLeft(subsystems.drive(),12)
                        .withTimeout(0),
                Commands.waitSeconds(1.25),
                DriveCommands.forward(subsystems.drive(),4)
                        .withTimeout(0),
                Intake.setPower(subsystems.intake(),OUTTAKE_POWER)
                        .withTimeout(0),
                Commands.waitSeconds(1),
                Intake.setPower(subsystems.intake(),0)
                        .withTimeout(0),
                DriveCommands.backward(subsystems.drive(),28)
                        .withTimeout(0),
                Commands.waitSeconds(1.5),
                DriveCommands.strafeRight(subsystems.drive(),27)
                        .withTimeout(0),
                Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED)
                        .withTimeout(0)
                );
    }

    public static Command redAuto(Subsystems subsystems) {
        return Commands.sequence(
                Pivot.setPosition(subsystems.pivot(), () -> PivotConstants.HIGH),
                DriveCommands.forward(subsystems.drive(), 60)
                        .withTimeout(0),
                Commands.waitSeconds(2),
                DriveCommands.strafeRight(subsystems.drive(),15)
                        .withTimeout(0),
                Commands.waitSeconds(1.25),
                DriveCommands.forward(subsystems.drive(),4)
                        .withTimeout(0),
                Commands.waitSeconds(.5),
                Intake.setPower(subsystems.intake(), () -> OUTTAKE_POWER)
                        .withTimeout(0),
                Commands.waitSeconds(1),
                Intake.setPower(subsystems.intake(),0)
                        .withTimeout(0),
                Commands.waitSeconds(0),
                DriveCommands.backward(subsystems.drive(),4)
                        .withTimeout(0),
                Commands.waitSeconds(.5),
                Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED)
                        .withTimeout(0),
                Commands.waitSeconds(.25),
                DriveCommands.strafeLeft(subsystems.drive(),15)
                        .withTimeout(0),
                Commands.waitSeconds(1.25),
                Intake.setPower(subsystems.intake(),INTAKE_POWER)
                        .withTimeout(0),
                Commands.waitSeconds(1),
                Intake.setPower(subsystems.intake(),0)
                        .withTimeout(0),
                Pivot.setPosition(subsystems.pivot(), () -> PivotConstants.HIGH)
                        .withTimeout(0),
                DriveCommands.strafeRight(subsystems.drive(),15)
                        .withTimeout(0),
                Commands.waitSeconds(1.25),
                DriveCommands.forward(subsystems.drive(),4)
                        .withTimeout(0),
                Intake.setPower(subsystems.intake(),OUTTAKE_POWER)
                        .withTimeout(0),
                Commands.waitSeconds(1),
                Intake.setPower(subsystems.intake(),0)
                        .withTimeout(0),
                Commands.waitSeconds(0),
                DriveCommands.backward(subsystems.drive(),4)
                        .withTimeout(0),
                Commands.waitSeconds(.5),
                Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED)
                        .withTimeout(0),
                Commands.waitSeconds(.25),
                DriveCommands.strafeLeft(subsystems.drive(),15)
                        .withTimeout(0),
                Commands.waitSeconds(1.25),
                Intake.setPower(subsystems.intake(),INTAKE_POWER)
                        .withTimeout(0),
                Commands.waitSeconds(1),
                Intake.setPower(subsystems.intake(),0)
                        .withTimeout(0),
                Pivot.setPosition(subsystems.pivot(), () -> PivotConstants.HIGH)
                        .withTimeout(0),
                DriveCommands.strafeRight(subsystems.drive(),15)
                        .withTimeout(0),
                Commands.waitSeconds(1.25),
                DriveCommands.forward(subsystems.drive(),4)
                        .withTimeout(0),
                Intake.setPower(subsystems.intake(),OUTTAKE_POWER)
                        .withTimeout(0),
                Commands.waitSeconds(1),
                Intake.setPower(subsystems.intake(),0)
                        .withTimeout(0),
                DriveCommands.backward(subsystems.drive(),28)
                        .withTimeout(0),
                Commands.waitSeconds(1.5),
                DriveCommands.strafeLeft(subsystems.drive(),31)
                        .withTimeout(0),
                Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED)
                        .withTimeout(0)
        );
    }
}