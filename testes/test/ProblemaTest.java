package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modulos.Problema;

class ProblemaTest {

	private Problema problema;

	@Test
	void testConstrutor() {
		problema = new Problema("A dificuldade da predicao do sistema eleitoral brasileiro", 1);

		assertEquals("P - A dificuldade da predicao do sistema eleitoral brasileiro - 1", problema.toString());
	}

	@Test
	void testToString() {
		problema = new Problema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 3);

		assertEquals("P - A problematica do aprendizado dos conceitos de programacao orientada a objeto - 3",
				problema.toString());
	}
}
