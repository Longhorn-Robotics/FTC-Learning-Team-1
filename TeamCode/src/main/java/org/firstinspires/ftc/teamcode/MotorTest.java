package org.firstinspires.ftc.teamcode;

import android.net.http.SslCertificate;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
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
        intakeServoR = hardwareMap.get(CRServo.class, "servo_5");
        intakeServoL = hardwareMap.get(CRServo.class, "servo_2");

        //gamepad1 = hardwareMap.get(Gamepad.class, "controller_1");

        telemetry.addData("Status", "Ready to run motor");
        telemetry.update();

        telemetry.addData("Status", "Ready to run");
        telemetry.update();
        // Wait for the play button on the Driver Station
        waitForStart();

        //Run all motors at 30%
        //motor0.setPower(0.3);
        //motor 1 is backwards irl
        //motor1.setPower(-0.3);
        //motor2.setPower(0.3);
        //motor3.setPower(0.3);
        telemetry.addData("Motor", "Running");
        telemetry.update();

        //Intake servos power 30%
        //Intake right is flipped irl
        //intakeServoR.setPower(1.0);
        //intakeServoL.setPower(-0.43);
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


            telemetry.addData("gamepad_left_stick_y", gamepad1.left_stick_y);
            telemetry.update();

            //forward and backward for motors
            motor0.setPower(gamepad1.left_stick_y);
            //motor 1 is flipped irl
            motor1.setPower(-gamepad1.left_stick_y);
            motor2.setPower(gamepad1.left_stick_y);
            motor3.setPower(gamepad1.left_stick_y);

            //left and right without turning
            //front left forward
            motor0.setPower(-gamepad1.left_stick_x);
            //motor 1 is flipped irl/front right "backward(cuz of flip)"
            motor1.setPower(gamepad1.left_stick_x);
            //bottom left back
            motor2.setPower(gamepad1.left_stick_x);
            //front right back
            motor3.setPower(gamepad1.left_stick_x);



            //right joystick to rotate robot
            telemetry.addData("gamepad_right_stick_x", gamepad1.right_stick_x);
            telemetry.update();

            // Left side (0, 2) must go FORWARD
            // Right side (3, 1) must go BACKWARD
            // LFront
            motor0.setPower(-gamepad1.right_stick_x);
            //LBack
            motor2.setPower(-gamepad1.right_stick_x);

            //RFront
            motor3.setPower(gamepad1.right_stick_x);
            //RBack
            //no need for negative because motor 1 is flipped
            motor1.setPower(-gamepad1.right_stick_x);





            //left trigger for intake
            if (gamepad1.left_trigger > 0.1) {
                intakeServoR.setPower(0.43);
                //Intake left is flipped irl
                intakeServoL.setPower(-1);
                telemetry.addData("IntakeServos", "Running");
            } else {
                //make sure to stop when done
                intakeServoR.setPower(0);
                intakeServoL.setPower(0);
            }



        }

        // Stop all motors when the opmode ends
        motor0.setPower(0);
        motor1.setPower(0);
        motor2.setPower(0);
        motor3.setPower(0);
        telemetry.addData("Motor", "Stopped");
        telemetry.update();
        //good starting position
        //kicker.setPosition(0.7);
        telemetry.update();

        //stop intake servo
        intakeServoR.setPower(0);
        intakeServoL.setPower(0);
    }
}
