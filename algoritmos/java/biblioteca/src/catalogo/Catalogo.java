package catalogo;

import datos.Libro;

/**
* La clase {@code Catalogo} representa un catálogo de libros ({@code Libro}) implementado sobre un arreglo.
* Los métodos principales ofrecidos por esta clase son:
* <ul>
* 	<li>Agregar un nuevo Libro al catálogo.</li>
*	<li>Buscar un Libro por su título</li>
* </ul>
* Esta implementación no realiza ningún tipo de verificación, específicamente:
* <ul>
*	<li>No verifica que un Libro agregado sea no nulo ({@code null}).</li>
*	<li>No verifica que la capacidad para crear un nuevo Catalogo sea mayor o igual a {@code 1}.</li>
* </ul>
* @see Libro
* @version 1.0
*/
public class Catalogo {

	/**
	* La capacidad por defecto de un nuevo Catalogo.
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 50;

	//el arreglo interno de libros.
	private Libro[] libros;
	//la cantidad actual de libros almacenados.
	private int nroLibros;
	
	/**
	* Construye un nuevo {@code Catalogo} usando una capacidad de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public Catalogo() {
		this(CAPACIDAD_POR_DEFECTO);
	}
	
	/**
	* Construye un nuevo {@code Catalogo} con una capacidad dada.
	* @param capacidad : la capacidad del nuevo {@code Catalogo}.
	*/
	public Catalogo(int capacidad) {
		libros = new Libro[capacidad];
		nroLibros = 0;
	}
	
	
	/**
	* Retorna {@code true} si este {@code Catalogo} no tiene más capacidad para almacenar libros.
	* @return {@code true} sii no hay capacidad disponible.
	*/
	public boolean estaLleno() {
		return (nroLibros == CAPACIDAD_POR_DEFECTO+1); //=> por las dudas para no errarle aunque no
		//throw new UnsupportedOperationException("Debe implementar este método");
	}
	
	/**
	* Agrega un nuevo {@code Libro} a este {@code Catalogo} si el mismo no se encuentra lleno.
	* @param libro : el nuevo {@code Libro} a agregar.
	* @return {@code true} sii el {@code Libro} pudo ser agregado, es decir, {@code estaLleno()} retornó {@code false} previamente a llamar a este método.
	* @see #estaLleno()
	*/
	public boolean agregarLibro(Libro libro) {
		if (estaLleno()){
           return false;   
		}
        Libro libroAg = (Libro) libro;
        libros[nroLibros]=libroAg;
		nroLibros++;
		return true;
	}
	
	/**
	* Busca un {@code Libro} de acuerdo a un título dado.
	* @param titulo : el título del {@code Libro} a buscar.
	* @return un libro {@code l} que pertenece a este {@code Catalogo} sii {@code l.titulo().equals(titulo)}, {@code null} en caso contrario.
	*/
	public Libro buscarPorTitulo(String titulo) {
       for (int i=0;i<nroLibros;i++){
          if (libros[i].titulo().equals(titulo)) {
             return libros[i];    
		  }	 
	   }
	   	return null;
	}
	
	/**
	 * libros es el nombre del atributo que hace referencia al arreglo 
	 * nroLibros es el nombre del atributo que hace referencia a la cantidad de libros actuales que hay en el catalogo
	 * el toString() hace mas bonito "syntactic sugar" para cuando querramos mostrar la clase catalogo
	 */
    /*
	@Override
	public String toString() {
		Catalogo mostCatalogo = new Catalogo(); //instanciacion de una clase=creacion de objeto mostLibros
		for (int i=0;i<nroLibros;i++){
			mostCatalogo.libros[i].toString(); /*muestra el catalogo en base a recorrer el arreglo
			                                     de el metodo toString definido ya en la clase Libro
											   */
											  /*
											}

	    System.out.println("El catalogo esta formado por: ");
        return mostCatalogo.toString();
	}
    */
}
