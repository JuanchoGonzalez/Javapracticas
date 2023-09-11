package lista;

public class ListaArr<T> implements Lista<T>{
    private Object[] info;
    private int cantidad;
    private static final int CAPACIDAD = 50;
    

    // constructor
    @SuppressWarnings("unchecked")
    public ListaArr(){
       info = (T[]) new Object[CAPACIDAD];  // cuando creo le digo de que creo con T y no necesito nada mas 
       cantidad = 0;                        // en cambio con new Object[CAPACIDAD]; tendria que castear para que ande
    }

    public boolean agregar(T elem){
        if (elementos() >= CAPACIDAD ) {
          return false;  
        }
        info[cantidad]=elem;
        cantidad++;
        return true;
    }

    public boolean agregarTodos(Lista<T> otraLista){
        if ((CAPACIDAD - elementos()) < otraLista.elementos()){
            return false;
        }
        for (int i=0; i < otraLista.elementos(); i++){
           agregar(otraLista.obtener(i));
        }
        return true;
    }

    public boolean insertar(T elem,int indice){
        if (indice < 0 || indice > elementos()) {
            throw new IndexOutOfBoundsException("Arreglos,Indice invalido");
        }
        if (elementos() == CAPACIDAD){
            throw new IndexOutOfBoundsException("Arreglos,lista llena");
        }
        if (indice == elementos()){
           agregar(elem);
        }else{
           for (int i=(elementos()-1);i>=indice;i--){
              info[i+1]=info[i];
           }     
           info[indice]=elem;
           cantidad++;
        }
        return true;
        
    }
    
    @SuppressWarnings("unchecked")
    public T eliminar(int indice){
        T eliminado = (T)info[indice];
        if (indice < 0 || indice >= cantidad) {
            throw new IndexOutOfBoundsException("Arreglos,Indice invalido");
        }
          for (int i=indice+1;i<=elementos();i++){
             info[i-1]=info[i];
          }
        info[cantidad-1] = null;
        cantidad--;
        return eliminado;
    }

    @SuppressWarnings("unchecked")
    public T obtener(int indice){
        if (indice < 0 || indice >= elementos()) {
            throw new IndexOutOfBoundsException("Arreglos,Indice invalido");
        }
        return (T) info[indice]; //le digo que info[indice] debe ser de tipo T que luego veo cual es
    }

    
    public Lista<T> subLista(int desdeInd, int hastaInd){
        if ( desdeInd < 0 || hastaInd <= desdeInd || hastaInd > cantidad ) {
           throw new IndexOutOfBoundsException("imposible retornar una sublista,ya que los indices estan mal");
        }
        Lista<T> listaNueva = new ListaArr<T>();
        for (int i=desdeInd;i<hastaInd;i++){
            listaNueva.agregar(obtener(i));
        }
        return listaNueva;
    }
    
    public boolean contiene(T elem){
        if (elem == null && info[0] == null){
            return true;
        }
        for (int i=0;i < elementos();i++){
           if (elem.equals(info[i])){
              return true;
           }

        }
        return false;
    }
    
    public void vaciar(){
       info=null;
       cantidad=0;
    }

    public int elementos(){
        return cantidad;
    }

    public boolean esVacia(){
       return elementos()==0;
    }

    public boolean repOK(){
        if (CAPACIDAD+1<cantidad || cantidad<0){
            return false;
        }
        /* 
        for (int i=cantidad;i < CAPACIDAD;i++){
           if (obtener(i) /= null){
             
           }
        }
        */
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
            cadena.append(String.valueOf(info[i]));
            if (i < elementos() - 1) {
                cadena.append(", ");
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
      if (otro == this){
        return true;
      }
      if (!(otro instanceof Lista))
			return false;
		ListaArr<T> otraLista = (ListaArr<T>) otro; 
		if (otraLista.elementos() != elementos() ){
			return false;
        }
        for (int i = 0; i < elementos(); i++) {
            if (!info[i].equals(otraLista.info[i])){
              return false;    
            }
        }
        //si paso todo quiere decir que todos son iguales de informacion
        return true;
	}

}




