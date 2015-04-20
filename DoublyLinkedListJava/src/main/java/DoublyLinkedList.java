
public class DoublyLinkedList<T> {

	
	/*
	 * Implementación del DoublyLinkedNode para su posterior uso en la implementación de la DoublyLinkedList,
	 * este DoublyLinkedNode guarda un elemento y una referencia tanto al nodo anterior como al siguiente.
	 */
	public class DoublyLinkedNode<E>{
		protected E elemento; 						// Una referencia al elemento contenido en el nodo.
	    protected DoublyLinkedNode<E> anterior; 	// Una referencia al nodo anterior.
	    protected DoublyLinkedNode<E> siguiente; 	// Una referencia al nodo siguiente.
	    
	    /*
	     * Constructor del DoublyLinkedNode.
	     */
	    public DoublyLinkedNode(E valor){
	    	this.anterior = null;
	    	this.siguiente = null;
	    	this.elemento = valor;
	    }
	}
	
	/*
	 * A continuación se implementa la DoublyLinkedList, que contará con dos variables de tipo DoublyLinkedNode
	 * para referirnos al primer y al último nodo además de una variable de tipo int para conocer el tamaño de
	 * la propia lista.
	 */
	
	protected int tamañoLista;				// Variable que guarda el tamaño de la lista.
	protected DoublyLinkedNode<T> primerNodo;	// Referencia al primer Nodo.
	protected DoublyLinkedNode<T> ultimoNodo;	// Referencia al último Nodo.
	
	/*
	 * Constructor de la DoublyLinkedList
	 */

	public DoublyLinkedList(){
		this.tamañoLista = 0;
		this.primerNodo = null;
		this.ultimoNodo = null;
	}
	
	/*
	 * Comprueba si la lista está vacía.
	 */

	public boolean isEmpty(){
		return this.primerNodo == null;
	}
	
	/*
	 * Inserta un nodo después de otro, como parámetros le pasamos el elemento del nodo que se busca (la "clave")
	 * y el elemento del nuevo nodo a insertar.
	 */
	
	public void insertAfter(T claveNodo, T nuevoElemento){
		DoublyLinkedNode<T> nuevoNodo = new DoublyLinkedNode<T>(nuevoElemento);
		DoublyLinkedNode<T> nodoActual = this.primerNodo;
	    boolean encontrado = false;
		while (nodoActual != null && !encontrado) {
			if (nodoActual.elemento.equals(claveNodo)) {
				nuevoNodo.anterior = nodoActual;
				nuevoNodo.siguiente = nodoActual.siguiente;
				encontrado = true;
				if (nodoActual.siguiente == null) {
					this.ultimoNodo = nuevoNodo;
				} else {
					nodoActual.siguiente.anterior = nuevoNodo;
				}
				nodoActual.siguiente = nuevoNodo;
			} else {
				nodoActual = nodoActual.siguiente;
			}
		}
		if(encontrado){
			this.tamañoLista++;
		}
	}
	
	/*
	 * Inserta un nodo antes de otro, como parámetros le pasamos el elemento del nodo que se busca (la "clave")
	 * y el elemento del nuevo nodo a insertar.
	 */
	
	public void insertBefore(T claveNodo, T nuevoElemento){
		DoublyLinkedNode<T> nuevoNodo = new DoublyLinkedNode<T>(nuevoElemento);
		DoublyLinkedNode<T> nodoActual = this.primerNodo;
		boolean encontrado = false;

		while (nodoActual != null && !encontrado) {
			if (nodoActual.elemento.equals(claveNodo)) {
				encontrado = true;
				nuevoNodo.anterior = nodoActual.anterior;
				nuevoNodo.siguiente = nodoActual;
				if (nodoActual.anterior == null) {
					this.primerNodo = nuevoNodo;
				} else {
					nodoActual.anterior.siguiente = nuevoNodo;
				}
				nodoActual.anterior = nuevoNodo;
			} else {
				nodoActual = nodoActual.siguiente;
			}
		}
		if (encontrado){
			this.tamañoLista++;
		}
	}

	/*
	 * Inserta un nodo al principio de la lista.
	 */

	public void insertBeginning(T nuevoElemento){
		DoublyLinkedNode<T> nuevoNodo = new DoublyLinkedNode<T>(nuevoElemento);
	    if (isEmpty()){
	      ultimoNodo = nuevoNodo;
	    }else{
	      primerNodo.anterior = nuevoNodo;
	    }
	    nuevoNodo.siguiente = primerNodo;
	    primerNodo = nuevoNodo;
	    this.tamañoLista++;
	}
	
	/*
	 * Inserta un nodo al final de la lista.
	 */
	
	public void insertEnd(T nuevoElemento){
		  DoublyLinkedNode<T> nuevoNodo = new DoublyLinkedNode<T>(nuevoElemento);
		    if (isEmpty()){
		      primerNodo = nuevoNodo;
		    }else {
		      ultimoNodo.siguiente = nuevoNodo;
		      nuevoNodo.anterior = ultimoNodo;
		    }
		    ultimoNodo = nuevoNodo;
		    this.tamañoLista++;
	}
	
	/*
	 * Elimina un nodo de la lista, como parametro le pasamos el elemento del nodo que se busca ("la clave").
	 */
	
	public void remove(T claveNodo){
		DoublyLinkedNode<T> nodoAuxiliar = this.primerNodo;
		boolean encontrado = false;
		while (nodoAuxiliar != null && !encontrado) {
			if (nodoAuxiliar.elemento.equals(claveNodo)) {
				encontrado = true;
				if (nodoAuxiliar.anterior == null) {
					this.primerNodo = nodoAuxiliar.siguiente;
				} else {
					nodoAuxiliar.anterior.siguiente = nodoAuxiliar.siguiente;
				}

				if (nodoAuxiliar.siguiente == null) {
					this.ultimoNodo = nodoAuxiliar.anterior;
				} else {
					nodoAuxiliar.siguiente.anterior = nodoAuxiliar.anterior;
				}
				this.tamañoLista--;

			} else {
				nodoAuxiliar = nodoAuxiliar.siguiente;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
