/* AO2 Fundamentos de inteligencia artificial */
/* Maria Esther Rubio Serrano */

/*Constantes*/
amor.
interes.
deseo.
admiracion.

/*Hechos sin variables*/

amores(['No te asustes si sientes algo extra�o en el estomago, son mariposas','Tienes mucha suerte. Lucha por lo que sientes','Mira las cosas de forma positiva, no es lo peor que podria pasarte','Si sientes deseos de escapar te comprendo y te reservo un billete en avion','Eres una persona especial. Te gusta ir al cine?','Recuerda volver otro dia para contarme como te va','Me emociona que aun sigan existiendo personas como tu']).

intereses(['Admiro tu actitud ante la vida,�has pensado en dedicarte a la politica?','En esta vida hay mas personas interesadas que personas interesantes. Es una pena','Casi todo el mundo parece dispuesto a mentirse a si mismo pero no pueden aguantar que alguien mas les mienta. Eres adorable','�Y yo que pensaba que Judas estaba muerto!','Eres una persona tan falsa que deberias llevar una etiqueta que pusiese "Made in China"','Las mentes cerradas suelen tener siempre la boca abierta']).

deseos(['�Por que es tan dificil querer siendo tan facil desear?. Porque en el deseo habla la impotencia y en el querer la fuerza','Reflexiona sobre tus impulsos','Dime de lo que presumes y te dire de lo que careces','Recuerda, de aqui a cien a�os todos calvos. El fisico no es lo unico importante, no seas superficial']).

admiraciones(['Quizas estas idealizando demasiado a esa otra persona, prueba a ser mas realista','Si no te gusta estar siempre en el mismo lugar, muevete que no eres un arbol','Si sigues por ese camino va a acabar siendo tu amor platonico forever and ever']).

/*Evaluaci�n de SAQ en base a las respuestas del test*/
evaluacion(amor).
evaluacion(interes).
evaluacion(deseo).
evaluacion(admiracion).

/*Lista de puntuaciones seg�n la opci�n elegida como respuesta*/
puntuaciones([5,150,50,100]).

/*Hechos con variables dinamicas*/
:-dynamic puntuacion/1.
puntuacion([]). %Lista de los puntos del test
elemento(_).

/*Ejecuta la aplicaci�n*/

/* Men� de inicio de la aplicacion*/
iniciar :- tab(10),write('...........*..*'),nl,
tab(5),write('........*........*'),nl,
tab(5),write('.....*.............*'),nl,
tab(5),write('...*................*'),nl,
tab(5),write('..*..................*'),nl,
tab(5),write('.*....................*.......*..*'),nl,
tab(5),write('.*....................*...*........*'),nl,
tab(5),write('.*.....................*............*'),nl,
tab(5),write('..*.....................*..........*'),nl,
tab(5),write('...*..............................*'),nl,
tab(5),write('.....*..........................*'),nl,
tab(5),write('.........*.................*'),nl,
tab(5),write('.............*.........*'),nl,
tab(5),write('...............*....*'),nl,
tab(5),write('................*.*'),nl,
tab(5),write('.......... ......*'),nl,nl,
tab(5),write('Bienvenido al simulador para aprender a quererse o SAQ'),nl,
tab(5),write('Elije una de las siguientes opciones:'),nl,
tab(10),write('1) Averigua cuales son tus sentimientos.'),nl,

tab(10),write('2) Borrar pantalla.'),nl,
tab(10),write('3) Salir.'),nl,nl,
tab(5),write('Pulsa el numero de la opci�n elegida: '),
read(X),opcion(X).

opcion(1):-limpia,comenzar. %Realiza las preguntas del test
opcion(2):-limpia,iniciar. %Borra el menu de inicio.
opcion(3):-borrarListas,limpia. %Vacia la lista de las puntuaciones del test y sale de la aplicaci�n

/* Borramos los datos de la lista del test que inicialmente debe estar vac�a*/
borrarListas:-puntuacion(P),retract(puntuacion(P)),asserta(puntuacion([])).

/* Limpia la pantalla <- borra la pantalla */
limpia:-write('\033[2J').

/* Empiezan las 5 preguntas del test de compatibilidad*/
comenzar:-pregunta(1),pregunta(2),pregunta(3),pregunta(4),
	pregunta(5),nombre,repetir.

pregunta(1):-nl,tab(5),write('�Que es lo que te atrae de esa persona especial?'),nl,
	tab(10),write('1) No se que es lo que me pasa.'),nl,
	tab(10),write('2) Su dinero y su posicion social.'),nl,
	tab(10),write('3) Su cuerpo, es perfecto.'),nl,
	tab(10),write('4) Su inteligencia, puedo pasar horas escuchandole hablar sobre cualquier tema.')
	,nl,nl,tab(5),write('Elija una de las opciones: '),read(Y),
	respuesta(Y),limpia.

pregunta(2):-nl,tab(5),write('Te dice que tiene pareja, �como reaccionas?'),nl,
	tab(10),write('1) Me alejo inmediatamente, nunca pondria en peligro su relacion. Me conformo con saber que es feliz'),nl,
	tab(10),write('2) Me da igual siempre y cuando el anillo me lo acabe poniendo a mi.'),nl,
	tab(10),write('3) Me molesta pero me lo tomo como una competicion y me apunto al gimnasio para mejorar mis opciones. '),nl,
	tab(10),write('4) Intento comprender que es lo que le une a su actual relacion basandome en lo que me cuenta sobre mi rival.')
	,nl,nl,tab(5),write('Elija una de las opciones: '),read(Y),
	respuesta(Y),limpia.

