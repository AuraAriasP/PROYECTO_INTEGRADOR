import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import processing.core.PApplet;

public class Logica {

	private PApplet app;
	private ArrayList<Usuario> user;
	private LinkedList<Usuario> ordenAlfabetico;
	private TreeSet<Usuario> ordenEdad;
	private TreeSet<Usuario> ordenPeso;

	public Logica(PApplet app) {
		this.app = app;
		user = new ArrayList<>();
		ordenAlfabetico = new LinkedList<>();
		ordenEdad = new TreeSet<>(new OrdenEdad());
		ordenPeso = new TreeSet<>(new OrdenPeso());
		cargarTxt();
	}

	public void cargarTxt() {
		String[] nombres = app.loadStrings("../data/nombres.txt");
		String[] info = app.loadStrings("../data/info.txt");
		String[] tono = app.loadStrings("../data/tono.txt");
		for (int i = 0; i < nombres.length; i++) {
			String[] datosU = nombres[i].split(":");
			String[] datosN = info[i].split("/");
			String[] datosT = tono[i].split("/");
			String cedula = datosN[0];
			int edad = Integer.parseInt(datosN[1]);
			int peso = Integer.parseInt(datosN[2]);
			int r = Integer.parseInt(datosT[0]);
			int g = Integer.parseInt(datosT[1]);
			int b = Integer.parseInt(datosT[2]);
			user.add(new Usuario(app, datosU[0], datosU[1], cedula, edad, peso, r, g, b));
		}
	}

	public void pintar() {
		for (int i = 0; i < user.size(); i++) {
			user.get(i).pintar(50, 100 + (i * 30));
		}
		Iterator<Usuario> itSuma = ordenAlfabetico.iterator();
		int i = 0;
		while (itSuma.hasNext()) {
			Usuario temp = itSuma.next();
			temp.pintar(400, 100 + (i * 30));
			i++;
		}
		Iterator<Usuario> itEdad = ordenEdad.iterator();
		int j = 0;
		while (itEdad.hasNext()) {
			Usuario temp = itEdad.next();
			temp.pintar(400, 100 + (j * 30));
			j++;
		}
		Iterator<Usuario> itPeso = ordenPeso.iterator();
		int a = 0;
		while (itPeso.hasNext()) {
			Usuario temp = itPeso.next();
			temp.pintar(400, 100 + (a * 30));
			a++;
		}
	}

	public void teclas() {
		switch (app.key) {
		case '1':
			if (ordenAlfabetico.isEmpty()) {
				ordenEdad.clear();
				ordenPeso.clear();
				ordenAlfabetico.addAll(user);
				Collections.sort(ordenAlfabetico);
			}
			break;
		case '2':
			if (ordenEdad.isEmpty()) {
				ordenAlfabetico.clear();
				ordenPeso.clear();
				ordenEdad.addAll(user);
			}
			break;
		case '3':
			if (ordenPeso.isEmpty()) {
				ordenAlfabetico.clear();
				ordenEdad.clear();
				ordenPeso.addAll(user);
			}
			break;
		}
	}

}
