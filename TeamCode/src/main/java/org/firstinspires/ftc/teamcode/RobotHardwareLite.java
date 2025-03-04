package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class RobotHardwareLite {
    HardwareMap hwMap;
    public DcMotor backLeft;
    public DcMotor frontLeft;
    public DcMotor backRight;
    public DcMotor frontRight;
    public Servo rail;
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

        rail = hwMap.get(Servo.class, "rizzy_rail");
        claw = hwMap.get(Servo.class, "rizzy_claw");

//        // Initialize linear rail motor to run with encoder
//        rail = hwMap.get(DcMotor.class, "railRAIL");
//        rail.setDirection(DcMotor.Direction.REVERSE);
//        rail.setTargetPosition(0);
//        rail.setPower(0.5);
//        rail.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        rail.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        rail.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        rail.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}