#include <stdio.h>
#include <stdlib.h>
#include "lista_enteros.h"	

/* ejemplo para manipular listas */


int main( int argc, char * argv[] )
{
  
  tipo_lista lista = crear( );
	
	ins( lista, 1, 0 );
	ins( lista, 2, 1 );
	ins( lista, 3, 2 );
	ins( lista, 4, 3 );
	
	// lista = [ 1, 2, 3, 4 ]
	
	printf( "lista = " );
	mostrar( lista );
	printf("\n");
	
	// reversa( lista ) = [ 4, 3, 2, 1 ]
	
	printf( "reversa( lista ) = " );
	mostrar( reversa( lista ) );
	printf("\n");
	
	tipo_lista xs = concat( lista, reversa( lista ) );
	
	// xs = [ 1, 2, 3, 4, 4, 3, 2, 1 ]
	
	printf( "concatenamos la lista y su reversa = " );
	mostrar( xs );
	printf("\n");

	printf( "Insertar en la lista original el valor 0 en la posicion 1 =" );
	
	ins( lista, 0, 1 );
	
	// lista = [ 1, 0, 2, 3, 4 ]
	
	mostrar( lista );
	printf("\n");
	
	printf("reemplazamos por el valor 4 en la posicion 1 \n");
	int valorAnt = reemplazar(lista,4,0);
    printf("El valor en la posicion 1 antes era: %d\n",valorAnt);
	printf("Lista luego de reemplazar ");
	mostrar(lista);
    printf("\n");  

    printf("Intercambio las posiciones 1 con 4 \n");
    intercambiar(lista,1,6);
	mostrar(lista);
	printf("\n");

  return 0;
}
