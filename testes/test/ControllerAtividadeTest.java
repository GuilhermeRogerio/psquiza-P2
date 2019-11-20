package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controladores.ControllerAtividade;
import controladores.ControllerPesquisa;

class ControllerAtividadeTest {

	private ControllerAtividade controllerAtividade;
	private ControllerPesquisa controllerPesquisa;

	@BeforeEach
	void setUp() {
		this.controllerAtividade = new ControllerAtividade();
		this.controllerPesquisa = new ControllerPesquisa();
		this.controllerPesquisa.cadastraPesquisa(
				"Homofobia em mensagens online de alunos de computacao do primeiro periodo.", "computacao, homofobia");
		this.controllerAtividade.cadastraAtividade(
				"Degustacao de uma nova remeca de cervejas, criadas a partir de um novo processo de fermentacao.",
				"MEDIO",
				"Degustadores podem sofrer com problemas de saude nessa atividade, tal como ser alergico a algum ingrediente da cerveja.");
		this.controllerAtividade.cadastraAtividade(
				"Monitoramento de chats dos alunos de computacao do primeiro periodo.", "BAIXO",
				"Por se tratar de apenas um monitoramento, o risco nao e elevado.");
		this.controllerAtividade.cadastraItem("A1", "Monitoramento slack");
		this.controllerAtividade.cadastraItem("A1", "Monitoramento whatsapp");
		this.controllerAtividade.cadastraItem("A1", "Degustacao com cerveja a temperatura ambiente");
		this.controllerPesquisa.associaAtividade("COM1", "A1", this.controllerAtividade.getAtividade("A1"));
		this.controllerAtividade.executaAtividade("A1", 2, 15);
		this.controllerAtividade.cadastraResultado("A2", "Analise nao foi possivel.");
	}

	@Test
	void testCadastraAtividade() {
		assertEquals("A3",
				this.controllerAtividade.cadastraAtividade(
						"Monitoramento de chats dos alunos de computacao do primeiro periodo.", "BAIXO",
						"Por se tratar de apenas um monitoramento, o risco nao e elevado."));
	}

