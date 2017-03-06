import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

// forward -> k‰si liikkuu oikealle
// backward -> k‰si liikkuu vasemmalle

public class Main {
	static Motors motors;
	static PenController penController;
	
	public static void main(String[] args) {
		
		init();
		String valinta = "vapaa";
		boolean lcdRefresh = false;
		int x = 0;
		int y = 0;
		
		LCD.drawString(valinta, 0, 0);
		while (true) {
			LCD.clear();
			LCD.drawString("x: " + x + ", y: " + y, 0, 0);
			LCD.refresh();
			if (valinta == "vapaa") {
				if (Button.DOWN.isDown()) {
					penController.drawLine("eteen", 25);
				}else if (Button.UP.isDown()) {
					penController.drawLine("taakse", 25);
				}else if (Button.RIGHT.isDown()) {
					penController.drawLine("vasen", 25);
				}else if (Button.LEFT.isDown()) {
					penController.drawLine("oikea", 25);
				}
//				if (Button.DOWN.isDown()) {
//					y--;
//					Delay.msDelay(500);
//				} else if (Button.UP.isDown()) {
//					y++;
//					Delay.msDelay(500);
//				} else if (Button.RIGHT.isDown()) {
//					x++;
//					Delay.msDelay(500);
//				} else if (Button.LEFT.isDown()) {
//					x--;
//					Delay.msDelay(500);
//				}
				else if (Button.ENTER.isDown()) {
					shapes.ympyra(5, 200);
				}
				
//			} else if (valinta == "nelio") {
//				if (Button.ENTER.isDown()){
//					shapes.nelio(100);
//				}
//			} else if (valinta == "kolmio"){
//				if (Button.ENTER.isDown()){
//					shapes.kolmio(100);
//				}
			}
			
			if (Button.ESCAPE.isDown()) {
				break;
			}
		}
		motors.close();
	}
	
	static void init() {
		motors = new Motors();
		penController = new PenController(motors);
		shapes = new Shapes(penController);
		letters = new Letters(penController);
	}
	
	
	
	
//	static void ympyra2() {
//	int alkuNopeusRight = rightMotor.getSpeed();
//	int alkuNopeusLeft = leftMotor.getSpeed();
//
//	int nopeusRight = alkuNopeusRight / 2;
//	int nopeusLeft = alkuNopeusLeft / 2;
//	drawLine("eteen", 250);
//	rightMotor.setSpeed(nopeusRight -= alkuNopeusRight / 4);
//	drawLine("eteen", 500);
//	rightMotor.setSpeed(nopeusRight -= alkuNopeusRight / 4);
//	drawLine("eteen", 750);
//	rightMotor.setSpeed(alkuNopeusRight / 2);
//	// drawLine("oikea", 500);
//	leftMotor.setSpeed(nopeusLeft = 0);
//	drawLine("oikea", 750);
//	leftMotor.setSpeed(nopeusLeft += alkuNopeusLeft / 4);
//	drawLine("oikea", 500);
//	leftMotor.setSpeed(nopeusLeft += alkuNopeusLeft / 4);
//	drawLine("oikea", 250);
//
//	leftMotor.setSpeed(alkuNopeusLeft);
//	rightMotor.setSpeed(alkuNopeusRight);
//}
	/*
static void ympyra2() {
	int alkuNopeusRight = motors.rightMotor.getSpeed();
	int alkuNopeusLeft = motors.leftMotor.getSpeed();
	
	int a = 500;
	int b = 1000;
	int c = 100;
	
	int nopeusRight = alkuNopeusRight;
	int nopeusLeft = alkuNopeusLeft;
	
	motors.leftMotor.setSpeed(nopeusLeft);
	motors.rightMotor.setSpeed(nopeusRight);
	
	drawLine("eteen", a);
	Delay.msDelay(c);
	motors.leftMotor.setSpeed(nopeusLeft / 2);
	drawLine("eteen", a); // etuetuvasen
	Delay.msDelay(c);
	motors.leftMotor.setSpeed(nopeusLeft);
	drawLine("etuvasen", b);
	Delay.msDelay(c);
	motors.leftMotor.setSpeed(nopeusLeft / 2);
	drawLine("vasen", a); // vasenvasenetu
	Delay.msDelay(c);
	motors.leftMotor.setSpeed(nopeusLeft);
	drawLine("vasen", a);
	Delay.msDelay(c);
	motors.rightMotor.setSpeed(nopeusRight / 2);
	drawLine("vasen", a); // vasenvasentaka
	Delay.msDelay(c);
	motors.rightMotor.setSpeed(nopeusRight);
	drawLine("takavasen", b);
	Delay.msDelay(c);
	motors.rightMotor.setSpeed(nopeusLeft / 2);
	drawLine("taakse", a); // takatakavasen
	Delay.msDelay(c);
	motors.rightMotor.setSpeed(nopeusLeft);
	drawLine("taakse", a);
	Delay.msDelay(c);
	motors.rightMotor.setSpeed(nopeusLeft / 2);
	drawLine("taakse", a); // takatakaoikea
	Delay.msDelay(c);
	motors.rightMotor.setSpeed(nopeusLeft);
	drawLine("takaoikea", b);
	Delay.msDelay(c);
	motors.leftMotor.setSpeed(nopeusLeft / 2);
	drawLine("oikea", a); // oikeaoikeataka
	Delay.msDelay(c);
	motors.leftMotor.setSpeed(nopeusLeft);
	drawLine("oikea", a);
	Delay.msDelay(c);
	motors.rightMotor.setSpeed(nopeusRight / 2);
	drawLine("oikea", a); // oikeaoikeaetu
	Delay.msDelay(c);
	motors.rightMotor.setSpeed(nopeusRight);
	drawLine("etuoikea", b);
	Delay.msDelay(c);
	motors.rightMotor.setSpeed(nopeusRight / 2);
	drawLine("eteen", a); // etuetuoikea
	Delay.msDelay(c);
	motors.rightMotor.setSpeed(nopeusRight);
	
	
	motors.leftMotor.setSpeed(alkuNopeusLeft);
	motors.rightMotor.setSpeed(alkuNopeusRight);
}
*/	
	// yritt‰‰ piirt‰‰ ympyr‰n
//	static void ympyra(float size) {
//		int alpha = 0;
//		float x = 0;
//		float y = 0;
//		
//		for (alpha = 0; alpha < 360; alpha += 30) {
//			x = (float) (size * Math.cos(alpha) - x);
//			
//			y = (float) ((size * Math.sin(alpha) - y));
//			drawLineXY(x, y);
//			if (Button.ESCAPE.isDown()) {
//				break;
//			}
//		}
//	}
	
