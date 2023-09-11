package lista.main;

import lista.ListaArr;
import lista.Lista;
import lista.ListaEnl;

public class Main {

    public static void main(String[] args){
       Lista<Integer> listaNew = new ListaArr<>();
       
       Lista<String> listaNew2 = new ListaEnl<>();

       listaNew.agregar(4);
       Lista<Integer> listaaAgregar = new ListaArr<>();

       listaaAgregar.agregar(5);
       listaaAgregar.agregar(6);
       listaNew.agregarTodos(listaaAgregar);
       System.out.println("Lista completa: " + listaNew);

       listaNew.insertar(3,2);

       System.out.println("Lista completa: " + listaNew);
       
       listaNew.eliminar(0);

       System.out.println("Lista completa: " + listaNew);

       System.out.println("Obtencion de un elemento: " + listaNew.obtener(1));

       System.out.println("SubLista:" + listaNew.subLista(0, 2));
       
       
       if (listaNew.contiene(4)){
        System.out.println("tiene el 3");
       }
       
       System.out.println("" + listaNew.elementos());
       System.out.println("" + listaNew);
       if (listaNew.esVacia()){
        System.out.println("esta vacia la lista");
       } else{
        System.out.println("tiene al menos un elemento");
       }

       listaNew.vaciar();
 
       System.out.println("" + listaNew.elementos());
       System.out.println("" + listaNew);
       if (listaNew.esVacia()){
        System.out.println("esta vacia la lista");
       } else {
        System.out.println("tiene al menos un elemento\n");
       }
       
       listaNew.agregar(4);
       System.out.println(""+ listaNew.obtener(0));
       listaNew2.agregar("first");
       System.out.println("tiene " + listaNew2.elementos() + " elementos");

       System.out.println("y la lista enlazada es: " + listaNew2);

       listaNew2.agregar("second");

       System.out.println("lista completa: " + listaNew2);

       Lista<String> listaaAgregar2 = new ListaEnl<>();

       listaaAgregar2.agregar("tercero");
       listaaAgregar2.agregar("cuarto");

       listaNew2.agregarTodos(listaaAgregar2);
       
       System.out.println("lista completa: " + listaNew2);
       

       System.out.println("obtencion del indice 3: " + listaNew2.obtener(3));

       listaNew2.insertar("cuarto2.0", 4);

       System.out.println("lista completa: " + listaNew2);

       listaNew2.eliminar(3);

       System.out.println("lista completa sin cuarto: " + listaNew2);
       
       boolean contieneElem;
       contieneElem=listaNew2.contiene("first");
       
       System.out.println("contiene first? :" + contieneElem);
    }
}
