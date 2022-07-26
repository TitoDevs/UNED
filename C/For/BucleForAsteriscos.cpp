#include<stdio.h>

int numero;
int fin;

int main(){

  printf("Numero de asteriscos? ");
  scanf("%d", &numero);

  for(int fin = numero; fin >= 1; fin--){
    printf("*");
  }
}

