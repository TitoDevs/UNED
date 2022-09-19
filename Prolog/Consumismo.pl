%----------------------------------------------------------------------
% TitoDev                              
% ---------------------------------------------------------------------

%Constantes
habitual.
ocasional.
experimentacion.
compulsivo.

%Hechos sin variables
habituales(['Evita la frase: date un caprichito, hombre', 'Buscate un hobby para evitar compras','No improvises, planea tu compra']).
ocasionales(['Sigue asi', 'Siguiendo estos pasos te ayudaras a ti personalmente y al planeta','Si ves que alguien tiene problemas con las compras compulsivas, ayudale']).
experimentacionales(['Recuerda que puedes evitar algunas compras','Tener un producto antes que otra persona no te hace mejor', 'Piensa antes de comprar un producto']).
compulsivos(['No improvises, planea tu compra. Haz una lista de lo que quieres','No compres cuando estés triste. No sustituyas una emoción porque las cosas no reconfortan','Cuando vayas de compras, ve con otra persona. Un amigo o familiar puede ser tu respaldo']).

%Evaluacion en base de las respuestas obtenidas
evaluacion(habitual).
evaluacion(ocasional).
evaluacion(experimentacion).
evaluacion(compulsivo).

%Lista de puntuaciones segun la eleccion escogida
puntuaciones([5,150,50,100]).

%Hechos con variables dinamicas
:-dynamic puntuacion/1.
puntuacion([]). /*Lista de los puntos del test*/
elemento(_).

%Ejecuta la aplicacion

%Menu inicial
iniciar :- tab(10),write('Bienvenido al simulador para averiguar que nivel de consumismo tienes'),nl,
tab(5),write('Elije una de las siguientes opciones:'),nl,
tab(10),write('1) Averiguar mi nivel de consumismo.'),nl,
tab(10),write('2) Tipos de consumismo.'),nl,
tab(10),write('3) Borrar pantalla.'),nl,
tab(10),write('4) Salir.'),nl,nl,
tab(5),write('Pulsa el numero de la opcion elegida: '),
read(X),opcion(X).

opcion(1):-limpia,comenzar. %Realiza las preguntas del test
opcion(2):-limpia,tipos. %Borra el menu de inicio.
opcion(3):-limpia,iniciar. %Lista de tipos de consumismo
opcion(4):-borrarListas,limpia. %Vacia la lista de las puntuaciones del test y sale de la aplicacion

%Borramos los datos de la lista del test que inicialmente debe estar vacia
borrarListas:-puntuacion(P),retract(puntuacion(P)),asserta(puntuacion([])).

%Limpia la pantalla <- borra la pantalla
limpia:-write('\033[2J').

%Empiezan las 5 preguntas del test de compatibilidad
comenzar:-pregunta(1),pregunta(2),pregunta(3),pregunta(4),
	pregunta(5),nombre,repetir.

pregunta(1):-nl,tab(5),write('Cuando sales, ¿gastas mas dinero del que te habias propuesto?'),nl,
	tab(10),write('1) Normalmente gasto menos.'),nl,
	tab(10),write('2) Gasto el que tengo y el de mis amigos.'),nl,
	tab(10),write('3) Soy mas agarrao que los tornillos de un submarino.'),nl,
	tab(10),write('4) Cumplo con todo lo que me propongo.')
	,nl,nl,tab(5),write('Elija una de las opciones: '),read(Y),
	respuesta(Y),limpia.

pregunta(2):-nl,tab(5),write('¿Tu estado animico esta relacionado con la posibilidad de comprar?'),nl,
	tab(10),write('1) Para nada, me alegro con saber que tengo lo justo y necesario.'),nl,
	tab(10),write('2) Si no estreno una prenda nueva a la semana, no soy persona.'),nl,
	tab(10),write('3) Soy feliz con ver la puesta de sol.'),nl,
	tab(10),write('4) Pues la verdad es que si no compro algo, aunque no sea necesario, me pone triste.')
	,nl,nl,tab(5),write('Elija una de las opciones: '),read(Y),
	respuesta(Y),limpia.

pregunta(3):-nl,tab(5),write('¿Has comprado algo esta semana que realmente no necesitabas?'),nl,
	tab(10),write('1) Me entran ganas pero luego pienso si lo voy a utilizar y al final no lo compro.'),nl,
	tab(10),write('2) Pues algo he comprado.'),nl,
	tab(10),write('3) Pues la verdad es que no.'),nl,
	tab(10),write('4) Si, pero lo regalo.')
	,nl,nl,tab(5),write('Elija una de las opciones: '),read(Y),
	respuesta(Y),limpia.

pregunta(4):-nl,tab(5),write('¿Has mentido sobre tus gastos reales?'),nl,
	tab(10),write('1) Pues creo que no.'),nl,
	tab(10),write('2) Si, me da bastante verguenza decir todo lo que gasto a la semana.'),nl,
	tab(10),write('3) Nunca, digo lo que he gastado y fin.'),nl,
	tab(10),write('4) Alguna vez si que he mentido.')
	,nl,nl,tab(5),write('Elija una de las opciones: '),read(Y),
	respuesta(Y),limpia.

