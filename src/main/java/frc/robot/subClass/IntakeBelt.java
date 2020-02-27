package frc.robot.subClass;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;

public class IntakeBelt {

    private VictorSPX intakeBelt;
    private DigitalInput intakeFrontSensor, intakeBackSensor;

    public IntakeBelt(VictorSPX intakeBelt, DigitalInput intakeFrontSensor, DigitalInput intakeBack) {
        this.intakeBelt = intakeBelt;
        this.intakeFrontSensor = intakeFrontSensor;
        this.intakeBackSensor = intakeBack;
    }

    public void applyState(State state){
        switch (state.intakeBeltState){
            case kIntake:
                intake();
                break;
            case kouttake:
                outtake();
                Util.sendConsole("outtake","out");
                break;
            case doNothing:
                setSpeed(0);
                break;
        }
    }

    private void setSpeed(double speed){
        intakeBelt.set(ControlMode.PercentOutput,speed);
    }

    private void intake(){
            setSpeed(-1);
    }
    private void outtake(){
        setSpeed(1);
    }
    private boolean getFrontSensor(){
        return intakeFrontSensor.get();
    }

    private boolean getBackSensor(){
        return intakeBackSensor.get();
    }
}
