#include <stdio.h>
#include "ListaPedidos.h"
#include "NuevoPedido.h"
#include "AltaPaciente.h"

void TipoPaquete::nuevo(){

  TipoFarmaco farmaco;
  TipoContacto contacto;

  printf("\n Nuevo pedido:\n\n");
  tecla = 'S';
  pedido.refPedido = pedido.numeroPedido + 1;
  if(tecla == 'S'){
    if(numeroPedidos<100){

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
            inserta(pedido);
            pedido.pesoPedido = 0;
            pedido.numeroFarmacos = 0;
            opcion = ' ';
          }
          if(tecla == 'S'){
            pedido.refPedido = pedido.numeroPedido + 1;
            inserta(pedido);
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

