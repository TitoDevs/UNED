%El moderador se llama lysander.
%moderador(nombre_del_moderador).
moderador(lysander).

%Preparamos para assert y agregar mas nombres de sistemas inteligentes
:- dynamic(esSistema/1).
:- dynamic(sistemaDe/2).

%preparamos para algunos assert necesarios en la aplicacion.
%soyTipo/1 almacenara el tipo de fumador que somos utiliza para ello getTipoFumador y la lectura por teclado de los cigarros que fumamos.
%miNombre/1 almacenara nuestro nombre que es leido por el sistema de IA al inicio de la aplicacion.
%sistema/IA almacenara sistema que nos gestiona es simplemente un capricho poder comunicarte con una IA FAMOSAAAAAAA, esto aumenta siempre
%el ego de los informaticos, :)
:- dynamic(soyTipo/1).
:- dynamic(miNombre/1).
:- dynamic(sistemaIA/1).

%Estos van a ser los posibles nombres de los sistemas inteligentes, que se van a encargar
%de encontrar recoger datos, procesarlos y supuestamente ponernos en comunicacion a los miembros.
%esSistema(nombre_delSistema_inteligente)
esSistema(jarvis).
esSistema(viki).
esSistema(ariia).
esSistema(sally).
esSistema(ava).
esSistema(kyoko).
esSistema(reina_roja).
esSistema(skynet).
esSistema(echelon).

%Estos hechos no los vamos a utilizar en la app, pero pueder se util como ejemplo para lanzar consultas,
%para saber a que pelicula pertenece cada maquina o a partir de la pelicula cual era su maquina
%sistemaDe(nombre_del_sistema,pelicula_en_la_que_sale)
sistemaDe(jarvis,ironman).
sistemaDe(viki,yo_robot).
sistemaDe(ariia,la_conspiracion_del_panico).
sistemaDe(sally,oblivion).
sistemaDe(ava,the_machine).
sistemaDe(kyoko,exmachine).
sistemaDe(reina_roja,resident_evil).
sistemaDe(skynet,terminator).
sistemaDe(echelon,la_conspiracion_del_poder).

%lista de miembros
%miembro([lista_nombre_de_miembros])
miembros([calisto,dianthe,acantha,argus,basha]).

%lista de triplas para saber datos de cada fumador
%miembroEs([(nombre_del_miembro, tipo_de_Fumador,anyos_comenzo_a_fumar)])
miembroEs([(calisto,drogodependiente,20),(dianthe,pasivo,0),(acantha,negativo,21),(argus,hedonista,18),(basha,cronico,19)]).

%Cada miembro tiene sus respuestas
%dupla de miembro y lista de duplas con franja y respuesta.
%respuestas(nombre_miembro,[franja_horaria,repuesta])
respuestas(calisto,[
				(madrugada,'Que tu tambien ocupado, pues cambia de rutina, cambia de sitio del que estas habitualmente.'),
				(mananna,'Me parece que en vez de cafe, vamos a cambiar a zumo, cambia de habitos.'),
				(mediodia,'Que se esta haciendo larga, porque no piensas en que los tuyos quieren que dejes de fumar.'),
				(despuesComer,'Ve rapido a lavarte los dientes y siestita muy rica.'),
				(tarde,'Dejalo ya, no pienses mas en el tabaco, con lo que te vas a ahora tio, NOS VAMOS DE VACACIONES!!!!'),
				(noche,'No era tan dificil, salimos a dar un paseo, duchita y al nono, total pa lo que queda no lo vamos a estropear.'),
				(fuera_rango,'No te entiendo tron, veo que tas muy necesitado de tabaco, olvidalo.'),				
				(saludo,'Vaya dia y ahora esto otra reunion.'),
				(empece_a_fumar,'Con los colegas,las malas companias. Le tenia que haber hecho caso a mi madre, aunque ella tambien fumaba.')
				]).
				
