/****************************************************
* Programa: CalcularDias
*
* Descripción:
*   Este programa calcula los días que faltan para el
*   cumpleaños de una persona.
****************************************************/
#include <stdio.h>
#include "Fechas.h"

/*===================================================
  En el módulo fechas.h están definidos:

    T_fecha = Tipo de valor FECHA
    LeerFecha = Procedimiento para leer una fecha
    EscribirFecha = Procedimiento para escribir una fecha
    DiasEntre = Función para calcular los días que hay
                entre dos fechas
    Hoy = Variable en la que se mantiene actualizada la
          fecha de hoy
====================================================*/

int main(){
  T_fecha fechaCumple;
  T_fecha fechaHoy;
  int dias;
  {
  printf("Cual es tu proximo cumpleannos?");
  LeerFecha(fechaCumple);
  }
  {
    fechaHoy = Hoy;
  }
  {
    dias = DiasEntre(fechaHoy, fechaCumple);
  }
  {
  printf("\nFaltan%4d, dias");
  printf(" días para tu cumpleannos");
  }
}
