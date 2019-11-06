package controladores;

import easyaccept.EasyAccept;

public class Facade {

	private ControllerGeral controllerGeral;

	public static void main(String[] args) {
		args = new String[] { "controladores.Facade", "testes_aceitacao/use_case_1.txt",
				"testes_aceitacao/use_case_2.txt", "testes_aceitacao/use_case_3.txt", "testes_aceitacao/use_case_4.txt", 
				"testes_aceitacao/use_case_5.txt","testes_aceitacao/use_case_6.txt","testes_aceitacao/use_case_7.txt","testes_aceitacao/use_case_8.txt" };
		EasyAccept.main(args);
	}

	public Facade() {
		controllerGeral = new ControllerGeral();
	}

	/**
	 * US1
	 */
	public void cadastraPesquisa (String descricao, String campoDeInteresse) {
		this.controllerGeral.cadastraPesquisa(descricao, campoDeInteresse);
	}

	public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
		this.controllerGeral.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
	}

	public void encerraPesquisa(String codigo, String motivo) {
		this.controllerGeral.encerraPesquisa(codigo, motivo);
	}

	public void ativaPesquisa(String codigo) {
		this.controllerGeral.ativaPesquisa(codigo);

	}

	public String exibePesquisa(String codigo) {
		return this.controllerGeral.exibePesquisa(codigo);
	}

	public boolean pesquisaEhAtiva(String codigo) {
		return this.controllerGeral.pesquisaEhAtiva(codigo);
	}
	

	/**
	 * US2
	 */
	public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto) {
		this.controllerGeral.cadastraPesquisador(nome, funcao, biografia, email, foto);
	}

	public void alteraPesquisador(String email, String atributo, String novoValor) {
		this.controllerGeral.alteraPesquisador(email, atributo, novoValor);
	}

	public void desativaPesquisador(String email) {
		this.controllerGeral.desativaPesquisador(email);
	}

	public void ativaPesquisador(String email) {
		this.controllerGeral.ativaPesquisador(email);
	}

	public String exibePesquisador(String email) {
		return this.controllerGeral.exibePesquisador(email);
	}

	public boolean pesquisadorEhAtivo(String email) {
		return this.controllerGeral.pesquisadorEhAtivo(email);
	}

	/**
	 * US3
	 */
	public void cadastraProblema(String descricao, int viabilidade) {
		this.controllerGeral.cadastraProblema(descricao, viabilidade);
	}

	public void cadastraObjetivo(String tipo, String descricao, int aderenciaProblema, int viabilidade) {
		this.controllerGeral.cadastraObjetivo(tipo, descricao, aderenciaProblema, viabilidade);
	}

	public void apagarProblema(String codigo) {
		this.controllerGeral.apagarProblema(codigo);
	}

	public void apagarObjetivo(String codigo) {
		this.controllerGeral.apagarObjetivo(codigo);
	}

	public String exibeProblema(String codigo) {
		return this.controllerGeral.exibeProblema(codigo);
	}

	public String exibeObjetivo(String codigo) {
		return this.controllerGeral.exibeObjetivo(codigo);
	}
	
	/**
	 * US4
	 */
	
	public String cadastraAtividade(String Descricao, String nivelRisco, String descricaoRisco) {
		return this.controllerGeral.cadastraAtividade(Descricao, nivelRisco, descricaoRisco);
	}
	
	public void apagaAtividade(String codigo) {
		this.controllerGeral.apagaAtividade(codigo);
	}
	
	public void cadastraItem(String codigo, String item) {
		this.controllerGeral.cadastraItem(codigo, item);
	}
	
	public String exibeAtividade(String codigo) {
		return this.controllerGeral.exibeAtividade(codigo);
	}
	
	public int contaItensPendentes(String codigo) {
		return this.controllerGeral.contaItensPendentes(codigo);
	}
	
	public int contaItensRealizados(String codigo) {
		return this.controllerGeral.contaItensRealizados(codigo);
	}

}
