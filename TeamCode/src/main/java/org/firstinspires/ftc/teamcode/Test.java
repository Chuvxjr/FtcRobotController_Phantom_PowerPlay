package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


        import android.graphics.Color;

        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.Servo;
        import com.qualcomm.robotcore.hardware.CRServo;
        import com.qualcomm.robotcore.hardware.ColorSensor;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.hardware.CRServo;
        import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
        import com.qualcomm.robotcore.util.ElapsedTime;

        import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

//TODO: ПРОЛЕТАРИЙ, ПЕРЕД ТЕМЬ, КАК МЕНЯТЬ ЧТО-ТО В ГАМАПЕДЕ, ПРОВЕРЬ СНАЧАЛА МАТЬ АГАПА!!!
@TeleOp(name = "Test", group = "TeleOP")
public class Test extends OpMode {
    DcMotor leftF, rightF, leftB, rightB, krut, vobla, pod, sos;
    CRServo zaxvat, vikidisch;
    private ElapsedTime runtime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);


    @Override
    public void init() {
        leftF = hardwareMap.dcMotor.get("lf");
        leftB = hardwareMap.dcMotor.get("lr");
        rightF = hardwareMap.dcMotor.get("rf");
        rightB = hardwareMap.dcMotor.get("rr");
        krut = hardwareMap.dcMotor.get("kr");
        vobla = hardwareMap.dcMotor.get("vl");
        zaxvat = hardwareMap.crservo.get("zx");
        vikidisch = hardwareMap.crservo.get("vs");
        pod = hardwareMap.dcMotor.get("pod");
        sos = hardwareMap.dcMotor.get("sos");
    }


    @Override

    public void loop() {
        pod.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        float pwrTrigger = (gamepad1.left_trigger);
        float pwrTrigger2 = (gamepad1.right_trigger);
        float pwrTrigger6 = (gamepad2.left_trigger);
        float pwrTrigger5 = (gamepad2.right_trigger);
        float pwrTrigger3 = (float) (gamepad2.left_trigger * 0.66);
        float pwrTrigger4 = (float) (gamepad2.right_trigger * 0.66);
        float StickX = (gamepad1.right_stick_x);
        float StickY = (gamepad1.right_stick_y);
        float Stick2X = (float) (gamepad1.left_stick_x * 0.3);
        float Stick2Y = (float) (gamepad1.left_stick_y * 0.3);
        //korob.setTargetPosition(720);
        double power = -1;
        if (gamepad1.a){
            leftF.setPower(1);
        } else {
            leftF.setPower(0);
        } if (gamepad1.b){
            leftB.setPower(1);
        } else {
            leftB.setPower(0);
        }
        if (gamepad1.x){
            rightF.setPower(1);
        } else {
            rightF.setPower(0);
        } if (gamepad1.y){
            rightB.setPower(1);
        } else {
            rightB.setPower(0);
        }}}
