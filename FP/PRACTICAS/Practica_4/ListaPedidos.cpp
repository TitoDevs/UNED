#include <stdio.h>
#include "ListaPedidos.h"

void TipoPaquete::inicializa(){
  numeroPedidos = 0;
}

void TipoPedido::insertar(TipoFarmaco farmaco){
  listadeFarmacos[numeroFarmacos] = farmaco;
  numeroFarmacos = numeroFarmacos + 1;
}
void TipoPaquete::inserta(TipoPedido pedido){
  pedidos[numeroPedidos] = pedido;
  numeroPedidos = numeroPedidos + 1;
}

void TipoPaquete::lista(TipoAgenda agenda){

  printf(" \n Lista diaria de pedidos\n\n");
  printf("Dia? ");
  scanf("%d", &pedido.diaEnvio);
  while(pedido.diaEnvio > 31 || pedido.diaEnvio < 1 ){
    printf("  Maximo 31. Intente de nuevo ");
    scanf("%d", &pedido.diaEnvio);
  }
  printf("Mes? ");
  scanf("%d", &pedido.mesEnvio);
  while(pedido.mesEnvio > 12 || pedido.mesEnvio < 1 ){
    printf("  Maximo 12. Intente de nuevo ");
    scanf("%d", &pedido.mesEnvio);
  }
  printf("Anno? ");
  scanf("%d", &pedido.annoEnvio);
  while(pedido.annoEnvio < 1601 || pedido.annoEnvio > 3000){
    printf("  Seleccione entre 1601 y 3000. Intente de nuevo ");
    scanf("%d", &pedido.annoEnvio);
  }

  for(int i = 0; i < pedidos[i].diaEnvio; i++){
    if(pedido.diaEnvio == pedidos[i].diaEnvio){
      if(pedido.mesEnvio == pedidos[i].mesEnvio){
        if(pedido.annoEnvio == pedidos[i].annoEnvio){
          printf("\n      Pedido %d\n", i + 1);
          printf(" Ubicacion destino: Distancia: %d y Angulo: %d\n", agenda.contactos[i].distancia, agenda.contactos[i].angulo);
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
