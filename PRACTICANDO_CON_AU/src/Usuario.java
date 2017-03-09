import processing.core.PApplet;

public class Usuario implements Comparable<Usuario> {

	private PApplet app;
	private String cedula, nombre, apellido;
	private int r, g, b, edad, peso, x, y, suma;

	public Usuario(PApplet app, String nombre, String apellido, String cedula, int edad, int peso, int r, int g,
			int b) {
		this.app = app;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
		this.peso = peso;
		this.r = r;
		this.g = g;
		this.b = b;
		System.out.println(
				nombre + " " + apellido + " " + cedula + " " + edad + " " + peso + " " + r + " " + g + " " + b);
		suma = r + g + b;
	}

	public void pintar(int x, int y) {
		this.x = x;
		this.y = y;
		app.fill(r, g, b);
		app.text(nombre + " " + apellido + " Suma: " + suma + " Edad: " + edad + " Peso: " + peso, x, y);
		app.noFill();
	}
	
	

	@Override
	public int compareTo(Usuario o) {
		if (this.nombre.equals(o.getNombre())) {
			return 0;
		}
		return this.nombre.compareTo(o.getNombre());
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
