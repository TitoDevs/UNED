/****************************************
* NOMBRE: #Juan Antonio#
* PRIMER APELLIDO: #Fernandez#
* SEGUNDO APELLIDO:#Gonzalez#
* DNI: #99999999#
* EMAIL: #jantonio.gonzalez@mimail.com#
*****************************************/

#include <stdio.h>

/*==========================================================================================
* Programa: Práctica 3
*
* Descripción:
*  Esta práctica consiste en realizar un programa que muestre por pantalla la hoja
*  del calendario de cualquier mes y año comprendido entre los años 1601 y 3000.
*  La hoja debe quedar ajustada a la izquierda de la pantalla y se deben emplear
*  los caracteres '=', '|', '.' y los espacios en blanco tal y como aparecen en el
*  ejemplo.
*  El programa debe pedir el mes y el año una vez para cada ejecución y no deberá
*  imprimir nada para los años fuera del rango 1601 y 3000.
*
* ¿Como vamos a enfocar el problema?
*  Declararemos los tipos que necesitamos (Día, Mes, Fecha) y un boolean para los años bisiestos.
*  Crearemos subprogramas para que nos calculen el día que corresponde a la fecha seleccionada,
*  calcular los días de un mes, determinar cuando es año bisiesto y sumar el día...
*  Utilizaremos sentencias como IF y FOR y operadores como '%' SWITCH, CASE, BREAK.
===========================================================================================*/

/*==========================================================================================
              DECLARAMOS LOS TIPOS QUE NECESITAMOS PARA REALIZAR EL EJERCICIO
===========================================================================================*/

  typedef enum TipoDia{ /*Dias de la semana*/
	 Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo};


  typedef enum TipoMes{ /*Meses del año*/
	 Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio, Agosto, Septiembre, Octubre, Noviembre,
	 Diciembre};

  typedef struct TipoFecha{ /*Fecha*/
	  int dia;
	  TipoMes mes;
	  int anno;
	  };

  bool bisiesto (int anno){ /*Para determinar cuando es bisiesto*/
	  return ((anno % 4 == 0) && (anno % 100 != 0)) || (anno % 400 == 0);
  }

