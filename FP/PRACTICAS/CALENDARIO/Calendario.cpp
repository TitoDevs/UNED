/****************************************************
* Programa: Calendario
*
* Descripción:
*   Programa para el calculo del día de la semana
*   que corresponde a una fecha comprendida entre:
*   1/1/1989 y 31/12/2088
****************************************************/
#include <stdio.h>

typedef enum TipoDia {
  Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo
};

typedef enum TipoMes {
  Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre, Diciembre
};

typedef struct TipoFecha {
  int dia;
  TipoMes mes;
  int anno;
};

TipoDia SumarDias(TipoDia dia, int n){
  const int DiasSemana = 7;
  int aux;

  aux = (int(dia) + n) % DiasSemana;
  return TipoDia(aux);
}

TipoDia DiaDeLaSemana(TipoFecha fecha){
  const int OrigenA = 89;
  TipoDia TreintaUnoDiciembre88 = Sabado;
  bool bisiesto;
  int IncreBisis, IncreAnnos, IncreDias;
  TipoMes M = fecha.mes;
  int A = fecha.anno;

  if(M == Enero){
    IncreDias = 0;
  } else if (M == Febrero){
    IncreDias = 3;
  } else if (M == Marzo){
    IncreDias = 3;
  } else if (M == Abril){
    IncreDias = 6;
  } else if (M == Mayo){
    IncreDias = 1;
  } else if (M == Junio){
    IncreDias = 4;
  } else if (M == Julio){
    IncreDias = 6;
  } else if (M == Agosto){
    IncreDias = 2;
  } else if (M == Septiembre){
    IncreDias = 5;
  } else if (M == Octubre){
    IncreDias = 0;
  } else if (M == Noviembre){
    IncreDias = 3;
  } else {
    IncreDias = 5;
  }
  bisiesto = (A % 4) == 0;
  if (A < OrigenA){
    A = A + 100;
  }
  IncreAnnos = A - OrigenA;
  IncreBisis = IncreAnnos/4;
  IncreDias = IncreDias + fecha.dia + IncreAnnos + IncreBisis;
  if(bisiesto && (M > Febrero)){
    IncreDias++;
  }
  return SumarDias(TreintaUnoDiciembre88, IncreDias);
}

