package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DigitalChannel;

//TODO: ПРОЛЕТАРИЙ, ПЕРЕД ТЕМЬ, КАК МЕНЯТЬ ЧТО-ТО В ГАМАПЕДЕ, ПРОВЕРЬ СНАЧАЛА МАТЬ АГАПА!!!
@TeleOp(name = "Gamepad_based", group = "TeleOP")
public class a_Gamepad_based extends OpMode {
    DcMotor leftF, rightF, leftB, rightB, pod, drin;
    CRServo zaxvat, pisun, big;
    DigitalChannel knopka;
    private ElapsedTime runtime = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);


    @Override
    public void init() {
        leftF = hardwareMap.dcMotor.get("lf");
        leftB = hardwareMap.dcMotor.get("lr");
        rightF = hardwareMap.dcMotor.get("rf");
        rightB = hardwareMap.dcMotor.get("rr");
        pisun = hardwareMap.crservo.get("pis");
        pod = hardwareMap.dcMotor.get("pod");
        drin = hardwareMap.dcMotor.get("drin");
        big = hardwareMap.crservo.get("big");
        zaxvat = hardwareMap.crservo.get("zx");
        knopka = hardwareMap.get(DigitalChannel.class, "knp");
        knopka.setMode(DigitalChannel.Mode.INPUT);
    }


    @Override

    public void loop() {
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
        if (knopka.getState() == true) {
            telemetry.addData("Digital Touch", "Is Not Pressed");
            telemetry.update();
        } else {
            telemetry.addData("Digital Touch", "Is Pressed");
            telemetry.update();
        }
        // занято 1 геймпад: стики , триггеры , бампера
        // занято 2 геймпад: крестовина вверх и вниз, бампера, буквы, триггеры

        if (StickY != 0 || StickX != 0) {
            leftF.setPower((+StickY - StickX) + pwrTrigger);
            leftB.setPower((+StickY + StickX) + pwrTrigger);
            rightB.setPower((-StickY + StickX) + pwrTrigger2);
            rightF.setPower((-StickY - StickX) - pwrTrigger2);
        } else if (Stick2Y != 0 || Stick2X != 0) {
            leftF.setPower((+Stick2Y - Stick2X) + pwrTrigger);
            rightB.setPower((-Stick2Y + Stick2X) + pwrTrigger2);
            rightF.setPower((-Stick2Y - Stick2X) + pwrTrigger2);
            leftB.setPower((+Stick2Y + Stick2X) + pwrTrigger);
        } else if (pwrTrigger != 0) {
            leftF.setPower(0.6 * pwrTrigger);
            rightB.setPower(0.6 * pwrTrigger);
            rightF.setPower(0.6 * pwrTrigger);
            leftB.setPower(0.6 * pwrTrigger);
        } else if (pwrTrigger2 != 0) {
            leftF.setPower(-0.6 * pwrTrigger2);
            rightB.setPower(-0.6 * pwrTrigger2);
            rightF.setPower(-0.6 * pwrTrigger2);
            leftB.setPower(-0.6 * pwrTrigger2);
        } else if (gamepad1.left_bumper) {
            leftF.setPower(0.2);
            rightB.setPower(0.2);
            rightF.setPower(0.2);
            leftB.setPower(0.2);
        } else if (gamepad1.right_bumper) {
            leftF.setPower(-0.2);
            rightB.setPower(-0.2);
            rightF.setPower(-0.2);
            leftB.setPower(-0.2);
        } else {
            leftF.setPower(0);
            rightB.setPower(0);
            rightF.setPower(0);
            leftB.setPower(0);

        }
        if (gamepad2.dpad_down){
            pod.setPower(1);
        } else if (gamepad2.dpad_up) {
            pod.setPower(-1);
        } else if (gamepad2.dpad_left) {
            pod.setPower(-0.01);
        }else if(gamepad2.dpad_right){
            pod.setPower(-0.1);
        } else {
            pod.setPower(0);
            pod.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }
        if (gamepad1.dpad_down){
            drin.setPower(1);
        } else if (gamepad1.dpad_up){
            while (knopka.getState() == true){
                drin.setPower(-1);
            }
        } else{
            drin.setPower(0);
        }
        if (gamepad2.left_bumper){
            pisun.setPower(0.4);
        } else {
            pisun.setPower(0);
        }

        if (gamepad2.a) {
            drin.setPower(1);
        }  else if (gamepad2.y){
            drin.setPower(-1);
        } else {
            drin.setPower(0);
        }
         if (gamepad2.b){
             zaxvat.setPower(0.18);
         } else  if (gamepad2.x){
             zaxvat.setPower(0);
         } else {
             zaxvat.setPower(-0.24);
         }

         if (gamepad2.right_bumper){
             big.setPower(-0.8);
         } else {
             big.setPower(0.9);
         }


        /*if (pwrTrigger5 != 0) {
            vobla.setPower(0.5 * pwrTrigger5);
        } else if (pwrTrigger6 != 0) {
            vobla.setPower(-0.5 * pwrTrigger6);
        }  else {
            vobla.setPower(0);
        }*/

       /* if (gamepad2.dpad_left) {
            krut.setPower(0.9);
        }
        else if (gamepad2.dpad_right){
            krut.setPower(-0.9);
        }
        else {
            krut.setPower(0);
        }*/
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