	// ----------------------------------------------------------------------------------------
	

	// piirt‰‰ viivan valittuun suuntaan valitulla pituudella
	// k‰ytt‰en rotate
//	static void drawLine2(String dir, int lenght) { 
//		rightMotor.synchronizeWith(new RegulatedMotor[] { leftMotor });
//		rightMotor.startSynchronization();
//		leftMotor.startSynchronization();
//		if (dir == "eteen") {
//			rightMotor.rotate(-lenght);
//			leftMotor.rotate(lenght);
//		} else if (dir == "taakse") {
//			rightMotor.rotate(lenght);
//			leftMotor.rotate(-lenght);
//		} else if (dir == "oikea") {
//			rightMotor.rotate(lenght);
//			leftMotor.rotate(lenght);
//		} else if (dir == "vasen") {
//			rightMotor.rotate(-lenght);
//			leftMotor.rotate(-lenght);
//		} else if (dir == "takavasen") {
//			leftMotor.rotate(-lenght * 2);
//		}
//
//		rightMotor.endSynchronization();
//		leftMotor.endSynchronization();
//		Delay.msDelay(10); // t‰m‰ pelasti
//	}
	// piirt‰‰ viivan valittuun suuntaan oletuspituudella
	// k‰ytt‰en rotate
//	static void drawLine2(String dir) {
//		int lenght = 360;
//		rightMotor.synchronizeWith(new RegulatedMotor[] { leftMotor });
//		rightMotor.startSynchronization();
//		leftMotor.startSynchronization();
//		if (dir == "eteen") {
//			rightMotor.rotate(-lenght);
//			leftMotor.rotate(lenght);
//		} else if (dir == "taakse") {
//			rightMotor.rotate(lenght);
//			leftMotor.rotate(-lenght);
//		} else if (dir == "oikea") {
//			rightMotor.rotate(lenght);
//			leftMotor.rotate(lenght);
//		} else if (dir == "vasen") {
//			rightMotor.rotate(-lenght);
//			leftMotor.rotate(-lenght);
//		} else if (dir == "takavasen") {
//			leftMotor.rotate(-lenght * 2);
//		}
//
//		rightMotor.endSynchronization();
//		leftMotor.endSynchronization();
//		Delay.msDelay(10); // t‰m‰ pelasti
	//	}
}