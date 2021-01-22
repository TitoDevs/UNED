#include <stdio.h>
#include <string.h>

typedef char TipoCadena[20];
int aux;
int ind;
char tecla = ' ';
char opcion = ' ';

typedef struct TipoContacto{
  int ref;
  TipoCadena nombre, apellido;
  int distancia;
  int angulo;
};

typedef TipoContacto TipoContactos[20];

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
  int numeroPedidos;
  int numeroContactos;
  void inicializa();
  void inserta(TipoPedido pedido, TipoContacto contacto);
  void lista();
};

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

void TipoPaquete::inicializa(){
  numeroPedidos = 0;
  numeroContactos = 0;
}

void TipoAgenda::inserta(TipoContacto contacto){
  contactos[numeroContactos] = contacto;
  numeroContactos = numeroContactos + 1;
}
void TipoPedido::insertar(TipoFarmaco farmaco){
  listadeFarmacos[numeroFarmacos] = farmaco;
  numeroFarmacos = numeroFarmacos + 1;
}
void TipoPaquete::inserta(TipoPedido pedido, TipoContacto contacto){
  pedidos[numeroPedidos] = pedido;
  numeroPedidos = numeroPedidos + 1;
  contactos[numeroContactos] = contacto;
  numeroContactos = numeroContactos + 1;
}

void TipoAgenda::lista(){
  printf("\n Lista de pacientes y su ubicacion\n\n");
  printf("    Ref.   Identificador       Distancia     Angulo \n\n");
  for(int i = 0; i <numeroContactos; i++){
    printf("    %d     %s %s          %d     %d \n", contactos[i].ref, contactos[i].nombre, contactos[i].apellido, contactos[i].distancia, contactos[i].angulo);
  }
  printf("\n");
}

void TipoPaquete::lista(){
  printf(" \n Lista diaria de pedidos\n\n");
  printf("Dia? ");
  scanf("%d", &pedido.diaEnvio);
  printf("Mes? ");
  scanf("%d", &pedido.mesEnvio);
  printf("Anno? ");
  scanf("%d", &pedido.annoEnvio);

  for(int i = 0; i < pedidos[i].diaEnvio; i++){
    if(pedido.diaEnvio == pedidos[i].diaEnvio){
      if(pedido.mesEnvio == pedidos[i].mesEnvio){
        if(pedido.annoEnvio == pedidos[i].annoEnvio){
          printf("\n      Pedido %d\n", i + 1);
          printf(" Ubicacion destino: Distancia: %d y Angulo: %d\n", contactos[i].distancia, contactos[i].angulo);
          for(int j = 0; j < pedidos[i].numeroFarmacos; j++){
            printf( " %d Unidades  %s Peso: %d gramos \n", pedidos[i].listadeFarmacos[j].unidadesFarmaco, pedidos[i].listadeFarmacos[j].nombreFarmaco, pedidos[i].listadeFarmacos[j].pesoFarmaco);
          }
          printf(" Peso total %d", pedidos[i].pesoPedido);
          printf("\n\n");
        }
      }
    }
  }
}

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

bool bisiesto (int anno){
  return ((anno % 4 == 0) && (anno % 100 != 0)) || (anno % 400 == 0);
}

