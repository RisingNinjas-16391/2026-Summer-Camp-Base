package org.firstinspires.ftc.teamcode.subsystems.pivot;

import com.acmerobotics.dashboard.config.Config;

@Config
public class PivotConstants {
    public static double kP = 3;
    public static double kG = 0.04;

    public static double ticksToRotations = 1.0 / (751.8 * 5);

    public static double setpoint = -0.12;
    public static double initialPosition = -0.12;

    public static double FEED = -0.12;
    public static double Level1 = 0.04;
    public static double Level2 = 0.08;
    public static double Level3 = 0.012;
    public static double Level4 = 0.016;
    public static double Level5 = 0.20;
    public static double CLIMB = 0.24;

    public static double currentThreshold = 2;
    public static double resetVoltage = -10;
}
