#pragma once
#include "AltaPaciente.h"

typedef char TipoCadena[20];

typedef struct TipoFarmaco{
  TipoCadena nombreFarmaco;
  int pesoFarmaco;
  int unidadesFarmaco;
  int numeroFarmacos;
  int numeroFarmaco;
  void inicializa();
};

typedef struct TipoPedido{
  int numeroPedido;
  int refPedido;
  int numeroEnvios;
  int refPaciente;
  int numeroFarmacos;
  int pesoPedido;
  TipoFarmaco listadeFarmacos[5];
  int diaEnvio;
  int mesEnvio;
  int annoEnvio;
  int entreEnvios;
  void insertar(TipoFarmaco farmaco);
};

typedef TipoFarmaco TipoFarmacos[5];
typedef TipoPedido TipoPedidos[100];

typedef struct TipoPaquete{
  TipoContactos contactos;
  TipoPedidos pedidos;
  TipoPedido pedido;
  TipoAgenda agenda;
  char opcion;
  char tecla;
  int numeroPedidos;
  int numeroContactos;
  void inicializa();
  void inserta(TipoPedido pedido);
  void lista(TipoAgenda agenda);
  void nuevo();

};


