/****************************************************
* Programa: Fechas2
*
* Descripción:
*   Programa que lee una serie de fechas,
*   comprueba que son correctas, y las
*   imprime en orden cronológico.
****************************************************/
#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
/*===================================================
  Tipo Abstracto FECHA
===================================================*/
typedef struct TipoFecha {
  bool Leer();
  void Escribir();
  bool EsCorrecta();
  bool EsPosterior(TipoFecha f);

  private:
    int dia, mes, anno;
};

/*===================================================
  Lista de fechas
===================================================*/

const int maxFechas = 100;
typedef TipoFecha listaFechas_t[maxFechas];

listaFechas_t lista;
int numFechas;

/*===================================================
  Nombres de los meses
===================================================*/
const int maxNombre = 15;
typedef char TipoNombreMes[maxNombre];
typedef TipoNombreMes listaNombres_t[13];

listaNombres_t nombres = {"?", "Enero", "Febrero",
"Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
"Septiembre", "Octubre", "Noviembre", "Diciembre"};

/*===================================================
  Implementación de operaciones con FECHAS
===================================================*/

bool TipoFecha::EsCorrecta(){

  if(dia<=0 || mes<=0 || anno<=0){
    return false;
  }
  switch (mes){
    case 1:
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    case 12:
      return (dia <= 31);
      break;
    case 4:
    case 6:
    case 9:
    case 11:
      return (dia <= 30);
      break;
    case 2:
      if(anno%4 == 0 && anno%100 != 0 || anno%400 == 0) {
        return (dia <= 29);
      } else {
        return (dia <= 28);
      };
      break;
    default:
      return false;
  }
}

void TipoFecha::Escribir(){
  printf("%2d-%s-%4d", dia, nombres[mes], anno);
}

void LeerMes( int & mes){
  TipoNombreMes nombre;
  bool encontrado;

  scanf("%s", nombre);
  if(isdigit(nombre[0])){
    mes = atoi(nombre);
  } else {
    mes = 13;
    encontrado = false;
    while (mes > 0 && !encontrado){
      mes--;
      encontrado =
        nombres[mes][0] == toupper(nombre[0]) &&
        nombres[mes][1] == tolower(nombre[1]) &&
        nombres[mes][2] == tolower(nombre[2]);
    }
  }
}

bool TipoFecha::Leer(){
  dia = 0;
  scanf("%d", &dia);
  if(dia == 0){
    return false;
  }
  LeerMes(mes);
  scanf("%d", &anno);
  if(anno < 100){
    anno = anno + 2000;
  }
  return true;
}

bool TipoFecha::EsPosterior(TipoFecha f){
  if(anno != f.anno){
    return (anno > f.anno);
  }
  if(mes != f.mes){
    return (mes > f.mes);
  }
  return (dia > f.dia);
}
void InsertarFecha( TipoFecha f ){
  int izquierda, derecha, centro;

  lista[numFechas] = f;
  numFechas++;
  izquierda = 0;
  derecha = numFechas-1;

  while (izquierda < derecha){
    centro = (izquierda+derecha)/2;
    if(f.EsPosterior(lista[centro])){
      izquierda = centro+1;
    } else {
      derecha = centro;
    }
  }
  for(int ind = numFechas-1; ind >= izquierda; ind--){
    lista[ind+1] = lista[ind];
  }
  lista[izquierda] = f;
}
/*===================================================
  Implementación de operaciones con FECHAS
===================================================*/
int main(){
  TipoFecha fecha;
  bool seguir;

  printf("Fechas leidas:\n");
  numFechas = 0;
  seguir = fecha.Leer();
  while (seguir && numFechas < maxFechas){
    fecha.Escribir();
    if(fecha.EsCorrecta()){
      InsertarFecha(fecha);
    }else{
      printf(" ** incorrecta **" );
    }
    printf("\n");
    seguir = fecha.Leer();
  }
  printf("\nFechas en orden:\n");
  for (int k=0;k<numFechas; k++){
    lista[k].Escribir();
    printf("\n");
  }

}
