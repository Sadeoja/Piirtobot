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
/**
 * 	piirt‰‰ viivan valittuun suuntaan tietyn ajan
 *  k‰ytt‰en forward, backward, flt metodeja
 * @param dir "eteen", "taakse", "oikea", "vasen", "etuoikea", "etuvasen", "takaoikea", "takavasen"
 * @param lenght double delayn aika liikkeess‰
 */
	// suora viiva
	public void drawLine(String dir, double lenght) { 
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
		
		Delay.msDelay((int) lenght); 
		
		motors.stop();
	}
	
/**
 * Piirt‰‰ 90 asteen ympyr‰n suuntaan dir1, kaartaen siit‰ suuntaan dir2
 * K‰ytt‰‰ delayta yksitt‰isten tarkkuusosien piirtoon
 * ja smoothnessia tarkkuusosien m‰‰r‰n‰
 * @param dir1 int, 0 = eteen, 1 = oikealle, 2 = taakse, 3 = vasemmalle
 * @param dir2 int, 0 = oikealle, 1 = vasemmalle
 * @param delay float, delayn aika yhdess‰ osassa
 * @param smoothness int, tarkkuusosien m‰‰r‰
 */
	// piirt‰‰ 90 asteen kaaren johonkin suuntaan
	// dir1 on mihin p‰in robotti alkaa piirt‰‰ (eteen = 0, taakse = 2, oikea = 1, vasen = 3)
	// dir2 minne kaari kaartuu (oikea = 0, vasen = 1)
	public void drawCurve(int dir1, int dir2, float delay, int smoothness) {
		double angle = 35;
		float interval = 35 / smoothness;
		
		// parillinen niin tarvitsee hidastaa oikeaa moottoria, pariton niin vasenta
		if ((dir1 + dir2) % 2 == 0) {
			for (int i = 0; i < smoothness; i++) {
				motors.setSpeed(100, 100 * (float) Math.sin(Math.toRadians(angle)));
				angle -= interval;
				switch(dir1) {
					// eteen + oikea
					case 0:
						motors.goForward();
						break;
						
					// oikea + vasen
					case 1:
						motors.goRight();
						break;
						
					// taakse + oikea
					case 2:
						motors.goBackward();
						break;
						
					// vasen + vasen
					case 3:
						motors.goLeft();
						break;
				}
				Delay.msDelay((int) delay);
				motors.stop();
			}
			for (int i = 0; i < smoothness; i++) {
				motors.setSpeed(100, 100 * (float) Math.sin(Math.toRadians(angle)));
				angle += interval;
					switch(dir1) {
					// eteen + oikea
					case 0:
						motors.goRight();
						break;
						
					// oikea + vasen
					case 1:
						motors.goForward();
						break;
						
					// taakse + oikea
					case 2:
						motors.goLeft();
						break;
						
					// vasen + vasen
					case 3:
						motors.goBackward();
						break;
				}
				Delay.msDelay((int) delay);
				motors.stop();
			}
		} else {
			for (int i = 0; i < smoothness; i++) {
				motors.setSpeed(100 * (float) Math.sin(Math.toRadians(angle)), 100);
				angle -= interval;
					switch(dir1) {
					// eteen + vasen
					case 0:
						motors.goForward();
						break;
						
					// oikea + oikea
					case 1:
						motors.goRight();
						break;
						
					// taakse + vasen
					case 2:
						motors.goBackward();
						break;
						
					// vasen + oikea
					case 3:
						motors.goLeft();
						break;
				}
				Delay.msDelay((int) delay);
				motors.stop();
			}
			for (int i = 0; i < smoothness; i++) {
				motors.setSpeed(100 * (float) Math.sin(Math.toRadians(angle)), 100);
				angle += interval;
					switch(dir1) {
					// eteen + vasen
					case 0:
						motors.goLeft();
						break;
						
					// oikea + oikea
					case 1:
						motors.goBackward();
						break;
						
					// taakse + vasen
					case 2:
						motors.goRight();
						break;
						
					// vasen + oikea
					case 3:
						motors.goForward();
						break;
				}
				Delay.msDelay((int) delay);
				motors.stop();
			}
		}
		
		motors.resetSpeed();
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