pregunta(5):-nl,tab(5),write('¿Dices siempre la verdad si tienes que justificar o explicar por que has comprado algo?'),nl,
	tab(10),write('1) He dicho mas mentiras que verdades.'),nl,
	tab(10),write('2) Muchas veces he dicho mentiras porque si no mi familia me echa la bronca.'),nl,
	tab(10),write('3) Si, para que mentir.'),nl,
	tab(10),write('4) He dicho mas mentiras que verdades')
	,nl,nl,tab(5),write('Elija una de las opciones: '),read(Y),
	respuesta(Y),limpia.

%Muestra la lista de los tipos de consumismo
tipos :- tab(10),write('Tipos de consumismo:'),nl,
tab(10),write('- Consumismo ocasional: Sucede cuando el acto de consumismo se produce en pocas ocasiones y se trata, sobre todo, de ocasiones especiales.'),nl,
tab(10),write('- Consumismo experimental: Se produce cuando el comprador se interesa en probar el funcionamiento de los nuevos productos del mercado y quiere hacerlo antes que otras personas.'),nl,
tab(10),write('- Consumismo habitual: Los casos de consumismo habitual son aquellos que se generan de forma recurrente, ya forman parte del estilo de vida de una persona o de una familia completa.'),nl,
tab(10),write('- Consumismo compulsivo: Se genera cuando se realizan compras nerviosas ante un evento extraordinario en la sociedad o en la vida del comprador.'),nl,nl,
tab(5),write('¿Quieres volver al menu inicial?: '),read(Y),leerL(Y).
leerL(y):-limpia,iniciar.
leerL(n):-opcion(4).

%Otros predicados y funciones auxiliares

%Funciones que devuelven la evaluacion, puntuacion y el nombre del usuario
evaluacion(X,Y):-consumismo(Y,X,_).
puntuacion(X,Y):-consumismo(_,X,Y).
nombreE(X,Y):-consumismo(X,Y,_);consumismo(_,Y,X).

%Funcion que almacena en una lista cada opcion respondida en preguntas
respuesta(R):-puntuacion(P),elemento(E),puntuaciones(Puntos),
	recorreLista(Puntos,R,E),inserta(E,P,Nueva),
	asserta(puntuacion(Nueva)).

%Le pide el nombre al usuario y calcula su puntuacion 
nombre:-nl,write('Por favor, escribe tu nombre: '),read(Name),puntuacion(Ptos),suma(Ptos,S),tipoEvaluacion(S,Eval),responder(Eval,Name,S).

%Escribe un consejo segun la evaluacion obtenida en el test
responder(Eval,N,Pt):-tipoEvaluacion(Pt,Eval),nl,write(N),write(', has obtenido '),write(Pt),write(' puntos. Tu tipo de consumismo es '),write(Eval),write('.'),nl,elijeConsejo(Eval,Lista),azarLista(Lista,Random),Consejo=Random,write(Consejo),write('.'),nl.

%Asigna la evaluacion que obtendra el usuario segun la puntuacion obtenida en el test
tipoEvaluacion(Num,Eval):-Num=<25,Eval=habitual,evaluacion(Eval);
        Num>=26,Num=<250,Eval=ocasional,evaluacion(Eval);
        Num>=251,Num=<500,Eval=experimentacion,evaluacion(Eval);
        Num>=501,Num=<750,Eval=compulsivo,evaluacion(Eval).

%Repetir el test y/n
repetir:-nl,write('¿Quiere repetir el test y/n?: '),read(Y),leer(Y).
leer(y):-puntuacion(P),retract(puntuacion(P)),asserta(puntuacion([])),limpia,comenzar.
leer(n):-limpia,volverMenu.

%Vuelve al menu inicial
volverMenu:-nl,write('¿Quieres volver al menu inicial? y/n?:'),
	read(Y),leerM(Y).
leerM(y):-puntuacion(P),retract(puntuacion(P)),asserta(puntuacion([])),iniciar.
leerM(n):-opcion(4).

%Funciones auxiliares para recorrer o insertar un elemento en una lista
recorreLista([Y|_],1,Y). %Recorre la lista
recorreLista([_|Xs],N,Y):-N2 is N-1,recorreLista(Xs,N2,Y).
inserta(Y,Lista,[Y|Lista]). %Inserta un elemento en la lista

%Suma todos los numeros enteros de una lista
suma([],0).
suma([P|Cola],Total):-suma(Cola,Aux),Total is Aux+P.

%Eleccion del consejo tras la realizacion del test
elijeConsejo(Eval,Lista):-Eval=habitual,habituales(Lista);Eval=ocasional,ocasionales(Lista);Eval=experimentacion,experimentacionales(Lista);Eval=compulsivo,compulsivos(Lista).
azarLista(Lista,Elegido):-length(Lista,Longitud),Indice is random(Longitud),nth0(Indice,Lista,Elegido).
