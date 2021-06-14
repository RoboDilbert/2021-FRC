package frc.robot.subsystems;

import frc.robot.subsystems.Intake.IntakeSolenoid;
import frc.robot.util.Constants;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Solenoid;




public class LiftSystem{
    
    private static CANSparkMax lifterMotor;
    private static CANEncoder lifterMotorEncoder;

    private static Solenoid lifterSolenoid;
    private static LifterSolenoid currentSolenoidState;

    public enum LifterState{
        UP,
        DOWN,
        STOP;
    }

    public enum LifterSolenoid{
        DOWN,
        UP;
    }

    public static void init(){
        lifterMotor = new CANSparkMax(Constants.lifterMotorID, MotorType.kBrushless);
        lifterMotor.setIdleMode(IdleMode.kBrake);
        lifterMotorEncoder = lifterMotor.getEncoder();
        lifterSolenoid = new Solenoid(Constants.lifterSolenoid);
    }

    public static void controlLifter(LifterState value){
        powerLifter(lifterMotor, value);
    }

    private static void powerLifter(SpeedController motor, LifterState value){
        if(value == LifterState.UP){
            motor.set(-Constants.lifterSpeedUp);
        }
        else if(value == LifterState.DOWN){
            motor.set(Constants.lifterSpeedDown);
        }
        else if (value == LifterState.STOP){
            motor.set(0);
        }
    }

    public static void lowerLifter(){
        currentSolenoidState = LifterSolenoid.DOWN;
        lifterSolenoid.set(false);
    }

    public static void raiseLifter(){
        currentSolenoidState = LifterSolenoid.UP;
        lifterSolenoid.set(true);
    }

    public void debugLift(){
        SmartDashboard.putNumber("Lift Motor Encoder", lifterMotorEncoder.getPosition());
    }
    
}