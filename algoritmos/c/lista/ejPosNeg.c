#include <stdio.h>
#include <stdlib.h>
#include "ejPosNeg.h"	

#define MAX 20

struct estructura_lista{
    int Arr[MAX];
    int cant; //me sirve para la cantidad y para el ultimo elemento(last)
};

int posMayNeg (tipo_lista a){
    int pos,neg=0;
    for (int i=0;i < a->cant;i++){
        if (a->Arr[i] > 0) {
            pos++;
        }else{
            neg++;
        }
    }
    if (pos > neg) {
        printf("hay mas positivos en el arreglo que negativos \n");
        return 0;
    }else {
        printf("hay mas negativos o iguales en el arreglo \n");
        return 1;
    }
}