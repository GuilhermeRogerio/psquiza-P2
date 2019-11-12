package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControllerProblemaObjetivo;

class ControllerProblemaObjetivoTest {

	private ControllerProblemaObjetivo controllerProblemaObjetivo;

	@BeforeEach
	void setUp() {
		controllerProblemaObjetivo = new ControllerProblemaObjetivo();

		controllerProblemaObjetivo.cadastraProblema(
				"O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		controllerProblemaObjetivo.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 1);
		controllerProblemaObjetivo.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto",
				5);
		controllerProblemaObjetivo.cadastraObjetivo("ESPECIFICO",
				"Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.",
				4, 5);
		controllerProblemaObjetivo.cadastraObjetivo("GERAL",
				"Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.",
				4, 2);
	}

	@Test
	void testCadastraProblema() {
		controllerProblemaObjetivo.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 1);

		controllerProblemaObjetivo.exibeProblema("P1");
	}

	@Test
	void testCadastraProblemaDescricaoNull() {
		assertThrows(NullPointerException.class, () -> this.controllerProblemaObjetivo.cadastraProblema(null, 1));
	}

	@Test
	void testCadastraProblemaDescricaoVazia() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerProblemaObjetivo.cadastraProblema(" ", 1));
	}

	@Test
	void testCadastraProblemaViabilidadeMenorQue1() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerProblemaObjetivo
				.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", -6));
	}

	@Test
	void testCadastraProblemaViabilidadeMaiorQue5() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerProblemaObjetivo
				.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 11));
	}

	@Test
	void testCadastraObjetivo() {
		controllerProblemaObjetivo.cadastraObjetivo("ESPECIFICO",
				"Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.",
				4, 5);

		controllerProblemaObjetivo.exibeObjetivo("O1");
	}

	@Test
	void testCadastraObjetivoTipoNull() {
		assertThrows(NullPointerException.class, () -> this.controllerProblemaObjetivo.cadastraObjetivo(null,
				"Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.",
				4, 5));
	}

	@Test
	void testCadastraObjetivoTipoVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerProblemaObjetivo.cadastraObjetivo(" ",
				"Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.",
				4, 5));
	}

	@Test
	void testCadastraObjetivoDescricaoNull() {
		assertThrows(NullPointerException.class, () -> this.controllerProblemaObjetivo.cadastraObjetivo("ESPECIFICO", null, 4, 5));
	}

	@Test
	void testCadastraObjetivoDescricaoVazia() {
		assertThrows(IllegalArgumentException.class,
				() -> this.controllerProblemaObjetivo.cadastraObjetivo("ESPECIFICO", " ", 4, 5));
	}

	@Test
	void testCadastraObjetivoAderenciaMenorQue1() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerProblemaObjetivo.cadastraObjetivo("ESPECIFICO",
				"Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.",
				0, 5));
	}

	@Test
	void testCadastraObjetivoAderenciaMaiorQue5() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerProblemaObjetivo.cadastraObjetivo("ESPECIFICO",
				"Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.",
				6, 5));
	}

	@Test
	void testCadastraObjetivoViabilidadeMenorQue1() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerProblemaObjetivo.cadastraObjetivo("ESPECIFICO",
				"Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.",
				4, -6));
	}

	@Test
	void testCadastraObjetivoViabilidadeMaiorQue5() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerProblemaObjetivo.cadastraObjetivo("ESPECIFICO",
				"Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.",
				4, 40));
	}

	@Test
	void testExibeProblema() {
		assertEquals("P3 - A problematica do aprendizado dos conceitos de programacao orientada a objeto - 5",
				controllerProblemaObjetivo.exibeProblema("P3"));
	}

	@Test
	void testExibeObjetivo() {
		assertEquals(
				"O2 - GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6",
				controllerProblemaObjetivo.exibeObjetivo("O2"));
	}

	@Test
	void testApagarProblema() {
		controllerProblemaObjetivo.apagarProblema("P2");

		assertThrows(IllegalArgumentException.class, () -> this.controllerProblemaObjetivo.exibeProblema("P2"));
	}

	@Test
	void testApagarObjetivo() {
		controllerProblemaObjetivo.apagarObjetivo("O1");

		assertThrows(IllegalArgumentException.class, () -> this.controllerProblemaObjetivo.exibeObjetivo("O1"));
	}

}
