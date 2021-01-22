#pragma once

typedef char TipoCadena[20];

typedef struct TipoContacto{
  int ref;
  TipoCadena nombre, apellido;
  int distancia;
  int angulo;
};

typedef TipoContacto TipoContactos[20];

typedef struct TipoAgenda{
  TipoContactos contactos;
  int numeroContactos;
  void nuevo();
  char tecla;
  void inicializa();
  void inserta(TipoContacto contacto);
  void lista();
};
