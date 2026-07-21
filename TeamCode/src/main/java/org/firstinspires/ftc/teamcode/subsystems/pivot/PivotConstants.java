package org.firstinspires.ftc.teamcode.subsystems.pivot;

import com.acmerobotics.dashboard.config.Config;

@Config
public class PivotConstants {
    public static double kP = 3;
    public static double kG = 0.04;

    /*
    ticks * (1 rev / 28 ticks) * (1 / 19.2) * (1 / 2) * (1 / 20)
    */

    public static double ticksToRotations = (1 / 28.0) * (1 / 19.2) * (1 / 5.0) * (1 / 2.0);

    public static double setpoint = -0.13;

    public static double initialPosition = -0.13;

    public static double FEED = -0.13;
    public static double LOW = 0.03;
    public static double HIGH = 0.18;
    public static double CLIMB = 0.5;

    public static double currentThreshold = 2;
    public static double resetVoltage = -10;

}
