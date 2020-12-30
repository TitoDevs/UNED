#include <stdio.h>

int main(){
  int N;
  int resultado;

  printf("Numero? ");
  scanf("%d", &N);

  printf("Tabla de multiplicar por %d\n", N);
  printf("============================\n");

  for(int j=1; j<=10; j++){
    resultado = N * j;
    printf("%d x %d = %d\n", N, j, resultado);
  }
}
