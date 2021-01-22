#include <stdio.h>
#include "AltaPaciente.h"

void TipoAgenda::inicializa(){
  numeroContactos = 0;
}
void TipoAgenda::inserta(TipoContacto contacto){
  contactos[numeroContactos] = contacto;
  numeroContactos = numeroContactos + 1;
}
void TipoAgenda::nuevo(){
  TipoContacto contacto;
  TipoContactos contactos;
  printf("\n Alta nuevo paciente: \n");
  tecla = 'S';
  while(tecla == 'S'){

    if(numeroContactos<20){
      tecla = ' ';
      contacto.ref = numeroContactos + 1;
      printf("\n    Identificador(entre 1 y 20 caracteres? ");
      scanf("%s %s", &contacto.nombre, contacto.apellido);
      printf("    Distancia (hasta 10000 metros a plena carga)? ");
      scanf("%d", &contacto.distancia);

      while(contacto.distancia>10000){
        printf("     Te has pasado del limite. Pruebe de nuevo ");
        scanf("%d", &contacto.distancia);
      }
      printf("    Angulo (entre 0 y 2000 r/1000 radianes)? ");
      scanf("%d", &contacto.angulo);

      while(contacto.angulo>2000){
        printf("     Te has pasado del limite. Pruebe de nuevo ");
        scanf("%d", &contacto.angulo);
      }
      printf("\n Datos correctos (S/N)? ");
      scanf("%c", &tecla);


      while((tecla != 'N') && (tecla != 'S')){
        scanf("%c", &tecla);
      }
      if(tecla == 'S'){
        inserta(contacto);
        printf(" Otro paciente? (S/N) ");
        scanf("%c", &tecla);

        tecla = ' ';

        while((tecla!='N') && (tecla!='S')){
            scanf( "%c", &tecla);
        }
        if(tecla == 'N'){
          tecla = ' ';
        }
        printf("\n");
      }
      if(tecla == 'N'){
        tecla = 'S';
      }
    }else{
      printf("\nYa no se admiten más pacientes\n\n");
      tecla = ' ';
    }
  }
}