pregunta(3):-nl,tab(5),write('Si te pidiesen que lo definieses con un solo adjetivo, �cual seria?'),nl,
	tab(10),write('1) Ni idea, es que es demasiadas cosas a la vez. Me siento incapaz de elegir.'),nl,
	tab(10),write('2) Rico.'),nl,
	tab(10),write('3) Guapo.'),nl,
	tab(10),write('4) Inteligente.')
	,nl,nl,tab(5),write('Elija una de las opciones: '),read(Y),
	respuesta(Y),limpia.

pregunta(4):-nl,tab(5),write('Si te enteras de que se encuentra en un lio, �como reaccionas?'),nl,
	tab(10),write('1) Lo ayudo sin pensarlo dos veces aunque acabemos siendo dos los que estan en apuros.'),nl,
	tab(10),write('2) Me esfumo por una temporada hasta que arregle sus historias raras.'),nl,
	tab(10),write('3) Estoy a su lado y aprovecho para intentar un acercamiento de tipo carnal.'),nl,
	tab(10),write('4) Le doy ideas para que lo pueda solucionar lo antes posible.')
	,nl,nl,tab(5),write('Elija una de las opciones: '),read(Y),
	respuesta(Y),limpia.

pregunta(5):-nl,tab(5),write('�Como crees que te ve?'),nl,
	tab(10),write('1) Ni idea, a veces le hago reir.'),nl,
	tab(10),write('2) Como el amor de su vida, le tengo loco por mis huesos.'),nl,
	tab(10),write('3) Es evidente que me ve como una persona muy atractiva y deseable'),nl,
	tab(10),write('4) Como alguien con quien se puede hablar de todo'),nl,nl,tab(5),write('Elija una de las opciones: '),read(Y),
	respuesta(Y),limpia.

/*Otros predicados y funciones auxiliares */

/* Funciones que devuelven la evaluacion,puntuaci�n y el nombre del usuario */
evaluacion(X,Y):-enamorado(Y,X,_).
puntuacion(X,Y):-enamorado(_,X,Y).
nombreE(X,Y):-enamorado(X,Y,_);enamorado(_,Y,X).

/* Funci�n que almacena en una lista cada opci�n respondida en preguntas */
respuesta(R):-puntuacion(P),elemento(E),puntuaciones(Puntos),
	recorreLista(Puntos,R,E),inserta(E,P,Nueva),
	asserta(puntuacion(Nueva)).

/* Le pide el nombre al usuario y calcula su puntuaci�n */
nombre:-nl,write('Por favor, escribe tu nombre: '),read(Name),puntuacion(Ptos),suma(Ptos,S),tipoEvaluacion(S,Eval),responder(Eval,Name,S).

/*Escribe un consejo seg�n la evaluaci�n obtenida en el test*/
responder(Eval,N,Pt):-tipoEvaluacion(Pt,Eval),nl,write(N),write(', has obtenido '),write(Pt),write(' puntos. Lo que sientes puede ser '),write(Eval),write('.'),nl,elijeConsejo(Eval,Lista),azarLista(Lista,Random),Consejo=Random,write(Consejo),write('.'),nl.

/* Asigna la evaluacion que obtendr�a el usuario seg�n la puntuaci�n obtenida en el test*/
tipoEvaluacion(Num,Eval):-Num=<25,Eval=amor,evaluacion(Eval);
        Num>=26,Num=<250,Eval=deseo,evaluacion(Eval);
        Num>=251,Num=<500,Eval=admiracion,evaluacion(Eval);
        Num>=501,Num=<750,Eval=interes,evaluacion(Eval).

/*Repetir el test y/n */
repetir:-nl,write('�Quiere repetir el test y/n?: '),read(Y),leer(Y).
leer(y):-puntuacion(P),retract(puntuacion(P)),asserta(puntuacion([])),limpia,comenzar.
leer(n):-limpia,volverMenu.

/* Vuelve al men� inicial */
volverMenu:-nl,write('�Quieres volver al men� inicial? y/n?:'),
	read(Y),leerM(Y).
leerM(y):-puntuacion(P),retract(puntuacion(P)),asserta(puntuacion([])),iniciar.
leerM(n):-opcion(3).

/* Funciones auxiliares para recorrer o insertar un elemento en una lista */
recorreLista([Y|_],1,Y). %Recorre la lista
recorreLista([_|Xs],N,Y):-N2 is N-1,recorreLista(Xs,N2,Y).
inserta(Y,Lista,[Y|Lista]). %Inserta un elemento en la lista

/* Suma todos los n�meros enteros de una lista */
suma([],0).
suma([P|Cola],Total):-suma(Cola,Aux),Total is Aux+P.

/*Eleccion del consejo que ofrece SAQ tras la realizacion del test*/
elijeConsejo(Eval,Lista):-Eval=amor,amores(Lista);Eval=interes,intereses(Lista);Eval=deseo,deseos(Lista);Eval=admiracion,admiraciones(Lista).
azarLista(Lista,Elegido):-length(Lista,Longitud),Indice is random(Longitud),nth0(Indice,Lista,Elegido).

