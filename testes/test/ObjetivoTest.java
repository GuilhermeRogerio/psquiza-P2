package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modulos.Objetivo;

class ObjetivoTest {

	private Objetivo objetivo;

	@Test
	void testConstrutor() {
		objetivo = new Objetivo("GERAL",
				"Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.",
				4, 2);

		assertEquals(
				"GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6",
				objetivo.toString());
	}

	@Test
	void testContrutorTipoNull() {
		assertThrows(NullPointerException.class, () -> this.objetivo = new Objetivo(null,
				"Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.",
				4, 2));
	}

	@Test
	void testContrutorTipoVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.objetivo = new Objetivo(" ",
				"Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.",
				4, 2));
	}

	@Test
	void testContrutorDescricaoNull() {
		assertThrows(NullPointerException.class, () -> this.objetivo = new Objetivo("GERAL", null, 4, 2));
	}

	@Test
	void testContrutorDescricaoVazia() {
		assertThrows(IllegalArgumentException.class, () -> this.objetivo = new Objetivo("GERAL", " ", 4, 2));
	}

	@Test
	void testContrutorAderenciaMenorQue1() {
		assertThrows(IllegalArgumentException.class, () -> this.objetivo = new Objetivo("ESPECIFICO",
				"Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.",
				-3, 2));
	}

	@Test
	void testContrutorAderenciaMaiorQue5() {
		assertThrows(IllegalArgumentException.class, () -> this.objetivo = new Objetivo("ESPECIFICO",
				"Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.",
				100, 2));
	}

	@Test
	void testContrutorViabilidadeMenorQue1() {
		assertThrows(IllegalArgumentException.class, () -> this.objetivo = new Objetivo("ESPECIFICO",
				"Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.",
				4, 0));
	}

	@Test
	void testContrutorViabilidadeMaiorQue5() {
		assertThrows(IllegalArgumentException.class, () -> this.objetivo = new Objetivo("ESPECIFICO",
				"Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.",
				4, 7));
	}

	@Test
	void testToString() {
		objetivo = new Objetivo("ESPECIFICO",
				"Detectar, atraves de bot eletronico, a presenca de mensagens eletronicas com conteudo homofobico.", 2,
				5);

		assertEquals(
				"ESPECIFICO - Detectar, atraves de bot eletronico, a presenca de mensagens eletronicas com conteudo homofobico. - 7",
				objetivo.toString());
	}

}
