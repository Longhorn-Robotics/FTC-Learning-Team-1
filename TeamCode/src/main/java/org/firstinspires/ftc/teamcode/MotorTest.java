package org.firstinspires.ftc.teamcode;

import android.net.http.SslCertificate;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Motor Test", group = "Testing")
public class MotorTest extends LinearOpMode {

    private DcMotor motor;
    private CRServo Servo;

    @Override
    public void runOpMode() {
        // Map the motor connected to port 1 (labeled "motor_1" in the Control Hub config)
        motor = hardwareMap.get(DcMotor.class, "motor_1");

        telemetry.addData("Status", "Ready to run motor1");
        telemetry.update();

        //Map servo to port 1 (labled "servo_0" in the Control Hub config)
        Servo = hardwareMap.get(CRServo.class, "servo_0");

        telemetry.addData("Status", "Ready to run serv0" );
        telemetry.update();

        // Wait for the play button on the Driver Station
        waitForStart();

        // Run motor at 20%
        motor.setPower(0.2);
        telemetry.addData("Motor", "Running");
        telemetry.update();

        Servo.setPower(0.5);
        telemetry.addData("CRServo", "Running");
        telemetry.update();

        // Keep running until stop is pressed
        while (opModeIsActive()) {
            // negative for y makes it work beacuse y is inverted on all controllers for some reason.
            double power = -gamepad1.left_stick_y;

            telemetry.addData("Motor Power", power);
            telemetry.update();
        }

        // Stop the motor when the opmode ends
        motor.setPower(0);
        telemetry.addData("Motor", "Stopped");
        telemetry.update();

        Servo.setPower(0);
        telemetry.addData("CRServo", "Stopped");
        telemetry.update();3
    }
}
