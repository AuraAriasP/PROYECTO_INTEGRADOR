import processing.core.PApplet;

public class MainApp extends PApplet {

	private Logica log;

	public static void main(String[] args) {
		PApplet.main("MainApp");
	}

	@Override
	public void settings() {
		size(800, 600);
	}

	@Override
	public void setup() {
		log = new Logica(this);
	}

	@Override
	public void draw() {
		background(45);
		log.pintar();
	}

	@Override
	public void keyPressed() {
		log.teclas();
	}

}
