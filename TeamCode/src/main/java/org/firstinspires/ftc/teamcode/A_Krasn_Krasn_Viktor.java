package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by maryjaneb  on 11/13/2016.
 *
 * nerverest ticks
 * 60 1680
 * 40 1120
 * 20 560
 *
 * monitor: 640 x 480
 *YES
 */
@Autonomous(name= "A_Krasn_Krasn_Viktor", group="Autonomous")
//
public class A_Krasn_Krasn_Viktor extends Methods {
    private final ElapsedTime runtime = new ElapsedTime();


    private static int valLeft = -1;
    private static int valRight = -1;
    private static float rectHeight = 0.5f / 8f;
    private static float rectWidth = 0.5f / 8f;
    private static float rectHeight1 = 0.5f / 8f;
    private static float rectWidth1 = 0.5f / 8f;

    private static float offsetX = 0f / 8f;//changing this moves the three rects and the three circles left or right, range : (-2, 2) not inclusive
    private static float offsetY = 0f / 8f;//changing this moves the three rects and circles up or down, range: (-4, 4) not inclusive

    private static float[] leftPos = {2.0f / 8f + offsetX, 4f / 8f + offsetY};
    private static float[] rightPos = {2.8f / 8f + offsetX, 4 / 8f + offsetY};

    private final int rows = 640;
    private final int cols = 480;
    @Override
    public void runOpMode() throws InterruptedException {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        phoneCam.openCameraDevice();
        phoneCam.setPipeline(new StageSwitchingPipeline());
        phoneCam.startStreaming(rows, cols, OpenCvCameraRotation.UPRIGHT);
        leftF = hardwareMap.dcMotor.get("lf");
        leftB = hardwareMap.dcMotor.get("lr");
        rightF = hardwareMap.dcMotor.get("rf");
        rightB = hardwareMap.dcMotor.get("rr");
        pisun = hardwareMap.crservo.get("pis");
        pod = hardwareMap.dcMotor.get("pod");
        drin = hardwareMap.dcMotor.get("drin");
        big = hardwareMap.crservo.get("big");
        zaxvat = hardwareMap.crservo.get("zx");

        initGyro();
        waitForStart();

        runtime.reset();
        while (opModeIsActive()) {
            telemetry.addData("Values", valLeft + "  " + valRight);
            telemetry.update();
            if (valLeft == 255) {
                drin_castom(2000);
                big.setPower(0.8);
                drin_castom(-1700);
                sleep(1300);
                pisun.setPower(0);
                vpered(730, 0.25);
                vpered(300, 0.25);
                nazad(250, 0.25);
                sleep(1000);
                razvarot(-275, 0.25);
                vpered(300, 0.25);
                drin_castom(3500);
                big.setPower(-0.77);
                vpered(180, 0.25);
                sleep(500);
                drin_castom(-1000);
                pisun.setPower(0.4);
                sleep(1000);
                drin_castom(1500);
                big.setPower(0.8);
                nazad(300, 0.25);
                razvarot(275, 0.25);
                razvarot(550,0.25);
                vpered(730, 0.3);
                drin_castom(-3000);
                stop_all();
                sleep(30000);
            } else if(valRight == 255){
                drin_castom(2000);
                big.setPower(0.8);
                drin_castom(-1700);
                sleep(1300);
                pisun.setPower(0);
                vpered(730, 0.25);
                vpered(300, 0.25);
                nazad(250, 0.25);
                sleep(1000);
                razvarot(-275, 0.25);
                vpered(300, 0.25);
                drin_castom(3500);
                big.setPower(-0.77);
                vpered(180, 0.25);
                sleep(500);
                drin_castom(-1000);
                pisun.setPower(0.4);
                sleep(1000);
                drin_castom(1500);
                big.setPower(0.8);
                nazad(300,0.25);
                razvarot(275, 0.25);
                vpered(200, 0.25);
                drin_castom(-3000);
                stop_all();
                sleep(30000);
            } else{
                drin_castom(2000);
                big.setPower(0.8);
                drin_castom(-1700);
                sleep(1300);
                pisun.setPower(0);
                vpered(730, 0.25);
                vpered(300, 0.25);
                nazad(250, 0.25);
                sleep(1000);
                razvarot(-275, 0.25);
                vpered(300, 0.25);
                drin_castom(3500);
                big.setPower(-0.77);
                vpered(180, 0.25);
                sleep(500);
                drin_castom(-1000);
                pisun.setPower(0.4);
                sleep(1000);
                drin_castom(1500);
                big.setPower(0.8);
                nazad(300,0.25);
                razvarot(275, 0.25);
                razvarot(-550,0.25);
                vpered(630, 0.3);
                drin_castom(-3000);
                stop_all();
                sleep(30000);
            }

            /*if (valLeft == 255) {
                vikidish_castom(500);
                vpered(1280, 0.25);
                vpravo(390, 0.25);
                vpravo(400, 0.25);
                vpered(250, 0.3);
                vikidish_castom(-3800);
                sleep(30000);
            } else if (valRight == 255) {
                vikidish_castom(500);
                vpered(880, 0.25);
                vlevo(100, 0.25);
                vpered(250, 0.3);
                vikidish_castom(-3800);
                sleep(30000);
            } else {
                vikidish_castom(500);
                vpered(880, 0.25);
                vlevo(100, 0.25);
                vlevo(850, 0.25);
                vpered(250, 0.3);
                vikidish_castom(-3800);
                sleep(30000);
            }*/
        }}
            /*
            if (valLeft == 255) {
            } else if (valRight == 255) {
            } else {
            }*/


