#pragma once
#include "AltaPaciente.h"
#include "ListaPedidos.h"

typedef enum TipoDia{
  Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo
};


typedef enum TipoMes{
  Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre
};

typedef struct TipoFecha{
  int dia;
  TipoMes mes;
  int anno;
};


typedef struct TipoCalendario{
  TipoPedidos pedidos;
  TipoFecha fecha;
  void mostrar(TipoPaquete paquete);
  int PrimerDia;
};
