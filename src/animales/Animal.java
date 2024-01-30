package animales;

public class Animal {
	// atributos
	private String nombre;
	private int tpoVida;

	// constructor con dos parámetros
	protected Animal(String nombre, int tpoVida) {
		super();
		this.nombre = nombre;
		if ((tpoVida > 0) && (tpoVida < 150)) {
			this.tpoVida = tpoVida;
		} else {
			this.tpoVida = 0;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTpoVida() {
		return tpoVida;
	}

	public void setTpoVida(int tpoVida) {
		this.tpoVida = tpoVida;
	}

}
