import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
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
		String valinta = "vapaa";
		boolean lcdRefresh = false;
		rightMotor.setSpeed(300);
		leftMotor.setSpeed(300);
		lifterMotor.setSpeed(300);
		// forward -> käsi liikkuu oikealle
		// backward -> käsi liikkuu vasemmalle
		LCD.drawString(valinta, 0, 0);
		while (true){
			if (valinta == "vapaa"){
				if (Button.DOWN.isDown()){
					drawLine("eteen");
				}else if (Button.UP.isDown()){
					drawLine("taakse");
				}else if (Button.RIGHT.isDown()){
					drawLine("vasen");
				}else if (Button.LEFT.isDown()){
					drawLine("oikea");
				} else if (Button.ENTER.isDown()){
					nelio(15);
				}
//			} else if (valinta == "nelio"){
//				if (Button.ENTER.isDown()){
//					nelio(100);
//				}
//			} else if (valinta == "kolmio"){
//				if (Button.ENTER.isDown()){
//					kolmio(100);
//				}
			}
			
			if (Button.ESCAPE.isDown()){
				break;
			}
		}
		
		
		
		rightMotor.close();
		leftMotor.close();
		lifterMotor.close();
	}
	
	static void drawLine(String dir){
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
		rightMotor.startSynchronization();
		leftMotor.startSynchronization();
		if (dir == "eteen"){
			rightMotor.rotate(-360);
			leftMotor.rotate(360);
		} else if (dir == "taakse"){
			rightMotor.rotate(360);
			leftMotor.rotate(-360);
		} else if (dir == "oikea"){
			rightMotor.rotate(360);
			leftMotor.rotate(360);
		} else if (dir == "vasen"){
			rightMotor.rotate(-360);
			leftMotor.rotate(-360);
		} else if (dir == "takavasen"){
			leftMotor.rotate(-1000);
		}
		
		rightMotor.endSynchronization();
		leftMotor.endSynchronization();
	}
	
	static void kolmio(int size){
		for (int i = 0; i < size; i++){
			drawLine("oikea");
		}
		Delay.msDelay(100);
		for (int i = 0; i < size; i++){
			drawLine("eteen");		
		}
		Delay.msDelay(100);
		for (int i = 0; i < size * 1.4; i++){
			drawLine("takavasen");
		}
		Delay.msDelay(100);
	}
	
	static void nelio(int size){
//		for (int i = 0; i < size; i++){
//			drawLine("oikea");
//		}
//		Delay.msDelay(500);
//		for (int i = 0; i < size; i++){
//			drawLine("eteen");
//		}
//		Delay.msDelay(500);
//		for (int i = 0; i < size; i++){
//			drawLine("vasen");
//		}
//		Delay.msDelay(500);
//		for (int i = 0; i < size; i++){
//			drawLine("taakse");
//		}
//		Delay.msDelay(500);
		
		drawLine("oikea");
		Delay.msDelay(500);
		drawLine("eteen");
		Delay.msDelay(500);
		drawLine("vasen");
		Delay.msDelay(500);
		drawLine("taakse");
		Delay.msDelay(500);
	}
	
	static void drawLineXY(int x, int y){
		rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
		rightMotor.startSynchronization();
		leftMotor.startSynchronization();
		int factor = 1;
		if (x > 0 && y > 0){
			rightMotor.rotate(x * factor);
			leftMotor.rotate(y * factor);
		} else if (x == 0 && y > 0){
			rightMotor.rotate(-y * factor);
			leftMotor.rotate(y * factor);
		} else if (x > 0 && y == 0){
			rightMotor.rotate(x * factor);
			leftMotor.rotate(x * factor);
		} else if (x < 0 && y > 0){
			leftMotor.rotate(x * y * factor);
		} else if (x < 0 && y == 0){
			rightMotor.rotate(x * factor);
			leftMotor.rotate(x * factor);
		} else if (x > 0 && y < 0){
			rightMotor.rotate(x * y * factor);
		} else if (x == 0 && y < 0){
			rightMotor.rotate(-y * factor);
			leftMotor.rotate(y * factor);
		} else if (x < 0 && y < 0){
			rightMotor.rotate(x * factor);
			leftMotor.rotate(y * factor);
		}
		
		rightMotor.endSynchronization();
		leftMotor.endSynchronization();
	}
}
