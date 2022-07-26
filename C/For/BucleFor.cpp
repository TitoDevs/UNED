#include<stdio.h>

int numero;
int resultado;
int res;

int main(){

  printf("Producto ");
  scanf("%d", &numero);

  for(int resultado = numero; resultado >= 1; resultado--){
    res = numero * resultado;
    printf("%d multiplicado por %d da %d\n",numero, resultado, res);
  }
}

