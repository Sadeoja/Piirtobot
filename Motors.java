import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Motors {
	public RegulatedMotor rightMotor;
	public RegulatedMotor leftMotor;
	public RegulatedMotor lifterMotor;
	public Motors(){
		rightMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		leftMotor = new EV3LargeRegulatedMotor(MotorPort.C);
		lifterMotor = new EV3MediumRegulatedMotor(MotorPort.B);
		rightMotor.setSpeed(300);
		leftMotor.setSpeed(300);
		lifterMotor.setSpeed(300);
	}
	
	public void syncStart(){
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
		rightMotor.startSynchronization();
		leftMotor.startSynchronization();
	}
	
	public void syncEnd(){
		rightMotor.endSynchronization();
		leftMotor.endSynchronization();
	}
	
	public void goForward(){
		syncStart();
		rightMotor.backward();
		leftMotor.forward();
		syncEnd();
	}
	
	public void goBackward(){
		syncStart();
		rightMotor.forward();
		leftMotor.backward();
		syncEnd();
	}
	
	public void goLeft(){
		syncStart();
		rightMotor.backward();
		leftMotor.backward();
		syncEnd();
	}
	
	public void goRight(){
		syncStart();
		rightMotor.forward();
		leftMotor.forward();
		syncEnd();
	}
	
	public void stopFlt(){
		syncStart();
		leftMotor.flt();
		rightMotor.flt();
		syncEnd();
	}
	
	public void close(){
		rightMotor.close();
		leftMotor.close();
		lifterMotor.close();
	}
}
