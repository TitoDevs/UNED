/****************************************************
* Programa: TrianguloDeNumeros
*
* Descripción:
*   Este programa escribe un triágunlo de dígitos.
*   La altura se lee como dato y debe ser menor de 10.
****************************************************/

#include <stdio.h>

int main(){
  const int centro = 35;
  const int inicial = 1;
  const int astedisco = "*";
  const int o = "o";
  int nivel;

  printf( "¿Altura del triángulo? ");
  scanf( "%d", &nivel);

for ( int altura = inicial; altura <= nivel; altura++){
  {
    for(int indice = 1; indice <= centro-altura; indice++){
      printf(" ");
    }
    printf("%d", inicial);
  }{

    for(int indice = inicial+1; indice <= altura; indice++){
      printf("%1d", indice);
    }
  }{

  for (int indice = inicial+1; indice >= inicial; indice--){
    printf("%1d", indice);
  }
}
printf("\n");
}
}
