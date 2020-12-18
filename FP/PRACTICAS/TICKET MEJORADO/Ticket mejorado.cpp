#include <stdio.h>

int main(){
  float precio;
  const float preciobase = 6.0;
  float dinerofinal = 0.0;
  char opcion = ' ';
  char tecla = ' ';
  int butacas = 0;
  int edad;
  int joven = 0;
  int nino = 0;
  int adulto = 0;
  int jubilado = 0;

  while(opcion != 'N'){
    printf("============================================\n");
    printf("              QUE QUIERES HACER?            \n");
    printf("============================================\n\n");
    printf("-COMPRAR UN TICKET 'T'\n");
    printf("-VER CUANTAS ENTRADAS SE HAN VENDIDO 'R'\n");
    printf("-FINALIZAR 'N'\n\n");
    printf("============================================\n");
    opcion = ' ';
    while((opcion !='T') && (opcion !='R') && (opcion !='F')){
      scanf("%c", &opcion);
    }
    if(opcion == 'T'){
      tecla = 'S';
      while(tecla == 'S'){
        printf("Que edad tiene? ");
        scanf("%d", &edad);
        butacas++;
        printf(".=====================================.\n");
        printf("          TICKET DE ENTRADA            \n");
        printf("'====================================='\n");
        if(edad <= 6){
          printf("|Nino gratis!   ");
          precio = preciobase - preciobase;
          nino++;
        }else if(edad < 18){
          printf("|Joven          ");
          precio = preciobase / 2;
          joven++;
        }else if(edad < 60){
          printf("|Adulto         ");
          precio = preciobase;
          adulto++;
        }else if(edad > 6){
          printf("|Jubilado       ");
          precio = preciobase - preciobase;
          jubilado++;
        }
        dinerofinal = dinerofinal + precio;
        printf("         Precio: %4.2f |\n", dinerofinal);
        printf("'====================================='\n\n");
        printf("Quieres otro ticket? (S/N)");
        tecla = ' ';
        while ((tecla != 'S') && (tecla != 'N')){
          scanf("%c", &tecla);
        }
      }
    }
    if(opcion == 'R'){
      printf(".=====================================.\n");
      printf("|          ENTRADAS VENIDIDAS         |\n");
      printf("'====================================='\n");
      printf("%4d Niños \n", nino);
      printf("%4d Jovenes \n", joven);
      printf("%4d Adultos \n", adulto);
      printf("%4d Jubilados \n", jubilado);
      printf("%4d Butacas total \n", butacas);
      printf("'====================================='\n");
      printf("    Total recaudado = %10.2f\n", dinerofinal);
      printf("'====================================='\n");
    }
  }
}
