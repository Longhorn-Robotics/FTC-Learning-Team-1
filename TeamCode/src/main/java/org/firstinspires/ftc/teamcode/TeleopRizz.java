package org.firstinspires.ftc.teamcode;//package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//import org.firstinspires.ftc.teamcode.RobotHardwareLite;
//import org.firstinspires.ftc.teamcode;
//TEST
@TeleOp(name="TeleopRizz", group="Pushbot")
public class TeleopRizz extends OpMode {

    private DcMotor frontRight= null;
    private DcMotor frontLeft= null;
    private DcMotor backRight= null;
    private DcMotor backLeft= null; 
    RobotHardwareLite robot = new RobotHardwareLite();

    @Override
    public void init(){
        robot.init(hardwareMap); //connects to all hardware components
        telemetry.addData("travis:", "fein fein fein fein");
        frontLeft  = hardwareMap.get(DcMotor.class, "left_front_drive");//0
        backLeft  = hardwareMap.get(DcMotor.class, "left_back_drive");//1
        frontRight = hardwareMap.get(DcMotor.class, "right_front_drive");//2
        backRight = hardwareMap.get(DcMotor.class, "right_back_drive");//3

    }
    @Override //repeats after PLAY, BEFORE STOP
    public void loop(){

        frontLeft.setPower(0.07);
        backLeft.setPower(0.07);
        frontRight.setPower(0.07);
        backRight.setPower(0.07);
        telemetry.addData("it should b:", "move fein fein fein");

        //Thread.sleep(2000)//Francisco only wants to see the robot move
    }
}