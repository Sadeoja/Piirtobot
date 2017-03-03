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
					drawLine("eteen");
				}else if (Button.UP.isDown()) {
					drawLine("taakse");
				}else if (Button.RIGHT.isDown()) {
					drawLine("vasen");
				}else if (Button.LEFT.isDown()) {
					drawLine("oikea");
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
					ympyra2();
//					penController.drawLineXY(x, y);
				}
				
//			} else if (valinta == "nelio") {
//				if (Button.ENTER.isDown()){
//					nelio(100);
//				}
//			} else if (valinta == "kolmio"){
//				if (Button.ENTER.isDown()){
//					kolmio(100);
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
	}
	
	
	// piirt‰‰ viivan valittuun suuntaan oletuspituudella
	// k‰ytt‰en forward, backward, flt metodeja
	static void drawLine(String dir, int lenght) { 
		if (dir == "eteen") {
			motors.goForward();
		} else if (dir == "taakse") {
			motors.goBackward();
		} else if (dir == "oikea") {
			motors.goRight();
		} else if (dir == "vasen") {
			motors.goLeft();
		} else if (dir == "takavasen") {
			motors.syncStart();
			motors.leftMotor.backward();
			motors.syncEnd();
		} else if (dir == "takaoikea") {
			motors.syncStart();
			motors.rightMotor.forward();
			motors.syncEnd();
		} else if (dir == "etuoikea") {
			motors.syncStart();
			motors.leftMotor.forward();
			motors.syncEnd();
		} else if (dir == "etuvasen") {
			motors.syncStart();
			motors.rightMotor.backward();
			motors.syncEnd();
		}
		
		Delay.msDelay(lenght); 
		
		motors.stopFlt();
	}
	
	// piirt‰‰ viivan valittuun suuntaan oletuspituudella
	// k‰ytt‰en forward, backward, flt metodeja
	static void drawLine(String dir) { 
		int lenght = 250;
		
		if (dir == "eteen") {
			motors.goForward();
		} else if (dir == "taakse") {
			motors.goBackward();
		} else if (dir == "oikea") {
			motors.goRight();
		} else if (dir == "vasen") {
			motors.goLeft();
		} else if (dir == "takavasen") {
			motors.syncStart();
			motors.leftMotor.backward();
			motors.syncEnd();
		} else if (dir == "takaoikea") {
			motors.syncStart();
			motors.rightMotor.forward();
			motors.syncEnd();
		} else if (dir == "etuoikea") {
			motors.syncStart();
			motors.leftMotor.forward();
			motors.syncEnd();
		} else if (dir == "etuvasen") {
			motors.syncStart();
			motors.rightMotor.backward();
			motors.syncEnd();
		}
		
		Delay.msDelay(lenght); 
		
		motors.stopFlt();
	}
	
	// piirt‰‰ kolmion
	static void kolmio(int size) {
		drawLine("oikea", size);
		drawLine("eteen", size);
		drawLine("takavasen", size * 2);
		Delay.msDelay(100);
	}
	
	// piirt‰‰ neliˆn eli nelj‰ viivaa per‰kk‰in
	static void nelio(int size) { 
		drawLine("vasen");
		Delay.msDelay(200); // n‰it‰ taukoja ei tapahdu jos k‰ytt‰‰ motor.rotate
		drawLine("eteen");
		Delay.msDelay(200);
		drawLine("oikea");
		Delay.msDelay(200);
		drawLine("taakse");
		Delay.msDelay(200);
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
