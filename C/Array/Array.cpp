#include <stdio.h>

typedef int VectorEnteros[10];
int suma;

int main(){

  VectorEnteros v;
  for(int i=0;i<10;i++){
    v[i] = i+1;
  }
  suma = 0;
  for(int i=0; i<10; i++){
    suma = suma + v[i];
  }
  printf("La suma %d", suma);
  return 0;
}
