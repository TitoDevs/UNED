package es.uned.lsi.eped.pract2020_2021;
import es.uned.lsi.eped.DataStructures.*;

/*Representa una cola con un nivel de prioridad asignado determinado*/
public class SamePriorityQueue<E> implements QueueIF<E>,Comparable<SamePriorityQueue<E>>{
 
  //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	private Queue<E> queue;
	int priority;
  /* OPERACIONES PROPIAS DE ESTA CLASE */

  /*constructor por defecto: crea cola vacía con la prioridad dada por parámetro.
   *@param p: nivel de prioridad asociado a la cola
  */
  SamePriorityQueue(int p){
	  priority = p;
	  queue = new Queue<E>();
  }

  /* Devuelve la prioridad de la cola
   * @return prioridad de la cola
   */
  public int getPriority(){
	  return priority;
  }
 
  /* OPERACIONES PROPIAS DE QUEUEIF */

  /*Devuelve el primer elemento de la cola
   * @Pre !isEmpty()
   */
  public E getFirst() {
	  if(queue.isEmpty()) {
		  return null;
	  }else {
		  return queue.getFirst();
	  }
  }
 
  /*Añade un elemento a la cola de acuerdo al orden de llegada*/
  public void enqueue(E elem) {
	  queue.enqueue(elem);
  }

  /*Elimina un elemento a la cola de acuerdo al orden de llegada
   * @Pre !isEmpty()
  */
  public void dequeue() {
	  queue.dequeue();
  }

  /* OPERACIONES PROPIAS DEL INTERFAZ SEQUENCEIF */

  /*Devuelve un iterador para la cola*/
  public IteratorIF<E> iterator() {
	  return queue.iterator();
  }
 
  /* OPERACIONES PROPIAS DEL INTERFAZ COLLECTIONIF */

  /*Devuelve el número de elementos de la cola*/
  public int size() {
	  return queue.size();
  }

  /*Decide si la cola está vacía*/
  public boolean isEmpty() {
	  return queue.isEmpty();
  }
 
  /*Decide si la cola contiene el elemento dado por parámetro*/
  public boolean contains(E e) {
	  return queue.contains(e);
  }
 
  /*Elimina todos los elementos de la cola*/
  public void clear() {
	  queue.clear();
  }
 
  /* OPERACIONES PROPIAS DEL INTERFAZ COMPARABLE */
 
  /*Comparación entre colas según su prioridad
   * Salida:
   *  - Valor >0 si la cola tiene mayor prioridad que la cola dada por parámetro
   *  - Valor 0 si ambas colas tienen la misma prioridad
   *  - Valor <0 si la cola tiene menor prioridad que la cola dada por parámetro
   */
  public int compareTo(SamePriorityQueue<E> o) {
	  int estado = 0;
	  if(priority == o.priority) {
		  estado = 0;
		  return estado;
	  }else if(priority < o.priority) {
		  estado = -1;
		  return estado;
	  }if(priority > o.priority) {
		  estado = 1;
		  return estado;
	  }else {
		  return estado;
	  }

  }

}

