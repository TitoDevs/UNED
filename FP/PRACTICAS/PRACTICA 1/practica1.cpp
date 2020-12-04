/****************************************
* NOMBRE: #Juan Antonio#
* PRIMER APELLIDO: #Fernandez#
* SEGUNDO APELLIDO:#Gonzalez#
* DNI: #99999999#
* EMAIL: #jantonio.gonzalez@mimail.com#
*****************************************/
#include <stdio.h>


typedef char cadena[];

cadena nombre = "Juan Antonio\n";
cadena ape1 = "Fernandez\n";
cadena ape2 = "Gonzalez\n";
int dni = 99999999;
cadena mail = "jantonio.gonzalez@mimail.com\n";

int main(){

  printf(nombre);
  printf(ape1);
  printf(ape2);
  printf("%d\n",dni );
  printf(mail);

}
