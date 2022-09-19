%-------------------------------------------------------------------------
% Actividad Obligatoria 2 de Fundamentos de Inteligencia Articial 2015/16
% Buenaventura Salcedo Santos-Olmo 
% ------------------------------------------------------------------------

%carga ficheros auxiliares
:-[constantes].
:-[hechos].

%Devuelve una lista a partir de todos los hechos de esSistema
%listaSistemas(devuelve_lista_de_los_nombre_de_las_IA)
listaSistemas(Lista):- 	findall((Nombre), esSistema(Nombre), L),Lista = L.

%Selecciona al azar un sistema de IA que nos gestione la interfaz
seleccionarSistemaAzar:-
	listaSistemas(Lista),
	length(Lista,N),
	random(1,N,V),
	seleccionarElementoN(Lista,V,Elemento), 
	Hecho = sistemaIA(Elemento),asserta(Hecho).
	
%Cambia el sistema de IA que nos gestiona la interfaz AL AZAR, borra primero el hecho sistemaIA(nombre) que exista actualmente 
cambiarSistemaAzar:- retract(sistemaIA(_)), seleccionarSistemaAzar.

%Cambia el sistema de IA que nos gesiona la interfaz utilizando el que le pasamos como parametro.
%cambiaSistema(nombre_de_la_IA)
cambiarSistema(X):- retract(sistemaIA(_)),Hecho = sistemaIA(X),asserta(Hecho).

%Realiza un assert con la IA que nos gestiona la interfaz. Vamos inserta un hecho.
%agregarSistema(nombre_de_la_IA_nueva)
agregarSistema(X):-	Hecho = esSistema(X),asserta(Hecho).

%Realiza un assert con la IA y la pelicula o situacion a la que pertenece. Vamos inserta un hecho con 2 valores.
%agregarPelicula(nombre_de_la_IA,pelicula_a_la_que_pertence)
agregarPelicula(X,Y):- Hecho = sistemaDe(X,Y),asserta(Hecho).

%Realiza un retract con la IA y tambien el hecho que indica a que pelicula pertenecia. Vamos borra un hecho de la BH.
%quitarSistema(nombre_de_la_IA_a_borrar)
quitarSistema(X):- retract(esSistema(X)), retract(sistemaDe(X,_)).

%Funcion recursiva que nos devuelve el elemento que hay en la posicion N de una lista.
%seleccionarElementoN(lista,posicion,elemento_a_devolver)
seleccionarElementoN([E|_],1,E):- !.
seleccionarElementoN([_|L],N,E):- M is N-1, seleccionarElementoN(L,M,E).

%le pasamos nuestro nombre para introudcirlo en el sistema. inserta un hecho a la BC
%insertaMe(mi_nombre)
insertaMe(Nombre) :- Hecho = miNombre(Nombre), asserta(Hecho).

%le pasamos los cigarrillos que fumamos, determina que tipo de fumador somosy lo inserta en la BC
%insertaTipo(numero_de_cigarros_que_fuma)
insertaTipo(NCigarros) :- getTipoFumador(NCigarros,TipoFumador), Hecho = soyTipo(TipoFumador), asserta(Hecho).

%define cada tipo de fumador a partir del numero de cigarros que fuma
%getTipoFumador(Numero_cigarrillos,Tipo_Fumador)
getTipoFumador(N,pasivo):- N == 0, !.
getTipoFumador(N,negativo):- N > 0, N =< 3 ,!.
getTipoFumador(N,hedonista):- N > 3 , N =< 10, !.
getTipoFumador(N,cronico):- N > 10, N =< 20, !.
getTipoFumador(_,drogodependiente).

%imprime el listado de miembros que hay en la lista que le pasamos, y la imprime utilizando recursividad.
%muestraMiembros(Lista_de_triplas_nombre_tipo_anyosQueEmpezoAFumar)
muestraMiembros([]):-!.
muestraMiembros([(N,T,_)|L]) :- write(N), write(' es '), write(T), nl,
	muestraMiembros(L).

%Utilizando recursividad imprimos la lista que le pasamos con los tipos de fumadores y una descripcion
%muestraFumadores(Lista_de_duplas_tipo_descipcion)
muestraFumadores([]) :- !.
muestraFumadores([(T,D)|L]) :- write(T), write(' '), write(D), nl,
	muestraFumadores(L).

%busca en la lista de tipos de fumadores la descripcion de ese tipo de fumador
%getDescripcionFumador(tipo_fumador,lista_tipos_fumadores,descripcion)	
getDescripcionFumador(_,[],'indefinido'):-!.
getDescripcionFumador(E,[(E,D)|_],D):-!.
getDescripcionFumador(E,[_|L],D):- getDescripcionFumador(E,L,D).

