package org.firstinspires.ftc.teamcode;
/*import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import com.qualcomm.hardware.bosch.BNO055IMU;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import  com.qualcomm.robotcore.hardware.VoltageSensor;
import  java.lang.Thread;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvWebcam;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.util.ArrayList;
import java.util.List;

class Robot_move extends Thread {
    DcMotor leftF, rightF, leftB, rightB, krut, vobla;
    CRServo zaxvat;

    Orientation angles;
    VoltageSensor sensor;
    double speed;
    private ElapsedTime runtime = new ElapsedTime();
    BNO055IMU imu;
    Acceleration gravity;
    BNO055IMU.Parameters imuParameters;

    //0 means skystone, 1 means yellow stone
    //-1 for debug, but we can keep it like this because if it works, it should change to either 0 or 255

    private static int valLeft = -1;
    private static int valRight = -1;
    private static float rectHeight = 1.15f / 8f;
    private static float rectWidth = 0.8f / 8f;
    private static float rectHeight1 = 1.15f / 8f;

    private static float rectWidth1 = 0.5f / 8f;

    private static float offsetX = 0f / 8f;//changing this moves the three rects and the three circles left or right, range : (-2, 2) not inclusive
    private static float offsetY = 0f / 8f;//changing this moves the three rects and circles up or down, range: (-4, 4) not inclusive

    private static float[] leftPos = {1.58f / 8f + offsetX, 1.3f / 8f + offsetY};
    private static float[] rightPos = {2.27f / 8f + offsetX, 1.3f / 8f + offsetY};

    private final int rows = 640;
    private final int cols = 480;
    //OpenCvWebcam phoneCam;

    public void resetEncoders() {
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void vpravo(int pos, double speed) {
        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(-pos);
        rightB.setTargetPosition(pos);
        rightF.setTargetPosition(-pos);
        leftB.setTargetPosition(pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
        while (opModeIsActive() && (leftF.isBusy()) && (rightF.isBusy()) && (rightB.isBusy()) && (leftB.isBusy())) {

        }

        // Stop all motion;
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);

    }



    public void LB(int pos, double speed) {

        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(pos);
        rightB.setTargetPosition(-pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed);
        rightB.setPower(speed);

        while (opModeIsActive() && (leftF.isBusy()) && (rightB.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(),
                    rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }

        // Stop all motion;
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);
    }

    public void RB(int pos, double speed) {

        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setTargetPosition(pos);
        rightF.setTargetPosition(-pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setPower(speed);
        leftB.setPower(speed);

        while (opModeIsActive() && (leftB.isBusy()) && (rightF.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(),
                    rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }

        // Stop all motion;
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);

    }

    public void LF(int pos, double speed) {

        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setTargetPosition(-pos);
        rightF.setTargetPosition(pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setPower(speed);
        leftB.setPower(speed);

        while (opModeIsActive() && (leftB.isBusy()) && (rightF.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(),
                    rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }

        // Stop all motion;
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);

    }




    public void nazad() {
        leftF.setPower(speed);
        rightB.setPower(-speed);
        rightF.setPower(-speed);
        leftB.setPower(speed);
    }

    public void vpered(int pos, double speed) {

        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(pos);
        rightB.setTargetPosition(-pos);
        rightF.setTargetPosition(-pos);
        leftB.setTargetPosition(pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
        while (opModeIsActive() && (leftF.isBusy()) && (rightF.isBusy()) && (rightB.isBusy()) && (leftB.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(),
                    rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
        sleep(100);
    }

    public void razvarot(int pos, double speed) {
        leftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftF.setTargetPosition(pos);
        rightB.setTargetPosition(pos);
        rightF.setTargetPosition(pos);
        leftB.setTargetPosition(pos);
        leftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
        while (opModeIsActive() && (leftF.isBusy()) && (rightF.isBusy()) && (rightB.isBusy()) && (leftB.isBusy())) {

            telemetry.addData("Path2", "Running at %7d :%7d : %7d :%7d",
                    leftF.getCurrentPosition(),
                    rightB.getCurrentPosition(), rightF.getCurrentPosition(), leftB.getCurrentPosition());
            telemetry.update();
        }
        rightB.setPower(0);
        leftB.setPower(0);
        rightF.setPower(0);
        leftF.setPower(0);
    }

    public void vpered2() {
        leftF.setPower(-speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(-speed);

    }


    public void nazad3() {
        leftF.setPower(speed);
        rightB.setPower(-speed);
        rightF.setPower(-speed);
        leftB.setPower(speed);

    }


    public void vpravo2() {
        leftF.setPower(-speed);
        rightB.setPower(speed);
        rightF.setPower(-speed);
        leftB.setPower(speed);

    }

    public void vlevo() {
        leftF.setPower(speed);
        rightB.setPower(-speed);
        rightF.setPower(speed);
        leftB.setPower(-speed);
    }

    public void razvarotplus() {
        leftF.setPower(speed);
        rightB.setPower(speed);
        rightF.setPower(speed);
        leftB.setPower(speed);
    }


    public void razvarotminus() {
        leftF.setPower(-speed);
        rightB.setPower(-speed);
        rightF.setPower(-speed);
        leftB.setPower(-speed);
    }

    public void stop_all() {
        rightB.setPower(-0);
        leftB.setPower(0);
        rightF.setPower(-0);
        leftF.setPower(0);
    }

    public void stop_all3() {
        rightB.setPower(-0);
        leftB.setPower(0);
        rightF.setPower(-0);
        leftF.setPower(0);
    }

    public void turnl(double ugol, double speed) {
        leftF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        double degrees = angles.firstAngle;
        while ((ugol - degrees) >= 4) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            degrees = angles.firstAngle;
            telemetry.addData("degrees", degrees);
            telemetry.addData("ugol", ugol);
            telemetry.addData("rasn", (ugol - degrees));
            telemetry.update();

            leftF.setPower(speed);
            rightF.setPower(speed);
            leftB.setPower(speed);
            rightB.setPower(speed);
        }
        leftF.setPower(0);
        rightF.setPower(0);
        leftB.setPower(0);
        rightB.setPower(0);
        sleep(500);
        while ((ugol - degrees) <= -0.1) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            degrees = angles.firstAngle;
            telemetry.addData("degrees", degrees);
            telemetry.addData("ugol", ugol);
            telemetry.addData("rasn", (ugol - degrees));
            telemetry.update();
            leftF.setPower(-speed);
            rightF.setPower(-speed);
            leftB.setPower(-speed);
            rightB.setPower(-speed);


        }

        leftB.setPower(0);
        rightB.setPower(0);
        leftB.setPower(0);
        rightB.setPower(0);
    }

    public void turnr(double ugol, double speed) {
        leftF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        double degrees = angles.firstAngle;
        while ((ugol - degrees) <= -4.0) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            degrees = angles.firstAngle;
            telemetry.addData("degrees", degrees);
            telemetry.addData("ugol", ugol);
            telemetry.addData("rasn", Math.abs(ugol - degrees));
            telemetry.update();

            leftF.setPower(-speed);
            rightF.setPower(-speed);
            leftF.setPower(-speed);
            rightB.setPower(-speed);
        }
        leftF.setPower(0);
        rightF.setPower(0);
        leftB.setPower(0);
        rightB.setPower(0);
        sleep(500);
        while ((ugol - degrees) >= 4) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            degrees = angles.firstAngle;
            telemetry.addData("degrees", degrees);
            telemetry.addData("ugol", ugol);
            telemetry.addData("rasn", Math.abs(ugol - degrees));
            telemetry.update();
            leftF.setPower(speed);
            rightF.setPower(speed);
            leftB.setPower(speed);
            rightB.setPower(speed);


        }
        leftB.setPower(0);
        rightB.setPower(0);
        leftB.setPower(0);
        rightB.setPower(0);

    }

    public void turnr2(double ugol, double speed) {
        leftF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        double degrees = angles.firstAngle;
        while (Math.abs(ugol - degrees) >= 4) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            degrees = angles.firstAngle;
            telemetry.addData("degrees", degrees);
            telemetry.addData("ugol", ugol);
            telemetry.addData("rasn", Math.abs(ugol - degrees));
            telemetry.update();
            leftF.setPower(-speed);
            rightF.setPower(-speed);
            leftB.setPower(-speed);
            rightB.setPower(-speed);


        }
        leftF.setPower(0);
        rightF.setPower(0);
        leftB.setPower(0);
        rightB.setPower(0);
        sleep(500);
        while ((ugol - degrees) >= 4.0) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            degrees = angles.firstAngle;
            telemetry.addData("degrees", degrees);
            telemetry.addData("ugol", ugol);
            telemetry.addData("rasn", (ugol - degrees));
            telemetry.update();

            leftF.setPower(speed);
            rightF.setPower(speed);
            leftF.setPower(speed);
            rightB.setPower(speed);
        }
        leftF.setPower(0);
        rightF.setPower(0);
        leftB.setPower(0);
        rightB.setPower(0);
        sleep(500);

        leftB.setPower(0);
        rightB.setPower(0);
        leftB.setPower(0);
        rightB.setPower(0);

    }

    public void initGyro() {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        //parameters.calibrationDataFile = "GyroCal.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        //
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }

    public void vobla228() {
        vobla.setPower(-0.6);
        sleep(500);
        vobla.setPower(0.1);
        sleep(200);
        vobla.setPower(0);
        sleep(300);
        zaxvat.setPower(-0.3);
        vobla.setPower(0);
        sleep(400);
        vobla.setPower(0.6);
        sleep(250);
        vobla.setPower(0);
        sleep(300);
        zaxvat.setPower(0.53);
        sleep(20);
    }

    double getBatteryVoltage() {
        double result = Double.POSITIVE_INFINITY;
        for (VoltageSensor sensor : hardwareMap.voltageSensor) {
            double voltage = sensor.getVoltage();
            if (voltage > 0) {
                result = Math.min(result, voltage);
            }
        }
        return result;
    }
}*/
