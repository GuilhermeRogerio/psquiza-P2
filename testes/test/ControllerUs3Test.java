package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControllerUs3;

class ControllerUs3Test {
	
	private ControllerUs3 controllerUs3;
	
	@BeforeEach
	void setUp() {
		controllerUs3 = new ControllerUs3();
		
		controllerUs3.cadastraProblema("O problema do discurso homofobico em chats online de alunos de computacao de primeiro periodo", 3);
		controllerUs3.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 1);
		controllerUs3.cadastraProblema("A problematica do aprendizado dos conceitos de programacao orientada a objeto", 5);
		controllerUs3.cadastraObjetivo("ESPECIFICO", "Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.", 4, 5);
		controllerUs3.cadastraObjetivo("GERAL", "Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao.", 4, 2);
	}

	@Test
	void testCadastraProblema() {
		controllerUs3.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 1);
		
		controllerUs3.exibeProblema("P1");
	}
	
	@Test
	void testCadastraProblemaDescricaoNull() {
		assertThrows(NullPointerException.class, () -> this.controllerUs3.cadastraProblema(null, 1));
	}
	
	@Test
	void testCadastraProblemaDescricaoVazia() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerUs3.cadastraProblema(" ", 1));
	}
	
	@Test
	void testCadastraProblemaViabilidadeMenorQue1() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerUs3.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", -6));
	}
	
	@Test
	void testCadastraProblemaViabilidadeMaiorQue5() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerUs3.cadastraProblema("A dificuldade da predicao do sistema eleitoral brasileiro", 11));
	}

	@Test
	void testCadastraObjetivo() {
		controllerUs3.cadastraObjetivo("ESPECIFICO", "Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.", 4, 5);
		
		controllerUs3.exibeObjetivo("O1");
	}
	
	@Test
	void testCadastraObjetivoTipoNull() {
		assertThrows(NullPointerException.class, () -> this.controllerUs3.cadastraObjetivo(null, "Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.", 4, 5));
	}
	
	@Test
	void testCadastraObjetivoTipoVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerUs3.cadastraObjetivo(" ", "Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.", 4, 5));
	}
	
	@Test
	void testCadastraObjetivoDescricaoNull() {
		assertThrows(NullPointerException.class, () -> this.controllerUs3.cadastraObjetivo("ESPECIFICO", null, 4, 5));
	}
	
	@Test
	void testCadastraObjetivoDescricaoVazia() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerUs3.cadastraObjetivo("ESPECIFICO", " ", 4, 5));
	}
	
	@Test
	void testCadastraObjetivoAderenciaMenorQue1() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerUs3.cadastraObjetivo("ESPECIFICO", "Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.", 0, 5));
	}
	
	@Test
	void testCadastraObjetivoAderenciaMaiorQue5() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerUs3.cadastraObjetivo("ESPECIFICO", "Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.", 6, 5));
	}
	
	@Test
	void testCadastraObjetivoViabilidadeMenorQue1() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerUs3.cadastraObjetivo("ESPECIFICO", "Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.", 4, -6));
	}
	
	@Test
	void testCadastraObjetivoViabilidadeMaiorQue5() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerUs3.cadastraObjetivo("ESPECIFICO", "Realizar rodas de conversa entre alunos do curso, incluindo especialmente aqueles que emitem mensagens homofobicas e alunos ou pessoas homoafetivas.", 4, 40));
	}

	@Test
	void testExibeProblema() {
		assertEquals("P3 - A problematica do aprendizado dos conceitos de programacao orientada a objeto - 5", controllerUs3.exibeProblema("P3"));
	}

	@Test
	void testExibeObjetivo() {
		assertEquals("O2 - GERAL - Diminuir a frequencia de mensagens homofobicas trocadas em chats online entre alunos de primeiro periodo de computacao. - 6", controllerUs3.exibeObjetivo("O2"));
	}

	@Test
	void testApagarProblema() {
		controllerUs3.apagarProblema("P2");
		
		assertThrows(IllegalArgumentException.class, () -> this.controllerUs3.exibeProblema("P2"));
	}

	@Test
	void testApagarObjetivo() {
		controllerUs3.apagarObjetivo("O1");
		
		assertThrows(IllegalArgumentException.class, () -> this.controllerUs3.exibeObjetivo("O1"));
	}

}
