/****************************************************
* Programa: Fibonacci
*
* Descripción:
*   Este programa imprime el todos los términos
*   de la serie de Fibonacci dentro del rango de
*   valores positivos del tipo int: (1 .. INT_MAX)
*   Se imprime tabulando a cuatro columnas
****************************************************/
#include <stdio.h>
#include <limits.h>

int columna;

void ImprimirTabulando(int k){
  if (columna > 4){
    columna = 1;
    printf("\n");
  }
  printf("%15d", k);
  columna++;
}

int main(){
  int termino;
  int anterior;
  int aux;

  columna = 1;

  anterior = 0;
  termino = 1;
  ImprimirTabulando(anterior);
  ImprimirTabulando(termino);

  while(INT_MAX - termino >= anterior){
    aux = termino + anterior;
    anterior = termino;
    termino = aux;
    ImprimirTabulando(termino);
  }
  printf("\n");
}
