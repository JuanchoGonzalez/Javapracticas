package main;

import datos.Libro;
import catalogo.Catalogo;

/**
* La clase {@code MainCatalogo} implementa una aplicación simple para mostrar el uso de {@code Catalogo} junto con {@code Libro}.
* Esta clase no usa parámetros, el comportamiento está completamente "hardcodeado" requiriendo modificiar y recompilar para hacer pruebas.
* @see catalogo.Catalogo
* @see datos.Libro
* @version 1.0
*/
public class MainCatalogo {

	/**
	* Experimenta con {@code Catalogo}, agregar libros, buscar, y mostrar el {@code Catalogo}.
	* @param args : arguments for this main method, not used in this implementation.
	*/
	public static void main(String[] args) {
		Libro libro1 = new Libro("Isaac Asimov", "The Caves of Steel", 42);
		Libro libro2 = new Libro("Isaac Asimov", "The Naked Sun", 47);
		Libro libro3 = new Libro("roberto", "aventura", 140);
		Libro libro4 = new Libro("leandro", "fas", 22);
		Libro libro5 = new Libro("matias", "fasfsa", 412);
		Catalogo catalogo = new Catalogo(10);

		catalogo.agregarLibro(libro1);
		catalogo.agregarLibro(libro3);
    
		//buscando libro
        Libro libroEncontrado = catalogo.buscarPorTitulo("aventura");

        // Mostrar el resultado de la búsqueda
        if (libroEncontrado != null) {
            System.out.println("Libro encontrado!\n" + libroEncontrado);
        } else {
            System.out.println("Libro no encontrado por el título en este catalogo");
        }
		//anda mal xq no tengo el metodo toString() aun implementado
		System.out.println("Catalogo:\n" + catalogo);
	}

}
