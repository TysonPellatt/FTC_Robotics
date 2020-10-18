package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;


@TeleOp(name = "arm_test")
public class armTest extends LinearOpMode {
    DcMotor armMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        armMotor = hardwareMap.get(DcMotor.class, "intake");
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();


        while (opModeIsActive()) {
            armMotor.setTargetPosition(-150);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.2);
            while (armMotor.isBusy());
                armMotor.setPower(0.1);
                sleep(1000);
            armMotor.setTargetPosition(-500);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(1.0);
            while (armMotor.isBusy()){
                telemetry.addData("position",armMotor.getCurrentPosition());
                telemetry.update();


            }
;           armMotor.setPower(0.2);
            sleep(1000);
        }
    }
}