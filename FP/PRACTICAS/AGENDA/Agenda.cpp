#include <stdio.h>
#include <string.h>

typedef char TipoNombre[30];

typedef struct TipoContacto{
  TipoNombre nombre;
  int telefono;

};

typedef TipoContacto TipoContactos[100];
typedef struct TipoAgenda{
  TipoContactos contactos;
  int numeroContactos;
  void inicializa();
  void inserta(TipoContacto contacto);
  void lista();
};

void TipoAgenda::inicializa(){
  numeroContactos = 0;
}

void TipoAgenda::inserta(TipoContacto contacto){
  contactos[i] = contacto;
  numeroContactos = numeroContactos+1;
}

void TipoAgenda::lista(){
  printf("========AGENDA========");
  for(int i=; i< numeroContactos; i++){
    printf("Contacto: %s - %d", contactos[i].nombre, contactos[i].telefono);
  }
}

int main(){
  TipoAgenda agenda;
  Tipocontacto contacto;
  printf("Usuario");
  scanf("%s", &
  agenda.inicializa();
  agenda.inserta(contacto);
  agenda.inserta(contacto);
  agenda.lista();

  return 0;
}
