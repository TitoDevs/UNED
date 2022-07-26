#include <stdio.h>

typedef char TipoCadena[20];

char tecla = ' ';
char opcion = ' ';

typedef struct TipoContacto{
  int ref;
  TipoCadena nombre, apellido;
  int distancia;
  int angulo;
};

typedef struct TipoPedido{
  int numeroPedido;
  int numeroEnvios;
  int refPaciente;
  TipoCadena nombreFarmaco;
  int pesoFarmaco;
  int unidadesFarmaco;
  int diaEnvio;
  int mesEnvio;
  int annoEnvio;
  int entreEnvios;
};
typedef TipoContacto TipoContactos[20];
typedef TipoPedido TipoPedidos[100];

typedef struct TipoPaquete{
  TipoContactos contactos;
  TipoPedidos pedidos;
  int numeroPedidos;
  int numeroContactos;
  void inicializa();
  void inserta(TipoPedido pedido);
  void lista(TipoContacto contacto);
};


typedef struct TipoAgenda{
  TipoContactos contactos;
  TipoPedidos pedidos;
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
}

void TipoAgenda::inserta(TipoContacto contacto){
  contactos[numeroContactos] = contacto;
  numeroContactos = numeroContactos + 1;
}

void TipoPaquete::inserta(TipoPedido pedido){
  pedidos[numeroPedidos] = pedido;
  numeroPedidos = numeroPedidos + 1;
}

int main(){

  TipoAgenda agenda;
  TipoContacto contacto;
  TipoPedido pedido;
  TipoPaquete paquete;
  agenda.inicializa();
  paquete.inicializa();

  printf("\n Nuevo pedido:\n\n");
  tecla = 'S';

  if(tecla == 'S'){

    if(paquete.numeroPedidos<100){

      printf("    Ref. Paciente (entre 1 y 20): ");
      scanf("%d", &pedido.refPaciente);
      printf("    Numero de envios? ");
      scanf("%d", &pedido.numeroEnvios);

      if(pedido.numeroEnvios>1){
        printf("    Numero de dias entre cada envio? (Entre 1 y 15 dias)? ");
        scanf("%d", &pedido.entreEnvios);
      }
      printf("    Dia del envio? ");
      scanf("%d", &pedido.diaEnvio);
      printf("    Mes del envio? ");
      scanf("%d", &pedido.mesEnvio);
      printf("    Anno del envio? ");
      scanf("%d", &pedido.annoEnvio);

      while(tecla== 'S'){

        printf("    Nombre del farmaco (Entre 1 y 20 caracteres)? ");
        scanf("%s", &pedido.nombreFarmaco);
        printf("    Peso farmaco (Menor de 3000 gramos)? ");
        scanf("%d", &pedido.pesoFarmaco);
        printf("    Unidades de farmaco? ");
        scanf("%d", &pedido.unidadesFarmaco);
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
            paquete.inserta(pedido);
            opcion = ' ';
          }
          if(tecla == 'S'){
            paquete.inserta(pedido);
            tecla = ' ';
          }
        }
        if(tecla == 'S'){
          tecla = 'S';
        }
      }
    }
  }
}
