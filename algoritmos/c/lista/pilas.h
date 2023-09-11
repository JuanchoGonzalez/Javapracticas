typedef struct estructura_pila* tipo_pila;

typedef enum {CHAR, INT} tipo_elemento; //tipo enumerado

//punteros a void , puntero a un lugar de memoria
//que no se que es pero tiene algo

nodo crear_nodo (void * elemento);

tipo_pila crear (tipo_elemento tipo);

void * tope(tipo_pila pila);

int apilar (tipo_pila pila, void * elemento);

void * desapilar (tipo_pila pila);

int vaciar (tipo_pila pila);

int elementos(tipo_pila pila);





