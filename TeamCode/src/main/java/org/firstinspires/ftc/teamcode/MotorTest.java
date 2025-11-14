package org.firstinspires.ftc.teamcode;

import android.net.http.SslCertificate;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;





@TeleOp(name = "Motor Test", group = "Testing")
public class MotorTest extends LinearOpMode {

    private DcMotor motor0, motor1, motor2, motor3;
    private Servo kicker;
    private CRServo intakeServoR, intakeServoL;

    @Override
    public void runOpMode() {
        // Map the motor connected to port 0-3 (labeled "motor_(number)" in the Control Hub config)
        motor0 = hardwareMap.get(DcMotor.class, "motor_0");
        motor1 = hardwareMap.get(DcMotor.class, "motor_1");
        motor2 = hardwareMap.get(DcMotor.class, "motor_2");
        motor3 = hardwareMap.get(DcMotor.class, "motor_3");


        //Map servo to port 0 (labled "servo_0" in the Control Hub config)
        kicker = hardwareMap.get(Servo.class, "servo_0");
        intakeServoR = hardwareMap.get(CRServo.class, "servo_2");
        intakeServoL = hardwareMap.get(CRServo.class, "servo_5");

        //gamepad1 = hardwareMap.get(Gamepad.class, "controller_1");

        telemetry.addData("Status", "Ready to run motor");
        telemetry.update();

        telemetry.addData("Status", "Ready to run");
        telemetry.update();
        // Wait for the play button on the Driver Station
        waitForStart();

        //Run all motors at 30%
        motor0.setPower(0.3);
        //motor 1 is backwards irl
        motor1.setPower(-0.3);
        motor2.setPower(0.3);
        motor3.setPower(0.3);
        telemetry.addData("Motor", "Running");
        telemetry.update();

        //Intake servos power 30%
        //Intake right is flipped irl
        intakeServoR.setPower(-1);
        intakeServoL.setPower(0.45);
        telemetry.addData("CRServo", "Running");
        telemetry.update();


        //code for kicker to work
        //end position
        //kicker.setPosition(1.0);
        telemetry.addData("Kicker", "Running");
        telemetry.update();

        /*
        //move 90 degrees
        Servo.setDirection(DcMotorSimple.Direction.valueOf("90"));
        //set power 65 percent power
        Servo.setPower(0.65);
        //wait 2 sec
        sleep(2000);

        //move 45 deg
        Servo.setDirection(DcMotorSimple.Direction.valueOf("45"));
        //move back 135
        Servo.setDirection(DcMotorSimple.Direction.valueOf("-135"));
        */

        // Do something while code is running
        //like read inputs or degree amounts
        while (opModeIsActive()) {
            // negative for y makes it work beacuse y is inverted on all controllers for some reason.
            // i dont know what double power means chat told me to
            //double power = -gamepad1.left_stick_y;
            //telemetry.addData("Motor Power", gamepad1.left_stick_y);
            //telemetry.update();

            //Print output RPM and Torque
            //Right intake servo 0.14 sec per 60 deg at 6 volts (71.43 RPM)
            //Left intake 0.09 sec per 60 deg at 6 volts (111.11 RPM)
            telemetry.addData("CRServo", "Stopped");
            telemetry.update();




        }

        // Stop all motors when the opmode ends
        motor0.setPower(0);
        motor1.setPower(0);
        motor2.setPower(0);
        motor3.setPower(0);
        telemetry.addData("Motor", "Stopped");
        telemetry.update();

        telemetry.addData("CRServo", "Stopped");
        //good starting position
        //kicker.setPosition(0.7);
        telemetry.update();

        //stop intake servo
        intakeServoR.setPower(0);
        intakeServoL.setPower(0);
    }
}
