package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "ClawLite", group = "Pushbot")

public class ClawLite extends OpMode {
    RobotHardwareLite robot = new RobotHardwareLite();


    @Override
    public void init() {
        robot.claw.setPosition(0.55);
        telemetry.addData("Say:", "CLAW");
        telemetry.update(); //need in each loop
//sdf
    }

    @Override
    public void loop() {
        if (gamepad1.right_bumper) {
            robot.claw.setPosition(0.3);
            telemetry.addData("Debug:","Right bumper");
        } else if (gamepad1.left_bumper) { //driver 1
            robot.claw.setPosition(0.8);
            telemetry.addData("Debug:","Left bumper");
        }
        telemetry.update();
    }
}
