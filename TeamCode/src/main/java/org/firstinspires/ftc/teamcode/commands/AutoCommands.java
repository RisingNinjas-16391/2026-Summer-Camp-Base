package org.firstinspires.ftc.teamcode.commands;

import static org.firstinspires.ftc.teamcode.subsystems.intake.IntakeConstants.INTAKE_POWER;
import static org.firstinspires.ftc.teamcode.subsystems.intake.IntakeConstants.OUTTAKE_POWER;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.localization.Pose;

import org.firstinspires.ftc.teamcode.subsystems.Subsystems;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.subsystems.pivot.Pivot;
import org.firstinspires.ftc.teamcode.subsystems.pivot.PivotConstants;
import org.firstinspires.ftc.teamcode.subsystems.shooter.Shooter;

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
                Pivot.setPosition(subsystems.pivot(), () -> PivotConstants.FEED),
                DriveCommands.forward(subsystems.drive(), 40),
                DriveCommands.strafeLeft(subsystems.drive(), 15),
                Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH),
                DriveCommands.forward(subsystems.drive(), 25),
                Intake.setPower(subsystems.intake(), OUTTAKE_POWER).withTimeout(.5),
                Intake.setPower(subsystems.intake(), 0).withTimeout(.1),
                DriveCommands.backward(subsystems.drive(), 10),
                Pivot.setPosition(subsystems.pivot(), PivotConstants.FEED + 0.05),
                DriveCommands.strafeRight(subsystems.drive(), 12),
                DriveCommands.forward(subsystems.drive(), 5),
                Intake.setPower(subsystems.intake(), INTAKE_POWER).withTimeout(2),
                Intake.setPower(subsystems.intake(), 0).withTimeout(.1),
                DriveCommands.backward(subsystems.drive(), 6),
                Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH),
                DriveCommands.strafeLeft(subsystems.drive(), 15),
                DriveCommands.forward(subsystems.drive(), 10),
                Intake.setPower(subsystems.intake(), OUTTAKE_POWER).withTimeout(1),
                Intake.setPower(subsystems.intake(), 0).withTimeout(.1),
                DriveCommands.backward(subsystems.drive(), 30),
                DriveCommands.strafeRight(subsystems.drive(), 30),
                Pivot.setPosition(subsystems.pivot(), PivotConstants.FEED)
        );
    }




    public static Command redAuto (Subsystems subsystems) {
        return Commands.sequence(
                DriveCommands.setPose(subsystems.drive(), () -> new Pose(0, 0, Math.toRadians(90))),
                Pivot.setPosition(subsystems.pivot(), () -> PivotConstants.FEED),
                DriveCommands.forward(subsystems.drive(), 40),
                DriveCommands.strafeRight(subsystems.drive(), 15),
                Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH),
                DriveCommands.forward(subsystems.drive(), 25),
                Intake.setPower(subsystems.intake(), OUTTAKE_POWER).withTimeout(.5),
                Intake.setPower(subsystems.intake(), 0).withTimeout(.1),
                DriveCommands.backward(subsystems.drive(), 10),
                Pivot.setPosition(subsystems.pivot(), PivotConstants.FEED + 0.05),
                DriveCommands.strafeLeft(subsystems.drive(), 15),
                DriveCommands.forward(subsystems.drive(), 5),
                Intake.setPower(subsystems.intake(), INTAKE_POWER).withTimeout(2),
                Intake.setPower(subsystems.intake(), 0).withTimeout(.1),
                DriveCommands.backward(subsystems.drive(), 6),
                Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH),
                DriveCommands.strafeRight(subsystems.drive(), 15),
                DriveCommands.forward(subsystems.drive(), 10),
                Intake.setPower(subsystems.intake(), OUTTAKE_POWER).withTimeout(1),
                Intake.setPower(subsystems.intake(), 0).withTimeout(.1),
                DriveCommands.backward(subsystems.drive(), 30),
                DriveCommands.strafeLeft(subsystems.drive(), 31),
                Pivot.setPosition(subsystems.pivot(), PivotConstants.FEED)
        );
    }
}