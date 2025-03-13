package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.RobotHardwareLite;

// From now on:
// Comment code correctly
// Follow variable naming conventions
// Organize things
// Use good commit names
// - Arman

@TeleOp(name = "LiteTeleop", group = "Pushbot")
public class LiteTeleop extends OpMode {
    RobotHardwareLite robot = new RobotHardwareLite();
    
    static double RAIL_MIN = 0.0f;
    static double RAIL_MAX = 3000.0f;

    static double ARM_MIN = 0.0f;
    static double ARM_MAX = 0.8f;

    static double CLAW_OPEN = 0.125f;
    static double CLAW_CLOSED = 0.25f;

    final double joystickBaseSpeed = 1f;
    
    double railPos = 0.0f;
    double armPos = 0.0f;

    boolean clawOpen = true; //true = OPEN; false = CLOSED

    // Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        robot.init(hardwareMap);
        robot.arm.setPosition(0.25); //set away from default of zero so it doesnt hit the table

        // Send telemetry message to signify robot waiting
        telemetry.addData("Say:", "Hello Advay");
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        // WHEELS
        double final_throttle = 0.0f;
        double final_strafe = 0.0f;
        double final_yaw = 0.0f;

        double joystickMultiplier = joystickBaseSpeed;

        final_throttle += (gamepad1.left_stick_y * joystickMultiplier);
        final_strafe += (gamepad1.left_stick_x * joystickMultiplier);
        final_yaw += (gamepad1.right_stick_x * joystickMultiplier);

        robot.frontLeft.setPower(0.6 * (final_throttle - final_strafe - final_yaw));
        robot.backLeft.setPower(final_throttle + final_strafe - final_yaw);
        robot.frontRight.setPower(0.6 * (-final_throttle - final_strafe - final_yaw));
        robot.backRight.setPower(-final_throttle + final_strafe - final_yaw);

        // LINEAR RAIL
        if (gamepad1.right_trigger > 0.1f) {
            railPos += 0.5;
        } else if (gamepad1.left_trigger > 0.1f) {
            railPos -= 0.5;
        }

        if (railPos < RAIL_MIN) {
            railPos = RAIL_MIN;
        }

        if (railPos > RAIL_MAX) {
            railPos = RAIL_MAX;
        }

        // ARM
        if (gamepad1.right_bumper) {
            armPos += 0.05;
        } else if (gamepad1.left_bumper) {
            armPos -= 0.05;
        }

        if (armPos < ARM_MIN) {
            armPos = ARM_MIN;
        }

        if (armPos > ARM_MAX) {
            armPos = ARM_MAX;
        }

        // CLAW
        if (gamepad1.y) {
            telemetry.addData("Debug: ", "Y-Button Detected");
            clawOpen = true;
        }

        if (gamepad1.a) {
            telemetry.addData("Debug: ", "A-button Detected");
            clawOpen = false;
        }

        if (clawOpen) {
            robot.claw.setPosition(CLAW_OPEN); //45 deg
        } else {
            robot.claw.setPosition(CLAW_CLOSED); //90 deg
        }

        // UPDATE POSITIONS
        robot.rail.setPosition(railPos);
        robot.arm.setPosition(armPos);

        telemetry.update();
    }
}
