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
  int linea = 0;
  int primero = 0;
  int ultimo = 0;

  printf("Limite de la serie? ");
  scanf("%d", &N);

  while (ultimo < N){
    linea++;
    primero = ultimo+1;
    ultimo = ultimo+linea;
    if(ultimo > N){
      ultimo = N;
    }
    for(int k = primero; k <= ultimo; k++){
      printf("%5d", k);
    }
    printf("\n");
  }
}
