package controladores;

import easyaccept.EasyAccept;

public class ControllerGeral {
	
	private ControllerUs3 controllerUs3;
	
	private ControllerPesquisador controllerPesquisador;
	
	public ControllerGeral() {
		this.controllerUs3 = new ControllerUs3();
		this.controllerPesquisador = new ControllerPesquisador();
	}
	
	/**
	 * US2
	 */
	
	public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto) {
		this.controllerPesquisador.cadastraPesquisador(nome, funcao, biografia, email, foto);
    }

	public void alteraPesquisador(String email, String atributo, String novoValor) {
		this.controllerPesquisador.alteraPesquisador(email, atributo, novoValor);
	}

	public void desativaPesquisador(String email) {
	    this.controllerPesquisador.desativaPesquisador(email);
   }
	
	public void ativaPesquisador(String email) {
		this.controllerPesquisador.ativaPesquisador(email);
   }

	public String exibePesquisador(String email) {
	    return this.controllerPesquisador.exibePesquisador(email);
  }

	public boolean pesquisadorEhAtivo(String email) {
	    return this.controllerPesquisador.pesquisadorEhAtivo(email);
  }	
	
	/**
	 * US3
	 */
	public void cadastraProblema(String descricao,int viabilidade) {
		this.controllerUs3.cadastraProblema(descricao, viabilidade);
	}
	
	public void cadastraObjetivo(String tipo, String descricao,int aderenciaProblema,int viabilidade) {
		this.controllerUs3.cadastraObjetivo(tipo, descricao, aderenciaProblema, viabilidade);
	}
	
	public void apagarProblema(String codigo) {
		this.controllerUs3.apagarProblema(codigo);
	}
	
	public void apagarObjetivo(String codigo) {
		this.controllerUs3.apagarObjetivo(codigo);
	}
	
	public String exibeProblema(String codigo) {
		return this.controllerUs3.exibeProblema(codigo);
	}
	
	public String exibeObjetivo(String codigo) {
		return this.controllerUs3.exibeObjetivo(codigo);
	}

}
