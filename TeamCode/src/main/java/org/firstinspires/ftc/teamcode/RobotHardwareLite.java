package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//2786.2 is full rotation for motor

public class RobotHardwareLite {
    HardwareMap hwMap;
    public DcMotor backLeft;
    public DcMotor frontLeft;
    public DcMotor backRight;
    public DcMotor frontRight;
    public DcMotor rail;
    public Servo arm;
    public Servo claw;

    private ElapsedTime period = new ElapsedTime();

    public RobotHardwareLite() {}

    public void init(HardwareMap ahwMap) {
        // Save reference to hardware map
        hwMap = ahwMap;

        // Initialize drive motors
        frontLeft = hwMap.get(DcMotor.class, "left_front_drive");
        backLeft = hwMap.get(DcMotor.class, "left_back_drive");
        frontRight = hwMap.get(DcMotor.class, "right_front_drive");
        backRight = hwMap.get(DcMotor.class, "right_back_drive");
        rail = hwMap.get(DcMotor.class, "rail");
        
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        rail = hwMap.get(DcMotor.class, "rail");
        //set defaults
        arm = hwMap.get(Servo.class, "arm");
    //    arm.setPosition(0.7);
        claw = hwMap.get(Servo.class, "claw");
    //    claw.setPosition(0.125);

//        // linear rail motor to run with encoder setup
        //we can modify it to be able to controllable by holding down a button later
//       
//        rail.setDirection(DcMotor.Direction.REVERSE);
//        rail.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        rail.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        rail.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        rail.setMode(DcMotor.RunMode.RUN_TO_POSITION);
  //      rail.setPower(0.5);
        
    }
}
