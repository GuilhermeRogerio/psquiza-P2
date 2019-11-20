package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modulos.Item;

class ItemTest {

	private Item item,item1,item2;
	
	@BeforeEach
	void setUp() {
		this.item = new Item("Monitoramento slack");
		this.item1 = new Item("Monitoramento discord");
		this.item2 = new Item("Monitoramento slack");
	}

	@Test
	void testConstrutor() {
		this.item = new Item("Monitoramento facebook/messenger");
		
		assertEquals("PENDENTE - Monitoramento facebook/messenger",this.item.toString());
	}

	@Test
	void testToString() {
		assertEquals("PENDENTE - Monitoramento slack",this.item.toString());
	}
	
	@Test
	void testHashCodeIgual() {
		assertEquals(this.item.hashCode(),this.item2.hashCode());
	}

	@Test
	void testEqualsObjectIgual() {
		assertTrue(this.item.equals(item2));
	}
	
	@Test
	void testEqualsObjectDiferente() {
		assertFalse(this.item.equals(item1));
	}

}
