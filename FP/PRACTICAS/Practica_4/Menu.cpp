#include <stdio.h>
#include "Menu.h"

char opcion = ' ';
TipoAgenda a;
TipoPaquete p;
TipoCalendario c;
TipoPedidos e;

void Menu::menuPrincipal(){

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
      a.nuevo();
    }
    if(opcion == 'U'){
      a.lista();
    }
    if(opcion == 'N'){
      p.nuevo();
    }
    if(opcion == 'L'){
      p.lista(a);
    }
    if(opcion == 'C'){
      c.mostrar(p);
    }
  }
}
