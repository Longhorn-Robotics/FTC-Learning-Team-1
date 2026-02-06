//Import offical FTC teamcode package
//omega9656.github.io/ultimate-goal/org/firstinspires/ftc/teamcode/hardware/package-summary.html
package org.firstinspires.ftc.teamcode;

//Import functions needed like DcMotor, CRServo, Teleop, and LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;






@TeleOp(name = "Motor Test", group = "Testing")
public class MotorTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        //Map the motor connected to port 0-3 (labeled "motor_(number)" in the Control Hub config)
        //Specify names of motors/make function to call them
        DcMotor motor0 = hardwareMap.get(DcMotor.class, "motor_0");
        DcMotor motor1 = hardwareMap.get(DcMotor.class, "motor_1");
        DcMotor motor2 = hardwareMap.get(DcMotor.class, "motor_2");
        DcMotor motor3 = hardwareMap.get(DcMotor.class, "motor_3");
        DcMotor outtakeR = hardwareMap.get(DcMotor.class, "outtakeL_2");
        DcMotor outtakeL = hardwareMap.get(DcMotor.class, "outtakeL_2");
        DcMotor kicker = hardwareMap.get(DcMotor.class, "outtakeK");

        //Map the servo connected to port X (labeled "servo_(X)" in the Control Hub config)
        //Specify names of servos/make function to call them
        CRServo intakeServoR = hardwareMap.get(CRServo.class, "servo_5");
        CRServo intakeServoL = hardwareMap.get(CRServo.class, "servo_2");
        CRServo kickerServo = hardwareMap.get(CRServo.class, "servo_4");

        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        // Wait for the play button on the Driver Station
        waitForStart();



        //This does something while the robot is running
        while (opModeIsActive()) {


            telemetry.addData("gamepad_left_stick_y", gamepad1.left_stick_y);
            telemetry.update();

            //forward and backward for motors
            motor0.setPower(gamepad1.left_stick_y);
            //motor 1 is flipped irl
            motor1.setPower(-gamepad1.left_stick_y);
            motor2.setPower(gamepad1.left_stick_y);
            motor3.setPower(-gamepad1.left_stick_y);

            //left and right without turning
            //front left forward
            motor0.setPower(-gamepad1.left_stick_x);
            //motor 1 is flipped irl/front right "backward(cuz of flip)"
            motor1.setPower(gamepad1.left_stick_x);
            //bottom left back
            motor2.setPower(gamepad1.left_stick_x);
            //front right back
            motor3.setPower(-gamepad1.left_stick_x);


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
            motor3.setPower(-gamepad1.right_stick_x);
            //RBack
            //no need for negative because motor 1 is flipped
            motor1.setPower(gamepad1.right_stick_x);






            //left trigger for intake
            if (gamepad1.left_trigger > 0.1) {
                intakeServoR.setPower(1);
                //Intake left is flipped irl
                intakeServoL.setPower(-1);
                telemetry.addData("IntakeServos", "Running");
            } else {
                //make sure to stop when done
                intakeServoR.setPower(0);
                intakeServoL.setPower(0);
            }

            //right trigger for outtake
            if (gamepad1.right_trigger > 0.1){
                outtakeR.setPower(gamepad1.right_trigger);
                outtakeL.setPower(gamepad1.right_trigger);
                telemetry.addData("Outtake", "Running");

            }else{
                outtakeR.setPower(0);
                outtakeL.setPower(0);
            }

            //code for kicker
            if (gamepad1.y){
                //motor kicker forward
                kicker.setPower(1);
                telemetry.addData("Kicker", "Running");
            } else {
                //motor kicker backwards
                kicker.setPower(-1);
                kicker.getCurrentPosition();
                telemetry.addData("kicker_current_position", kicker.getCurrentPosition());
                telemetry.update();
            }

            //Servo on kicker
            if (gamepad1.b){
                kickerServo.setPower(1);

            } else{
                kickerServo.setPower(0);
            }
        }

        //Opmode ends

        // Stop all motors when the opmode ends
        motor0.setPower(0);
        motor1.setPower(0);
        motor2.setPower(0);
        motor3.setPower(0);
        telemetry.addData("Motor", "Stopped");
        telemetry.update();
        telemetry.update();

        //stop intake servos
        intakeServoR.setPower(0);
        intakeServoL.setPower(0);
    }
}
