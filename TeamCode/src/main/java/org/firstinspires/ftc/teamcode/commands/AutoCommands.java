package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.localization.Pose;

import org.firstinspires.ftc.teamcode.subsystems.Subsystems;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
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
                DriveCommands.forward(subsystems.drive(), 55),
                Commands.parallel(
                DriveCommands.strafeLeft(subsystems.drive(), 29),
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH)
                        ),
                Commands.parallel(
                DriveCommands.forward(subsystems.drive(), 10).withTimeout(1),
                Intake.setPower(subsystems.intake(), 0.5).withTimeout(1)
                        ),
                Commands.parallel(
                DriveCommands.backward(subsystems.drive(), 10),
                Intake.setPower(subsystems.intake(), 0).withTimeout(0.5)
                        ),
                Commands.parallel(
                Pivot.setPosition(subsystems.pivot(), PivotConstants.FEED),
                DriveCommands.strafeRight(subsystems.drive(), 27)
                        ),
                        DriveCommands.forward(subsystems.drive(), 4.5),
                Intake.setPower(subsystems.intake(), -0.5).withTimeout(2),
                Commands.parallel(
                        Intake.setPower(subsystems.intake(), -0).withTimeout(0),
                        DriveCommands.backward(subsystems.drive(), 10)
                        ),
                Commands.parallel(
                DriveCommands.strafeLeft(subsystems.drive(), 13),
                Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH)
                ),
                Commands.parallel(
                DriveCommands.forward(subsystems.drive(), 15).withTimeout(2),
                Intake.setPower(subsystems.intake(), 0.5).withTimeout(1)
                        ),
                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(), 10),
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.FEED)
                ),
                DriveCommands.strafeRight(subsystems.drive(), 11),
                DriveCommands.forward(subsystems.drive(), 3).withTimeout(0.2),
                Commands.waitSeconds(2),
                DriveCommands.backward(subsystems.drive(), 8).withTimeout(0.2)
                );
    }

    public static Command redAuto(Subsystems subsystems) {
        return Commands.sequence(
                DriveCommands.setPose(subsystems.drive(), () -> new Pose(0, 0, Math.toRadians(90))),
                DriveCommands.forward(subsystems.drive(), 55),
                Commands.parallel(
                        DriveCommands.strafeRight(subsystems.drive(), 29),
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH)
                ),
                //
                DriveCommands.forward(subsystems.drive(), 11).withTimeout(1),
                Intake.setPower(subsystems.intake(), 0.5).withTimeout(1),
                //
                DriveCommands.backward(subsystems.drive(), 10),
                Intake.setPower(subsystems.intake(), 0).withTimeout(0.5),
                Commands.parallel(
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.FEED),
                        DriveCommands.strafeLeft(subsystems.drive(), 30)
                ),
                DriveCommands.forward(subsystems.drive(), 4.5),
                Intake.setPower(subsystems.intake(), -0.5).withTimeout(1.9),
                Commands.parallel(
                        Intake.setPower(subsystems.intake(), -0).withTimeout(0),
                        DriveCommands.backward(subsystems.drive(), 10)
                ),
                Commands.parallel(
                        DriveCommands.strafeRight(subsystems.drive(), 13),
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH)
                ),
                DriveCommands.forward(subsystems.drive(), 15).withTimeout(3),
                Intake.setPower(subsystems.intake(), 0.5).withTimeout(1),
                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(), 10),
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.FEED)
                ),
                //Everything below is Avery's code for the auto, it runs past the time so :(
                //I added a park that fits within the time constraints below (not commented in)
                DriveCommands.backward(subsystems.drive(), 20),
                DriveCommands.strafeLeft(subsystems.drive(), 27)
                //DriveCommands.strafeLeft(subsystems.drive(), 15),
                //DriveCommands.forward(subsystems.drive(), 3).withTimeout(0.1),
                //Commands.waitSeconds(2),
                //Commands.parallel(
                //        DriveCommands.backward(subsystems.drive(), 10),
                //        Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH)
                //),
                //DriveCommands.strafeRight(subsystems.drive(), 11),
                //DriveCommands.forward(subsystems.drive(), 14),
                //Intake.setPower(subsystems.intake(), 1.5).withTimeout(1),
                //DriveCommands.backward(subsystems.drive(), 26),
                //DriveCommands.strafeLeft(subsystems.drive(), 30)
        );
    }
}