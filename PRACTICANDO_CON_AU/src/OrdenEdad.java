import java.util.Comparator;

public class OrdenEdad implements Comparator<Usuario> {

	@Override
	public int compare(Usuario a, Usuario b) {
		return a.getEdad() - b.getEdad();
	}

}
