import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Main {

	static RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.A);
	static RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.C);
	static RegulatedMotor lifterMotor = new EV3MediumRegulatedMotor(MotorPort.B);
	
	public static void main(String[] args) {
		
		rightMotor.setSpeed(1000);
		leftMotor.setSpeed(1000);
		lifterMotor.setSpeed(1000);
		// forward -> käsi liikkuu oikealle
		// backward -> käsi liikkuu vasemmalle
		
		while (true){
			if (Button.DOWN.isDown()){
				drawLine(0);
			}else if (Button.UP.isDown()){
				drawLine(1);
			}else if (Button.RIGHT.isDown()){
				drawLine(2);
			}else if (Button.LEFT.isDown()){
				drawLine(3);
			}else if (Button.ESCAPE.isDown()){
				break;
			}
		}
		
		
		
		rightMotor.close();
		leftMotor.close();
		lifterMotor.close();
	}
	
	static void drawLine(int dir){
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
		rightMotor.startSynchronization();
		leftMotor.startSynchronization();
		if (dir == 0){
			rightMotor.rotate(360);
			leftMotor.rotate(-360);
		} else if (dir == 1){
			rightMotor.rotate(-360);
			leftMotor.rotate(360);
		} else if (dir == 2){
			rightMotor.rotate(360);
			leftMotor.rotate(360);
		} else if (dir == 3){
			rightMotor.rotate(-360);
			leftMotor.rotate(-360);
		}
		
		rightMotor.endSynchronization();
		leftMotor.endSynchronization();
		Delay.msDelay(500);
	}
}
