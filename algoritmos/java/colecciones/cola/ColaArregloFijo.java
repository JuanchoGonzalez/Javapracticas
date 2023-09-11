package cola;

import java.util.Collection;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
*/
public class ColaArregloFijo<T> implements Cola<T> {

	/**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;

	/**
	* Construye una nueva cola vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public ColaArregloFijo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye una nueva cola vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la cola
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	@SuppressWarnings("unchecked")
	public ColaArregloFijo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = (T[]) new Object[capacidad]; //se construye un arreglo con n elementos dado por capacidad   
	}

	/**
	* Construye una cola a partir de elementos en una colección.
	* Los elementos en la colección se encolan de izquierda a derecha.
	* La capacidad de la cola va a ser suficiente para por lo menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la cola
	*/
	public ColaArregloFijo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			encolar(e);	
		}
	}

	@Override
	public boolean esVacia() {
		return elementos() == 0;	
	}

	@Override
	public int elementos() {
		return elementos;
	}

	@Override
	public boolean encolar(T elem) {
		if (elementos() >= CAPACIDAD_POR_DEFECTO){
			return false;
		}
		arreglo[elementos]=elem;
		elementos++;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T desencolar() {
		if (esVacia()){
			throw new IllegalStateException ("La cola esta vacia, imposible desencolar");
		}
		if (elementos()==1){
          vaciar();
		}
		T desencolado;
        desencolado=(T) arreglo[0]; 
		for (int i=1;i < elementos();i++){
             arreglo[i-1]=arreglo[i];
		}
		arreglo[elementos-1] = null;
		elementos--;

		return desencolado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T primero() {
		if (esVacia()){
			throw new IllegalStateException ("La cola esta vacia, imposible mostrar el primero");
		}
		T showFirst;
        showFirst=(T) arreglo[0]; 

		return showFirst;
	}

	@Override
	public void vaciar() {
		arreglo=null;
		elementos=0;
  	}

	@Override
	public boolean repOK() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");	
	}

	@Override
	public String toString() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");	
	}

	@Override
	public boolean equals(Object other) {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");	
	}

	/**
	* Permite obtener un elemento del arreglo en un indice determinado realizando el casteo necesario.
	* @param index el indice del elemento a obtener
	*/
	@SuppressWarnings("unchecked")
   	private T elemento(int index) {
        	return (T) arreglo[index];
    	}

}
