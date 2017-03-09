import java.util.Comparator;

public class OrdenPeso implements Comparator<Usuario> {

	@Override
	public int compare(Usuario a, Usuario b) {
		return a.getPeso() - b.getPeso();
	}

}