    static class StageSwitchingPipeline extends OpenCvPipeline {
        Mat yCbCrChan2Mat = new Mat();
        Mat thresholdMat = new Mat();
        Mat all = new Mat();
        List<MatOfPoint> contoursList = new ArrayList<>();

        enum Stage {//color difference. greyscale
            detection,//includes outlines
            THRESHOLD,//b&w
            RAW_IMAGE,//displays raw view
        }

        private Stage stageToRenderToViewport = Stage.detection;
        private  Stage[] stages = Stage.values();

        @Override
        public void onViewportTapped() {
            /*
             * Note that this method is invoked from the UI thread
             * so whatever we do here, we must do quickly.
             */

            int currentStageNum = stageToRenderToViewport.ordinal();

            int nextStageNum = currentStageNum + 1;

            if (nextStageNum >= stages.length) {
                nextStageNum = 0;
            }

            stageToRenderToViewport = stages[nextStageNum];
        }

        @Override
        public Mat processFrame(Mat input) {
            contoursList.clear();
            /*
             * This pipeline finds the contours of yellow blobs such as the Gold Mineral
             * from the Rover Ruckus game.
             */

            //color diff cb.
            //lower cb = more blue = skystone = white
            //higher cb = less blue = yellow stone = grey
            Imgproc.cvtColor(input, yCbCrChan2Mat, Imgproc.COLOR_RGB2YCrCb);//converts rgb to ycrcb
            Core.extractChannel(yCbCrChan2Mat, yCbCrChan2Mat, 2);//takes cb difference and stores

            //b&w
            Imgproc.threshold(yCbCrChan2Mat, thresholdMat, 120, 255, Imgproc.THRESH_BINARY_INV);

            //outline/contour
            Imgproc.findContours(thresholdMat, contoursList, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
            yCbCrChan2Mat.copyTo(all);//copies mat object
            //Imgproc.drawContours(all, contoursList, -1, new Scalar(255, 0, 0), 3, 8);//draws blue contours


            //get values from frame


            double[] pixLeft = thresholdMat.get((int) (input.rows() * leftPos[1]), (int) (input.cols() * leftPos[0]));//gets value at circle
            valLeft = (int) pixLeft[0];

            double[] pixRight = thresholdMat.get((int) (input.rows() * rightPos[1]), (int) (input.cols() * rightPos[0]));//gets value at circle
            valRight = (int) pixRight[0];

            //create three points
            Point pointLeft = new Point((int) (input.cols() * leftPos[0]), (int) (input.rows() * leftPos[1]));
            Point pointRight = new Point((int) (input.cols() * rightPos[0]), (int) (input.rows() * rightPos[1]));

            //draw circles on those points
            Imgproc.circle(all, pointLeft, 5, new Scalar(255, 0, 0), 1);//draws circle
            Imgproc.circle(all, pointRight, 5, new Scalar(255, 0, 0), 1);//draws circle

            //draw 3 rectangles
            Imgproc.rectangle(//1-3
                    all,
                    new Point(
                            input.cols() * (leftPos[0] - rectWidth1 / 2),
                            input.rows() * (leftPos[1] - rectHeight1 / 2)),
                    new Point(
                            input.cols() * (leftPos[0] + rectWidth1 / 2),
                            input.rows() * (leftPos[1] + rectHeight1 / 2)),
                    new Scalar(0, 255, 0), 3);

            Imgproc.rectangle(//5-7
                    all,
                    new Point(
                            input.cols() * (rightPos[0] - rectWidth / 2),
                            input.rows() * (rightPos[1] - rectHeight / 2)),
                    new Point(
                            input.cols() * (rightPos[0] + rectWidth / 2),
                            input.rows() * (rightPos[1] + rectHeight / 2)),
                    new Scalar(0, 255, 0), 3);

            switch (stageToRenderToViewport) {
                case THRESHOLD: {
                    return thresholdMat;
                }

                case detection: {
                    return all;
                }

                case RAW_IMAGE: {
                    return input;
                }

                default: {
                    return input;
                }
            }
        }
    }
}

