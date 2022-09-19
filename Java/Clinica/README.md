La práctica consiste en implementar un sistema integrado de gestión de una clínica
especializada en COVID-19. En el inicio de la pandemia se dedicaban fundamentalmente a
la realización de pruebas diagnósticas para determinar si los pacientes tenían la
enfermedad, pero con la aparición de las vacunas han abierto un departamento para
gestionar la campaña de vacunación.


Por tanto, la clínica ha de guardar información acerca de las pruebas diagnósticas que se
realizan a los pacientes, así como de las vacunas que se les administran, en un historial que
es único para cada uno de los pacientes.


En la aplicación que se desea desarrollar, es necesario almacenar dos tipos distintos de
persona, para diferenciar si se trata de un paciente de la clínica, o de un empleado de la
misma. Dentro de los empleados, encontramos tres subtipos: el administrador del sistema,
los enfermeros que realizan las pruebas y administran las vacunas, y los técnicos de
laboratorio que se encargan de analizar los resultados de las pruebas.


Dentro de las pruebas diagnósticas que se pueden realizar encontramos tres tipos: las
pruebas de antígenos, los tests PCR y los análisis serológicos. Además, las pruebas de
antígenos pueden ser pruebas rápidas (que se toman con una pequeña muestra de sangre
obtenida con un pinchazo en el dedo) o pruebas clásicas, en las que el procedimiento es
similar a la prueba PCR.


Por último, las vacunas que recibe y administra esta clínica pueden ser de tres tipos
distintos: la desarrollada por Pfizer, la desarrollada por Moderna o la desarrollada por
Johnson&Johnson. Las dos primeras requieren de dos dosis, separadas por un mínimo de
21 días para generar inmunidad en el paciente. La vacuna de Johnson&Johnson, sin
embargo, sólo requiere de la administración de una dosis.


En general, las funciones que tiene el sistema de gestión de la clínica son las siguientes:

- Gestión de usuarios: altas, bajas, modificaciones de las personas que figuran en el
sistema (empleados -- administradores, técnicos y enfermeros -- y pacientes). La
primera vez que acude un cliente a la clínica hay que darle de alta en el sistema.

- Realización de una prueba diagnóstica: los clientes acuden a la clínica para
realizarse la prueba diagnóstica que le haya indicado su centro de salud. Esta
prueba puede ser de los tipos indicados anteriormente, y será necesario almacenar
la fecha de realización de la prueba, así como su resultado. Un paciente puede
realizarse todos los test de antígenos que desee, sin embargo entre dos pruebas
PCR es necesario que hayan pasado al menos 15 días, y entre dos test serológicos
han de haber pasado 6 meses. Los test de antígenos y las pruebas PCR nos indican
un resultado positivo o negativo en la enfermedad. Por su parte, los test serológicos
nos indican un valor de anticuerpos entre 0 y 10, y sólo sirven para determinar si el
paciente ha pasado la infección (valor de anticuerpos superior a 2). Al realizar
cualquier prueba diagnóstica es importante almacenar también el enfermero que la
ha realizado, así como el técnico de laboratorio que ha analizado los resultados.
Para evitar contagios entre su personal, la clínica ha establecido que los enfermeros
sólo puedan realizar un máximo de 5 pruebas diagnósticas (de cualquier tipo) por
semana. En cuanto a los técnicos de laboratorio, sólo pueden dedicarse al análisis
de 4 pruebas por semana, por lo que será necesario comprobar estas restricciones a
la hora de asignar un enfermero y un técnico para realizar una prueba.

- Gestión de pacientes confinados: cuando un paciente resulta positivo en un test de
antígenos o en una prueba PCR, ha de mantenerse confinado en su casa durante 10
días. La clínica se encarga de gestionar las llamadas a dichos pacientes para
comprobar que están cumpliendo el confinamiento, por lo que es necesario saber si
un paciente ha sido positivo en algún momento, y cuánto tiempo lleva y le queda de
confinamiento. Cuando un paciente positivo finaliza su tiempo de confinamiento, se
le programa una prueba serológica para medir su nivel de anticuerpos de la
enfermedad.

- Comunicación con los pacientes: la función del administrador de la clínica será la de
ponerse en contacto con los pacientes que están confinados en sus casas para
comprobar que efectivamente están cumpliendo el confinamiento. Para ello podrá
obtener en todo momento el listado de dichos pacientes. Además, podrá generar un
listado de pacientes que han terminado su confinamiento para convocarles a un test
serológico.

- Gestión del stock de vacunas: Cada determinado tiempo, la clínica recibe stock de
los tres tipos de vacunas que gestiona, de tal forma que se almacenará en el
sistema la cantidad de dosis recibidas de cada una de las vacunas. Para simplificar
la gestión del stock, se considera que cada “unidad” de vacuna almacenada
representa todas las dosis necesarias para alcanzar completa inmunidad (es decir,
una unidad de la vacuna de Pfizer o Moderna contiene dos dosis, y una unidad de la
vacuna de Johnson&Johnson contiene una dosis).

- Gestión de la vacunación: Los pacientes pasarán por la clínica para vacunarse. Para
ello, se gestionará una campaña de vacunación basada en la edad de los pacientes,
de tal forma que los pacientes que aún no hayan sido vacunados tendrán prioridad
en función de su edad. De esta manera, los mayores de 65 años estarán en el
primer grupo de vacunación, y el resto de pacientes en el segundo grupo. Se ha de
asignar el tipo de vacuna que se pondrá así como el enfermero que administrará la
vacuna. Para la administración de una vacuna que requiere dos dosis, el enfermero.
