import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

/**
 * Moottorin ohjaus
 * @author ?
 * Tässä tiedostossa voidaan ohjata moottoreita.
 */


public class Motors {
	private int defaultSpeed = 300;
	private int angleLimit = 1600;
	private int lifterAngle = 45;
	
	public EV3LargeRegulatedMotor rightMotor;
	public EV3LargeRegulatedMotor leftMotor;
	public EV3MediumRegulatedMotor lifterMotor;
	
	public Motors(){
		rightMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		leftMotor = new EV3LargeRegulatedMotor(MotorPort.C);
		lifterMotor = new EV3MediumRegulatedMotor(MotorPort.B);
		rightMotor.setSpeed(defaultSpeed);
		leftMotor.setSpeed(defaultSpeed);
		lifterMotor.setSpeed(defaultSpeed);
	}
	
	/**
	 * Tämä metodi tarkistaa ollaanko liian lähellä rajoja
	 * @return
	 */
	
	public boolean checkPosition() {
		// jos ollaan liian lähellä rajaa
		if (Math.abs(leftMotor.getPosition()) + Math.abs(rightMotor.getPosition()) >= angleLimit)
			return false;
		} else {
			return true;
		}
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
	
	public void goFrontLeft() {
		syncStart();
		rightMotor.backward();
		syncEnd();
	}
	
	public void goFrontRight() {
		syncStart();
		leftMotor.forward();
		syncEnd();
	}
	
	public void goBackLeft() {
		syncStart();
		leftMotor.backward();
		syncEnd();
	}
	
	public void goBackRight() {
		syncStart();
		rightMotor.forward();
		syncEnd();
	}
	
	public void rotate(int leftAngle, int rightAngle) {
		syncStart();
		leftMotor.rotate(leftAngle);
		rightMotor.rotate(rightAngle);
		syncEnd();
	}
	
	public void lift() {
		lifterMotor.rotateTo(lifterAngle);
	}
	
	public void lower() {
		lifterMotor.rotateTo(0);
	}
	
	public void stopFlt(){
		syncStart();
		leftMotor.flt();
		rightMotor.flt();
		syncEnd();
	}
	
	public void stop() {
		syncStart();
		leftMotor.stop(true);
		rightMotor.stop(true);
		syncEnd();
	}
	
	public void setSpeed(float leftSpeed, float rightSpeed) {
		syncStart();
		leftMotor.setSpeed((int) ((leftSpeed / 100.0) * defaultSpeed));
		rightMotor.setSpeed((int) ((rightSpeed / 100.0) * defaultSpeed));
		syncEnd();
	}
	
	public void resetSpeed() {
		syncStart();
		leftMotor.setSpeed(defaultSpeed);
		rightMotor.setSpeed(defaultSpeed);
		syncEnd();
	}
	
	public void resetPosition() {
		syncStart();
		leftMotor.rotateTo(0);
		rightMotor.rotateTo(0);
		syncEnd();
		while(leftMotor.isMoving() || rightMotor.isMoving()) {
			// wait
		}
	}
	
	/**
	 * Tämä metodi palauttaa robotin nollakohtaan jos liian lähellä rajoja
	 * @return
	 */
	
	public void restartCheck() {
		if (!checkPosition()) {
			resetPosition();
		}
	}
	
	public void close(){
		rightMotor.close();
		leftMotor.close();
		lifterMotor.close();
	}
}