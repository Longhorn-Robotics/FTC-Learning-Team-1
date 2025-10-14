package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Motor Test", group = "Testing")
public class MotorTest extends LinearOpMode {

    private DcMotor motor;

    @Override
    public void runOpMode() {
        // Map the motor connected to port 1 (labeled "motor_1" in the Control Hub config)
        //CHANGE TO "andrei" for device name if it still doesnt work
        motor = hardwareMap.get(DcMotor.class, "motor_1");

        telemetry.addData("Status", "Ready to start");
        telemetry.update();

        // Wait for the play button on the Driver Station
        waitForStart();

        // Run motor at 20%
        motor.setPower(0.2);

        telemetry.addData("Motor", "Running");
        telemetry.update();

        // Keep running until stop is pressed
        while (opModeIsActive()) {
            // You can also stop the motor if you want to add conditions
        }

        // Stop the motor when the opmode ends
        motor.setPower(0);
        telemetry.addData("Motor", "Stopped");
        telemetry.update();
    }
}