respuestas(dianthe,[
				(madrugada,'Ohhhhh, porque molestas, si yo voy a la reunion solo por conocer gente.'),
				(mananna,'Bua no calientes el ambiente, desayuna y no contamines a los demas.'),
				(mediodia,'Que pasa siempre igual con el tabaco, olvidate de el es facil, mira yo no fumo y vivo.'),
				(despuesComer,'Para que fumar ahora, no lo hagas, total pa na, dinero perdido.'),
				(tarde,'Mil cosas antes de fumar, un rato por aqui otro rato por alli,y a lo mejor no fumas.'),
				(noche,'Pero porque molestas, te he dicho que no fumo, no puedo ayudarte mas.'),
				(fuera_rango,'Y encima no sabes ni que hora es, telita, anda relajate un ratito.'),
				(saludo,'Que conste que yo no fumo, pero bueno asi os conozco, soy dianthe.'),
				(empece_a_fumar,'Pues en la cafeteria del curro')
				]).
				
respuestas(acantha,[
				(madrugada,'Todavia estas despierto, un vasito de leche y a dormir te vendria muy bien.'), 
				(mananna,'Hola que tal te has despertado, hace un cafecito para empezar el dia, y nos olvidamos el humo.'),
				(mediodia,'Dia largo o que, unos cicles de menta.'),
				(despuesComer,'Que tal la comida, mejor cuando no fumas, sabe hasta mas rica.'),
				(tarde,'Vaya tarde bonita donde hacer mil cosas, relax y no fumes.'),
				(noche,'Uf, se nos fue el dia y no hemos fumado, coge pulsometro un ratito de footing ducha y a dormir.'),
				(fuera_rango,'Me parece que llevas unas copitas de mas tambien, a esta hora no puedo decirte nada'),
				(saludo,'Hola amigos, soy acantha que tal estais?'),
				(empece_a_fumar,'Pues en la cafeteria del curro con unas compañeras, un pitillo para desestresar y ...')
				]).

respuestas(argus,[
				(madrugada,'Vaya horitas, porque no estas durmiendo, el suenno tambien hay que disfrutarlo.'), 
				(mananna,'Vamos otra mannana por la que alegrarnos, un buen desayuno nos iria de lujo y rapidito a la faena.'),
				(mediodia,'Que bueno, anda que no queda dia, segue un ratito con lo tuyo.'),
				(despuesComer,'Me quede lleno, una comida sin humos riquisima.'),
				(tarde,'Disfruta un rato mas del día, anda que no nos quedan horas.'),
				(noche,'cri,cri, escucha lo que te rodea, ve a la ventana, cuantos puntos luminosos por encima de nosotros, quedate ahi un ratito'),
				(fuera_rango,'Ui,ui, no creo que nos entendamos en las horas, que son,'),
				(saludo,'Que tal companneros soy argus.'),
				(empece_a_fumar,'Jugando a las cartas con unos amigos, me ofrecieron un habano y me enganche.')
				]).

respuestas(basha,[
				(madrugada,'A estas horas, antes de dormir un cigarrillo no es lo mas apropiados, porque no te lavas los dientes y a dormir.'),
				(mananna,'Desayunamos y despues unos caramelitos para calmarnos.'),
				(mediodia,'Olvidate de fumar, pero es que se hace muy largo el tiempo hasta comer, unos mentolines??'),
				(despuesComer,'Uff, ese cigarrillo despues de comer, pero hay que hecharle ganas, un cafecito??'),
				(tarde,'Vamos a ganar esta batalla, que tal tus amigos, los visitamos??'),
				(noche,'Que muchas ganas de fumar, pos vamos a cambiarlo por disfrutar de una pelicula.'),
				(fuera_rango,'Vaya tela marinera, esa hora no la conozco, venga olvidate del cigarrillo.'),				
				(saludo, 'Hi brothers and sister, que tal estais yo soy basha.'),
				(empece_a_fumar,'Fue rutina, me ofrecieron en el cafe, otro y otro, y cuando me di cuenta, ya fumaba de mas.')
				]).





%lista de tuplas de tipos de fumadores y su descripcion
%fumador([(tipo_de_fumador, descripcion_del_tipo_de_fumador)])
fumador([
	(drogodependiente, 'fuma constantemente uno tras otro'),
	(cronico, 'fuma sin ser consciente de ello y no sabe porque fuma'),
	(hedonista,'es el fuma de forma controlada por placer'),
	(negativo,'es el que fuma cuando esta nervioso'),
	(pasivo, 'no fuma pero es afectado por el uso de otros')
	]).