%busca un fumador de la lista y devuelve su nombre.
%coge esta lista de duplas de miembros con tipo y devuelveme en Y un nombre que coincida con ese tipo X
%sino esta consideraremos que no fuma es pasivo.
%getNombre(tipo_fumador,lista,nombre_miembro)
%getNombreDelTipo(_,[],'pasivo'):- !.
getNombreMiembroDel(T,[(N,T,_)|_],N):- !.
getNombreMiembroDel(T,[_|L],A):- getNombreMiembroDel(T,L,A).

%devuelve el tipo de fumador a partir del nombre en la lista de triplas que le pasamos
%getTipoDe(nombre,lista,tipo_fumador_devuelto)
getTipoDe(N,[(N,T,_)|_],T):- !.
getTipoDe(N,[_|L],A):- getTipoDe(N,L,A).

%Calcula franja horaria a partir del valor entero que le pasamos, para seleccionar despues los comentarios de cada miembro a esa hora
%franjaHoraria(hora_que_es,nombre_de_la_franja_correspondiente)
franjaHoraria(Hora,Franja):-
	Hora >= 0  , Hora < 7  , Franja = madrugada,! ;
	Hora >= 7  , Hora < 11 , Franja = mannana,! ;
	Hora >= 11 , Hora < 14 , Franja = mediodia,! ;
	Hora >= 14 , Hora < 16 , Franja = despuesComer,! ;
	Hora >= 16 , Hora < 20 , Franja = tarde,! ;
	Hora >= 20 , Hora < 24 , Franja = noche,! ;
	Hora >= 24             , Franja = fuera_rango,! ;
	Hora < 0               , Franja = fuera_rango,!.

%Muestra una sencilla descripcion de nuestro nombre, y el tipo de fumador que somos, leyendo la BC
describeme:- nl, nl,
	miNombre(MiNombre), write(MiNombre), write(' eres un fumador del tipo '),
	soyTipo(TipoFumador), write(TipoFumador), write(', es decir, '),
	fumador(ListaTiposFumadores),
	getDescripcionFumador(TipoFumador,ListaTiposFumadores,Descripcion),
	write(Descripcion), nl.

%Devuelve una lista de duplas con las respuestas de todos los miembros con ese atributo, 
%que sirve de selector en la lista de duplas de respuesta de cada miembro
%getRespuestasTodosMiembrosConAtributo(atributo_ejemplo_franjahoraria,lista_a_devolver_con_las_respuestas_de_todos_a_esa_hora)
getRespuestasTodosMiembrosConAtributo(Atributo,L):-
	miembros(ListaMiembros),
	getRespuestasMiembros(Atributo,ListaMiembros,ListaDuplas),
	L = ListaDuplas.

%Busca las respuestas quedan al atributo que se le pasa, con un listado de los miembros
%getRespuestasMiebros(atributo,lista_de_miembros,devuelve_lista_duplas_mibembro_comentario)
getRespuestasMiembros(_,[],[]):- !.
getRespuestasMiembros(A,[C|L],[(C,D)|Lista]):-
	respuestas(C,LR),
	getDescripcionAtributo(A,LR,R),
	D = R,
	getRespuestasMiembros(A,L,Lista).

%Busca las repuestas de un miembro en la lista de duplas
%getRespuestaDelMiembro(nombre,lista_duplas,respuesta_devuelta__de_ese_miembro)
getRespuestaDelMiembro(N,[(N,R)|_],R):- !.
getRespuestaDelMiembro(N,[_|L],A):- getRespuestaDelMiembro(N,L,A).

%Busca recursivamente en una lista de duplas el atributo que pasamos en el primer elemento y devuelve el segundo
%getDescripcionAtributo(atributo_a_buscar,lista_de_duplas,descripcion_a_devolver)
getDescripcionAtributo(_,[],'sin comentarios'):-!.
getDescripcionAtributo(A,[(A,D)|_],D):-!.
getDescripcionAtributo(A,[_|L],D):- getDescripcionAtributo(A,L,D).

%muestra por pantalla las contestaciones de los miembros el atributo pasado.
muestraRespuestas([]):-!.
muestraRespuestas([(N,T)|L]) :- write(N),write(' dice: '), write(T), nl,
	muestraRespuestas(L).

%queDice(nombreMiembro,Hora)
queDice(X,H,R):-
	franjaHoraria(H,Atributo),
	respuestas(X,L),
	getDescripcionAtributo(Atributo,L,QueDice),
	R = QueDice,!.
%imprime por pantalla lo que dice ese miembro a cierta hora.
%muestraQueDice(nombre_miembro,Hora)
muestraQueDice(X,H):- queDice(X,H,R),nl,
	write('La respuesta que da '), write(X),write(' a las '),write(H), write(' es '),write(R), nl .
		
