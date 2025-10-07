package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="HelloWorldOpMode")
public class HelloWorldOpMode extends LinearOpMode {
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Hello, FTC World!");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("Loop", "Running...");
            telemetry.update();
        }
    }
}
