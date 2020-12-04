/****************************************
* NOMBRE: #Juan Antonio#
* PRIMER APELLIDO: #Fernandez#
* SEGUNDO APELLIDO:#Gonzalez#
* DNI: #99999999#
* EMAIL: #jantonio.gonzalez@mimail.com#
*****************************************/

/*==========================================================================================
* Programa: Práctica 2
*
* Descripción:
*  Esta práctica consiste en realizar un programa que imprima por
*  pantalla rombos concéntricos dibujados con los caracteres '@' , 'o' y '.'.
*  El tamaño del rombo no puede superar los 20 caracteres.
*  El programa no deberá imprimir nada para tamaños cero o negativo.
*
* ¿Como vamos a enfocar el problema?
*  Dividiremos el rombo en 4 triangulos.
*  Utilizaremos sentencias como IF y FOR y operadores como '%'.
===========================================================================================*/

#include <stdio.h>

int main () {

  int lado;
  int altura;
  int num;
  int k;

/*==========================================================================================
                LADO DEL ROMBO: Escaneamos el valor que queremos (max 20)
===========================================================================================*/

  printf("¿Lado del Rombo?");
  scanf("%d", &lado);
  printf("\n");

/*==========================================================================================
                               Triangulo superior-izquierdo
===========================================================================================*/

  if (lado >= 1){
    if (lado <= 20){  /*Limitación a 20*/
      for (int altura = 1; altura <= lado; altura ++ ){
        for (int k = 1; k <= (lado - altura ); k ++){
          printf (" ");
          }
        for  (int num = 1; num <= altura; num ++) {
          if ( num % 4 == 1){
            printf ("@");
            }
          if ( num % 4 == 2){
            printf (".");
            }
          if ( num % 4 == 3){
            printf ("o");
            }
          if ( num % 4 == 0){
            printf (".");
            }
          }

/*==========================================================================================
                               Triangulo superior-derecho
===========================================================================================*/

        for ( int num = altura; num >= 2 ; num -- ){
          if ( num % 4 == 2){
            printf ("@");
            }
          if ( num % 4 == 3) {
            printf (".");
            }
          if ( num % 4 == 0){
            printf ("o");
            }
          if ( num % 4 == 1){
            printf (".");
            }
          }
        printf ("\n");
        }

/*==========================================================================================
                               Triangulo inferior-izquierdo
===========================================================================================*/

      for ( int altura = 1; altura <= lado ; altura ++){
        for ( int k = 1;  k <= altura; k ++){
          printf (" ");
          }
        for (int num = 1 ; num <= ( lado - altura ); num ++ ) {
          if (num %4 == 1 ){
            printf ("@");
            }
          if (num %4 == 2 ){
            printf (".");
            }
          if (num %4 == 3 ) {
            printf ("o");
            }
          if (num %4 ==0 ) {
            printf (".");
            }
          }

/*==========================================================================================
                                Triangulo inferior-derecho
===========================================================================================*/

        for ( int num = (lado - altura); num >= 2; num -- ) {
          if ( num %4 == 2){
            printf ("@");
            }
          if ( num %4 == 3){
            printf (".");
            }
          if (num %4 == 0){
            printf ("o");
            }
          if (num %4 == 1){
            printf (".");
            }
          }
        printf ("\n");
        }
      }
    }
  }
