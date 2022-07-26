#include <stdio.h>

int main(){

  const int inicial = 1;
  const int centro = 35;
  int nivel;

  printf("Dime el lado" );
  scanf("%d", &nivel);

  for ( int alt = inicial; alt <= nivel; alt++){
    for ( int indice = 1; indice <= centro-alt; indice++){
      printf(" ");
    }
    printf("%d", inicial);
  for (int indice = inicial+1; indice <= alt; indice++){
    printf("%1d", indice);
  }
  for (int indice = alt-1; indice >= inicial; indice--){
    printf("%1d", indice);
  }
  printf("\n");
  }

  for ( int alt = nivel-1; alt >=inicial ; alt--){
    for ( int indice = 1; indice <= centro-alt; indice++){
      printf(" ");
    }
    printf("%d", inicial);
  for (int indice = inicial+1; indice <= alt; indice++){
    printf("%1d", indice);
  }
  for (int indice = alt-1; indice >= inicial; indice--){
    printf("%1d", indice);
  }
  printf("\n");
  }
}



