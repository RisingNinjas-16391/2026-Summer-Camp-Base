package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.subsystems.claw.Claw;
import org.firstinspires.ftc.teamcode.subsystems.drive.Drive;
import org.firstinspires.ftc.teamcode.subsystems.intake.Intake;
import org.firstinspires.ftc.teamcode.subsystems.pivot.Pivot;
import org.firstinspires.ftc.teamcode.subsystems.servo_intake.ServoIntake;
import org.firstinspires.ftc.teamcode.subsystems.shooter.Shooter;

//public record Subsystems(Drive drive, Pivot pivot, Claw claw) {
//}

public record Subsystems(Drive drive, Pivot pivot, Intake intake, Shooter shooter) {
}
