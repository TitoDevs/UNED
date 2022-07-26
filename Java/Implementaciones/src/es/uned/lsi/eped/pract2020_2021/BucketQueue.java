package es.uned.lsi.eped.pract2020_2021;

import es.uned.lsi.eped.DataStructures.*;

/*Representa una cola con prioridad implementada mediante una secuencia de SamePriorityQueue*/
public class BucketQueue<E> extends Collection<E> implements PriorityQueueIF<E> {
 
  //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	private List<SamePriorityQueue<E>> listSame;
	private int posicion;
	private SamePriorityQueue<E> samePriority;

  /* Clase privada que implementa un iterador para la *
   * cola con prioridad basada en secuencia.          */
  public class PriorityQueueIterator implements IteratorIF<E> {

    //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE
	private IteratorIF<SamePriorityQueue<E>> sameIterador;
	private IteratorIF<E> queueIterador;
	

    /*Constructor por defecto*/
    protected PriorityQueueIterator(){
    	reset();
    }

    /*Devuelve el siguiente elemento de la iteración*/
    public E getNext() {
    	if(queueIterador.hasNext()) {
    		return queueIterador.getNext();
    	}else {
    		queueIterador = sameIterador.getNext().iterator();
    		return queueIterador.getNext();
    	}
    }
    
    /*Comprueba si queda algún elemento por iterar*/
    public boolean hasNext() {
    	if(sameIterador.hasNext()) {
    		return true;
    	}else if(queueIterador == null) {
    		return false;
    	}else if(queueIterador.hasNext()) {
    		return true;
    	}
    	return false;
    }
 
    /*Reinicia el iterador a la posición inicial*/
    public void reset() {
    	sameIterador = listSame.iterator();
    	if(sameIterador.hasNext()) {
    		queueIterador = sameIterador.getNext().iterator();
    	}else {
    		queueIterador = null;
    	}
    	
    }
  }


  /* OPERACIONES PROPIAS DE ESTA CLASE */

  /*constructor por defecto: crea cola con prioridad vacía
   */
  BucketQueue(){
	  listSame = new List<SamePriorityQueue<E>>();
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ PRIORITYQUEUEIF */

  /*Devuelve el elemento más prioritario de la cola y que
   *llegó en primer lugar
   * @Pre !isEmpty()
   */
  public E getFirst() {
	  //Comprobamos que la lista no est� vac�a
	  if(!listSame.isEmpty()) {
		  return null;
	  }else {
		  return listSame.get(posicion).getFirst();
	  }
  }
 
  /*Añade un elemento a la cola de acuerdo a su prioridad
   *y su orden de llegada
   */
  public void enqueue(E elem, int prior) {
	  //Definimos la cola como nula
	  SamePriorityQueue<E> colaPrincipal = null;
	  //Definimos una posici�n para tener un orden
	  int posicion = 1;
	  //Creamos iterador
	  IteratorIF<SamePriorityQueue<E>> iterador = listSame.iterator();
	  
	  //Si la posici�n es menor o igual a el tama�o de la lista se hace la condici�n
	  while(posicion <= this.listSame.size()) {
		  
		  SamePriorityQueue<E> colaActual = iterador.getNext();
		  //si la prioridad de la cola es menor a la de la cola actual
		  if(colaActual.getPriority() < prior) {
			  //No hay lista con esa prioridad, hay que crearla
			  break;
			  
		  //si la prioridad de lal cola es igual
		  }else if(colaActual.getPriority() == prior){
			  colaPrincipal = colaActual;
			  break;
		  }
		  ++posicion;
	  }
	 
	  if(colaPrincipal == null) {
		  colaPrincipal = new SamePriorityQueue<E>(prior);
		  this.listSame.insert(posicion, colaPrincipal);
	  }
	  
	  colaPrincipal.enqueue(elem);
	  this.size = this.size + 1;
  }

  /*Elimina el elemento más prioritario y que llegó a la cola
   *en primer lugar
   * @Pre !isEmpty()
   */
  public void dequeue() {
	  if(listSame.iterator().hasNext()) {
		  SamePriorityQueue<E> cola = listSame.get(1);
		  cola.dequeue();
		  if(cola.isEmpty()) {
			  listSame.remove(1);
		  }
		  this.size = this.size - 1;
	  }
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ SEQUENCEIF */

  /*Devuelve un iterador para la cola*/
  public IteratorIF<E> iterator() {
	  return new PriorityQueueIterator();
  }
 
  /* OPERACIONES PROPIAS DE LA INTERFAZ COLLECTIONIF */

  /*Devuelve el número de elementos de la cola*/
  public int size() {
	  return size;
  }

  /*Decide si la cola está vacía*/
  public boolean isEmpty() {
	  return samePriority.isEmpty();
  }
 
  /*Decide si la cola contiene el elemento dado por parámetro*/
  public boolean contains(E e) {
	  return samePriority.contains(e);
  }
 
  /*Elimina todos los elementos de la cola*/
  public void clear() {
	  samePriority.clear();
  }
 
}