/*==========================================================================================
                                      SUBPROGRAMAS
===========================================================================================*/

   TipoDia SumarDias (TipoDia dia , int N) {	                        /* N = el numéro por el que se incrementa la fecha */

	   const  int DiasSemana = 7;
	   int aux;

	   aux = (int (dia) + N ) % DiasSemana;				/* Aux = ( Día referencia + incremento ) menos semanas enteras */

	   return TipoDia (aux);
	   }

 /*==========================================================================================
                LADO DEL ROMBO: Escaneamos el valor que queremos (max 20)
===========================================================================================*/

   TipoDia DiaDeLaSemana ( TipoFecha fecha ) {

	   TipoMes M = fecha.mes;
	   int A = fecha.anno;
	   int IncreDias;						/* Incremento en días de la semana */
	   int IncreAnnos; 						/* Incremento en días por años enteros */
	   int IncreBisiesto;						/* Incremento en días por años bisiestos */
	   const int AnnoReferencia = 1601;				/* Año a partir del cual determinamos el día */
	   const TipoDia DiaReferencia = Domingo;			/* Día a partir del cual determinamos el día*/

	   if (M == Enero) {
		   IncreDias = 0;
	   } else if (M == Febrero ){
		   IncreDias = 3;
	   } else if (M == Marzo ) {
		   IncreDias = 3;
	   } else if (M == Abril ) {
		   IncreDias = 6;
	   } else if (M == Mayo) {
		   IncreDias = 	1;
	   } else if (M == Junio) {
		   IncreDias =  4;
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


	   IncreAnnos = A - AnnoReferencia;	                        /* Cálculo de incremento de días por años completos desde año
									referencia */


    IncreBisiesto = 0;                                                  /* Añadir dias por años bisiestos */

    for (int N=1602; N<A; N++) {
      if (bisiesto (N)) {
        IncreBisiesto ++;
        }
      }

	   if ( bisiesto (A) && 			                /* añadir un día si la fecha a evaluar cae en un ano bisiesto
									despues del día 29 de febrero */
		( M > Febrero )) {
		   IncreDias ++;
		   }

	   IncreDias = IncreDias + IncreAnnos 	                        /* Cálculo de incremento total de días */
			+ IncreBisiesto
			+ fecha.dia;


	   return SumarDias (DiaReferencia, IncreDias);
	   }

 /*==========================================================================================
                LADO DEL ROMBO: Escaneamos el valor que queremos (max 20)
===========================================================================================*/

   int DiasDelMes (TipoFecha fecha) {
     switch (fecha.mes) {
       case Febrero:
          if (bisiesto (fecha.anno)) {
            return (29);
          } else { return (28);
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

/*==========================================================================================
                LADO DEL ROMBO: Escaneamos el valor que queremos (max 20)
===========================================================================================*/
int main () {

  int aux;								/* variable de almacenamiento temporal del mes*/
  int ind; 								/* contador de posiciones del calendario */

  TipoFecha fecha;
  TipoDia PrimerDia;

  fecha.dia = 1;							/* iniciar el primer día de la fecha para poder determinar
									cual es el primer día del mes*/


 /*--- Preguntar datos  y determinar información necesaria
  * a la realización del calendario ---*/

  do {									/* preguntar meses hasta obtener una respuesta acceptable */
	  printf ("¿Mes (1..12)?");
	  scanf ("%d", &aux);

  } while (aux < 1 || aux > 12);

  printf ("¿Anno (1601..3000)?");
  scanf ("%d", &fecha.anno);

  fecha.mes = TipoMes (aux - 1);					/* conversión del mes */
  PrimerDia = DiaDeLaSemana (fecha);					/* Calcular en que día de la semana cae el primer día del mes*/

 /*==========================================================================================
                LADO DEL ROMBO: Escaneamos el valor que queremos (max 20)
===========================================================================================*/

  if (fecha.anno >= 1601 && fecha.anno <= 3000) {			/* el calendario no imprime nada para los años fuera del rango */

	  printf ("\n");						/* espacio en blanco antes de la hoja del calendario */

	  switch (fecha.mes) {
	  case Enero:
	  printf ("ENERO     ");
	  break;
	  case Febrero:
	  printf ("FEBRERO   ");
	  break;
	  case Marzo:
	  printf ("MARZO     ");
	  break;
	  case Abril:
	  printf ("ABRIL     ");
	  break;
	  case Mayo:
	  printf ("MAYO      ");
	  break;
	  case Junio:
	  printf ("JUNIO     ");
	  break;
	  case Julio:
	  printf ("JULIO     ");
	  break;
	  case Agosto:
	  printf ("AGOSTO    ");
	  break;
	  case Septiembre:
	  printf ("SEPTIEMBRE");
	  break;
	  case Octubre:
	  printf ("OCTUBRE   ");
	  break;
	  case Noviembre:
	  printf ("NOVIEMBRE ");
	  break;
	  case Diciembre:
	  printf ("DICIEMBRE ");
	  break;
	  }

	  printf ("             ");
	  printf ("%d\n", fecha.anno);
	  printf ("===========================\n");
	  printf ("LU  MA  MI  JU  VI | SA  DO\n");
	  printf ("===========================\n");

 /*==========================================================================================
                LADO DEL ROMBO: Escaneamos el valor que queremos (max 20)
===========================================================================================*/
	ind = 0;

	for (int k = int (PrimerDia); k >= 1; k --) {				/* imprimir blancos de principio de mes */
		if (ind % 7 == 5) {						/* imprimir barra de fín de semana */
			printf ("| ");
		}
		if ( ind %7 != 0 && ind % 7 != 5 ) {	/* imprimir blanco entre campos si no es lunes o viernes */
		printf (" ");
		}
		printf (" . ");
		ind ++;
	}

	for (int k = 0; k < DiasDelMes (fecha); k ++) {			/* imprimir todos los días del mes*/
	  if (ind != 0) {
		  if (ind % 7 == 0) {					/* cambio de semana (linea ) si es necesario */
			  printf ("\n");
		  }
	  }
	   if (ind % 7 == 5) {						/* imprimir barra de fín de semana */
		  printf ("| ");
	  }
	  if ( ind %7 != 0 && ind % 7 != 5 ) {		/* imprimir blanco entre campos si no es lunes o viernes */
		printf (" ");
	  }
	  printf ("%2d ", k+1 );
	  ind ++;
	}

	while ( ind % 7 != 0 ) {
		if (ind % 7 == 5) {						/* imprimir barra de fín de semana */
		  printf ("| ");
		}
		if ( ind %7 != 0 && ind % 7 != 5 ) {	/* imprimir blanco entre campos si no es lundes viernes */
			printf (" ");
		}
		printf (" . ");
		ind ++;
	}
	printf ("\n");
  }
}
