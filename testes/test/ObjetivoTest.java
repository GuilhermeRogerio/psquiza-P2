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
				"O - GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6",
				objetivo.toString());
	}

	@Test
	void testToString() {
		objetivo = new Objetivo("ESPECIFICO",
				"Detectar, atraves de bot eletronico, a presenca de mensagens eletronicas com conteudo homofobico.", 2,
				5);

		assertEquals(
				"O - ESPECIFICO - Detectar, atraves de bot eletronico, a presenca de mensagens eletronicas com conteudo homofobico. - 7",
				objetivo.toString());
	}

}
