package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.localization.Pose;

import org.firstinspires.ftc.teamcode.commands.auto.TuneablePose;
import org.firstinspires.ftc.teamcode.subsystems.Subsystems;
import org.firstinspires.ftc.teamcode.subsystems.drive.Drive;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.subsystems.intake.IntakeConstants;
import org.firstinspires.ftc.teamcode.subsystems.pivot.Pivot;
import org.firstinspires.ftc.teamcode.subsystems.pivot.PivotConstants;
import org.firstinspires.ftc.teamcode.subsystems.servo_intake.ServoIntake;

import java.io.DataInput;
import java.util.function.Supplier;

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
   DriveCommands.forward(subsystems.drive(), 10),
                DriveCommands.turn(subsystems.drive(), 90),
                DriveCommands.forward(subsystems.drive(), 10),
                DriveCommands.turn(subsystems.drive(), 90),
                DriveCommands.forward(subsystems.drive(), 10),
                DriveCommands.turn(subsystems.drive(), 90),
                DriveCommands.forward(subsystems.drive(), 10),
                DriveCommands.turn(subsystems.drive(), 90)

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
    public static TuneablePose pose1 = new TuneablePose(0, 0, 0);

    public static Command blueAuto(Subsystems subsystems) {
        return Commands.sequence(
                DriveCommands.strafeRight(subsystems.drive(),7),
                Commands.parallel(
                        DriveCommands.forward(subsystems.drive(), 17.5),
                        Intake.setPower(subsystems.intake(), IntakeConstants.INTAKE_POWER).withTimeout(1)

                ),
                Commands.parallel(
                        DriveCommands.turn(subsystems.drive(), -140),
                        Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(1)
                ),
                Commands.parallel(
                        Intake.setPower(subsystems.intake(),0).withTimeout(0.1),
                        DriveCommands.forward(subsystems.drive(),24),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.L5)
                ),
                Intake.setPower(subsystems.intake(),IntakeConstants.OUTTAKE_POWER).withTimeout(0.5),
                DriveCommands.backward(subsystems.drive(),5),
                Commands.parallel(
                        DriveCommands.turn(subsystems.drive(),152),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED),
                        Intake.setPower(subsystems.intake(),0).withTimeout(0.1)
                ),
                Commands.parallel(
                        DriveCommands.forward(subsystems.drive(),37),
                        Intake.setPower(subsystems.intake(), IntakeConstants.INTAKE_POWER).withTimeout(1)
                ),
                Commands.parallel(
                        DriveCommands.turn(subsystems.drive(),-166),
                        //DriveCommands.turn(subsystems.drive(),-160),
                        Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(1)
                ),
                Commands.parallel(
                        Intake.setPower(subsystems.intake(),0).withTimeout(0.1),
                        DriveCommands.forward(subsystems.drive(),38),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.L4)
                ),
                Intake.setPower(subsystems.intake(),IntakeConstants.OUTTAKE_POWER).withTimeout(0.3),
                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(),4),
                        Intake.setPower(subsystems.intake(),0).withTimeout(0.1),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED)
                ),
                DriveCommands.turn(subsystems.drive(),-24),
                DriveCommands.strafeRight(subsystems.drive(),28),
                DriveCommands.forward(subsystems.drive(),4),
                DriveCommands.turn(subsystems.drive(), 180)
        );
    }

    public static Command redAuto(Subsystems subsystems) {
        return Commands.sequence(
                DriveCommands.strafeLeft(subsystems.drive(),7),
                Commands.parallel(
                        DriveCommands.forward(subsystems.drive(), 17.5),
                        Intake.setPower(subsystems.intake(), IntakeConstants.INTAKE_POWER).withTimeout(1)

                ),
                Commands.parallel(
                        DriveCommands.turn(subsystems.drive(), 138),
                        Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(1)
                ),
                Commands.parallel(
                        Intake.setPower(subsystems.intake(),0).withTimeout(0.1),
                        DriveCommands.forward(subsystems.drive(),26),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.L5)
                ),
                Intake.setPower(subsystems.intake(),IntakeConstants.OUTTAKE_POWER).withTimeout(0.5),
                DriveCommands.backward(subsystems.drive(),5),
                Commands.parallel(
                        DriveCommands.turn(subsystems.drive(),-150),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED),
                        Intake.setPower(subsystems.intake(),0).withTimeout(1.5)
                ),
                Commands.parallel(
                        DriveCommands.forward(subsystems.drive(),38),
                        Intake.setPower(subsystems.intake(), IntakeConstants.INTAKE_POWER).withTimeout(1)
                ),
                Commands.parallel(
                        DriveCommands.turn(subsystems.drive(),169),
                        Intake.setPower(subsystems.intake(),IntakeConstants.INTAKE_POWER).withTimeout(1)
                ),
                Commands.parallel(
                        Intake.setPower(subsystems.intake(),0).withTimeout(0.1),
                        DriveCommands.forward(subsystems.drive(),38),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.L4)
                ),
                Intake.setPower(subsystems.intake(),IntakeConstants.OUTTAKE_POWER).withTimeout(0.3),
                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(),4),
                        Intake.setPower(subsystems.intake(),0).withTimeout(0.1),
                        Pivot.setPosition(subsystems.pivot(),PivotConstants.FEED)
                ),

                //DriveCommands.driveToPose(subsystems.drive(),  pose1::getPose),
                DriveCommands.turn(subsystems.drive(),24),
                DriveCommands.strafeLeft(subsystems.drive(),26),
                DriveCommands.forward(subsystems.drive(),10),
                DriveCommands.turn(subsystems.drive(), 180)

        );
    }
}