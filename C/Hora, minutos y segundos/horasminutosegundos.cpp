/** Programa: HorasMinutosSegundos*/
/* Conversión a Horas, Minutos y Segundos*/

#include <stdio.h>

int main (){
  int horas, minutos, segundos;

  printf( "¿Segundos Totales?" );
  scanf( "%d", &segundos );
  horas = segundos / 3600;
  segundos = segundos % 3600;
  minutos = segundos / 60;
  segundos = segundos % 60;

  printf("Equivalen a %2d horas %2d minutos y %2d segundos \n", horas, minutos, segundos );
}
