package controladores;

import easyaccept.EasyAccept;

public class Facade {

	private ControllerGeral controllerGeral;

	public static void main(String[] args) {
		args = new String[] { "controladores.Facade", "testes_aceitacao/use_case_2.txt",
				"testes_aceitacao/use_case_3.txt" };
		EasyAccept.main(args);
	}

	public Facade() {
		controllerGeral = new ControllerGeral();
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

}
