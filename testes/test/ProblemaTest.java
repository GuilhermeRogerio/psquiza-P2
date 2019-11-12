package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modulos.Problema;

class ProblemaTest {

	private Problema problema;

	@Test
	void testConstrutor() {
		problema = new Problema("A dificuldade da predicao do sistema eleitoral brasileiro", 1);

		assertEquals("A dificuldade da predicao do sistema eleitoral brasileiro - 1", problema.toString());
	}

	@Test
	void testContrutorDescricaoNull() {
		assertThrows(NullPointerException.class, () -> this.problema = new Problema(null, 1));
	}

	@Test
	void testContrutorDescricaoVazia() {
		assertThrows(IllegalArgumentException.class, () -> this.problema = new Problema(" ", 1));
	}

	@Test
	void testContrutorViabilidadeMenorQue1() {
		assertThrows(IllegalArgumentException.class,
				() -> this.problema = new Problema("A dificuldade da predicao do sistema eleitoral brasileiro", -5));
	}

	@Test
	void testContrutorViabilidadeMaiorQue5() {
		assertThrows(IllegalArgumentException.class,
				() -> this.problema = new Problema("A dificuldade da predicao do sistema eleitoral brasileiro", 10));
	}

	@Test
	void testToString() {
		problema = new Problema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 3);

		assertEquals("A problematica do aprendizado dos conceitos de programacao orientada a objeto - 3",
				problema.toString());
	}
}
