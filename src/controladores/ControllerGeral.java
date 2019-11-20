package controladores;

import modulos.Pesquisa;
import modulos.Pesquisador;
import util.Validador;

/**
 * Controloador responsavel por gerir o sistema.
 *
 */
public class ControllerGeral {

	/**
	 * Instância do contrololador da Pesquisa
	 * 
	 */
	protected ControllerPesquisa controllerPesquisa;

	/**
	 * Instância do controlador do fornecedor
	 * 
	 *
	 */
	protected ControllerProblemaObjetivo controllerProblemaObjetivo;

	/**
	 * Instância do controlador do fornecedor
	 *
	 */
	protected ControllerPesquisador controllerPesquisador;

	/**
	 * Instância do controlador de atividade.
	 * 
	 */
	protected ControllerAtividade controllerAtividade;
	
	/**
	 * Objeto para validar os parâmetros.
	 * 
	 */
	protected Validador validador;

	/**
	 * Construtor que inicializa os controladores instâciados.
	 * 
	 */
	public ControllerGeral() {
		this.controllerPesquisa = new ControllerPesquisa();
		this.controllerProblemaObjetivo = new ControllerProblemaObjetivo();
		this.controllerPesquisador = new ControllerPesquisador();
		this.controllerAtividade = new ControllerAtividade();
		this.validador = new Validador();
	}

	/**
	 * US1
	 */

	/**
	 * Método passa ao controlador de pesquisa os parâmetros a serem cadastrados
	 * 
	 * @param descricao o resumo descritivo da pesquisa
	 * @param campoDeInteresse a areas abrangidas pela pesquisa
	 *       
	 */
	public void cadastraPesquisa(String descricao, String campoDeInteresse) {
		this.controllerPesquisa.cadastraPesquisa(descricao, campoDeInteresse);
	}

