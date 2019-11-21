package controladores;

import modulos.Pesquisa;
import modulos.Pesquisador;
import util.Validador;

/**
 * Controlador responsavel por gerir o sistema.
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
	 * Método passa ao controlador de pesquisa os parâmetros a serem cadastrados.
	 * 
	 * @param descricao O resumo descritivo da pesquisa.
	 * @param campoDeInteresse As areas abrangidas pela pesquisa.
	 *       
	 */
	public void cadastraPesquisa(String descricao, String campoDeInteresse) {
		this.controllerPesquisa.cadastraPesquisa(descricao, campoDeInteresse);
	}

	/**
	 * Método passa ao controlador de pesquisa os parâmetros a serem alterados em pesquisa
	 * 
	 * @param codigo O identificador da pesquisa.
	 * @param conteudoASerAlterado O atributo a ser mudado.
	 */
	public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
		this.controllerPesquisa.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
	}

	/**
	 * Método passa ao controlador de pesquisa os parâmetros que da pesquisa a ser encerrada
	 * 
	 * @param codigo O identificador da pesquisa.
	 * @param motivo O motivação para o encerramento da pesquisa.
	 */
	public void encerraPesquisa(String codigo, String motivo) {
		this.controllerPesquisa.encerraPesquisa(codigo, motivo);
	}

	/**
	 * Método passa ao controlador de pesquisa os parâmetros para a ativação da pesquisa
	 * 
	 * @param codigo O identificador da pesquisa.
	 */
	public void ativaPesquisa(String codigo) {
		this.controllerPesquisa.ativaPesquisa(codigo);
	}

	/**
	 * Método passa ao controlador de pesquisa os parâmetros para a exibição da pesquisa
	 * 
	 * @param codigo O identificador da pesquisa.
	 * @return A representação textual da pesquisa.
	 */
	public String exibePesquisa(String codigo) {
		return this.controllerPesquisa.exibePesquisa(codigo);
	}

	/**
	 * Método passa ao controlador de pesquisa os parâmetros para a verificação da atividade da pesquisa
	 * 
	 * @param codigo O identificador da pesquisa.
	 * @return "True" se a pesquisa estiver ativa e "False" se a pesquisa estiver inativa.
	 */
	public boolean pesquisaEhAtiva(String codigo) {
		return this.controllerPesquisa.pesquisaEhAtiva(codigo);
	}

	/**
	 * US2
	 */

	/**
	 * Método que passa ao controlador dos pesquisadores os parâmetros a serem
	 * cadastrados.
	 * 
	 * @param nome      O nome do pesquisador.
	 * @param funcao    A função do pesquisador.
	 * @param biografia A biografia do pesquisador.
	 * @param email     O email do pesquisador.
	 * @param foto      A foto do pesquisador.
	 */
	public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto) {
		this.controllerPesquisador.cadastraPesquisador(nome, funcao, biografia, email, foto);
	}

	/**
	 * Método que passa ao controlador dos pesquisadores os parâmetros a serem alterados.
	 * 
	 * @param email     O email identificador do pesquisador.
	 * @param atributo  O atributo a ser alterado.
	 * @param novoValor O novo valor do atributo.
	 */
	public void alteraPesquisador(String email, String atributo, String novoValor) {
		this.controllerPesquisador.alteraPesquisador(email, atributo, novoValor);
	}
	
	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a ativação.
	 * 
	 * @param email O email identificador do pesquisador.
	 */
	public void ativaPesquisador(String email) {
		this.controllerPesquisador.ativaPesquisador(email);
	}
	
	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a desativação.
	 * 
	 * @param email O email identificador do pesquisador.
	 */
	public void desativaPesquisador(String email) {
		this.controllerPesquisador.desativaPesquisador(email);
	}

	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a exibição.
	 * 
	 * @param email O email identificador do pesquisador.
	 * @return A representação textual do pesquisador.
	 */
	public String exibePesquisador(String email) {
		return this.controllerPesquisador.exibePesquisador(email);
	}

	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a verificação do estado.
	 * 
	 * @param email O email identificador do pesquisador.
	 * @return O estado do pesquisador no sistema, True para ativo e False para inativo.
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
	 * @param descricao A descrição do problema.
	 * @param viabilidade A viabilidade do problema ser resolvido.
	 */
	public void cadastraProblema(String descricao, int viabilidade) {
		this.controllerProblemaObjetivo.cadastraProblema(descricao, viabilidade);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos os parâmetros a serem cadastrados.
	 * 
	 * @param tipo O tipo do objetivo.
	 * @param descricao A descricao do objetivo.
	 * @param aderenciaProblema O problema Aderencia ao problema.
	 * @param viabilidade A viabilidade de o objetivo ser concretizado.
	 */
	public void cadastraObjetivo(String tipo, String descricao, int aderenciaProblema, int viabilidade) {
		this.controllerProblemaObjetivo.cadastraObjetivo(tipo, descricao, aderenciaProblema, viabilidade);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a remoção.
	 * 
	 * @param codigo O codigo do problema.
	 */
	public void apagarProblema(String codigo) {
		this.controllerProblemaObjetivo.apagarProblema(codigo);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a remoção.
	 * 
	 * @param codigo O identificador do objetivo.
	 */
	public void apagarObjetivo(String codigo) {
		this.controllerProblemaObjetivo.apagarObjetivo(codigo);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a exibição.
	 * 
	 * @param codigo O identificador do problema.
	 * @return A represetação textual do problema.
	 */
	public String exibeProblema(String codigo) {
		return this.controllerProblemaObjetivo.exibeProblema(codigo);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a exibição.
	 * 
	 * @param codigo O identificador do objetivo.
	 * @return A represetação do objetivo.
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
	 * @param Descricao      O objetivo da atividade
	 * @param nivelRisco     O nível de risco que a atividade apresenta
	 * @param descricaoRisco A descrição que explica o nivel de risco apresentado
	 * @return O código da atividade cadastrada.
	 */
	public String cadastraAtividade(String Descricao, String nivelRisco, String descricaoRisco) {
		return this.controllerAtividade.cadastraAtividade(Descricao, nivelRisco, descricaoRisco);
	}

	/**
	 * Método que passa ao controle de atividade os parâmetros para apagar uma atividade.
	 * 
	 * @param codigo O identificador da atividade a ser apagada.
	 */
	public void apagaAtividade(String codigo) {
		this.controllerAtividade.apagaAtividade(codigo);
	}

	/**
	 * Método que cadastra um item à atividade indicada.
	 * 
	 * @param codigo O identificador da atividade.
	 * @param item   O identificador do item a ser cadastrado.
	 */
	public void cadastraItem(String codigo, String item) {
		this.controllerAtividade.cadastraItem(codigo, item);
	}

	/**
	 * Método que passa ao controle de atividade o parâmetro para exibir uma atividade.
	 * 
	 * @param codigo O identificador da atividade.
	 * @return A representação textual da atividade.
	 */
	public String exibeAtividade(String codigo) {
		return this.controllerAtividade.exibeAtividade(codigo);
	}

	/**
	 * Método que passa ao controle de atividade o parâmetro para a contagem de itens pendentes.
	 * 
	 * @param codigo O identificador da atividade.
	 * @return A quantia de itens pendentes.
	 */
	public int contaItensPendentes(String codigo) {
		return this.controllerAtividade.contaItensPendentes(codigo);
	}

	/**
	 * Método que passa ao controle de atividade o parâmetro para a contagem de itens realizados.
	 * 
	 * @param codigo O identificador da atividade.
	 * @return O quantia de itens resolvidos.
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
	 * @param idPesquisa O identificador da pesquisa.
	 * @param idProblema O identificador do problema.
	 * @return O resultado da associação do problema, "True" para associado e "False" para não associado.
	 */
	public boolean associaProblema(String idPesquisa, String idProblema) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		this.validador.valida(idProblema, "Campo idProblema nao pode ser nulo ou vazio.");
		return this.controllerPesquisa.associaProblema(idPesquisa, this.controllerProblemaObjetivo.problema(idProblema));
	}

	/**
	 * Método que passa ao controle de pesquisa os parâmetros a para a desassociação do problema.
	 *
	 * @param idPesquisa O identificador da pesquisa.
	 * @return O resultado da desasssociação do problema, "True" para desassociado e "False" para não desassociado.
	 */
	public boolean desassociaProblema(String idPesquisa) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		return this.controllerPesquisa.desassociaProblema(idPesquisa);
	}

	/**
	 * Método que passa ao controle de pesquisa os parâmetros para a associação do objetivo.
	 *
	 * @param idPesquisa O identificador da pesquisa.
	 * @param idObjetivo O identificador do objetivo.
	 * @return "True" para associado e "False" para não associado.
	 */
	public boolean associaObjetivo(String idPesquisa, String idObjetivo) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		this.validador.valida(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		return this.controllerPesquisa.associaObjetivo(idPesquisa, this.controllerProblemaObjetivo.objetivo(idObjetivo), idObjetivo);
	}

	/**
	 * Método que passa ao controle de pesquisa os parâmetros para a desassociação do objetivo.
	 *
	 * @param idPesquisa O identificador da pesquisa.
	 * @param idObjetivo O identificador do objetivo.
	 * @return "True' para desassociado e "False" para não desassociado.
	 */
	public boolean desassociaObjetivo(String idPesquisa, String idObjetivo) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		this.validador.valida(idObjetivo, "Campo idObjetivo nao pode ser nulo ou vazio.");
		return this.controllerPesquisa.desassociaObjetivo(idPesquisa, idObjetivo);
	}

	/**
	 * Método que passa ao controle de pesquisa o parâmetro para se listar as pesquisas.
	 * 
	 * @param ordem O critério para a ordenação da lista.
	 * @return A lista das pesquisas ordenadas.
	 */
	public String listaPesquisas(String ordem) {
		return this.controllerPesquisa.listaPesquisas(ordem);
	}
	
	/**
	 * US6
	 */
	
	/**
	 * Método que passa ao controle de pesquisador os parâmetros para associar um pesquisador.
	 * 
	 * @param idPesquisa O identificador da pesquisa.
	 * @param emailPesquisador O identificador do pesquisador.
	 * @return "True" para associado e "False" para não associado. 
	 */
	public boolean associaPesquisador(String idPesquisa, String emailPesquisador) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		this.validador.valida(emailPesquisador, "Campo emailPesquisador nao pode ser nulo ou vazio.");
		Pesquisa pesquisa = this.controllerPesquisa.getPesquisa(idPesquisa);
		Pesquisador pesquisador = this.controllerPesquisador.getPesquisador(emailPesquisador);
		this.validador.validaPesquisaAtivada(pesquisa);
		return pesquisador.associaPesquisa(idPesquisa, pesquisa);
	}
	
	/**
	 * Método que repassa ao controle de pesquisador os parâmetros para desassociar um pesquisador.
	 * 
	 * @param idPesquisa O identificador da pesquisa.
	 * @param emailPesquisador O identificador do pesquisador.
	 * @return "True" para desassociado e "False" para não desassociado.
	 */
	public boolean desassociaPesquisador(String idPesquisa, String emailPesquisador) {
		this.validador.valida(idPesquisa, "Campo idPesquisa nao pode ser nulo ou vazio.");
		this.validador.valida(emailPesquisador, "Campo emailPesquisador nao pode ser nulo ou vazio.");
		Pesquisa pesquisa = this.controllerPesquisa.getPesquisa(idPesquisa);
		Pesquisador pesquisador = this.controllerPesquisador.getPesquisador(emailPesquisador);
		this.validador.validaPesquisaAtivada(pesquisa);
		return pesquisador.desassociaPesquisa(idPesquisa, pesquisa);
	}
	
	/**
	 * Método que repassa ao controle de pesquisador os parâmetros para cadastrar a especialidade no professor.
	 * 
	 * @param email O identificador do professor.
	 * @param formacao A formação do professor.
	 * @param unidade A unidade 
	 * @param data A data
	 */
	public void cadastraEspecialidadeProfessor(String email, String formacao, String unidade, String data) {
		this.validador.valida(email, "Campo email nao pode ser nulo ou vazio.");
		this.validador.valida(formacao, "Campo formacao nao pode ser nulo ou vazio.");
		this.validador.valida(unidade, "Campo unidade nao pode ser nulo ou vazio.");
		this.validador.valida(data, "Campo data nao pode ser nulo ou vazio.");
		this.validador.validaData(data);
		this.validador.validaEspecialidadeProfessor(this.controllerPesquisador.getPesquisador(email).getFuncao().toLowerCase());
		this.controllerPesquisador.getPesquisador(email).cadastraEspecialidadeProfessor(formacao, unidade, data);
	}
	
	/**
	 * Método que repassa ao controle de pesquisador os parâmetros para cadastrar a especialidade no aluno
	 * 
	 * @param email O identificador do aluno.
	 * @param semestre
	 * @param IEA
	 */
	public void cadastraEspecialidadeAluno(String email, int semestre, double IEA) {
		this.validador.valida(email, "Campo email nao pode ser nulo ou vazio.");
		this.validador.validaSemestre(semestre);
		this.validador.validaIEA(IEA);
		this.validador.validaEspecialidadeAluno(this.controllerPesquisador.getPesquisador(email).getFuncao());
		this.controllerPesquisador.getPesquisador(email).cadastraEspecialidadeAluno(semestre, IEA);
	}
	
	/**
	 * Método que repassa ao controlador de pesquisador os parâmetros para a listagem dos pesquisadores.
	 * 
	 * @param tipo
	 * @return A lista dos pesquisadores.
	 */
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
	 * @param codigoPesquisa  da pesquisa.
	 * @param codigoAtividade Código da atividade.
	 * @return "True" se a associação for bem sucedida e "False" se a associação não acontecer.
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
	 * @param codigoAtividade O identificador da atividade.
	 * @param item            O item a ser executado.
	 * @param duracao         A quantidade de horas gastas em determinada atividade.
	 */
	public void executaAtividade(String codigoAtividade, int item, int duracao) {
		this.controllerAtividade.executaAtividade(codigoAtividade, item, duracao);
	}

	/**
	 * Método passa ao controlador de atividade os parâmetros a serem cadastrados.
	 * 
	 * @param codigoAtividade O identificador da atividade.
	 * @param resultado       O resultado da atividade.
	 * @return O número identificador do resultado.
	 */
	public int cadastraResultado(String codigoAtividade, String resultado) {
		return this.controllerAtividade.cadastraResultado(codigoAtividade, resultado);
	}

	/**
	 * Método passa ao controlador de atividade os parâmetros a serem removidos.
	 * 
	 * @param codigoAtividade O identificador da atividade.
	 * @param numeroResultado O número identificador do resultado.
	 * @return "True" se a remoção for bem sucedida e "False" se a remocão não acontecer.
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
	 * @param codigoAtividade O identificador da atividade.
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
	 * Método que retona o objetivo.
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
	 */
	public ControllerAtividade getControllerAtividade() {
		return this.controllerAtividade;
	}
	
	/**
	 * US10
	 */
	/**
	 * Método que repassa ao controle de pesquisa os parâmetros para se configurar a estratégia.
	 * 
	 * @param estrategia A estratégia a ser configurada.
	 */
	public void configuraEstrategia(String estrategia) {
		this.controllerPesquisa.configuraEstrategia(estrategia);
	}
	
	/**
	 * Método que repasa ao controle de pesquisa os parâmetros para sugerir a próxima atividade.
	 * 
	 * @param codigoPesquisa O identificador da pesquisa.
	 * @return A representação da próxima atividade.
	 */
	public String proximaAtividade(String codigoPesquisa) {
		return this.controllerPesquisa.proximaAtividade(codigoPesquisa);
	}

}
