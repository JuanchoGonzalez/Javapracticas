package lista;

public class ListaEnl<T> implements Lista<T> {
    private Nodo<T> cabeza;
    private int cantidad;
    

    private static class Nodo<T>{
        private T info;
        private Nodo<T> siguiente;

        public Nodo(T elem) {
            info = elem;
            siguiente = null;
        }
    } //termina la clase privada de nodo

    //constructor base
    public ListaEnl() {
        cabeza = null;
        cantidad = 0;
    }
    

    public boolean agregar(T elem){
       Nodo<T> nodoNuevo = new Nodo<T>(elem);
       if (cabeza == null){
        cabeza = nodoNuevo; //con esto esta xq cuando se crea un nuevo nodo apunta a null.
       }else{
        Nodo<T> actual;
        actual=cabeza;
        while (actual.siguiente != null){
            actual=actual.siguiente;
        }
        actual.siguiente=nodoNuevo;
        //nodoNuevo.siguiente=null; esto no es necesario ya que al crearse el nuevo, la referencia siguiente va a null
       }
       cantidad++; 
       return true;
    }

    public boolean agregarTodos(Lista<T> otraLista){
        int i=0;
        while (otraLista.elementos() > i){
            agregar(otraLista.obtener(i));
            i++;
        }
        return true;
        
    }
    public boolean insertar(T elem, int indice){
      if (indice < 0 || indice > cantidad) {
         throw new IndexOutOfBoundsException("Lista enlazada,Indice invalido");
      }
      Nodo<T> nuevoNodo = new Nodo<T>(elem);
      if (indice==0){
        nuevoNodo.siguiente=cabeza;
        cabeza=nuevoNodo;
      }else{
        Nodo<T> actual= cabeza;  
        for (int i=0;i < indice-1;i++){ //indice-1 xq se para en el anterior.
          actual=actual.siguiente;
        }
        nuevoNodo.siguiente=actual.siguiente;
        actual.siguiente=nuevoNodo; 
      }
      cantidad++;
      return true;
    }

    public T eliminar(int indice){
        if (indice < 0 || indice >= cantidad) {
            throw new IndexOutOfBoundsException("Lista enlazada,Indice invalido");
        }
        T eliminado = (T)obtener(indice);
        if (indice == 0){
            cabeza=cabeza.siguiente;
        }else{
            Nodo<T> actual;
            actual=cabeza;
            for (int i=0;i<indice-1;i++){
                actual=actual.siguiente;
            }
            actual.siguiente=actual.siguiente.siguiente;
        }
        cantidad--;
        return eliminado;

    }
    
    public T obtener(int indice){
        if (indice < 0 || indice >= cantidad) {
            throw new IndexOutOfBoundsException("Lista enlazada,Indice invalido");
        }
        Nodo<T> actual;
        actual=cabeza;
        for (int i=0;i < indice;i++){
            actual=actual.siguiente;
        }
        return actual.info; //nose si va T
    }
    
    public Lista<T> subLista(int desdeInd, int hastaInd){
        if ( desdeInd < 0 || hastaInd <= desdeInd || hastaInd > cantidad ) {
            throw new IndexOutOfBoundsException("imposible retornar una sublista,ya que los indices estan mal");
        }
        Lista<T> listaNueva = new ListaEnl<T>();
        for (int i=desdeInd;i<hastaInd;i++){
            listaNueva.agregar(obtener(i));
        }
        return listaNueva;
    }

    public boolean contiene(T elem){
        for (int i=0;i < elementos();i++){
            if (obtener(i).equals(elem)){
               return true; 
            }
        }
        return false;
    }

    public void vaciar(){
        cabeza.siguiente = null;
        cantidad=0;
    }

    public int elementos(){
        return cantidad;
    }

    public boolean esVacia(){
        return cabeza==null; //elementos() == 0;
    }

    public boolean repOK(){
        if (cantidad < 0){
           return false;
        }
        for (int i=0;i < elementos();i++){
            if (obtener(i) == null){
                return false;
            }
        }
        return true;
     }

     @Override
     public String toString(){ 
         if (elementos() == 0) {
             return "[]"; // Lista vacía
         }
         
         StringBuilder cadena = new StringBuilder();
         cadena.append("[");
         
         for (int i = 0; i < elementos(); i++) {
             cadena.append(String.valueOf(obtener(i)));
             if (i < elementos() - 1) {
                 cadena.append(",");
             }
         }
         cadena.append("]");
         
         return cadena.toString();
     }

    @SuppressWarnings("unchecked")
    @Override
	public boolean equals(Object otro){
        if (otro == null){
            return false;
        }
        if (this == otro){
            return true;
        }
        if (!( otro instanceof Lista)){
            return false;
        }
        ListaEnl<T> otraLista = (ListaEnl<T>) otro; 
		if (otraLista.elementos() != this.elementos() ){
			return false;
        }
        for (int i = 0; i < this.elementos(); i++) {
            if (!(this.obtener(i).equals(otraLista.obtener(i)))){
              return false;
            } 
        }

        //si paso todo quiere decir que todos son iguales de informacion
        return true;
       

    }

}