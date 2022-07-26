/************************************
* Programa: Ordenar3
*
* Descripción:
*   Este programa ordena tres valores y
*   los guarda ordenados de menor a mayor
*   en las mismas variables que se leen
************************************/
#include <stdio.h>

int main(){
  int valUno, valDos, valTres, auxiliar;

  printf("¿Datos?");
  scanf( "%d %d %d", &valUno, &valDos, &valTres );

  if(valUno > valDos){
    auxiliar = valUno;
    valUno = valDos;
    valDos = auxiliar;
  }

  if(valTres < valUno){
    auxiliar = valTres;
    valTres = valUno;
    valUno = auxiliar;
  }else if (valTres < valDos){
    auxiliar = valTres;
    valTres = valDos;
    valDos = auxiliar;
  }

  printf("Datos Ordenados = %5d %5d %5d\n", valUno, valDos, valTres);
}
