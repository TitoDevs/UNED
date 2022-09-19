1- Presentación del problema

Con la llegada de las vacunas del COVID, se organiza una estrategia de vacunación que tiene en
cuenta no sólo el orden de llegada de los pacientes al centro de vacunación, sino también su
pertenencia a grupos prioritarios. El criterio principal para ordenar la vacunación es considerar la
prioridad d e cada paciente en primer lugar (es decir, pacientes con una prioridad más alta serán
atendidos primero) y ante pacientes con la misma prioridad atender primero a quienes llegaron antes.

La estructura de datos abstracta que se corresponde con esta situación es la cola de prioridad : una
cola modificada en la que, en lugar de salir los elementos en el orden en el que entraron, primero
saldrán los más prioritarios (ordenados en el orden de llegada).

En esta práctica consideraremos dos implementaciones alternativas para una cola de prioridad. La
primera, llamada bucket queue , utiliza una estructura de datos secuencial para almacenar los
diferentes niveles de prioridad. La segunda consiste en almacenar los niveles de prioridad utilizando
un árbol binario de bús queda. Una vez implementadas ambas opciones, las aplicaremos a dos casos
diferentes, y haremos un estudio comparado de la eficiencia de ambas implementaciones en cada
uno de los casos.

2- Enunciado de la práctica

La práctica consiste en

(i) Razonar e imple mentar dos soluciones alternativas para la estructura de datos abstracta
cola de prioridad, una basada en secuencias y otra basada en árboles de búsqueda binaria.
La implementación utilizará los tipos de datos programados por el Equipo Docente.

(ii) Implement ar un programa que aplique ambas implementaciones.

(iii) Ejecutar el programa anterior sobre juegos de prueba empleando ambas implementaciones
y realizar estudios comparativos del tiempo de ejecución de cada una de ellas.

2.1. Cola de prioridad: Estructura de Datos Abstracta

La estructura de datos abstracta cola de prioridad funciona como una cola modificada en la que los
elementos no salen estrictamente en el mismo orden que entraron, sino que tienen asociada una
prioridad y salen antes los de mayor prioridad. Si dos elementos tienen el mismo orden de prioridad,
sale antes e l que entró primero, como en una cola convencional. Esta estructura de datos incluye las
siguientes operaciones:

getFirst: devuelve el elemento más prioritario (y que entró primero) de la cola con prioridad.  
enqueue: inserta un elemento con una cierta pri oridad en la cola con prioridad.  
dequeue: elimina el elemento más prioritario (y que entró primero) de la cola con prioridad.

2.2. Implementación 1: Bucket Queue

Esta implementación consiste en utilizar una secuencia ordenada de colas, cada una de ellas con los
elementos de un mismo nivel de prioridad. De esta forma, el primer elemento de la secuencia es la
cola que contiene los elementos con mayor prioridad.

2.3. Implementación 2: Árbol Binario de Búsqueda

Esta implementación consiste en utilizar un árbol binario de búsqueda (ABB) ordenado según la
prioridad de los elementos. Cada nodo representa un nivel de prioridad, de modo que mantiene una
cola con los elementos de dicho nivel de prioridad en el orden en el que van llegando.

3- Diseño de la práctica

A continuación, vamos a ver el diseño de clases de la práctica necesario para su implementación. Para
aquellas clas es ya programadas, incluiremos una descripción de su funcionamiento y para aquellas
que deban ser completadas por los estudiantes indicaremos cuál será su comportamiento esperado.

3.1. PriorityQueueIF.java

Se trata de la interfaz presentada en el apartado 2.1. que especifica las operaciones de las colas con
prioridad y no debe modificarse

3.2. SamePriorityQueue.java

Esta clase representa colas que tienen asociado un nivel de prioridad representado como un número
entero. El funcionamiento de esta estructura es exactamente el mismo que el de una cola normal ,
de modo que implementa la interfaz QueueIF . Por otro lado, estas estructuras pueden compararse entre
sí de acuerdo con su nivel de prioridad, de modo que implementa la interfaz Comparable . Esto último
implica que esta clase debe implementar un método denominado compareTo que compara un objeto
SamePriorityQueue con otro del mismo tipo. La descripción de las operaciones se encuentra en el
esqueleto de esta clase, adjunto a este enunciado.

3.3. BucketQueue.java

Esta clase implementa las colas con prioridad de la manera descrita en el apartado 2.2 basada en una
secuencia de elementos SamePriorityQueue . Además, incluye la clase privada
PriorityQueueIterator que implementa un iterador para l a cola con prioridad. La descripción de las
operaciones se encuentra en el esqueleto de esta clase.

3.4. BSTPriorityQueue.java

Esta clase implementa las colas con prioridad de la manera descrita en el apartado 2.3 basada en un
árbol binario de búsqueda de elementos SamePriorityQueue . Además, incluye la clase privada
PriorityQueueIterator que implementa un iterador para la cola con prioridad. La descripción de las
operaciones se encuentra en el esqueleto de esta clase, adjunto a este enunciado.

3.5. Main.java

Esta clase contiene el programa principal y se da completamente terminada por parte del Equipo
Docente y no debe modificarse . El funcionamiento es el siguiente:
- El programa requiere tres argumentos:
    a. El primero es una cadena de caracteres que puede ser BQ o BST , de manera que se indica
cuál de las dos implementaciones propuestas de la cola con prioridad se va a emplear.  
    b. El segundo es la ruta del fichero de entrada del programa. El formato de un fichero de
entrada es el siguiente: cada línea del fichero indica una de las siguientes operaciones
de la cola con prioridad: enqueue , dequeue , size e iterator . En caso de que la operación sea enqueue , a continuación, se indica el elemento y la prioridad, todo ello
separado por espacios en blanco. Por ejemplo “enqueue p54 9 9”.  
    c. El tercero es la ruta del fichero de salida generado por el programa. La salida gener ada
se explica en el punto 3.  

- Se comprueba que se han proporcionado adecuadamente los parámetros. En caso contrario,
se lanza un mensaje de error y termina el programa. En el caso del primer argumento, se
comprueba que la cadena de caracteres es BQ o BST y se crea una cola con prioridad vacía con
la implementación correspondiente. En el caso del segundo y tercer argumento se comprueba
que las rutas de los ficheros existen mediante la función auxiliar existsFolder de la clase
Main.

- El programa lee línea a línea el fichero de entrada, de manera que se aplican en orden las
operaciones correspondientes sobre la cola con prioridad. En el caso de que la operación sea
size , el programa escribe en el fichero de salida el número de elementos de la cola con
priorida d en su estado actual. En el caso de que la operación sea iterator , el programa escribe
la secuencia de elementos de la cola con prioridad en su estado actual, ayudándose de la
función auxiliar toString de la clase Main.

- El programa termina mostrando el tiempo de ejecución en milisegundos del paso anterior.
