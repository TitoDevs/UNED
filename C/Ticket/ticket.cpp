/*****************************************************
* Programa: Ticket
*
* Descrici�n:
*   Este programa elabora un ticket de entrada y los
*   res�menes de recaudaci�n de un espect�culo.
*   El precio del ticket depende de la edad del
*   espectador (Nido, Joven, Adulto o Jubilado)
******************************************************/
#include <stdio.h>

int main() {
  const float PrecioBase = 6.0; /* Precio de la butaca */
  int butacas = 0;              /* N�mero de butacas vendidas */
  int edad;                     /* Edad del cliente */
  float totalEuros = 0.0;       /* Total de euros recaudados */
  float precio;                 /* Precio de cada butaca */
  char opcion = ' ';            /* Opci�n del programa */
  char tecla = ' ';             /* Tecla Si/No */

  /* Bucle hasta opci�n F de fin --*/

  while (opcion != 'F') {
    printf( "Opcion (Ticket, Resumen o Fin) ? ");
    opcion = ' ';
    while ((opcion != 'T') && (opcion != 'R') && (opcion != 'F')) {
      scanf( "%c", &opcion );
    }

  /*========================
    Elaboraci�n del ticket
   ========================*/
  if (opcion == 'T'){
    tecla = 'S';
    while (tecla == 'S') {
      printf( "Edad? " );
      scanf( "%d" , &edad );
      butacas++;
      printf( ".-------------------------. \n" );
      printf( "|    TICKET DE ENTRADA    | \n" );
      if (edad < 6) {
        printf( "|Gratis " );
        precio = 0.0;
      } else if (edad < 18) {
        printf( "|Joven " );
        precio = PrecioBase / 2.0;
      } else if (edad < 65) {
        printf( "|Adulto ");
        precio = PrecioBase;
      } else {
        printf( "|Jubilado ");
        precio = 4.0;
      }
      totalEuros = totalEuros + precio;
      printf( "        Precio: %4.2f|\n", precio );
      printf( "'-------------------------'\n\n" );
      printf( "Otro ticket(S/N)" );
      tecla = ' ';
      while ((tecla != 'S' ) && (tecla != 'N' )) {
        scanf( "%c", &tecla);
      }
    }
  }
  /*=======================================
    Elaboraci�n del Resumen de Recaudaci�n
   ========================================*/

    if (opcion == 'R') {
      printf( "    RESUMEN DE VENTAS    \n" );
      printf( "    -----------------    \n" );
      printf( " %4d Butacas \n", butacas );
      printf( "Total Recaudado = %10.2f\n\n", totalEuros );
    }
  }
}
