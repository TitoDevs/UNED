/****************************************************
* Programa: Fracciones
*
* Descripción:
*   Este programa es una calculadora que suma,
*   resta, multiplica y divide fracciones.
****************************************************/
#include <stdio.h>

void ReducirFraccion( int & n, int & d){
  int divisor = 2;

  while((divisor <= n) && (divisor <= d)){
    while ((n % divisor == 0) && (d % divisor == 0)){
      n = n / divisor;
      d = d / divisor;
    }
    divisor++;
  }
}

void SumarFracciones( int n1, int d1, int n2, int d2, int & n3, int & d3){
  n3 = n1*d2 + n2*d1;
  d3 = d1*d2;
  ReducirFraccion(n3, d3);
}

void RestarFracciones( int n1, int d1, int n2, int d2, int & n3, int & d3){
  SumarFracciones(n1, d1, -n2, d2, n3, d3);
}

void MultiplicarFracciones( int n1, int d1, int n2, int d2, int & n3, int & d3){
  n3 = n1*n2;
  d3 = d1*d2;
  ReducirFraccion(n3, d3);
}

void DividirFracciones( int n1, int d1, int n2, int d2, int & n3, int & d3){
  n3 = n1*d2;
  d3 = d1*n2;
  ReducirFraccion(n3, d3);
}

void LeerFraccion( int & n, int & d){
  scanf("%d/%d", &n, &d);
  ReducirFraccion(n, d);
}

void EscribirFraccion( int n, int d){
  printf( "%d/%d\n", n, d);
}

int main(){
  int num = 0;
  int den = 0;
  int nn, dd;
  char operacion = ' ';

  while(operacion != 'F'){
    printf(">> ");
    scanf(" %c", &operacion);

    if(operacion == '+'){
      LeerFraccion( nn, dd);
      SumarFracciones( num, den, nn, dd, num, den);

    }else if (operacion == '-'){
      LeerFraccion( nn, dd);
      RestarFracciones( num, den, nn, dd, num, den);

    }else if (operacion == '*'){
      LeerFraccion( nn, dd);
      RestarFracciones( num, den, nn, dd, num, den);

    }else if (operacion == '/'){
      LeerFraccion( nn, dd);
      RestarFracciones( num, den, nn, dd, num, den);

    }else if (operacion == 'N'){
      LeerFraccion( num, den);

    }else if (operacion == '='){
      printf("         ");
      EscribirFraccion(num, den);
      printf("Pulse +, -, *, /, N, =, o F\n");
    }
  }
}
