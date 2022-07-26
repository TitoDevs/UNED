/****************************************************
* Programa: Secuencia
*
* Descripción:
*   Programa que lee una serie de números enteros,
*   los almacena en una secuencia enlazada, en orden,
*   y los imprime. Después se pueden borrar de
*   manera efectiva.
****************************************************/

#include <stdio.h>

typedef struct TipoNodo{
  int valor;
  TipoNodo * siguiente;
};
typedef TipoNodo * TipoSecuencia;
typedef TipoNodo * TipoPuntNodo;

int main(){
  int numero;
  TipoSecuencia secuencia;
  TipoPuntNodo cursor, anterior, nuevo;

  printf("Datos leidos:\n");
  secuencia = NULL;
  scanf("%d", &numero);

  while(numero != 0){
    printf(" %d", numero);
    cursor = secuencia;
    anterior = NULL;

    while(cursor != NULL && cursor->valor < numero){
      anterior = cursor;
      cursor = cursor->siguiente;
    }

    nuevo = new TipoNodo;
    nuevo->valor = numero;

    if(anterior == NULL){

      nuevo->siguiente = secuencia;
      secuencia = nuevo;
    }else{
      nuevo->siguiente = anterior->siguiente;
      anterior->siguiente = nuevo;
    }
    scanf("%d", &numero);
  }
  printf("\n");

  printf("\nDatos ordenados\n");
  cursor = secuencia;
  while (cursor != NULL){
    printf("%5d", cursor->valor);
    cursor = cursor->siguiente;
  }
  printf("\n");

  printf("\nDatos a borrar:\n");
  scanf("%d", &numero);

  while(numero != 0){
    cursor = secuencia;
    anterior = NULL;
    while(cursor != NULL && cursor->valor != numero){
      anterior = cursor;
      cursor = cursor->siguiente;
    }

    if(cursor != NULL){
      if(anterior != NULL){
        anterior->siguiente = cursor->siguiente;
      }else{
        secuencia = cursor->siguiente;
      };
      delete cursor;
      printf(" %d borrado\n", numero);
      cursor = secuencia;
      while(cursor != NULL){
        printf("%5d", cursor->valor);
        cursor = cursor->siguiente;
      }
      printf("\n");
    }else{
      printf(" %d no encontrado\n", numero);
    }
    scanf("%d", &numero);
  }
}
