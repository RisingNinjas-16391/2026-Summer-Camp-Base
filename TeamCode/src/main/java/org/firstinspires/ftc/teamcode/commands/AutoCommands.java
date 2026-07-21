package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.subsystems.Subsystems;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.subsystems.pivot.Pivot;

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
                DriveCommands.forward(subsystems.drive(), 32),
                DriveCommands.strafeLeft(subsystems.drive(),15),
                Pivot.setPosition(subsystems.pivot(), 0.27),
                DriveCommands.forward(subsystems.drive(),28),
                Intake.setPower(subsystems.intake(), -1).withTimeout(0.75),
                DriveCommands.backward(subsystems.drive(),11),
                Pivot.setPosition(subsystems.pivot(),-0.12),
                Intake.setPower(subsystems.intake(),0.65).withTimeout(0),
                DriveCommands.strafeRight(subsystems.drive(),15),
                DriveCommands.forward(subsystems.drive(),8),
                DriveCommands.backward(subsystems.drive(),8),
                Intake.setPower(subsystems.intake(),0).withTimeout(0.25),
                Pivot.setPosition(subsystems.pivot(),0.27),
                DriveCommands.strafeLeft(subsystems.drive(),15),
                DriveCommands.forward(subsystems.drive(),11),
                Intake.setPower(subsystems.intake(),-1).withTimeout(0.75),
                Intake.setPower(subsystems.intake(),0).withTimeout(0),
                DriveCommands.backward(subsystems.drive(),27),
                DriveCommands.strafeRight(subsystems.drive(),29)
        );
    }

    public static Command redAuto(Subsystems subsystems) {
        return Commands.sequence(
                DriveCommands.forward(subsystems.drive(), 33),
                DriveCommands.strafeRight(subsystems.drive(),15),
                Pivot.setPosition(subsystems.pivot(), 0.27),
                DriveCommands.forward(subsystems.drive(),30),
                Intake.setPower(subsystems.intake(), -1).withTimeout(0.75),
                DriveCommands.backward(subsystems.drive(),11),
                Pivot.setPosition(subsystems.pivot(),-0.12),
                Intake.setPower(subsystems.intake(),0.65).withTimeout(0),
                DriveCommands.strafeLeft(subsystems.drive(),15),
                DriveCommands.forward(subsystems.drive(),8),
                DriveCommands.backward(subsystems.drive(),8),
                Intake.setPower(subsystems.intake(),0).withTimeout(0),
                Pivot.setPosition(subsystems.pivot(),0.27),
                DriveCommands.strafeRight(subsystems.drive(),15),
                DriveCommands.forward(subsystems.drive(),11),
                Intake.setPower(subsystems.intake(),-1).withTimeout(0.75),
                Intake.setPower(subsystems.intake(),0).withTimeout(0),
                DriveCommands.backward(subsystems.drive(),25),
                DriveCommands.strafeLeft(subsystems.drive(),25)
        );
    }
}