package org.firstinspires.ftc.teamcode; //our code

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gamepad;

// LIST OF THINGS TO DO
// 1. Find out how to connect gamepad
// 2. Put the correct servo ids
// 3. I don't think gamepad.bumper is a thing???
// 4. Fix BUGS
// 5. Fix BUGS Pt. 2
// 6. Fix BUGS Pt. 3
// 7. Fix BUGS Pt. 3
// 8. Fix BUGS Pt. 4
// 9. Fix BUGS Pt. 5
// Keep going until the end of eternity...

//TEST
@TeleOp(name="TeleopRizz", group="Pushbot")
public class TeleopRizz extends OpMode {

    private DcMotor frontRight= null; //jaZDVVZDZDZSVVZDZDVva sucks
    private DcMotor frontLeft= null; //python lowk better
    private DcMotor backRight= null; //we should use py
    private DcMotor backLeft= null; //

    // INDEX 0 CORRESPONDS WITH LINEAR RAIL, 1 WITH CLAW, AND 2 WITH ARM
    public int linearRailIdx = 0;
    public int clawIdx = 1;
    public int armIdx = 2;

     public float[] servoRotations = List.of(0, 0, 0);

     // HOW TO REMOVE LIMITS FOR SERVO ROTATIONS: Set maxRot to 9999 or set minRot to -9999

     public float[] minRot = List.of(0, 0, 0);
     public float[] maxRot = List.of(4, 4, 4);
    
     private Gamepad gamepad = new Gamepad(); // Still needs some work...
     public List<Servo> servoIdentity = List.of(hardwareMap.get(Servo.class, "lr"), hardwareMap.get(Servo.class, "clw"), hardwareMap.get(Servo.class, "arm"));
    
     // NEED TO ADJUST CLOSE AND OPEN CLAW POSITIONS
     public float closeClawPosition = 0;
     public float openClawPosition = 0;
        
    RobotHardwareLite robot = new RobotHardwareLite();

    @Override
    public void init(){
//        robot.init(hardwareMap); //connects to all hardware components
        telemetry.addData("travis:", "fein fein fein fein");
        frontLeft = hardwareMap.get(DcMotor.class, "left_front_drive");
        backLeft = hardwareMap.get(DcMotor.class, "left_back_drive");
        frontRight = hardwareMap.get(DcMotor.class, "right_front_drive");
        backRight = hardwareMap.get(DcMotor.class, "right_back_drive");
    }

    waitForStart();
    
    @Override //repeats after PLAY, BEFORE STOP
    public void loop(){
        frontLeft.setPower(1);
        backLeft.setPower(1);
        frontRight.setPower(1);
        backRight.setPower(1);
        telemetry.addLine(String.format("It should be moving"));

        if (gamepad.y) {
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
