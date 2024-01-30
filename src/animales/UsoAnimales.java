package animales;

public class UsoAnimales {

	public static void main(String[] args) {
		Mamifero perro = new Mamifero("perro", 15, true);
		Insecto hormiga = new Insecto("hormiga", 1, false, true, "oso hormiguero");
		System.out.println("El animal: " + hormiga.getNombre() + " tiene alas?: " + hormiga.isAlas());
		System.out.println(hormiga.getNombre() + " tiene de enemigo a: " + hormiga.getEnemigo().getNombre());
	}

}
