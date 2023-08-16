package es.uned.lsi.eped.pract2020_2021;
import es.uned.lsi.eped.DataStructures.*;
import static es.uned.lsi.eped.DataStructures.BSTreeIF.IteratorModes.*;
import static es.uned.lsi.eped.DataStructures.BSTreeIF.Order.*;

/*Representa una cola con prioridad implementada mediante un árbol binario de búsqueda de SamePriorityQueue*/
public class BSTPriorityQueue<E> extends Collection<E> implements PriorityQueueIF<E> {
	
	private BSTree<SamePriorityQueue<E>> bsSame;
	private SamePriorityQueue<E> samePriority;
 
  //LA DEFINICIÓN DE LOS ATRIBUTOS DE LA CLASE ES TAREA DE CADA ESTUDIANTE

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
    	}else if(queueIterador.hasNext()){
    		return true;
    	}
    	return false;
    	
    }
 
    /*Reinicia el iterador a la posición inicial*/
    public void reset() {
    	sameIterador = bsSame.iterator(REVERSEORDER);
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
  BSTPriorityQueue(){
	  bsSame = new BSTree<SamePriorityQueue<E>>(ASCENDING);
  }

  /* OPERACIONES PROPIAS DE LA INTERFAZ PRIORITYQUEUEIF */

  /*Devuelve el elemento más prioritario de la cola y que
   *llegó en primer lugar
   * @Pre !isEmpty()
   */
  public E getFirst() {
	  if(bsSame.isEmpty()) {
		  return null;
	  }else {
		  return bsSame.getRoot().getFirst();
	  }
  }
 
  /*Añade un elemento a la cola de acuerdo a su prioridad
   *y su orden de llegada
   */
  public void enqueue(E elem, int prior) {
	  SamePriorityQueue<E> colaPrincipal = null;
	  IteratorIF<SamePriorityQueue<E>> iterador = bsSame.iterator(REVERSEORDER);
	  
	  while(iterador.hasNext()) {
		  SamePriorityQueue<E> colaActual = iterador.getNext();
		  if(colaActual.getPriority() < prior) {
			  break;
				  
		  }else if(colaActual.getPriority() == prior){
			  colaPrincipal = colaActual;
			  break;
		  }
	  }
	  
	  if(colaPrincipal == null) {
		  colaPrincipal = new SamePriorityQueue<E>(prior);
		  this.bsSame.add(colaPrincipal);
	  }

	  colaPrincipal.enqueue(elem);
	  this.size = this.size + 1;
  }

  /*Elimina el elemento más prioritario y que llegó a la cola
   *en primer lugar
   * @Pre !isEmpty()
   */
  public void dequeue() {
	  if(bsSame.iterator(REVERSEORDER).hasNext()) {
		  SamePriorityQueue<E> cola = bsSame.iterator(REVERSEORDER).getNext();
		  cola.dequeue();
		  if(cola.isEmpty()) {
			  bsSame.remove(cola);
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