	/**
	 * Método passa ao controlador de pesquisa os parâmetros a serem alterados em pesquisa
	 * 
	 * @param codigo o identificador da pesquisa
	 * @param campoASerAlterado o atributo a ser mudado
	 */
	public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
		this.controllerPesquisa.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
	}

	/**
	 * Método passa ao controlador de pesquisa os parâmetros que da pesquisa a ser encerrada
	 * 
	 * @param codigo o identificador da pesquisa
	 * @param motivo o motivação para o encerramento da pesquisa
	 */
	public void encerraPesquisa(String codigo, String motivo) {
		this.controllerPesquisa.encerraPesquisa(codigo, motivo);
	}

	/**
	 * Método passa ao controlador de pesquisa os parâmetros para a ativação da pesquisa
	 * 
	 * @param codigo o identificador da pesquisa
	 */
	public void ativaPesquisa(String codigo) {
		this.controllerPesquisa.ativaPesquisa(codigo);
	}

	/**
	 * Método passa ao controlador de pesquisa os parâmetros para a exibição da pesquisa
	 * 
	 * @param codigo o identificador da pesquisa
	 * @return a exibição da pesquisa
	 */
	public String exibePesquisa(String codigo) {
		return this.controllerPesquisa.exibePesquisa(codigo);
	}

	/**
	 * Método passa ao controlador de pesquisa os parâmetros para a verificação da atividade da pesquisa
	 * 
	 * @param codigo o identificador da pesquisa
	 * @return o resultado do estado da pesquisa
	 */
	public boolean pesquisaEhAtiva(String codigo) {
		return this.controllerPesquisa.pesquisaEhAtiva(codigo);
	}

	/**
	 * US2
	 */

	/**
	 * Método que passa ao controlador dos pesquisadores os parâmetros a serem cadastrados.
	 * 
	 * @param nome      o nome do pesquisador.
	 * @param funcao    a função do pesquisador.
	 * @param biografia a biografia do pesquisador.
	 * @param email     o email do pesquisador.
	 * @param foto      a foto do pesquisador.
	 */
	public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto) {
		this.controllerPesquisador.cadastraPesquisador(nome, funcao, biografia, email, foto);
	}

	/**
	 * Método que passa ao controlador dos pesquisadores os parâmetros a serem alterados.
	 * 
	 * @param email     o email identificador do pesquisador.
	 * @param atributo  o atributo a ser alterado.
	 * @param novoValor o novo valor do atributo.
	 */
	public void alteraPesquisador(String email, String atributo, String novoValor) {
		this.controllerPesquisador.alteraPesquisador(email, atributo, novoValor);
	}
	
	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a ativação.
	 * 
	 * @param email o email identificador do pesquisador.
	 */
	public void ativaPesquisador(String email) {
		this.controllerPesquisador.ativaPesquisador(email);
	}
	
	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a desativação.
	 * 
	 * @param email o email identificador do pesquisador.
	 */
	public void desativaPesquisador(String email) {
		this.controllerPesquisador.desativaPesquisador(email);
	}

	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a exibição.
	 * 
	 * @param email o email identificador do pesquisador.
	 * @return a representação do pesquisador.
	 */
	public String exibePesquisador(String email) {
		return this.controllerPesquisador.exibePesquisador(email);
	}

	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a verificação do estado.
	 * 
	 * @param email o email identificador do pesquisador.
	 * @return o estado do pesquisador no sistema.
	 */
	public boolean pesquisadorEhAtivo(String email) {
		return this.controllerPesquisador.pesquisadorEhAtivo(email);
	}
	
	/**
	 * US3
	 */

	/**
	 * Método que passa ao controlador dos problemas e objetivos os parâmetros a serem cadastrados.
	 * 
	 * @param descricao a descrição do problema.
	 * @param viabilidade a viabilidade do problema ser resolvido.
	 */
	public void cadastraProblema(String descricao, int viabilidade) {
		this.controllerProblemaObjetivo.cadastraProblema(descricao, viabilidade);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos os parâmetros a serem cadastrados.
	 * 
	 * @param tipo o tipo do objetivo.
	 * @param descricao a descricao do objetivo.
	 * @param aderencia o problema Aderencia ao problema.
	 * @param viabilidade a viabilidade de o objetivo ser concretizado.
	 */
	public void cadastraObjetivo(String tipo, String descricao, int aderenciaProblema, int viabilidade) {
		this.controllerProblemaObjetivo.cadastraObjetivo(tipo, descricao, aderenciaProblema, viabilidade);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a remoção.
	 * 
	 * @param codigo o codigo do problema.
	 */
	public void apagarProblema(String codigo) {
		this.controllerProblemaObjetivo.apagarProblema(codigo);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a remoção.
	 * 
	 * @param codigo o codigo do objetivo.
	 */
	public void apagarObjetivo(String codigo) {
		this.controllerProblemaObjetivo.apagarObjetivo(codigo);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a exibição.
	 * 
	 * @param codigo Codigo do problema.
	 * @return a represetação do problema.
	 */
	public String exibeProblema(String codigo) {
		return this.controllerProblemaObjetivo.exibeProblema(codigo);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a exibição.
	 * 
	 * @param codigo o codigo do objetivo.
	 * @return a represetação do objetivo.
	 */
	public String exibeObjetivo(String codigo) {
		return this.controllerProblemaObjetivo.exibeObjetivo(codigo);
	}

	/**
	 * US4
	 */

	/**
	 * Método que passa ao controle de atividade os parâmetros para o cadastro da atividade.
	 * 
	 * @param descricao      - Objetivo da atividade
	 * @param nivelRisco     - Nivel de risco que a atividade apresenta
	 * @param descricaoRisco - Descrição que explica o nivel de risco apresentado
	 * @return o código da atividade que acabou de ser cadastrada
	 */
	public String cadastraAtividade(String Descricao, String nivelRisco, String descricaoRisco) {
		return this.controllerAtividade.cadastraAtividade(Descricao, nivelRisco, descricaoRisco);
	}

	/**
	 * Método que passa ao controle de atividade os parâmetros para apagar uma atividade.
	 * 
	 * @param codigo o código da atividade a ser apagada.
	 */
	public void apagaAtividade(String codigo) {
		this.controllerAtividade.apagaAtividade(codigo);
	}

	/**
	 * Método que cadastra um item à atividade indicada.
	 * 
	 * @param codigo o código da atividade
	 * @param item   o código do item a ser cadastrado.
	 */
	public void cadastraItem(String codigo, String item) {
		this.controllerAtividade.cadastraItem(codigo, item);
	}

	/**
	 * Método que passa ao controle de atividade o parâmetro para exibir uma atividade.
	 * 
	 * @param codigo o código da atividade que se deseja
	 * @return a representação textual da atividade.
	 */
	public String exibeAtividade(String codigo) {
		return this.controllerAtividade.exibeAtividade(codigo);
	}

	/**
	 * Método que passa ao controle de atividade o parâmetro para a contagem de itens pendentes.
	 * 
	 * @param codigo o código da atividade
	 * @return a quantia de itens pendentes.
	 */
	public int contaItensPendentes(String codigo) {
		return this.controllerAtividade.contaItensPendentes(codigo);
	}

	/**
	 * Método que passa ao controle de atividade o parâmetro para a contagem de itens realizados.
	 * 
	 * @param codigo o código da atividade
	 * @return o quantia de itens resolvidos.
	 */
	public int contaItensRealizados(String codigo) {
		return this.controllerAtividade.contaItensRealizados(codigo);
	}
	
	/**
	 * US5
	 */
	
	/**
	 * Método que passa ao controle de pesquisa os parãmetros para a associação do problema.
	 *
	 * @param idPesquisa o identificador da pesquisa
	 * @param idProblema o identificador do problema
	 * @return o resultado da associação do problema
	 */
	public boolean associaProblema(String idPesquisa, String idProblema) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		this.validador.valida(idProblema, "Campo idProblema nao pode ser nulo ou vazio.");
		return this.controllerPesquisa.associaProblema(idPesquisa, this.controllerProblemaObjetivo.problema(idProblema));
	}

	/**
	 * Método que passa ao controle de pesquisa os parâmetros a para a desassociação do problema.
	 *
	 * @param idPesquisa o identificador da pesquisa
	 * @return o resultado da desasssociação do problema
	 */
	public boolean desassociaProblema(String idPesquisa) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		return this.controllerPesquisa.desassociaProblema(idPesquisa);
	}

	/**
	 * Método que passa ao controle de pesquisa os parâmetros para a associação do objetivo.
	 *
	 * @param idPesquisa o identificador da pesquisa
	 * @param idObjetivo o identificador do objetivo
	 * @return o resultado da associação do objetivo
	 */
	public boolean associaObjetivo(String idPesquisa, String idObjetivo) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		this.validador.valida(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		return this.controllerPesquisa.associaObjetivo(idPesquisa, this.controllerProblemaObjetivo.objetivo(idObjetivo), idObjetivo);
	}

	/**
	 * Método que passa ao controle de pesquisa os parâmetros para a desassociação do objetivo.
	 *
	 * @param idPesquisa o identificador da pesquisa
	 * @param idObjetivo o identificador do objetivo
	 * @return o resultado da desassociação do objetivo
	 */
	public boolean desassociaObjetivo(String idPesquisa, String idObjetivo) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		this.validador.valida(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		return this.controllerPesquisa.desassociaObjetivo(idPesquisa, idObjetivo);
	}

	/**
	 * Método que passa ao controle de pesquisa o parâmetro para se listar as pesquisas.
	 * 
	 * @param ordem o critério para a ordenação da lista
	 * @return a lista das pesquisas ordenada
	 */
	public String listaPesquisas(String ordem) {
		return this.controllerPesquisa.listaPesquisas(ordem);
	}
	
	/**
	 * US6
	 */
	
	public boolean associaPesquisador(String idPesquisa, String emailPesquisador) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		this.validador.valida(emailPesquisador, "Campo emailPesquisador nao pode ser nulo ou vazio.");
		Pesquisa pesquisa = this.controllerPesquisa.getPesquisa(idPesquisa);
		Pesquisador pesquisador = this.controllerPesquisador.getPesquisador(emailPesquisador);
		this.validador.validaPesquisaAtivada(pesquisa);
		return pesquisador.associaPesquisa(idPesquisa, pesquisa);
	}
	
	public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		this.validador.valida(emailPesquisador, "Campo emailPesquisador nao pode ser nulo ou vazio.");
		Pesquisa pesquisa = this.controllerPesquisa.getPesquisa(idPesquisa);
		Pesquisador pesquisador = this.controllerPesquisador.getPesquisador(emailPesquisador);
		this.validador.validaPesquisaAtivada(pesquisa);
		return pesquisador.desassociaPesquisa(idPesquisa, pesquisa);
	}
	
	public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data) {
		this.validador.valida(email, "Campo email nao pode ser nulo ou vazio.");
		this.validador.valida(formacao, "Campo formacao nao pode ser nulo ou vazio.");
		this.validador.valida(unidade, "Campo unidade nao pode ser nulo ou vazio.");
		this.validador.valida(data, "Campo data nao pode ser nulo ou vazio.");
		this.validador.validaData(data);
		this.validador.validaEspecialidadeProfessor(this.controllerPesquisador.getPesquisador(email).getFuncao().toLowerCase());
		this.controllerPesquisador.getPesquisador(email).cadastraEspecialidadeProfessor(formacao, unidade, data);
	}
	
	public void cadastraEspecialidadeAluno(String email, int semestre, double IEA) {
		this.validador.valida(email, "Campo email nao pode ser nulo ou vazio.");
		this.validador.validaSemestre(semestre);
		this.validador.validaIEA(IEA);
		this.validador.validaEspecialidadeAluno(this.controllerPesquisador.getPesquisador(email).getFuncao());
		this.controllerPesquisador.getPesquisador(email).cadastraEspecialidadeAluno(semestre, IEA);
	}
	
	public String listaPesquisadores(String tipo) {
		this.validador.valida(tipo, "Campo tipo nao pode ser nulo ou vazio.");
		this.validador.validaFuncao(tipo);
		return this.controllerPesquisador.listaPesquisadores(tipo);
	}

	/**
	 * US7
	 */

	/**
	 * Método que passa ao controlador de atividade os parâmetro para a associação.
	 * 
	 * @param codigoPesquisa  Código da pesquisa.
	 * @param codigoAtividade Código da atividade.
	 * @return "True" se a associação for bem sucedida e "False" se a associação não
	 *         acontecer.
	 */
	public boolean associaAtividade(String codigoPesquisa, String codigoAtividade) {
		this.validador.valida(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		if (this.controllerAtividade.getAtividade(codigoAtividade) != null) {
			return this.controllerPesquisa.associaAtividade(codigoPesquisa, codigoAtividade,
					this.controllerAtividade.getAtividade(codigoAtividade));
		} else {
			throw new IllegalArgumentException("Atividade nao encontrada");
		}

	}

	/**
	 * Método que passa ao controlador de atividade os parâmetro para a desassociação.
	 * 
	 * @param codigoPesquisa  Código da pesquisa.
	 * @param codigoAtividade Código da atividade.
	 * @return "True" se a desassociação for bem sucedida e "False" se a
	 *         desassociação não acontecer.
	 */
	public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade) {
		this.validador.valida(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		if (this.controllerAtividade.getAtividade(codigoAtividade) != null) {
			return this.controllerPesquisa.desassociaAtividade(codigoPesquisa, codigoAtividade);
		} else {
			throw new IllegalArgumentException("Atividade nao encontrada");
		}
	}

	/**
	 * Método passa ao controlador de atividade os parâmetros a serem executados.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @param item            Item a ser executado.
	 * @param duracao         Quantidade de horas gastas em determinada atividade.
	 */
	public void executaAtividade(String codigoAtividade, int item, int duracao) {
		this.controllerAtividade.executaAtividade(codigoAtividade, item, duracao);
	}

	/**
	 * Método passa ao controlador de atividade os parâmetros a serem cadastrados.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @param resultado       Resultado da atividade.
	 * @return Número identificador do resultado.
	 */
	public int cadastraResultado(String codigoAtividade, String resultado) {
		return this.controllerAtividade.cadastraResultado(codigoAtividade, resultado);
	}

	/**
	 * Método passa ao controlador de atividade os parâmetros a serem removidos.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @param numeroResultado Número identificador do resultado.
	 * @return "True" se a remoção for bem sucedida e "False" se a remocão não
	 *         acontecer.
	 */
	public boolean removeResultado(String codigoAtividade, int numeroResultado) {
		return this.controllerAtividade.removeResultado(codigoAtividade, numeroResultado);
	}

	/**
	 * Método passa ao controlador de atividade os parâmetros a serem retornados.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @return A quantidade de horas gastas em determinada atividade.
	 */
	public int getDuracao(String codigoAtividade) {
		return this.controllerAtividade.getDuracao(codigoAtividade);
	}

	/**
	 * Método passa ao controlador de atividade os parâmetros a serem listados.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @return Os resultados de uma determinada atividade.
	 */
	public String listaResultados(String codigoAtividade) {
		return this.controllerAtividade.listaResultados(codigoAtividade);
	}
	
	//getter controladores
	
	public ControllerPesquisa getControllerPesquisa() {
		return controllerPesquisa;
	}
	
	public ControllerPesquisador getControllerPesquisador() {
		return controllerPesquisador;
	}
	
	public ControllerProblemaObjetivo getControllerProblemaObjetivo() {
		return controllerProblemaObjetivo;
	}

	
	/**
	 * Método que retona o objetiv
	 * 
	 * @return ControllerProblemaObjetivo
	 * */
	public ControllerProblemaObjetivo getControllerProblema() {
		return this.controllerProblemaObjetivo;
	}
	
	/**
	 * Retorna o controlador dos módulos Atividade
	 * 
	 * @return ControllerAtividade
	 * */
	public ControllerAtividade getControllerAtividade() {
		return this.controllerAtividade;
	}
	
	/**
	 * US10
	 */
	
	public void configuraEstrategia(String estrategia) {
		this.controllerPesquisa.configuraEstrategia(estrategia);
	}
	
	public String proximaAtividade(String codigoPesquisa) {
		return this.controllerPesquisa.proximaAtividade(codigoPesquisa);
	}

}