%da un consejo a partir de la hora y tipo de fumador, busca un miembro de ese tipo de fumador, devulve su nombre y el repuesta.
%darConsejo(hora,tipo_fumador,nombre_del_miembro_que_va_a_contestar, respuesta)
darConsejo(Hora,TipoFumador,Nombre,Consejo):-
	franjaHoraria(Hora,Atributo),
	miembroEs(L),
	getNombreMiembroDel(TipoFumador,L,N),
	getRespuestasTodosMiembrosConAtributo(Atributo,LR),
	getRespuestaDelMiembro(N,LR,R),
	Consejo = R, Nombre = N .	
	
%Limpia la pantalla
limpiar:- write('\033[2J').

%iniciacion de la app,limpia pantalla -  presentacion moderador - eleccion de la IA y presentacion - peticion de algunos datos para assert - 
%se inciian conversaciones - se habilita la interfaz de dialogo gestionada por el sistema de IA.
inicio :- 
	limpiar ,
	moderador(Moderador),
	write('*'),write(Moderador),write(' dice: '),nl,
	write('Acabas de entrar en el mundo virtual de una sesion para dejar de fumar'), nl,nl,
	write('Se va a seleccionar uno de los siguientes Sistemas de IA para que se comunique contigo e interactue con tu interfaz: '),nl,
	listaSistemas(ListaSistemas),write(ListaSistemas),seleccionarSistemaAzar,nl,
	write('Se ha elegido al azar a: '),
	sistemaIA(IA),sistemaDe(IA,Pelicula),write(IA),nl,nl,
	write('Soy el moderador de la sesion, mi nombre es '),
	write(Moderador),
	write('el resto de miembros son fumadores y conversando y con terapia entre unos y otros vamos a intentar conseguir dejar de fumar'), nl,nl,
	write('>>>'),write(IA),write(' dice: '),
	write('Hola soy '),write(IA),write(' el Sistema de Inteligencia Artificial, provengo de '),write(Pelicula),write(' y necesito un par de datos. '),nl,
	write('Dime tu nombre (Teclea los espacios con "_") : '),read(Nombre), insertaMe(Nombre), nl,
	write('>>>'),write(IA),write(' dice: '),
	write('Dime el numero de cigarrillos que fumas al dia (Teclea numero entero) : '),read(NCigarros),insertaTipo(NCigarros),nl,
	write('*'),write(Moderador),write(' dice: '),write('Un saludo a todo el grupo.'), nl, nl,
	getRespuestasTodosMiembrosConAtributo(saludo,LS),muestraRespuestas(LS), nl,
	write('*'),write(Moderador), write(' dice: '), write('Por favor '), miNombre(Yo),write(Yo), write(' no seas timido, dedicanos un saludo. (Teclea entre apostrofes)'), nl,nl,
	write(Yo), write(' dice: '), read(_), nl,
	write('*'),write(Moderador),write(' dice: '),write('Bueno ahora quiero escuchar como comenzasteis a fumar'),nl,nl,
	getRespuestasTodosMiembrosConAtributo(empece_a_fumar,LEAF),muestraRespuestas(LEAF), nl,
	write('*'),write(Moderador), write(' dice: Y tu '), write(Yo), write(' como comenzaste a fumar?? (Teclea entre apostrofes)'),nl,nl,
	write(Yo), write(' dice: '), read(_), nl,
	write('*'),write(Moderador), write(' dice: '),write('Bueno podemos seguir hablando de nuestras cosas'),nl,
	write('...'),nl,write('...'),nl,write('...unos hablan...siguen...conversando...'),nl,write('...'),nl,nl,
	write('***DESPUES DE VARIOS MINUTOS U HORAS CONVERSANDO...***'),nl,nl,
	write('*'),write(Moderador), write(' dice: '),write(IA),write(' os deja abierta esta interfaz, para que podais comunicaros o solicitarle informacion.'),nl,nl,
	linea_de_comandos.

	
%Imprimir menu de opciones
menu:- nl, nl,sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),nl,
	write('Deseas alguna información, hazmelo saber eligiendo el numero'),nl,
	write('************************************************************'),nl,
	write('1.- Conocer tipos de fumadores'),nl,
	write('2.- Saber que tipo de fumador soy'),nl,
	write('3.- Conocer a los miembros del grupo'),nl,
	write('4.- Pedir ayuda a un compañero de tu tipo'),nl,
	write('5.- Pedir ayuda al compañero que elijas'),nl,
	write('6.- Pedir ayuda a todos'),nl,nl,
	write('-- Operaciones con el Sistema IA --'),nl,
	write('11.- Nombre del Sistema IA'),nl,
	write('12.- Agregar un Sistema IA'),nl,
	write('13.- Mostrar Sistema IA disponibles'),nl,
	write('14.- Cambiar de Sistema IA al azar'),nl,
	write('15.- Cambiar de Sistema IA por el que elijamos'),nl,
	write('16.- Quitar un Sistema IA del listado'),nl,
	write('20.- Irnos de aqui'),nl,
	write('(Teclea numero entero)'),nl,
	read(Opcion), ejecutar(Opcion).
	