	@Test
	void testCadastraAtividadeDescricaoVazia() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.cadastraAtividade(" ", "MEDIO",
				"Degustadores podem sofrer com problemas de saude nessa atividade, tal como ser alergico a algum ingrediente da cerveja."));
	}

	@Test
	void testCadastraAtividadeDescricaoNula() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.cadastraAtividade(null, "MEDIO",
				"Degustadores podem sofrer com problemas de saude nessa atividade, tal como ser alergico a algum ingrediente da cerveja."));
	}

	@Test
	void testCadastraAtividadeNivelRiscoVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.cadastraAtividade(
				"Degustacao de uma nova remeca de cervejas, criadas a partir de um novo processo de fermentacao.", " ",
				"Degustadores podem sofrer com problemas de saude nessa atividade, tal como ser alergico a algum ingrediente da cerveja."));
	}

	@Test
	void testCadastraAtividadeNivelRiscoNulo() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.cadastraAtividade(
				"Degustacao de uma nova remeca de cervejas, criadas a partir de um novo processo de fermentacao.", null,
				"Degustadores podem sofrer com problemas de saude nessa atividade, tal como ser alergico a algum ingrediente da cerveja."));
	}

	@Test
	void testCadastraAtividadeDescricaoRiscoVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.cadastraAtividade(
				"Degustacao de uma nova remeca de cervejas, criadas a partir de um novo processo de fermentacao.",
				"BAIXO", " "));
	}

	@Test
	void testCadastraAtividadeDescricaoRiscoNulo() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.cadastraAtividade(
				"Degustacao de uma nova remeca de cervejas, criadas a partir de um novo processo de fermentacao.",
				"BAIXO", null));
	}

	@Test
	void testCadastraAtividadeNivelRiscoInvalido() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.cadastraAtividade(
				"Degustacao de uma nova remeca de cervejas, criadas a partir de um novo processo de fermentacao.",
				"RELATIVAMENTE ALTO",
				"Degustadores podem sofrer com problemas de saude nessa atividade, tal como ser alergico a algum ingrediente da cerveja."));
	}

	@Test
	void testApagaAtividade() {
		this.controllerAtividade.apagaAtividade("A1");

		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.exibeAtividade("A1"));

	}

	@Test
	void testCadastraItem() {
		this.controllerAtividade.cadastraItem("A1", "Monitoramento facebook/messenger");

		assertEquals(3, this.controllerAtividade.contaItensPendentes("A1"));
	}

	@Test
	void testCadastraItemCodigoVazio() {
		assertThrows(IllegalArgumentException.class,
				() -> this.controllerAtividade.cadastraItem(" ", "Monitoramento discord"));
	}

	@Test
	void testCadastraItemCodigoNulo() {
		assertThrows(NullPointerException.class,
				() -> this.controllerAtividade.cadastraItem(null, "Monitoramento discord"));
	}

	@Test
	void testCadastraItemItemVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.cadastraItem("A1", " "));
	}

	@Test
	void testCadastraItemItemNulo() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.cadastraItem("A1", null));
	}

	@Test
	void testExibeAtividade() {
		assertEquals(
				"Degustacao de uma nova remeca de cervejas, criadas a partir de um novo processo de fermentacao. (MEDIO - Degustadores podem sofrer com problemas de saude nessa atividade, tal como ser alergico a algum ingrediente da cerveja.) | PENDENTE - Monitoramento slack | REALIZADO - Monitoramento whatsapp | PENDENTE - Degustacao com cerveja a temperatura ambiente",
				this.controllerAtividade.exibeAtividade("A1"));
	}

	@Test
	void testExibeAtividadeCodigoVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.exibeAtividade(" "));
	}

	@Test
	void testExibeAtividadeCodigoNulo() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.exibeAtividade(null));
	}

	@Test
	void testContaItensPendentes() {
		assertEquals(2, this.controllerAtividade.contaItensPendentes("A1"));
	}

	@Test
	void testContaItensPendentesCodigoVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.contaItensPendentes(" "));
	}

	@Test
	void testContaItensPendentesCodigoNulo() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.contaItensPendentes(null));
	}

	@Test
	void testContaItensRealizados() {
		this.controllerAtividade.executaAtividade("A1", 1, 15);
		assertEquals(2, this.controllerAtividade.contaItensRealizados("A1"));
	}

	@Test
	void testContaItensRealizadosCodigoVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.contaItensRealizados(" "));
	}

	@Test
	void testContaItensRealizadosCodigoNulo() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.contaItensRealizados(null));
	}

	@Test
	void testExecutaAtividade() {
		this.controllerAtividade.executaAtividade("A1", 1, 15);
		assertEquals(2, this.controllerAtividade.contaItensRealizados("A1"));
	}

	@Test
	void testExecutaAtividadeCodigoAtividadeVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.executaAtividade(" ", 1, 15));
	}

	@Test
	void testExecutaAtividadeCodigoAtividadeNulo() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.executaAtividade(null, 1, 15));
	}

	@Test
	void testExecutaAtividadeItemNegativo() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.executaAtividade("A1", -1, 15));
	}

	@Test
	void testExecutaAtividadeDuracaoNegativa() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.executaAtividade("A1", 1, -5));
	}

	@Test
	void testExecutaAtividadeAtividadeNaoAssociada() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.executaAtividade("A2", 1, 15));
	}

	@Test
	void testExecutaAtividadeItemInesistente() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.executaAtividade("A1", 7, 15));
	}

	@Test
	void testExecutaAtividadeItemJaRealizado() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.executaAtividade("A1", 2, 15));
	}

	@Test
	void testCadastraResultado() {
		assertEquals(2, this.controllerAtividade.cadastraResultado("A2", "Analise nao foi possivel."));
	}

	@Test
	void testCadastraResultadoCodigoAtividadeVazio() {
		assertThrows(IllegalArgumentException.class,
				() -> this.controllerAtividade.cadastraResultado(" ", "Analise nao foi possivel."));
	}

	@Test
	void testCadastraResultadoCodigoAtividadeNulo() {
		assertThrows(NullPointerException.class,
				() -> this.controllerAtividade.cadastraResultado(null, "Analise nao foi possivel."));
	}

	@Test
	void testCadastraResultadoResultadoVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.cadastraResultado("A2", " "));
	}

	@Test
	void testCadastraResultadoResultadoNulo() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.cadastraResultado("A2", null));
	}

	@Test
	void testRemoveResultado() {
		this.controllerAtividade.cadastraResultado("A2", "Analise nao foi possivel.");
		assertTrue(this.controllerAtividade.removeResultado("A2", 1));
	}

	@Test
	void testRemoveResultadoCodigoAtividadeVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.removeResultado(" ", 1));
	}

	@Test
	void testRemoveResultadoCodigoAtividadeNulo() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.removeResultado(null, 1));
	}

	@Test
	void testRemoveResultadoAtividadeInesistente() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.removeResultado("A3", 1));
	}

	@Test
	void testGetDuracao() {
		assertEquals(15, this.controllerAtividade.getDuracao("A1"));
	}

	@Test
	void testGetDuracaoCodigoAtividadeVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.getDuracao(" "));
	}

	@Test
	void testGetDuracaoCodigoAtividadeNulo() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.getDuracao(null));
	}

	@Test
	void testGetDuracaoAtividadeInesistente() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.getDuracao("A3"));
	}

	@Test
	void testListaResultados() {
		assertEquals("Analise nao foi possivel.", this.controllerAtividade.listaResultados("A2"));
	}

	@Test
	void testListaResultadosCodigoAtividadeVazio() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.listaResultados(" "));
	}

	@Test
	void testListaResultadosCodigoAtividadeNulo() {
		assertThrows(NullPointerException.class, () -> this.controllerAtividade.listaResultados(null));
	}

	@Test
	void testListaResultadosAtividadeInesistente() {
		assertThrows(IllegalArgumentException.class, () -> this.controllerAtividade.listaResultados("A3"));
	}

}