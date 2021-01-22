#include<stdio.h>
#include "CalendarioPedidos.h"
#include "ListaPedidos.h"
char tecla = ' ';
int aux;
int ind;
TipoDia SumarDias (TipoDia dia , int N) {
  const  int DiasSemana = 7;
  int aux;
  aux = (int (dia) + N ) % DiasSemana;
  return TipoDia (aux);
}

bool bisiesto (int anno){
  return ((anno % 4 == 0) && (anno % 100 != 0)) || (anno % 400 == 0);
}


TipoDia DiaDeLaSemana ( TipoFecha fecha ) {

  TipoMes M = fecha.mes;
  int A = fecha.anno;
  int IncreDias;
  int IncreAnnos;
  int IncreBisiesto;
  const int AnnoReferencia = 1601;
  const TipoDia DiaReferencia = Domingo;

  if (M == Enero) {
    IncreDias = 0;
  } else if (M == Febrero ){
    IncreDias = 3;
    } else if (M == Marzo ) {
      IncreDias = 3;
    } else if (M == Abril ) {
      IncreDias = 6;
    } else if (M == Mayo) {
      IncreDias = 1;
    } else if (M == Junio) {
      IncreDias = 4;
    } else if (M == Julio) {
      IncreDias = 6;
    } else if (M == Agosto) {
      IncreDias = 2;
    } else if (M == Septiembre) {
      IncreDias = 5;
    } else if (M == Octubre) {
      IncreDias = 0;
    } else if (M == Noviembre) {
      IncreDias = 3;
    } else {IncreDias = 5;
  }

  IncreAnnos = A - AnnoReferencia;
  IncreBisiesto = 0;

  for (int N=1602; N<A; N++) {
    if (bisiesto (N)) {
    IncreBisiesto ++;
    }
  }

  if ( bisiesto (A) && ( M > Febrero )) {
    IncreDias ++;
  }
  IncreDias = IncreDias + IncreAnnos + IncreBisiesto + fecha.dia;
  return SumarDias (DiaReferencia, IncreDias);
}

int DiasDelMes (TipoFecha fecha) {
  switch (fecha.mes) {
    case Febrero:
      if (bisiesto (fecha.anno)) {
        return (29);
      } else {
        return (28);
        };
      break;
    case Abril:
    case Junio:
    case Septiembre:
      return (30);
      break;
    default:
      return (31);
  }
}

void TipoCalendario::mostrar(TipoPaquete paquete){

  printf("\n Pedidos mensual de pedidos:\n");

  tecla = 'S';
  while(tecla == 'S'){
    printf (" Seleccion Mes? ");
    scanf ("%d", &aux);
    while (aux < 1 || aux > 12){
      printf("  Pon un mes correcto ");
      scanf("%d", &aux);
    }
    printf (" Seleccion Anno? ");
    printf("%d", pedidos[0].diaEnvio);
    scanf ("%d", &fecha.anno);
    while (fecha.anno < 1601 || fecha.anno > 3000){
      printf("  Pon un anno correcto ");
      scanf("%d", &fecha.anno);
    }
    printf("\n Pedidos del mes o vuelos del Dron\n");
    fecha.mes = TipoMes (aux - 1);
    PrimerDia = DiaDeLaSemana(fecha);

    if (fecha.anno >= 1601 && fecha.anno <= 3000) {
      printf ("\n");
      switch (fecha.mes) {
      case Enero:
        printf ("Enero     ");
      break;
      case Febrero:
        printf ("Febrero   ");
      break;
      case Marzo:
        printf ("Marzo     ");
      break;
      case Abril:
        printf ("Abril     ");
      break;
      case Mayo:
        printf ("Mayo      ");
      break;
      case Junio:
        printf ("Junio     ");
      break;
      case Julio:
        printf ("Julio     ");
      break;
      case Agosto:
        printf ("Agosto    ");
      break;
      case Septiembre:
        printf ("Septiembre");
      break;
      case Octubre:
        printf ("Octubre   ");
      break;
      case Noviembre:
        printf ("Noviembre ");
      break;
      case Diciembre:
        printf ("Diciembre ");
      break;
      }

      printf("             ");
      printf("%d\n", fecha.anno);
      printf("===========================\n");
      printf(" L   M   M   J   V | S   D\n");
      printf("===========================\n");

      ind = 0;

      for (int k = int (PrimerDia); k >= 1; k --) {
        if (ind % 7 == 5) {
          printf ("| ");
        }
        if ( ind %7 != 0 && ind % 7 != 5 ) {
          printf (" ");
        }
          printf ("   ");
        ind ++;
      }

      for (int k = 0; k < DiasDelMes (fecha); k ++) {
        if (ind != 0) {
          if (ind % 7 == 0) {
            printf ("\n");
          }
        }
      if (ind % 7 == 5) {
        printf ("| ");
      }
      if ( ind %7 != 0 && ind % 7 != 5 ) {
        printf (" ");
      }

      for(int i=0; i<paquete.numeroPedidos; i++){
        if(paquete.pedidos[i].mesEnvio == aux && paquete.pedidos[i].annoEnvio == fecha.anno){
          if(k+1 == paquete.pedidos[0].diaEnvio){
          printf ("%2d ", paquete.pedidos[0].diaEnvio );
          }else{
            printf("-- ");
          }
        }else{
          printf("-- ");
        }
      }
      ind ++;
    }

    while ( ind % 7 != 0 ) {
      if (ind % 7 == 5) {
        printf ("| ");
      }
      if ( ind %7 != 0 && ind % 7 != 5 ) {
        printf (" ");
      }
      printf ("   ");
      ind ++;
    }
    printf ("\n");
    }
    printf("\n Mostrar otro mes (S/N)? ");
    scanf("%c", &tecla);
    while((tecla != 'S') && (tecla!= 'N')){
      scanf("%c", &tecla);
    }
    if(tecla == 'S'){
      tecla = 'S';
    }
    if(tecla == 'N'){
      tecla = ' ';
    }
  }
}


