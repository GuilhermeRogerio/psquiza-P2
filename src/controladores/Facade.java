package controladores;

import busca.Busca;
import easyaccept.EasyAccept;

import util.Resultado;

public class Facade {

	private ControllerGeral controllerGeral;
	private Resultado resultados;
	private Busca busca;

	public static void main(String[] args) {
		args = new String[] { "controladores.Facade", "testes_aceitacao/use_case_1.txt",
				"testes_aceitacao/use_case_2.txt", "testes_aceitacao/use_case_3.txt", "testes_aceitacao/use_case_4.txt",
				"testes_aceitacao/use_case_5.txt", "testes_aceitacao/use_case_6.txt", "testes_aceitacao/use_case_7.txt",
				"testes_aceitacao/use_case_8.txt","testes_aceitacao/use_case_11.txt" };
		EasyAccept.main(args);
		
//		System.out.println(new Busca().buscaLimit("computacao", 2));
	}

	public Facade() {
		controllerGeral = new ControllerGeral();
		resultados = new Resultado(controllerGeral);
		busca = new Busca(controllerGeral);
	}

	/**
	 * US1
	 */
	public void cadastraPesquisa(String descricao, String campoDeInteresse) {
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
	

	/*
	 * US5
	 */
	public boolean associaProblema(String idPesquisa, String idProblema) {
		return this.controllerGeral.associaProblema(idPesquisa, idProblema);
	}
	
	public boolean desassociaProblema(String idPesquisa) {
		return this.controllerGeral.desassociaProblema(idPesquisa);
	}
	
	public boolean associaObjetivo(String idPesquisa, String idObjetivo) {
		return this.controllerGeral.associaObjetivo(idPesquisa, idObjetivo);
	}
	
	public boolean desassociaObjetivo(String idPesquisa, String idObjetivo) {
		return this.controllerGeral.desassociaObjetivo(idPesquisa, idObjetivo);
	}

	public String listaPesquisas(String ordem){
		return this.controllerGeral.listaPesquisas(ordem);
	}
	
	/**
	 * US6
	 */
	
	public boolean associaPesquisador(String idPesquisa, String emailPesquisador) {
		return this.controllerGeral.associaPesquisador(idPesquisa, emailPesquisador);
	}
	
	public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
		return this.controllerGeral.desassociaPesquisador(idPesquisa, emailPesquisador);
	}
	
	public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data) {
		this.controllerGeral.cadastraEspecialidadeProfessor(email, formacao, unidade, data);
	}
	
	public void cadastraEspecialidadeAluno(String email, int semestre, double IEA) {
		this.controllerGeral.cadastraEspecialidadeAluno(email, semestre, IEA);
	}
	
	public String listaPesquisadores(String tipo) {
		return this.controllerGeral.listaPesquisadores(tipo);
	}
	
	/**
	 * US7
	 */

	public boolean associaAtividade(String codigoPesquisa, String codigoAtividade) {
		return this.controllerGeral.associaAtividade(codigoPesquisa, codigoAtividade);
	}

	public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade) {
		return this.controllerGeral.desassociaAtividade(codigoPesquisa, codigoAtividade);
	}

	public void executaAtividade(String codigoAtividade, int item, int duracao) {
		this.controllerGeral.executaAtividade(codigoAtividade, item, duracao);
	}
	
	public int cadastraResultado(String codigoAtividade, String resultado) {
		return this.controllerGeral.cadastraResultado(codigoAtividade, resultado);
	}
	
	public boolean removeResultado(String codigoAtividade, int numeroResultado) {
		return this.controllerGeral.removeResultado(codigoAtividade, numeroResultado);
	}
	
	public int getDuracao(String codigoAtividade) {
		return this.controllerGeral.getDuracao(codigoAtividade);
	}
	
	public String listaResultados(String codigoAtividade) {
		return this.controllerGeral.listaResultados(codigoAtividade);
	}	
	 
	 /**
	  * US8
	  */
	 public String busca(String termo) {
		 return this.busca.busca(termo, false);
	 }
	 
	 public String busca(String termo, int numeroDoResultado) {
		 return this.busca.busca(termo, numeroDoResultado);
	 }
	 
	 public int contaResultadosBusca(String termo) {
		return this.busca.contaResultadosBusca(termo);
	}
	 
	 /**
	  * US11
	  */
	public void gravarResumo(String codigoPesquisa) {
		 this.resultados.gravarResumo(codigoPesquisa);
	 }
	 
	 public void gravarResultados(String codigoPesquisa) {
		 this.resultados.gravarResultados(codigoPesquisa);
	 }
}
	