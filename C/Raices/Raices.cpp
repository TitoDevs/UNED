/****************************************************
* Programa: Raices
*
* Descripción:
*   Este programa calcula las raíces de una
*   ecuación de segundo grado: axª + bx + c.
****************************************************/
#include <stdio.h>
#include <math.h>

float Discriminante (float a, float b, float c){
  return b*b - 4.0*a*c;
}
void LeerValor(int grado, float & valor){
  printf("Coeficiente de grado %1d?", grado);
  scanf("%f", &valor);
}
int main(){
  float valorA, valorB, valorC;
  float parteUno, parteDos;
  float valorD;

  LeerValor(2, valorA);
  LeerValor(1, valorB);
  LeerValor(0, valorC);
  if(valorA == 0.0){
    if(valorB == 0.0){
      if(valorC == 0.0){
        printf("Ecuación no valida\n");
      }else{
        printf("Solucion imposible\n");
      }
    }else{
      printf("Raiz unica = %10.2\n", -valorC/valorB);
    }
  }else{
    parteUno = - valorB/(2.0*valorA);
    valorD = Discriminante(valorA, valorB, valorC);
    if(valorD >= 0.0){
      parteDos = sqrt(valorD)/(2.0*valorA);
      printf("Raices reales:\n");
      printf("%10.2f y \n", parteUno+parteDos);
      printf("%10.2f \n", parteUno-parteDos);
    }else{
      parteDos = sqrt(-valorD)/(2.0*valorA);
      printf("Raices complejas:\n");
      printf("Parte real =       %10.2f y\n", parteUno);
      printf("Parte imaginaria = %10.2f \n", parteDos);
    }
  }
}
