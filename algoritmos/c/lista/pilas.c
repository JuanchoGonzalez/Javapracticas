#include <stdio.h>
#include <stdlib.h>
#include "pilas.h"

typedef struct nodo_polimorfico* nodo;

struct nodo_polimorfico{
    void * valor;
    struct nodo_polimorfico *siguiente;
};

struct estructura_pila{
    tipo_elemento tipo;
    nodo tope;
    int elementos;
};

nodo crear_nodo (void * elemento){ 
    nodo linkable = (nodo) malloc (sizeof (struct estructura_pila)); //si no hay memoria en pc te retorna linkable apunta a null
    linkable->valor=elemento; //podriamos hacer un if que vea si linkable es NULL para no romper todo en caso que
    linkable->siguiente=NULL; //tenga llena la memoria pero no es muy viable este caso

    return linkable;
}

tipo_pila crear (tipo_elemento tipo){  //lo tengo de la estructura de pila al tipo_elemento 
    tipo_pila pila = (tipo_pila) malloc (sizeof(struct estructura_pila));

    pila->tipo = tipo;
    pila->tope = NULL;
    pila->elementos = 0;

    return pila;
}

void * tope(tipo_pila pila){
    if (pila->tope == NULL) { //pila->elementos == 0 tambien andaria es decision
       printf("pila vacia nada que devolver");
       return NULL; 
    }
    return pila->tope->valor; 
} 

int apilar (tipo_pila pila , void * elemento){
    if (pila == NULL){
        printf("la pila no esta creada imposible apilar");
        return (-1);
    }
    
    nodo nuevo = crear_nodo(elemento); //es lo mismo que hacer nodo nuevo = (nodo) malloc (sizeof(estructura_lista));
    if (nuevo == NULL){ //falta memoria no se pudo crear
       printf("no se pudo crear el nodo, memoria llena");
       return (-1);
    }

    if (pila->tope == NULL){ //Pila vacia 
       pila->tope->valor=nuevo->valor;
       pila->tope->siguiente=NULL;
       // solamente hago que el elemento se copie en el campo valor del nodo tope 
    }else {
    nuevo->siguiente=pila->tope;
    pila->tope=nuevo;
     }
    pila->elementos++;
    return 0;
}

void * desapilar(tipo_pila pila){
    if (pila == NULL) { 
       printf("pila no inicializada");
       return NULL;
    }
    if (pila->tope == NULL) { //pila->elementos == 0 no valdria tambien?
       printf("pila vacia nada que desapilar");
       return NULL;
    }

    void *valor_tope = pila->tope->valor; //copio el valor antes de desapilar asi retorno este

    nodo nodoAux; //inicializo variable de tipo nodo 
    nodoAux=pila->tope; //y apunta a lo que apunta el tope
    
    pila->tope=nodoAux->siguiente; //pila->tope=pila->tope->siguiente

    free(nodoAux); //libero memoria del nodo que inicialize ya que anteriormente movi el tope
    

    pila->elementos--;

    return valor_tope; //retorno el valor que desapile
}

int vaciar(tipo_pila pila){
    if (pila == NULL) { 
       printf("pila no inicializada nada que vaciar");
       return NULL;
    }
    if (pila->tope == NULL) { //pila->elementos == 0 es lo mismo
       printf("pila vacia nada que vaciar");
       return 0;     
    }
    while(pila->tope != NULL){ 
        desapilar(pila);
        printf("desapilando\n");
    }
    // no hago esto pila->elementos=0 ya que en desapilar voy restando 1 
    return 0;
}

int elementos(tipo_pila pila){
    return pila->elementos;
} 
