/****************************************************
* Programa: Floyd1
*
* Descripción:
*   Este programa imprime el triangulo de Floyd
*   con los números correlativos de 1 a N.
*   El valor de N se lee como dato
****************************************************/
#include <stdio.h>

int main(){
  int N;
  int linea = 1;
  int ultimo = 1;

  printf("Limite de la serie? ");
  scanf("%d", &N);

  for(int k = 1; k <= N; k++){
    if(k > ultimo){
      printf("\n");
      linea++;
      ultimo = ultimo+linea;
    }
    printf("%5d", k);
  }
  if(N > 0){
    printf("\n");
  }
}
