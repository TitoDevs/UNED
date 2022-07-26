/****************************************************
* Programa: CalcularDias
*
* Descripci�n:
*   Este programa calcula los d�as que faltan para el
*   cumplea�os de una persona.
****************************************************/
#include <stdio.h>
#include "Fechas.h"

/*===================================================
  En el m�dulo fechas.h est�n definidos:

    T_fecha = Tipo de valor FECHA
    LeerFecha = Procedimiento para leer una fecha
    EscribirFecha = Procedimiento para escribir una fecha
    DiasEntre = Funci�n para calcular los d�as que hay
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
  printf(" d�as para tu cumpleannos");
  }
}
