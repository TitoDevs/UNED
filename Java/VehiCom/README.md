# Ejercicio VehiCom
Realizar un programa en C+/- para gestionar la utilización de vehículos compartidos
(coches, bicicletas y patinetes): VehiCom. Cada vehículo estará aparcado en un punto al que el
cliente deberá llegar, activar el vehículo, usarlo por un tiempo indefinido y finalmente volver a
dejarlo aparcado en cualquier otro punto. El ámbito para la gestión de todos los vehículos será
circular de un radio de 10 kilómetros a partir de un origen de coordenadas (0,0) situado en el
centro de la ciudad o pueblo considerado. El sistema VehiCom deberá tener las siguientes
capacidades mínimas:
- Hasta 20 vehículos sumando los tres tipos (coche, bicicleta, patinete).
- Hasta 50 clientes diferentes.


Las operaciones del programa serán las siguientes:
- Alta nuevo cliente
- Alta nuevo vehículo
- Activación de vehículo
- Devolución de vehículo
- Resumen mensual uso de cliente


Se trata de realizar el programa principal para la gestión de los vehículos y las
correspondientes funciones, procedimientos y los TADs que el alumno crea conveniente. En la
realización de esta práctica se debe reutilizar, en la medida de lo posible, el código fuente ya
realizado para la tercera, que se redefinirá como un TAD “CalendarioMes”, incorporando las
operaciones nuevas necesarias para cumplir las necesidades de esta cuarta práctica.
El programa principal deberá presentar las siguientes opciones:

1.- La opción “Alta nuevo cliente” permite dar de alta en el sistema un nuevo cliente para que
pueda hacer uso de los vehículos compartidos disponibles.

2.- La opción “Alta nuevo vehículo” permite dar de alta en el sistema un nuevo vehículo y su
correspondiente ubicación inicial en la que se dejará aparcado para poder ser compartido. La
ubicación se determina mediante coordenadas polares: Radio vector y Ángulo polar referidas al
centro de la ciudad o pueblo. El Radio se introducirá mediante un número entero positivo
expresado en metros (hasta 10.000 metros = 10 kilómetros) y será la distancia en línea recta que
existe entre el centro y la ubicación. El Ángulo se introducirá mediante un número real positivo
comprendido entre 0,00 y 360,00, que quedará expresado en grados sexagesimales.

3.- La opción “Activar vehículo” solicita la ubicación del cliente (Radio y Ángulo) y permitirá elegir
el tipo de vehículo necesitado (C = coche, B = bicicleta, P = patinete, T = todos los tipos). Además
se deberá introducir el momento de la activación (fecha y hora). La opción mostrará hasta cinco
vehículos disponibles y que se encuentren los más próximos a la ubicación del cliente, ordenados
de menor a mayor distancia.

4.- La opción “Devolver vehículo” permite la devolución de un vehículo y dejarlo aparcado en una
nueva ubicación para su utilización posterior.

5.- La opción de “Resumen mensual de cliente” solicita el identificador de cliente, el mes y
el año del que se quiere el resumen.
