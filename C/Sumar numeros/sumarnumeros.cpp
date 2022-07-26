/** Programa: SumaNumeros */
/* Calcula e imprime la suma de los números correlativos desde 4 hasta 45 */

#include <stdio.h>

int main() {
  printf( "La suma de los números correlativos desde 4 hasta 45\n");
  printf( "es igual a: ");
  printf( "%5d\n", (45 - 4 + 1) * (45 + 4) / 2);
}
