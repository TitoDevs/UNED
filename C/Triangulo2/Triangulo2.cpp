/****************************************************
* Programa: Triangulo (Versión corregida)
*
* Descripción:
*   Este programa escribe el borde de un triángulo
*   aproximadamente equilátero, usando asteriscos.
*   La altura del triángulo, en líneas de texto,
*   se lee como dato
****************************************************/

#include <stdio.h>

int main(){
  int altura;

  printf( "Altura? ");
  scanf( "%d", &altura);

  if(altura > 0){
    for (int k = 1; k <= altura-1; k++){
      printf(" ");
    }
    printf("*\n");
  }
  for (int k = 2; k <= altura-1; k++){
    for (int j = 1; j <= altura-k; j++){
      printf(" ");
    }
    printf("*");
    for (int j = 1; j <= 2*k-3; j++){
      printf(" ");
    }
    printf("*\n");
  }
  if(altura > 1){
    printf("*");
    for (int k = 1; k <= altura-1; k++){
      printf(" *");
    }
    printf("\n");
  }
}
