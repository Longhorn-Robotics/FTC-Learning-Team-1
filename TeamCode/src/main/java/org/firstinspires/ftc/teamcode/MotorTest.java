package org.firstinspires.ftc.teamcode;

import android.net.http.SslCertificate;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;



@TeleOp(name = "Motor Test", group = "Testing")
public class MotorTest extends LinearOpMode {

    private DcMotor motor;
    private CRServo Servo;

    @Override
    public void runOpMode() {
        // Map the motor conn65ected to port 1 (labeled "motor_1" in the Control Hub config)
        motor = hardwareMap.get(DcMotor.class, "motor_1");
        //gamepad1 = hardwareMap.get(Gamepad.class, "controller_1");

        telemetry.addData("Status", "Ready to run motor1");
        telemetry.update();

        //Map servo to port 1 (labled "servo_0" in the Control Hub config)
        Servo = hardwareMap.get(CRServo.class, "servo_0");

        telemetry.addData("Status", "Ready to run serv0" );
        telemetry.update();

        // Wait for the play button on the Driver Station
        waitForStart();

        // Run motor at 20%
        //motor.setPower(0.2);
        //telemetry.addData("Motor", "Running");
        //telemetry.update();

        //Servo.setPower(0.1);
        //telemetry.addData("CRServo", "Running");
        //telemetry.update();

        //code for kicker to work
        //make sure to restart/start at 45 percent power
        Servo.setPower(0.45);
        //move 90 degrees
        Servo.setDirection(DcMotorSimple.Direction.valueOf("90"));
        //set power 65 percent power
        Servo.setPower(0.45);
        //wait 2 sec
        sleep(2000);

        //move 45 deg
        Servo.setDirection(DcMotorSimple.Direction.valueOf("45"));
        //move back 135
        Servo.setDirection(DcMotorSimple.Direction.valueOf("-135"));

        // Do something while code is running
        //like read inputs or degree amounts
        while (opModeIsActive()) {
            // negative for y makes it work beacuse y is inverted on all controllers for some reason.
            // i dont know what double power means chat told me to
            //double power = -gamepad1.left_stick_y;
            //telemetry.addData("Motor Power", gamepad1.left_stick_y);
            //telemetry.update();



        }

        // Stop the motor when the opmode ends
        motor.setPower(0);
        telemetry.addData("Motor", "Stopped");
        telemetry.update();

        Servo.setPower(0);
        telemetry.addData("CRServo", "Stopped");
        telemetry.update();
    }
}
