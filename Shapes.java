public class Shapes {
	private PenController penController;
	
	public Shapes(PenController penController) {
		this.penController = penController;
	}
	
	// piirtää kolmion
	static void kolmio(int size) {
		penController.drawLine("oikea", size);
		penController.drawLine("eteen", size);
		penController.drawLine("takavasen", size * 2);
	}
	
	// piirtää neliön
	static void nelio(int size) { 
		penController.drawLine("vasen", size);
		penController.drawLine("eteen", size);
		penController.drawLine("oikea", size);
		penController.drawLine("taakse", size);
	}
	
	// piirtää salmiakin
	static void salmiakki(int size) {
		penController.drawLine("etuvasen", size);
		penController.drawLine("etuoikea", size);
		penController.drawLine("takaoikea", size);
		penController.drawLine("takavasen", size);
	}
	
	// piirtää ympyrän
	static void ympyra(int radius, int smoothness) {
		penController.drawCurve(0, 0, radius, smoothness);
		penController.drawCurve(1, 0, radius, smoothness);
		penController.drawCurve(2, 0, radius, smoothness);
		penController.drawCurve(3, 0, radius, smoothness);
	}
}