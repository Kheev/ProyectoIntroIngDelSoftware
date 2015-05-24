import static org.junit.Assert.*;

import org.junit.*;




public class MainTest {

	@Test
	public void creoNuevaListaSuTamañoDebeSer0(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		Assert.assertEquals(0, lista.tamañoLista);
	}
	
	@Test
	public void creoNuevaListaSusNodosSonNull(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		Assert.assertNull(lista.primerNodo);
		Assert.assertNull(lista.ultimoNodo);
	}
	@Test
	public void listaVacia(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		Assert.assertTrue(lista.isEmpty());
	}
	
	@Test
	public void insertaUnNodoSuTamañoDebeSer1(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertBeginning(5);
		Assert.assertEquals(1, lista.tamañoLista);
	}
	
	@Test
	public void insertaPrimerNodoSusNodoDebenSerElElemento(){
		int elemento = 5;
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertBeginning(elemento);
		Assert.assertTrue(lista.primerNodo.elemento == elemento);
		Assert.assertTrue(lista.ultimoNodo.elemento == elemento);
	}
	
	@Test
	public void insertarNodoAlfinal(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		int elemento = 24;
		lista.insertBeginning(5);
		lista.insertEnd(elemento);
		Assert.assertTrue(lista.ultimoNodo.elemento == elemento);
	}
	
	@Test
	public void insertarVariosNodosUltimoNodoIgualUltimoInsertado(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();	
		for(int i=0;i<10;i++){
			lista.insertEnd(i);
		}
		Assert.assertTrue(lista.ultimoNodo.elemento == 9);
	}
	
	@Test
	public void insertarDespuesDeNodoTamañoAumentaYNodoAñadidoEsCorrecto(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertBeginning(5);
		lista.insertAfter(5, 10);
		Assert.assertEquals(2, lista.tamañoLista);
		Assert.assertTrue(lista.ultimoNodo.elemento == 10);
	}
	
	@Test
	public void insertarAntesDeNodoTamañoAumentaYNodoAñadidoEsCorrecto(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertBeginning(5);
		int elemento = 10;
		lista.insertBefore(5, elemento);
		Assert.assertEquals(2, lista.tamañoLista);
		Assert.assertTrue(lista.primerNodo.elemento == elemento);
	}
	
	@Test
	public void insertarNodoAntesDeNodoInexistenteTamañoNoAumenta(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertBefore(5, 10);
		Assert.assertEquals(0, lista.tamañoLista);
	}
	
	@Test
	public void insertarNodoAntesDeNodoInexistenteSusNodosNoSeModifican(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertBefore(5, 10);
		Assert.assertTrue(lista.primerNodo == null);
		Assert.assertTrue(lista.ultimoNodo == null);
	}
	
	@Test
	public void insertarNodoDespuesDeNodoInexistenteSusNodosNoSeModificanYSuTamañoSigueSiendo0(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertAfter(5, 10);
		Assert.assertTrue(lista.primerNodo == null);
		Assert.assertTrue(lista.ultimoNodo == null);
		Assert.assertEquals(0, lista.tamañoLista);
	}
	
	@Test
	public void borrarNodoTamañoSeModificaCorrectamenteYNodoTambien(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		int elemento = 20;
		lista.insertBeginning(5);
		lista.insertEnd(10);
		lista.insertEnd(elemento);
		Assert.assertTrue(lista.tamañoLista == 3);
		Assert.assertTrue(lista.ultimoNodo.elemento == elemento);
		lista.remove(elemento);
		Assert.assertTrue(lista.tamañoLista == 2);
		Assert.assertTrue(lista.ultimoNodo.elemento == 10);
	}
	
	@Test
	public void borrarNodoInexistenteNoModificaTamañoNiNodos(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.remove(5);
		Assert.assertTrue(lista.tamañoLista == 0);
		Assert.assertTrue(lista.ultimoNodo == null);
		Assert.assertTrue(lista.primerNodo == null);
	}
}
