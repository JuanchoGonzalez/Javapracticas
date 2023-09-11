#include <stdio.h>
#include <stdlib.h>
#include "lista_enteros.h"

#define MAX 100

struct estructura_lista{
    int Arr[MAX];
    int cant; //me sirve para la cantidad y para el ultimo elemento(last)
};

tipo_lista crear(void){
    tipo_lista lista = (tipo_lista) malloc (sizeof(struct estructura_lista));
	lista->cant = -1; //tengo algun elemento

	return lista;
}

int es_vacia( tipo_lista lista ){
	return (lista->cant == 0);
}

tipo_lista agregar(tipo_lista lista, int elemento){
	if (lista->cant == MAX-1){
        printf("El arreglo esta lleno, imposible agregar");
	}else {
	   int cantMax=lista->cant-1;
       for (int i=cantMax;i >= 0; i--){
		   lista->Arr[i+1] =lista->Arr[i];
	   }
       lista->Arr[0]=elemento;
	   lista->cant++;
	}

	return lista;
}

int ins(tipo_lista lista, int elemento, int posicion){
	if (lista->cant == MAX-1) {
	   printf("la lista esta llena, imposible agregar\n");
       return (-1);
    }
	if (posicion < 0 || posicion > (lista->cant)){
		printf("posicion invalida\n");
		return (-1);
	}   

	if (posicion == lista->cant){
		lista->Arr[lista->cant]=elemento;
	}else {
		if (posicion == 0){
		agregar(lista,elemento);
	}else {
       for (int i=lista->cant-1; i >= posicion;i--){ //ver
		   lista->Arr[i+1] =lista->Arr[i];
	   }
	    lista->Arr[posicion]=elemento;
	 }
	}

	lista->cant++;
	return 0;
}

tipo_lista fin( tipo_lista lista, int elemento ){
	if (lista->cant >= MAX+1) {
	   printf("la lista esta llena, imposible agregar\n");
       return;
    }

	int i;
	i=(lista->cant)+1;  //me paro en uno mas de la cantidad para añadirlo  
	lista->Arr[i]=elemento; //guardo el valor de elemento en la posicion i del arreglo
	return lista;
}

int eliminar_comienzo( tipo_lista lista ){
	if ( es_vacia( lista ) ){
		return -1;
	}
    for (int i=0; i<lista->cant; i++ ){
       lista->Arr[i]=lista->Arr[i+1];
	}
	lista->cant = (lista->cant)-1;

	return 0;
}

int eliminar(tipo_lista lista, int posicion){
	if (posicion < 0 || posicion > lista->cant ){
		return -1;
	};

	if ( es_vacia( lista ) ){
		return -1;
	}

	if ( !posicion ){
		eliminar_comienzo( lista );

		return 0;
	}

	for ( int i = posicion; i < lista->cant; i++ ){
		lista->Arr[i]=lista->Arr[i+1];
	}

	lista->cant = (lista->cant)-1;

	return 0;
}


int obtener( tipo_lista lista, int posicion ){
	return lista->Arr[posicion];
}


tipo_lista reversa( tipo_lista lista ){
	int aux=lista->cant;
	for ( int i = 0; i < (lista->cant)/2 ; i++ ){
		lista->Arr[i]=lista->Arr[aux];
		aux--;
	};

	return lista;
}

tipo_lista concat( tipo_lista ini, tipo_lista cola ){

	for ( int i = 0; i < ini->cant ; i++ ){
		fin(ini,obtener(ini, i ));
	};

	for ( int i = 0; i < cola->cant ; i++ ){
		fin(cola, obtener( cola, i ));
	};
   /*
   tipo_lista fin( tipo_lista lista, int elemento ){
	ins( lista, elemento, lista->elementos ); 
    */
	//return lista;
}   
	//return tipo_lista;

tipo_lista sub( tipo_lista lista, int c, int f ){
	for ( int i = c; i < f ; i++ ){
		fin( lista, obtener( lista, i ));
	};

	return lista;
}

tipo_lista copia( tipo_lista lista ){
	return sub( lista, 0, lista->cant );
}

int cabeza( tipo_lista lista ){
	return (lista->Arr[0]);
}

tipo_lista cola( tipo_lista lista ){
	return sub(lista, 1, lista->cant );
}

void mostrar( tipo_lista lista ){
	printf( "[ " );

	for ( int i = 0; i < lista->cant; i++ ){
		printf( "%i ", obtener( lista, i ) );
	};

	printf( "]" );
}

int reemplazar(tipo_lista lista, int e, int posicion){
	  int valorAnterior;
      
	  lista->Arr[posicion]=e;
      if ( (es_vacia(lista) != 0)) {
		return -1;
	  };
       
      if (posicion < 0  || posicion > lista->cant){
		return -1;
	  };

      valorAnterior=lista->Arr[posicion];
	  lista->Arr[posicion]=e;
	  return valorAnterior;
	
	  }

tipo_lista intercambiar(tipo_lista lista, int pos1,int pos2){
	  int aux;

      if (pos1 == pos2){
		return lista;
	  }

	  if ( (es_vacia(lista) != 0)) {
	       return ;
	  };

      if ((pos1 > (lista->cant-1) || pos1 < 0) || (pos2 > (lista->cant-1) || pos2 < 0)){
         //return NULL;
	  }
     
	aux=lista->Arr[pos1];
	lista->Arr[pos2]=lista->Arr[pos1];; 
    lista->Arr[pos1]=aux;
 
	return lista;
}






