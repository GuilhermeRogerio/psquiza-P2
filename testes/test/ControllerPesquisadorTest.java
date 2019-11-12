package test;

import org.junit.jupiter.api.BeforeEach;

import controladores.ControllerPesquisador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerPesquisadorTest {
    private ControllerPesquisador controllerpesquisador;

    @BeforeEach
    void setUp() {
        this.controllerpesquisador = new ControllerPesquisador();
        this.controllerpesquisador.cadastraPesquisador("Andre", "professor", "Um ser apaixonado por programação", "andre1706@gmail.com", "https://thepic.net");
        this.controllerpesquisador.cadastraPesquisador("Miguel", "estudante", "Apaixonado por musicas e desenvolvimentos de novas tecnologias", "flaviomiguel84@outlook.com", "https://Cordyceps");
        this.controllerpesquisador.cadastraPesquisador("heisenberg", "externo", "Interresado nos efeitos da metafetamina e no estudo sobre o cancer. Pesquisador principal da pesquisa de radigrafia a fotons, peca fundamental na pesquisa que ganhou um premio nobel.", "breakingbad@200", "https://Cordyceps");
        this.controllerpesquisador.cadastraPesquisador("Arthur", "externo", "Personalidade forte e destemido naquilo que faz", "tutucds@mc.com", "https://tirafotoai.net");
        this.controllerpesquisador.cadastraPesquisador("Maria", "professor", "testetestetteste", "marialucia15@show.com", "https://semideia.com");
        this.controllerpesquisador.cadastraPesquisador("Andreza", "extrerno", "Me perdoe mais estou sem criatividade no momento ", "andrezanascimento@hhht.net", "https://thisissparta.nxt");
        this.controllerpesquisador.cadastraPesquisador("Valmir", "estudante", "sem ideias", "valmir@sla.com", "https://thepicture.com");
        this.controllerpesquisador.desativaPesquisador("marialucia15@show.com");
        this.controllerpesquisador.desativaPesquisador("breakingbad@200");
        this.controllerpesquisador.desativaPesquisador("andrezanascimento@hhht.net");
        this.controllerpesquisador.desativaPesquisador("tutucds@mc.com");

    }

    @Test
    void testaCadastroPesquisadorAtributosVazios() {
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.cadastraPesquisador("", "professor", "testando validacoes", "teste@teste", "http://seila.com"));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.cadastraPesquisador("Matheus", "", "testando validacoes", "teste@teste", "http://seila.com"));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.cadastraPesquisador("Matheus", "professor", "", "teste@teste", "http://seila.com"));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.cadastraPesquisador("Matheus", "professor", "testando validacoes", "", "http://seila.com"));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.cadastraPesquisador("Matheus", "professor", "testando validacoes", "teste@teste", ""));
    }

    @Test
    void testaCadastroPesquisadorNomeNulo() {
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.cadastraPesquisador(null, "professor", "testando validacoes", "teste@teste", "http://seila.com"));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.cadastraPesquisador("Matheus", null, "testando validacoes", "teste@teste", "http://seila.com"));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.cadastraPesquisador("Matheus", "professor", null, "teste@teste", "http://seila.com"));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.cadastraPesquisador("Matheus", "professor", "testando validacoes", null, "http://seila.com"));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.cadastraPesquisador("Matheus", "professor", "testando validacoes", "teste@teste", null));
    }

    @Test
    void testaCadastroPesquisadorEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.cadastraPesquisador("Matheus", "professor", "testando validacoes", "teste", "http://seila.com"));
    }

    @Test
    void testaCadastroPesquisadorFotoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.cadastraPesquisador("Matheus", "professor", "testando validacoes", "teste@teste", "ttps:yourfot.com"));
    }

    @Test
    void testaAlteracaoPesquisador() {
        this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "NOME", "flavio");
        this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "FUNCAO", "professor");
        this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "BIOGRAFIA", "Teste alteracao biografia");
        this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "FOTO", "https://suafoto.com");
        this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "EMAIL", "124test@teste ");
    }


    @Test
    void testaAlteracaoPesquisadorAtributoInexistente(){
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84", "secretario", "sla"));
    }

    @Test
    void testaAlteracaoPesquisadorInexistente() {
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("miguel84@outlook.com", "NOME", "flavio"));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("6nxt9@outlook.com", "FUNCAO", "professor"));
    }

    @Test
    void testaAlteracaoPesquisadorAtributosVazios() {
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "", "flavio"));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "", "professor"));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "", "Teste alteracao biografia"));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "", "https://suafoto.com"));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "", "124test@teste "));
    }

    @Test
    void testaAlteracaoPesquisadorAtributosNulos() {
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", null, "flavio"));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", null, "professor"));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", null, "Teste alteracao biografia"));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", null, "https://suafoto.com"));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", null, "124test@teste "));
    }

    @Test
    void testaAlteracaoPesquisadorValoresVazios() {
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "NOME", ""));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "FUNCAO", ""));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "BIOGRAFIA", " "));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "EMAIL", ""));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "FOTO", " "));
    }

    @Test
    void testaAlteracaoPesquisadorValoresNulos() {
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "NOME", null));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "FUNCAO", null));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "BIOGRAFIA", null));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "EMAIL", null));
        assertThrows(NullPointerException.class, () -> this.controllerpesquisador.alteraPesquisador("flaviomiguel84@outlook.com", "FOTO", null));
    }

    @Test
    void testaDesativacaoPesquisador() {
        this.controllerpesquisador.desativaPesquisador("andre1706@gmail.com");
        this.controllerpesquisador.desativaPesquisador("flaviomiguel84@outlook.com");
    }

    @Test
    void testaDesativacaoPesquisadorInexistente() {
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.desativaPesquisador("kassio@gmail.com"));
    }

    @Test
    void testaDesativaPesquisadorDesativado(){
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.desativaPesquisador("breakingbad@200"));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.desativaPesquisador("andrezanascimento@hhht.net"));
    }

    @Test
    void testaAtivaPesquisador(){
        this.controllerpesquisador.ativaPesquisador("tutucds@mc.com");
        this.controllerpesquisador.ativaPesquisador("marialucia15@show.com");
    }

    @Test
    void testaAtivaPesquisadorAtivado(){
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.ativaPesquisador("andre1706@gmail.com"));
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.ativaPesquisador("valmir@sla.com"));
    }

    @Test
    void testaExibicaoPesquisador(){
        assertEquals("Andre (professor) - Um ser apaixonado por programação - andre1706@gmail.com - https://thepic.net", this.controllerpesquisador.exibePesquisador("andre1706@gmail.com"));
        assertEquals("Miguel (estudante) - Apaixonado por musicas e desenvolvimentos de novas tecnologias - flaviomiguel84@outlook.com - https://Cordyceps", this.controllerpesquisador.exibePesquisador("flaviomiguel84@outlook.com"));
        assertEquals("heisenberg (externo) - Interresado nos efeitos da metafetamina e no estudo sobre o cancer. Pesquisador principal da pesquisa de radigrafia a fotons, peca fundamental na pesquisa que ganhou um premio nobel. - breakingbad@200 - https://Cordyceps", this.controllerpesquisador.exibePesquisador("breakingbad@200"));
    }

    @Test
    void testaExibicaoPesquisadorInexistente(){
        assertThrows(IllegalArgumentException.class, () -> this.controllerpesquisador.exibePesquisador("testet@t123"));
    }

    @Test
    void testaEstadoPesquisador(){
        assertFalse(this.controllerpesquisador.pesquisadorEhAtivo("tutucds@mc.com"));
        assertTrue(this.controllerpesquisador.pesquisadorEhAtivo("valmir@sla.com"));
        assertTrue(this.controllerpesquisador.pesquisadorEhAtivo("andre1706@gmail.com"));
        assertFalse(this.controllerpesquisador.pesquisadorEhAtivo("breakingbad@200"));
    }

}
