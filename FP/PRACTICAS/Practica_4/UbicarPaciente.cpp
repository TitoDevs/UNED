#include <stdio.h>
#include "AltaPaciente.h"
#include "UbicarPaciente.h"

int numColumnas;
int anchoColumna;

void TipoAgenda::lista(){
  printf("\n Lista de pacientes y su ubicacion\n\n");
  numColumnas = 4;
  anchoColumna = 20;
  printf("    Ref.   Identificador       Distancia     Angulo \n\n");
  for(int i = 0; i <numeroContactos; i++){

    printf("    %d     %s %s          %d     %d \n", contactos[i].ref, contactos[i].nombre, contactos[i].apellido, contactos[i].distancia, contactos[i].angulo);
  }
  printf("\n");
}