TipoDia SumarDias (TipoDia dia , int N) {
  const  int DiasSemana = 7;
  int aux;
  aux = (int (dia) + N ) % DiasSemana;
  return TipoDia (aux);
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

int main(){
  TipoAgenda agenda;
  TipoContacto contacto;
  TipoContactos contactos;
  TipoPedido pedido;
  TipoPedidos pedidos;
  TipoPaquete paquete;
  TipoFecha fecha;
  TipoDia PrimerDia;
  TipoFarmaco farmaco;
  agenda.inicializa();
  paquete.inicializa();
  fecha.dia = 1;

  while(opcion != 'S') {
    printf(" FarmaDron: Distribucion de Farmacos con Dron\n");
    printf("     Alta nuevo paciente                (Pulsar A)\n");
    printf("     Ubicar pacientes                   (Pulsar U)\n");
    printf("     Nuevo pedido                       (Pulsar N)\n");
    printf("     Lista diaria de pedidos            (Pulsar L)\n");
    printf("     Calendario mensual de pedidos      (Pulsar C)\n");
    printf("     Salir                              (Pulsar S)\n");
    printf(" Teclear una opcion valida (A|U|N|L|C|S)? ");
    opcion = ' ';

    while((opcion!='A') && (opcion!='U') && (opcion!='N') && (opcion!='L') && (opcion!='C') && (opcion!='S')){
      scanf( "%c", &opcion );
    }

    if(opcion == 'A'){
      printf("\n Alta nuevo paciente: \n");
      tecla = 'S';

      while(tecla == 'S'){

        if(agenda.numeroContactos<20){
          tecla = ' ';
          contacto.ref = agenda.numeroContactos + 1;
          printf("\n    Identificador(entre 1 y 20 caracteres? ");
          scanf("%s %s", contacto.nombre, contacto.apellido);
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
            agenda.inserta(contacto);
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
    if(opcion == 'U'){
      agenda.lista();
    }

    while(opcion == 'N'){
      printf("\n Nuevo pedido:\n\n");
      tecla = 'S';
      pedido.refPedido = pedido.numeroPedido + 1;
      if(tecla == 'S'){


        if(paquete.numeroPedidos<100){

          printf("    Ref. Paciente (entre 1 y 20): ");
          scanf("%d", &pedido.refPaciente);

          printf("    Numero de envios? ");
          scanf("%d", &pedido.numeroEnvios);

          if(pedido.numeroEnvios>1){
            printf("    Numero de dias entre cada envio? (Entre 1 y 15 dias)? ");
            scanf("%d", &pedido.entreEnvios);
            if(pedido.entreEnvios > 15){
              printf("     Maximo 15 dias. Prueba de nuevo ");
              scanf("%d", &pedido.entreEnvios);
            }
          }
          printf("    Dia del envio? ");
          scanf("%d", &pedido.diaEnvio);
          while(pedido.diaEnvio > 31){
            printf("     El dia introducido no es valido. Seleccione otro. ");
            scanf("%d", &pedido.diaEnvio);
          }
          printf("    Mes del envio? ");
          scanf("%d", &pedido.mesEnvio);
          while(pedido.mesEnvio > 12){
            printf("     El mes introducido no es valido. Seleccione otro. ");
            scanf("%d", &pedido.mesEnvio);
          }
          printf("    Anno del envio? ");
          scanf("%d", &pedido.annoEnvio);

          while(pedido.annoEnvio < 1000){
            printf("     Tienes que poner 4 digitos. Intentalo de nuevo. ");
            scanf("%d", &pedido.annoEnvio);
          }

          while(tecla== 'S'){
            printf("    Nombre del farmaco (Entre 1 y 20 caracteres)? ");
            scanf("%s", &farmaco.nombreFarmaco);
            printf("    Peso farmaco (Menor de 3000 gramos)? ");
            scanf("%d", &farmaco.pesoFarmaco);
            pedido.pesoPedido = pedido.pesoPedido + farmaco.pesoFarmaco;
            while(farmaco.pesoFarmaco > 3000){
              printf("     Máximo 3000 gramos. Pruebe de nuevo");
              scanf("%d", &farmaco.pesoFarmaco);
            }
            printf("    Unidades de farmaco? ");
            scanf("%d", &farmaco.unidadesFarmaco);
            pedido.insertar(farmaco);
            printf("    Otro farmaco?(S/N) ");
            scanf("%c", &tecla);

            while((tecla != 'N') && (tecla != 'S')){
              scanf("%c", &tecla);
            }

            if(tecla == 'N'){
              printf("    Otro pedido?(S/N) ");
              scanf("%c", &tecla);

              while((tecla != 'N') && (tecla != 'S')){
              scanf("%c", &tecla);
              }

              if(tecla == 'N'){
                pedido.refPedido = pedido.numeroPedido + 1;
                paquete.inserta(pedido, contacto);
                pedido.pesoPedido = 0;
                pedido.numeroFarmacos = 0;
                opcion = ' ';
              }
              if(tecla == 'S'){
                pedido.refPedido = pedido.numeroPedido + 1;
                paquete.inserta(pedido, contacto);
                pedido.numeroFarmacos = 0;
                pedido.pesoPedido = 0;
                tecla = ' ';
              }
            }
            if(tecla == 'S'){

            }
          }
        }
      }
    }
    if(opcion == 'L'){
      paquete.lista();
    }

    if(opcion == 'C'){
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
        printf("%s", contactos[0].nombre);
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
          if(k-1 == 12){
            printf ("%2d ", aux );
          }else{
            printf ("-- ");
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
  }
}
