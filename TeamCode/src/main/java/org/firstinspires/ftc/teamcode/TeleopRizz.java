package org.firstinspires.ftc.teamcode; //our code

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gamepad;

//TEST
@TeleOp(name="TeleopRizz", group="Pushbot")
public class TeleopRizz extends OpMode {

    private Gamepad gamepad1 = new Gamepad(); //constructor

    private DcMotor frontRight = null; //jaZDVVZDZDZSVVZDZDVva sucks
    private DcMotor frontLeft = null; //python lowk better
    private DcMotor backRight = null; //we should use py
    private DcMotor backLeft = null; //

    // INDEX 0 CORRESPONDS WITH LINEAR RAIL, 1 WITH CLAW, AND 2 WITH ARM
//    public int linearRailIdx = 0;
//    public int clawIdx = 1;
//    public int armIdx = 2;

    //    public float[] servoRotations = List.of(0, 0, 0);

    // HOW TO REMOVE LIMITS FOR SERVO ROTATIONS: Set maxRot to 9999 or set minRot to -9999

    //    public float[] minRot = List.of(0, 0, 0);
    //   public float[] maxRot = List.of(4, 4, 4);

    //   private Gamepad gamepad = new Gamepad(); // Still needs some work...
//     public List<Servo> servoIdentity = List.of(hardwareMap.get(Servo.class, "N/A"), hardwareMap.get(Servo.class, "N/A"), hardwareMap.get(Servo.class, "N/A"));

    // NEED TO ADJUST CLOSE AND OPEN CLAW POSITIONS
//     public float closeClawPosition = 0;
    //    public float openClawPosition = 0;

    RobotHardwareLite robot = new RobotHardwareLite();

    @Override
    public void init() {
//        robot.init(hardwareMap); //connects to all hardware components
        telemetry.addData("travis:", "fein fein fein fein");
        frontLeft = hardwareMap.get(DcMotor.class, "left_front_drive");
        backLeft = hardwareMap.get(DcMotor.class, "left_back_drive");
        frontRight = hardwareMap.get(DcMotor.class, "right_front_drive");

        // double JOYSTICK_MIN;
   //     double JOYSTICK_MAX;



    }

    // waitForStart();

    @Override //repeats after PLAY, BEFORE STOP
    public void loop() {
        double y = -gamepad1.left_stick_y;
        double rx = gamepad1.left_stick_x;
        double power = Math.sqrt(Math.pow(y, 2) + Math.pow(rx, 2)); //java sucks
        double x = Math.atan2(y, rx);


        if (gamepad1.right_stick_x != 0) {
            frontRight.setPower(x - (0.25) * Math.PI);
            backLeft.setPower(x - (0.25) * Math.PI);

            frontLeft.setPower(x + (0.25) * Math.PI);
            backRight.setPower(x + (0.25) * Math.PI);
        } else {
            frontLeft.setPower(x);
            backLeft.setPower(x);

            frontRight.setPower(-x);
            backRight.setPower(-x);
        }

    }
}
   /*    if (gamepad.y) {
           SetServoPosition(servoIdentity[linearRailIdx], servoRotations.get(linearRailIdx) + 1);
         }

         if (gamepad.a) {
           SetServoPosition(servoIdentity[linearRailIdx], servoRotations.get(linearRailIdx) - 1);
         }

         if (gamepad.b) {
           SetServoPosition(servoIdentity[clawIdx], closeClawPosition);
         } else {
           SetServoPosition(servoIdentity[clawIdx], openClawPosition);
         }

         if (gamepad.LeftBumper) {
           SetServoPosition(servoIdentity[armIdx], servoRotations.get(armIdx) - 1);
         }

         if (gamepad.RightBumper) {
           SetServoPosition(servoIdentity[armIdx], servoRotations.get(armIdx) + 1);
         }

         ConfineServoBoundaries();
        //        Thread.sleep(2000)//Francisco only wants to see the robot move
    }

    public void ConfineServoBoundaries() {
       for (int i=0; i<servoRotations.Length; i++) {
         if (servoRotations.get(i) != 9999) {
           if (servoRotations.get(i) <= minRot.get(i)) {
             servoRotations.get(i) = minRot.get(i);
           }
         }

         if (servoRotations.get(i) != -9999) {
           if (servoRotations.get(i) >= maxRot.get(i)) {
             servoRotations.get(i) = maxRot.get(i);
           }
         }
       }
     }

     public void SetServoRotation(int servoIdx, float position) {
       servoIdentity.set(servoIdx).setPosition(position);
     }
}
*/