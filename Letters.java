/**
 * Piirt‰‰ eri kirjaimia
 * @author anttijuj
 *
 */

public class Letters {
	private PenController penController;
	
	public Letters(PenController penController) {
		this.penController = penController;
	}

/**
 * Piirt‰‰ yhden annetun kirjaimen alkaen suunnilleen kirjaimen alaosasta tietyll‰ koolla
 * @param letter String, "a", "b", "c", ..., "x", "y", "z"
 * @param size float, kirjaimen koko (yhden liikkeen aika, hyv‰ size noin 500-1000)
 */
	
	public void drawLetter(String letter, float size) {
		float mp = 1;
		switch(letter) {
			case "a":
				penController.drawLine("eteen", size);
				penController.drawLine("oikea", size / 2);
				penController.drawLine("taakse", size);
				penController.drawLine("eteen", size / 2);
				penController.drawLine("vasen", size / 2);
				break;
				
			case "b":
				penController.drawLine("eteen", size);
				penController.drawCurve(1, 0, size * mp, 50);
				penController.drawCurve(2, 0, size * mp, 50);
				penController.drawCurve(1, 0, size * mp, 50);
				penController.drawCurve(2, 0, size * mp, 50);
				break;
				
			case "c":
				penController.drawCurve(3, 0, size * mp * 2, 50);
				penController.drawCurve(0, 0, size * mp * 2, 50);
				break;
				
			case "d":
				penController.drawLine("eteen", size);
				penController.drawCurve(1, 0, size * mp * 2, 50);
				penController.drawCurve(2, 0, size * mp * 2, 50);
				break;
				
			case "e":
				penController.drawLine("vasen", size / 2);
				penController.drawLine("eteen", size / 2);
				penController.drawLine("oikea", size / 2);
				penController.drawLine("vasen", size / 2);
				penController.drawLine("eteen", size / 2);
				penController.drawLine("oikea", size / 2);
				break;
				
			case "f":
				penController.drawLine("eteen", size / 2);
				penController.drawLine("oikea", size / 2);
				penController.drawLine("vasen", size / 2);
				penController.drawLine("eteen", size / 2);
				penController.drawLine("oikea", size / 2);
				break;
				
			case "g":
				penController.drawLine("eteen", size / 2);
				penController.drawLine("vasen", size / 4);
				penController.drawLine("oikea", size / 4);
				penController.drawLine("taakse", size / 2);
				penController.drawCurve(3, 0, size * mp * 2, 50);
				penController.drawCurve(0, 0, size * mp * 2, 50);
				break;
				
			case "h":
				penController.drawLine("eteen", size);
				penController.drawLine("taakse", size / 2);
				penController.drawLine("oikea", size / 2);
				penController.drawLine("eteen", size / 2);
				penController.drawLine("taakse", size);
				break;
				
			case "i":
				penController.drawLine("eteen", size);
				break;
				
			case "j":
				penController.drawCurve(2, 1, size * mp, 50);
				penController.drawCurve(1, 1, size * mp, 50);
				penController.drawLine("eteen", size / 1.5);
				break;
				
			case "k":
				penController.drawLine("eteen", size);
				penController.drawLine("taakse", size / 2);
				penController.drawLine("etuoikea", size / 2);
				penController.drawLine("takavasen", size / 2);
				penController.drawLine("takaoikea", size / 2);
				break;
				
			case "l":
				penController.drawLine("taakse", size);
				penController.drawLine("oikea", size / 2);
				break;
				
			case "m":
				penController.drawLine("eteen", size);
				penController.drawLine("takaoikea", size / 2);
				penController.drawLine("etuoikea", size / 2);
				penController.drawLine("taakse", size);
				break;
				
			case "n":
				penController.drawLine("eteen", size);
				penController.drawLine("takaoikea", size * 1.4);
				penController.drawLine("eteen", size);
				break;
				
			case "o":
				penController.drawCurve(3, 0, size * mp * 2, 50);
				penController.drawCurve(0, 0, size * mp * 2, 50);
				penController.drawCurve(1, 0, size * mp * 2, 50);
				penController.drawCurve(2, 0, size * mp * 2, 50);
				break;
				
			case "p":
				penController.drawLine("eteen", size);
				penController.drawCurve(1, 0, size * mp, 50);
				penController.drawCurve(2, 0, size * mp, 50);
				break;
				
			case "q":
				penController.drawCurve(3, 0, size * mp * 2, 50);
				penController.drawCurve(0, 0, size * mp * 2, 50);
				penController.drawCurve(1, 0, size * mp * 2, 50);
				penController.drawCurve(2, 0, size * mp * 2, 50);
				penController.drawLine("takaoikea", size / 4);
				break;
				
			case "r":
				penController.drawLine("eteen", size);
				penController.drawCurve(1, 0, size * mp, 50);
				penController.drawCurve(2, 0, size * mp, 50);
				penController.drawLine("takaoikea", size / 1.4);
				break;
				
			case "s":
				penController.drawCurve(3, 0, size * mp * 2, 50);
				penController.drawCurve(2, 1, size * mp * 2, 50);
				penController.drawCurve(1, 1, size * mp * 2, 50);
				penController.drawCurve(0, 1, size * mp * 2, 50);
				penController.drawCurve(3, 0, size * mp * 2, 50);
				penController.drawCurve(0, 0, size * mp * 2, 50);
				penController.drawCurve(1, 0, size * mp * 2, 50);
				break;
				
			case "t":
				penController.drawLine("eteen", size);
				penController.drawLine("vasen", size / 2);
				penController.drawLine("oikea", size);
				break;
				
			case "u":
				penController.drawLine("eteen", size / 2);
				penController.drawLine("taakse", size / 2);
				penController.drawCurve(2, 0, size * mp * 2, 50);
				penController.drawCurve(3, 0, size * mp * 2, 50);
				penController.drawLine("eteen", size / 2);
				break;
				
			case "v":
				penController.drawLine("takaoikea", size * 1.4);
				penController.drawLine("etuoikea", size * 1.4);
				break;
				
			case "w":
				penController.drawLine("takaoikea", size * 1.4);
				penController.drawLine("etuoikea", size / 1.4);
				penController.drawLine("takaoikea", size / 1.4);
				penController.drawLine("etuoikea", size * 1.4);
				break;
				
			case "x":
				penController.drawLine("takaoikea", size * 1.4);
				penController.drawLine("etuvasen", size / 1.4);
				penController.drawLine("takavasen", size / 1.4);
				penController.drawLine("etuoikea", size * 1.4);
				break;
				
			case "y":
				penController.drawLine("eteen", size / 2);
				penController.drawLine("etuvasen", size / 1.4);
				penController.drawLine("takaoikea", size / 1.4);
				penController.drawLine("etuoikea", size / 1.4);
				break;
				
			case "z":
				penController.drawLine("vasen", size / 2);
				penController.drawLine("etuoikea", size * 1.4);
				penController.drawLine("vasen", size / 2);
				break;
		}
	}
}