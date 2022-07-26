/****************************************************
* Programa: Fibonacci2
*
* Descripción:
*   Este programa imprime el todos los términos
*   de la serie de Fibonacci dentro del rango de
*   valores positivos del tipo int: (1 .. INT_MAX)
*   Se imprime tabulando a cuatro columnas
****************************************************/
#include <stdio.h>
#include <limits.h>

int TABcolumna;
int TABultima;
int TABancho;

void IniciarTabulacion(int columnas, int ancho){
  TABultima = columnas;
  TABancho = ancho;
  TABcolumna = 1;
}

void ImprimirTabulando(int k){
  if(TABcolumna > TABultima){
    TABcolumna = 1;
    printf("\n");
  }
  printf("%*d", TABancho, k);
  TABcolumna++;
}

int main(){
  int termino;
  int anterior;
  int aux;

  IniciarTabulacion( 6, 11);

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
