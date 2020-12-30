/****************************************************
* Programa: FactorialRecursivo
*
* Descripción:
*   Este programa calcula el factorial de los primeros
*   números naturales, de forma recursiva
****************************************************/
#include <stdio.h>

int FactorialRecursivo(int n){
  if (n <= 1){
    return 1;
  }else {
    return n * FactorialRecursivo(n-1);
  }
}

int main(){
  for (int i = 0; i <= 10; i++){
    printf("%2d! vale:%10d\n", i, FactorialRecursivo( i ));
  }
}
