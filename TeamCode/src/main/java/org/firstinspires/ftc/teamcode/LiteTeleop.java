package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotHardwareLite;

@TeleOp(name = "LiteTeleop", group = "Pushbot")
public class LiteTeleop extends OpMode {
    static double RAIL_MIN = 0.0f;
    static double RAIL_MAX = 3000.0f;

    final double joystickBaseSpeed = 1f;
    RobotHardwareLite robot = new RobotHardwareLite();
    double railPos = 0.0f;

    // Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        robot.init(hardwareMap);
        // Send telemetry message to signify robot waiting
        telemetry.addData("Say", "Hello Advay");
    }

    // Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    @Override
    public void init_loop() {
    }

    // Code to run ONCE when the driver hits PLAY
    @Override
    public void start() {

    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        // Final Robot Instructions
        double final_throttle = 0.0f;
        double final_strafe = 0.0f;
        double final_yaw = 0.0f;

//        double joystickMultiplier = joystickBaseSpeed + (1.0f - gamepad1.right_trigger);
        double joystickMultiplier = joystickBaseSpeed;

        final_throttle += (gamepad1.left_stick_y * joystickMultiplier);
        final_strafe += (gamepad1.left_stick_x * joystickMultiplier);
        final_yaw += (gamepad1.right_stick_x * joystickMultiplier);

        robot.frontLeft.setPower(0.6*(final_throttle - final_strafe - final_yaw));
        robot.backLeft.setPower(final_throttle + final_strafe - final_yaw);
        robot.frontRight.setPower(0.6*(-final_throttle - final_strafe - final_yaw));
        robot.backRight.setPower(-final_throttle + final_strafe - final_yaw);

        telemetry.addLine(String.format("Right Trigger: %6.2f", gamepad1.right_trigger));
        telemetry.addLine(String.format("Target Position: %6.2f", railPos));
        telemetry.addLine(String.format("Rail Position: %d", robot.rail.getPosition()));

        railPos += (gamepad1.right_trigger - gamepad1.left_trigger) * 0.5f;

        //if (railPos < RAIL_MIN) railPos = RAIL_MIN;
        //else if (railPos > RAIL_MAX) railPos = RAIL_MAX;

        robot.rail.setPosition(railPos);

        telemetry.update();
    }

    // Code to run ONCE after the driver hits STOP
    @Override
    public void stop() {
    }
}