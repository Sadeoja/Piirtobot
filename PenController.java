import lejos.utility.Delay;

/**
 * Kynän ohjaus moottoreiden avulla 
 * @author anttijuj
 * Tällä tiedostolla ohjataan kynää käyttämällä Motors.java:n funktioita.
 * Laita kaikki liikkeisiin liittyvät asiat tänne.
 */

public class PenController {
	private int x, y;
	private Motors motors;

	public PenController(Motors motors) {
		x = 0;
		y = 0;
		this.motors = motors;
	}

	void move(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public void drawLineXY(float dx, float dy) {
		int factor = 90;
		int intx = Math.round(dx * factor);
		int inty = Math.round(dy * factor);

		int speed = 300;
		int lenght = (int) (100 * Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));

		motors.syncStart();

		// hopeless
		if (dx > 0 && dy > 0) {
			if (dx == dy) {
				motors.leftMotor.forward();
			}

		} else if (dx == 0 && dy > 0) {
			motors.goForward();
		} else if (dx > 0 && dy == 0) {
			motors.goRight();
		} else if (dx < 0 && dy > 0 && -dx == dy) {
			motors.rightMotor.backward();
		} else if (dx < 0 && dy == 0) {
			motors.goLeft();
		} else if (dx > 0 && dy < 0 && dx == -dy) {
			motors.rightMotor.forward();
		} else if (dx == 0 && dy < 0) {
			motors.goBackward();
		} else if (dx < 0 && dy < 0 && dx == dy) {
			motors.leftMotor.backward();
		}

		motors.syncEnd();

		Delay.msDelay(lenght);

		motors.stopFlt();
		move(intx, inty);
	}

	// public void drawLineXY(float x, float y){
	// int factor = 90;
	// int intx = Math.round(x * factor);
	// int inty = Math.round(y * factor);
	// rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
	// rightMotor.startSynchronization();
	// leftMotor.startSynchronization();
	//
	// // hopeless
	// if (x > 0 && y > 0){
	// rightMotor.rotate(intx - inty);
	// leftMotor.rotate(intx + inty);
	// } else if (x == 0 && y > 0){
	// rightMotor.rotate(-inty);
	// leftMotor.rotate(inty);
	// } else if (x > 0 && y == 0){
	// rightMotor.rotate(intx);
	// leftMotor.rotate(intx);
	// } else if (x < 0 && y > 0){
	// rightMotor.rotate(intx - inty);
	// leftMotor.rotate(intx + inty);
	// } else if (x < 0 && y == 0){
	// rightMotor.rotate(intx);
	// leftMotor.rotate(intx);
	// } else if (x > 0 && y < 0){
	// rightMotor.rotate(-inty + intx);
	// leftMotor.rotate(inty + intx);
	// } else if (x == 0 && y < 0){
	// rightMotor.rotate(-inty);
	// leftMotor.rotate(inty);
	// } else if (x < 0 && y < 0){
	// rightMotor.rotate(-inty + intx);
	// leftMotor.rotate(inty + intx);
	// }
	//
	// rightMotor.endSynchronization();
	// leftMotor.endSynchronization();
	// rightMotor.waitComplete();
	// leftMotor.waitComplete();
	// }

	// public void drawLineXY(double x, double y){
	// int factor = 90;
	// int intx = (int) Math.round(x * factor);
	// int inty = (int) Math.round(y * factor);
	// rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});
	// rightMotor.startSynchronization();
	// leftMotor.startSynchronization();
	//
	// // hopeless
	// if (x > 0 && y > 0){
	// rightMotor.rotate(intx - inty);
	// leftMotor.rotate(intx + inty);
	// } else if (x == 0 && y > 0){
	// rightMotor.rotate(-inty);
	// leftMotor.rotate(inty);
	// } else if (x > 0 && y == 0){
	// rightMotor.rotate(intx);
	// leftMotor.rotate(intx);
	// } else if (x < 0 && y > 0){
	// rightMotor.rotate(intx - inty);
	// leftMotor.rotate(intx + inty);
	// } else if (x < 0 && y == 0){
	// rightMotor.rotate(intx);
	// leftMotor.rotate(intx);
	// } else if (x > 0 && y < 0){
	// rightMotor.rotate(-inty + intx);
	// leftMotor.rotate(inty + intx);
	// } else if (x == 0 && y < 0){
	// rightMotor.rotate(-inty);
	// leftMotor.rotate(inty);
	// } else if (x < 0 && y < 0){
	// rightMotor.rotate(-inty + intx);
	// leftMotor.rotate(inty + intx);
	// }
	//
	// rightMotor.endSynchronization();
	// leftMotor.endSynchronization();
	// rightMotor.waitComplete();
	// leftMotor.waitComplete();
	// }
}
