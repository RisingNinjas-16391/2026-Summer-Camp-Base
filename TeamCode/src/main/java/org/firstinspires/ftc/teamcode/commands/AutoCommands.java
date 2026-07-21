package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.localization.Pose;

import org.firstinspires.ftc.teamcode.subsystems.Subsystems;
import org.firstinspires.ftc.teamcode.subsystems.drive.Drive;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.subsystems.pivot.Pivot;
import org.firstinspires.ftc.teamcode.subsystems.pivot.PivotConstants;
import org.firstinspires.ftc.teamcode.subsystems.wrist.Wrist;

import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;



@Config
public class AutoCommands {

    public static double FRONT = 59;

    public static double SIDE1 = 17;

    public static double BACK = 30;

    public static double HUMAN = 30;

    public static double SIDE2 = 17;

    public static double XP = 35;

    public static double YP = 15;

    public static double SIDE1B = 17;

    public static double SIDE2B = 15;



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
                Commands.parallel(
                        Pivot.setPosition(subsystems.pivot(), () -> PivotConstants.HIGH),
                        DriveCommands.forward(subsystems.drive(), FRONT)
                ),

                DriveCommands.strafeLeft(subsystems.drive(), SIDE1B),
                DriveCommands.forward(subsystems.drive(), 4),
                Intake.setPower(subsystems.intake(), () -> 0.4).withTimeout(0.5),

                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(), 4),
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.FEED)
                ),

                DriveCommands.strafeRight(subsystems.drive(), SIDE2B),

                Commands.parallel(
                        DriveCommands.forward(subsystems.drive(), 2),
                        Intake.setPower(subsystems.intake(), () -> -0.5).withTimeout(2)
                ),

                DriveCommands.backward(subsystems.drive(), 2),

                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(), 4),
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH)
                ),

                DriveCommands.forward(subsystems.drive(), 3),

                DriveCommands.strafeLeft(subsystems.drive(), SIDE1B),
                DriveCommands.forward(subsystems.drive(), 4),
                Intake.setPower(subsystems.intake(), () -> 0.6).withTimeout(0.5),

                DriveCommands.driveToPose(subsystems.drive(), () -> new Pose(35, -5, 0))




        );
    }

    public static Command redAuto (Subsystems subsystems) {
        return Commands.sequence(

                Commands.parallel(
                        Pivot.setPosition(subsystems.pivot(), () -> PivotConstants.HIGH),
                        DriveCommands.forward(subsystems.drive(), FRONT)
                ),

                DriveCommands.strafeRight(subsystems.drive(), SIDE1),
                DriveCommands.forward(subsystems.drive(), 4),
                Intake.setPower(subsystems.intake(), () -> 0.4).withTimeout(0.5),

                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(), 4),
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.FEED)
                ),

                DriveCommands.strafeLeft(subsystems.drive(), SIDE2),

                Commands.parallel(
                DriveCommands.forward(subsystems.drive(), 2),
                Intake.setPower(subsystems.intake(), () -> -0.5).withTimeout(2)
                ),

                DriveCommands.backward(subsystems.drive(), 2),

                Commands.parallel(
                        DriveCommands.backward(subsystems.drive(), 4),
                        Pivot.setPosition(subsystems.pivot(), PivotConstants.HIGH)
                ),

                DriveCommands.forward(subsystems.drive(), 3),

                DriveCommands.strafeRight(subsystems.drive(), SIDE1),
                DriveCommands.forward(subsystems.drive(), 4),
                Intake.setPower(subsystems.intake(), () -> 0.6).withTimeout(0.5),

                DriveCommands.driveToPose(subsystems.drive(), () -> new Pose(XP, YP, 0))


        );


    }
}

