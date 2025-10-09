package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Motor Test", group="Testing")
public class MotorTest extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Status", "Ready to start");
    }

    @Override
    public void start() {
        telemetry.addData("Status", "Running");
    }

    @Override
    public void loop() {
        // Keeps updating while the OpMode is running
    }

    @Override
    public void stop() {
        telemetry.addData("Status", "Stopped");
    }
}
