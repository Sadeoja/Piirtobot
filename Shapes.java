/**
 * T‰ll‰ piirret‰‰n erilaisia kuvioita
 * @author anttijuj
 * Kaikki kuviot t‰nne!
 */

public class Shapes {
	private PenController penController;
	
	public Shapes(PenController penController) {
		this.penController = penController;
	}

/**
 * Piirt‰‰ kolmion tietyll‰ koolla
 * @param size int delayn aika liikkeiss‰
 */
	
	// piirt‰‰ kolmion
	public void kolmio(int size) {
		penController.drawLine("oikea", size);
		penController.drawLine("eteen", size);
		penController.drawLine("takavasen", size * 2);
	}
	
/**
 * Piirt‰‰ neliˆn tietyll‰ koolla
 * @param size int delayn aika liikkeiss‰
 */
	
	// piirt‰‰ neli√∂n
	public void nelio(int size) { 
		penController.drawLine("vasen", size);
		penController.drawLine("eteen", size);
		penController.drawLine("oikea", size);
		penController.drawLine("taakse", size);
	}
	
/**
 * Piirt‰‰ salmiakki-kuvion tietyll‰ koolla
 * @param size int delayn aika liikkeiss‰
 */
	// piirt‰‰ salmiakin
	public void salmiakki(int size) {
		penController.drawLine("etuvasen", size);
		penController.drawLine("etuoikea", size);
		penController.drawLine("takaoikea", size);
		penController.drawLine("takavasen", size);
	}
	
/**
 * Piirt‰‰ ympyr‰n tietyll‰ tarkkuudella ja koolla
 * @param radius int delayn aika yhdell‰ tarkkuusosalla
 * @param smoothness int ympyr‰n tarkkuus
 */
	// piirt‰ ympyr‰n
	public void ympyra(int radius, int smoothness) {
		penController.drawCurve(0, 0, radius, smoothness);
		penController.drawCurve(1, 0, radius, smoothness);
		penController.drawCurve(2, 0, radius, smoothness);
		penController.drawCurve(3, 0, radius, smoothness);
	}
}