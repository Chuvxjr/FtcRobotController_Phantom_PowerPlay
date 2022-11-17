package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@TeleOp(name = "test", group = "TeleOP")
public class test_servak extends OpMode {
    DcMotorEx krut1, krut2;
    CRServo vikidisch;
    private ElapsedTime runtime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);


    @Override
    public void init() {

       vikidisch = hardwareMap.crservo.get("vs");
       krut1 = hardwareMap.get(DcMotorEx.class,"kr1");
        krut1 = hardwareMap.get(DcMotorEx.class,"kr2");


    }


    @Override

    public void loop() {
        if (gamepad1.right_bumper) {
            krut1.setPower(1);
         } else if (gamepad1.left_bumper) {
            krut1.setPower(-1);
        } else if (gamepad1.x) {
            krut1.setVelocity(500);
        } else if (gamepad1.b) {
            krut1.setVelocity(500);
        } else if (gamepad1.a) {
            krut1.setPower(0.2);
        } else if (gamepad1.y) {
            krut1.setPower(-0.2);
        } else {
            krut1.setPower(0);
        }
        if (gamepad1.dpad_right) { // НОРМАЛЬНАЯ МОЩНОСТЬ 0 6 НА МЕРТВОМ 0 5 НА НОРМАЛЬНОМ.
            krut2.setVelocity(1800);
        } else if (gamepad1.dpad_left) {
            krut2.setPower(-0.6);
        } else if (gamepad1.dpad_up) {
            krut2.setVelocity(1120);
        } else if (gamepad1.dpad_down){
            krut2.setVelocity(-610);
        } else {
            krut2.setPower(0);
        }




    }

}
      /*  if (gamepad1.start) {
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0.75);
            }
            runtime.reset();
            while (runtime.time() <= 450) {
                tolk.setPower(0);
            }
        }
*/