#include<stdio.h>
#include<time.h>
#include<stdlib.h>

int main(){
   int secreto;
   int intentos = 3;
   int n;

   srand(time(NULL));
   secreto = rand() % 20;

  while(intentos > 0){
    printf("Dime un numero del 1 al 20 \n");
    scanf("%d", &n);
    intentos--;

    if(n<secreto){
      printf("Incorrecto: el n secreto es mayor. Te quedan %d intentos\n", intentos);
      if(intentos==0){
          printf("GAME OVER. El numero secreto era %d", secreto);
        }
    }else{
      if(n>secreto){
        printf("Incorrecto: el n secreto es menor. Te quedan %d intentos\n", intentos);
        if(intentos==0){
          printf("GAME OVER. El numero secreto era %d", secreto);
        }
      }else{
        printf("Correcto\n");
      }
    }
  }
  return 0;
}