% prompt ligero de lectura de opciones para no imprimir siempre el menu
linea_de_comandos:- nl,sistemaIA(IA),
	write('>>>'),write(IA),write(' dice: '),
	write('Esperando numero entero de opcion, teclea 0. para recibir ayuda.'),
	read(O), ejecutar(O).
	
%Una vez elejida la opcion la procesamos
%ejecutar(Numero_de_la_Opcion)
ejecutar(Opcion):- 
	Opcion == 0, menu;
	Opcion == 1, nl,sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),nl,
				fumador(L),muestraFumadores(L), linea_de_comandos;				
	Opcion == 2, nl,sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),nl,
				describeme, linea_de_comandos;
	Opcion == 3, nl,sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),nl,
				miembroEs(L),muestraMiembros(L), linea_de_comandos;
	Opcion == 4, nl, 
				sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),
				write('Que hora es?? (Teclea numero entero) : '),
				read(Hora),soyTipo(Tipo),
				darConsejo(Hora,Tipo,NombreMiembro,Consejo),
				write(NombreMiembro),write(' dice: Soy de tu mismo tipo de fumador deberias '),
				write(Consejo), nl, linea_de_comandos;
	Opcion == 5, nl, 
				sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),write('Te recuerdo que los miembros son:'),nl,
				miembros(L),write(L),nl,
				write('>>>'),write(IA),write(' dice: '),write('Teclea el miembro al que quieres pedir ayuda: (Teclea sin espacios)'),
				read(M),
				sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),write('Que hora es?? (Teclea numero entero) : '),
				read(H),nl,
				queDice(M,H,R),
				write(M),write(' dice: '),write(R),nl, linea_de_comandos;
	Opcion == 6, nl, sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),
				write('Que hora es?? (Teclea numero entero) : '),
				read(H),nl,
				franjaHoraria(H,Atributo),
				getRespuestasTodosMiembrosConAtributo(Atributo,LEAF),
				muestraRespuestas(LEAF),nl,linea_de_comandos;
	Opcion == 11,nl, sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),
				sistemaDe(IA,Pelicula),
				write('El sistema actual de IA its me: '), write(IA),write(' de la pelicula '), write(Pelicula),nl,linea_de_comandos;
	Opcion == 12, nl, sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),
				write('Que nombre de sistema de IA quieres agregar?? (Teclea los espacios con "_") : '), read(Sistema),nl,
				write('A que pelicula o a que pertenece ese nombre?? (Teclea los espacios con "_") : '), read(Pelicula),nl,
				agregarSistema(Sistema),
				agregarPelicula(Sistema,Pelicula),
				listaSistemas(ListaSistemas),write(ListaSistemas),nl,linea_de_comandos;
	Opcion == 13, nl,sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),
				write('La lista de sistema de IA disponibles es: '),nl,
				listaSistemas(ListaSistemas),write(ListaSistemas),nl,linea_de_comandos;
	Opcion == 14, nl, sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),
				cambiarSistemaAzar,
				write('El nuevo sistema de IA, va a ser: '),sistemaIA(NuevoIA),write(NuevoIA), nl, linea_de_comandos;
	Opcion == 15, nl, sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),
				write('Estos son los sistemas de IA disponibles, escribe por el que quieres cambiar: '),nl,
				listaSistemas(ListaSistemas),write(ListaSistemas),nl, read(Sistema),
				cambiarSistema(Sistema),
				write('El nuevo sistema de IA, va a ser: '),sistemaIA(NuevoIA),write(NuevoIA), nl, linea_de_comandos;
	Opcion == 16, nl, sistemaIA(IA),write('>>>'),write(IA),write(' dice: '),
				write('Estos son los sistemas de IA disponibles, escribe el que quieres eliminar:'),nl,
				listaSistemas(ListaSistemas),write(ListaSistemas),nl, read(Sistema),
				quitarSistema(Sistema),
				write('La lista de sistemas de IA disponibles es: '),nl,
				listaSistemas(ListaSistemas2),write(ListaSistemas2),nl,linea_de_comandos;		
	Opcion == 20, nl, nl, write('Bye hasta otro momento').