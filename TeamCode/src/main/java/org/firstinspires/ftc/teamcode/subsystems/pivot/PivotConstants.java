package org.firstinspires.ftc.teamcode.subsystems.pivot;

import com.acmerobotics.dashboard.config.Config;

@Config
public class PivotConstants {
    public static double kP = 3;
    public static double kG = 0.04;

    public static double ticksToRotations = 1.0 / (751.8 * 5);

    public static double setpoint = -0.12;

    public static double initialPosition = -0.12;

    public static double FEED = -0.13;
    public static double L1= -0.17;
    public static double L2 = -0.24;

    public static double L3 = -0.30;

    public static double L4 = -0.365;

    public static double L5 = -0.425;
    public static double CLIMB = -1.5;

    public static double currentThreshold = 2;
    public static double resetVoltage = -10;

}
//-0.12
//