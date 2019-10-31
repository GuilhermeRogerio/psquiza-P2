package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import controladores.ControllerPesquisa;

class ControllerPesquisaTest {

    private ControllerPesquisa controller;

    @BeforeEach
    void init() {
        controller = new ControllerPesquisa();
        controller.cadastraPesquisa("Autoavaliacao na Disciplina de Programacao Orientada a Objeto.",
                "computacao, homofobia");
        controller.cadastraPesquisa("Aumento da evasao no numero de eleitores paraibanos.", "eleicao, paraiba");

        assertThrows(IllegalArgumentException.class, () -> controller.cadastraPesquisa(
                "Formato do campo de interesse invalido.",
                "Lorem ipsum dolor sit amet consectetur adipiscing elit Integer euismod leo in consequat efficitur. Proin commodo nisi eget ligula consequat imperdiet ac quis turpis In non fringilla orci Pellentesque pellentesque ipsum vel ipsum ultrices scelerisque Nulla facilisi Morbi ut tellus ante Suspendisse malesuada quis quam eu efficitur Ut mollis turpis magna sit amet auctor nunc pulvinar ultricies. Nam pharetra scelerisque magna ut feugiat."));

    }

    @Test
    void testExibir() {

        assertEquals("COM1 - Autoavaliacao na Disciplina de Programacao Orientada a Objeto. - computacao, homofobia",
                controller.exibePesquisa("COM1"));

        assertEquals("ELE1 - Aumento da evasao no numero de eleitores paraibanos. - eleicao, paraiba",
                controller.exibePesquisa("ELE1"));

        assertEquals("ELE1 - Aumento da evasao no numero de eleitores paraibanos. - eleicao, paraiba",
                controller.exibePesquisa("ELE1"));

        assertThrows(NullPointerException.class, () -> controller.exibePesquisa(null));
        assertThrows(IllegalArgumentException.class, () -> controller.exibePesquisa(""));

    }

    @Test
    void testAtivacao() {
        assertThrows(IllegalArgumentException.class, () -> controller.ativaPesquisa(""));
        assertThrows(IllegalArgumentException.class, () -> controller.ativaPesquisa("XXX"));
    }

    @Test
    void testEncerramento() {
        assertThrows(Error.class, () -> controller.encerraPesquisa("", "Motivo"));
        assertThrows(Error.class, () -> controller.encerraPesquisa("XXX", "Motivo"));
        assertThrows(IllegalArgumentException.class, () -> controller.encerraPesquisa("COM1", ""));
        assertThrows(Error.class, () -> controller.encerraPesquisa(null, "Motivo"));
        controller.encerraPesquisa("ELE1", "motivo");
    }

    @Test
    void testAlteracao() {
        assertThrows(IllegalArgumentException.class,
                () -> controller.alteraPesquisa("XXX", "conteudoASerAlterado", "novoConteudo"));
        assertThrows(IllegalArgumentException.class,
                () -> controller.alteraPesquisa("COM1", "conteudoASerAlterado", "novoConteudo"));

        controller.encerraPesquisa("COM1", "motivo");
        assertThrows(Error.class, () -> controller.alteraPesquisa("COM1", "CAMPO", "novoConteudo"));
        controller.alteraPesquisa("ELE1", "DESCRICAO", "Modelagem do motor de inducao");
    }

    @Test
    void testEhAtiva() {
        assertEquals(true, controller.pesquisaEhAtiva("COM1"));
        controller.encerraPesquisa("COM1", "motivo");
        assertEquals(false, controller.pesquisaEhAtiva("COM1"));

        assertThrows(IllegalArgumentException.class,
                () -> controller.alteraPesquisa("COM1", "conteudoASerAlterado", "novoConteudo"));

        assertThrows(IllegalArgumentException.class, () -> controller.pesquisaEhAtiva("COM4"));
    }
}