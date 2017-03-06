import lejos.utility.Delay;

/**
 * Kyn‰n ohjaus moottoreiden avulla 
 * @author ?
 * T‰ll‰ tiedostolla ohjataan kyn‰‰ k‰ytt‰m‰ll‰ Motors.java:n funktioita.
 * Laita kaikki liikkeisiin liittyv‰t asiat t‰nne.
 */

public class PenController {
	private Motors motors;

	public PenController(Motors motors) {
		this.motors = motors;
	}
	
	// piirt‰‰ viivan valittuun suuntaan tietyn ajan
	// k‰ytt‰en forward, backward, flt metodeja
	public void drawLine(String dir, int lenght) { 
		if (dir == "eteen") {
			motors.goForward();
		} else if (dir == "taakse") {
			motors.goBackward();
		} else if (dir == "oikea") {
			motors.goRight();
		} else if (dir == "vasen") {
			motors.goLeft();
		} else if (dir == "takavasen") {
			motors.goBackLeft();
		} else if (dir == "takaoikea") {
			motors.goBackRight();
		} else if (dir == "etuoikea") {
			motors.goFrontRight();
		} else if (dir == "etuvasen") {
			motors.goFrontLeft();
		}
		
		Delay.msDelay(lenght); 
		
		motors.stopFlt();
	}
	
	// piirt‰‰ 45 asteen kaaren johonkin suuntaan
	// dir1 on mihin p‰in robotti alkaa piirt‰‰ (eteen = 0, taakse = 2, oikea = 1, vasen = 3)
	// dir2 minne kaari kaartuu (oikea = 0, vasen = 1)
	public void drawCurve(String dir1, String dir2, int delay, int smoothness) {
		float speed = 100;
		float interval = 100.0 / smoothness;
		
		switch(dir1) {
			// eteen
			case 0:
				motors.goForward();
				break;
				
			// oikea
			case 1:
				motors.goRight();
				break;
				
			// taakse
			case 2:
				motors.goBackward();
				break;
				
			// vasen
			case 3:
				motors.goLeft();
				break;
		}
		
		// parillinen niin tarvitsee hidastaa oikeaa moottoria, pariton niin vasenta
		if ((dir1 + dir2) mod 2 == 0) {
			for (int i = 0; i < smoothness; i++) {
				motors.setSpeed(100, speed);
				speed -= smoothness;
				Delay.msDelay(delay);
			}
		} else {
			for (int i = 0; i < smoothness; i++) {
				motors.setSpeed(speed, 100);
				speed -= smoothness;
				Delay.msDelay(delay);
			}
		}
		
		motors.stopFlt();
	}
	
	/*
	public void drawLineXY(float dx, float dy) {
		int factor = 90;
		int intx = Math.round(dx * factor);
		int inty = Math.round(dy * factor);

		int lenght = (int) (100 * Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
		
		if (dx > 0 && dy > 0) {
			motors.goFrontRight();
		} else if (dx == 0 && dy > 0) {
			motors.goForward();
		} else if (dx > 0 && dy == 0) {
			motors.goRight();
		} else if (dx < 0 && dy > 0 && -dx == dy) {
			motors.goFrontLeft();
		} else if (dx < 0 && dy == 0) {
			motors.goLeft();
		} else if (dx > 0 && dy < 0 && dx == -dy) {
			motors.goBackRight();
		} else if (dx == 0 && dy < 0) {
			motors.goBackward();
		} else if (dx < 0 && dy < 0 && dx == dy) {
			motors.goBackLeft();
		}
	}
	*/
}