import static org.junit.Assert.*;

import org.junit.*;




public class MainTest {

	@Test
	public void creoNuevaListaSuTama�oDebeSer0(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		Assert.assertEquals(0, lista.tama�oLista);
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
	public void insertaUnNodoSuTama�oDebeSer1(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertBeginning(5);
		Assert.assertEquals(1, lista.tama�oLista);
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
	public void insertarDespuesDeNodoTama�oAumentaYNodoA�adidoEsCorrecto(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertBeginning(5);
		lista.insertAfter(5, 10);
		Assert.assertEquals(2, lista.tama�oLista);
		Assert.assertTrue(lista.ultimoNodo.elemento == 10);
	}
	
	@Test
	public void insertarAntesDeNodoTama�oAumentaYNodoA�adidoEsCorrecto(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertBeginning(5);
		int elemento = 10;
		lista.insertBefore(5, elemento);
		Assert.assertEquals(2, lista.tama�oLista);
		Assert.assertTrue(lista.primerNodo.elemento == elemento);
	}
	
	@Test
	public void insertarNodoAntesDeNodoInexistenteTama�oNoAumenta(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertBefore(5, 10);
		Assert.assertEquals(0, lista.tama�oLista);
	}
	
	@Test
	public void insertarNodoAntesDeNodoInexistenteSusNodosNoSeModifican(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertBefore(5, 10);
		Assert.assertTrue(lista.primerNodo == null);
		Assert.assertTrue(lista.ultimoNodo == null);
	}
	
	@Test
	public void insertarNodoDespuesDeNodoInexistenteSusNodosNoSeModificanYSuTama�oSigueSiendo0(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.insertAfter(5, 10);
		Assert.assertTrue(lista.primerNodo == null);
		Assert.assertTrue(lista.ultimoNodo == null);
		Assert.assertEquals(0, lista.tama�oLista);
	}
	
	@Test
	public void borrarNodoTama�oSeModificaCorrectamenteYNodoTambien(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		int elemento = 20;
		lista.insertBeginning(5);
		lista.insertEnd(10);
		lista.insertEnd(elemento);
		Assert.assertTrue(lista.tama�oLista == 3);
		Assert.assertTrue(lista.ultimoNodo.elemento == elemento);
		lista.remove(elemento);
		Assert.assertTrue(lista.tama�oLista == 2);
		Assert.assertTrue(lista.ultimoNodo.elemento == 10);
	}
	
	@Test
	public void borrarNodoInexistenteNoModificaTama�oNiNodos(){
		DoublyLinkedList<Integer> lista = new DoublyLinkedList();
		lista.remove(5);
		Assert.assertTrue(lista.tama�oLista == 0);
		Assert.assertTrue(lista.ultimoNodo == null);
		Assert.assertTrue(lista.primerNodo == null);
	}
}
