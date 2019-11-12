package controladores;

/**
 * Controloador responsavel por gerir o sistema.
 *
 */
public class ControllerGeral {

	/**
	 * Instância do contrololador da Pesquisa
	 * 
	 */
	private ControllerPesquisa controllerPesquisa;

	/**
	 * Instância do controlador do fornecedor
	 *
	 */
	private ControllerProblemaObjetivo controllerProblemaObjetivo;

	/**
	 * Instância do controlador do fornecedor
	 *
	 */
	private ControllerPesquisador controllerPesquisador;
	
	/**
	 * Instância do controlador de atividade
	 */
	private ControllerAtividade controllerAtividade;

	/**
	 * Construtor que inicializa os controladores instâciados.
	 */
	public ControllerGeral() {
		this.controllerPesquisa = new ControllerPesquisa();
		this.controllerProblemaObjetivo = new ControllerProblemaObjetivo();
		this.controllerPesquisador = new ControllerPesquisador();
		this.controllerAtividade = new ControllerAtividade();
	}

	/**
	 * US1
	 */
	
	/**
	 * Método passa ao controlador de pesquisa os parâmetros a serem cadastrados
	 * @author adyssonfs 
	 * @param descricao: resumo descritivo da pesquisa
	 * @param campoDeInteresse: areas que são abrangidas pela pesquisa. 
	 * A entrada deve ser até 255 caracteres. Cada area é separada por vírgula  
	 * */
	public void cadastraPesquisa(String descricao, String campoDeInteresse) {
		this.controllerPesquisa.cadastraPesquisa(descricao, campoDeInteresse);
	}
	
	/**
	 * Método passa ao controlador de pesquisa os parâmetros a serem alterados em pesquisa
	 * @author adyssonfs 
	 * @param codigo: identificador da pesquisa
	 * @param campoASerAlterado: pode ser "CAMPO" ou "DESCRICAO"
	 * */
	public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
		this.controllerPesquisa.alteraPesquisa(codigo, conteudoASerAlterado, novoConteudo);
	}
	
	/**
	 * Método passa ao controlador de pesquisa os parâmetros que da pesquisa a ser encerrada
	 * @author adyssonfs 
	 * @param codigo: identificador da pesquisa
	 * @param motivo: motivação para o encerramento da pesquisa"
	 * */
	public void encerraPesquisa(String codigo, String motivo) {
		this.controllerPesquisa.encerraPesquisa(codigo, motivo);
	}
	
	
	/**
	 * Método passa ao controlador de pesquisa os parâmetros para a ativação da pesquisa
	 * @author adyssonfs 
	 * @param codigo: identificador da pesquisa
	 * */
	public void ativaPesquisa(String codigo) {
		this.controllerPesquisa.ativaPesquisa(codigo);
	}
	
	/**
	 * Método passa ao controlador de pesquisa os parâmetros para a exibição da pesquisa
	 * @author adyssonfs 
	 * @param codigo: identificador da pesquisa
	 * */
	public String exibePesquisa(String codigo) {
		return this.controllerPesquisa.exibePesquisa(codigo);
	}
	
	/**
	 * Método passa ao controlador de pesquisa os parâmetros para a verificação da atividade da pesquisa
	 * @author adyssonfs 
	 * @param codigo: identificador da pesquisa
	 * */
	public boolean pesquisaEhAtiva(String codigo) {
		return this.controllerPesquisa.pesquisaEhAtiva(codigo);
	}
	
	public ControllerPesquisa getControllerPesquisa() {
		return controllerPesquisa;
	}
	
	/**
	 * US2
	 */

	/**
	 * Método que passa ao controlador dos pesquisadores os parâmetros a serem
	 * cadastrados.
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
	 * Método que passa ao controlador dos pesquisadores os parâmetros a serem
	 * alterados.
	 * 
	 * @param email     o email identificador do pesquisador.
	 * @param atributo  o atributo a ser alterado.
	 * @param novoValor o novo valor do atributo.
	 */
	public void alteraPesquisador(String email, String atributo, String novoValor) {
		this.controllerPesquisador.alteraPesquisador(email, atributo, novoValor);
	}

	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a
	 * desativação.
	 * 
	 * @param email o email identificador do pesquisador.
	 */
	public void desativaPesquisador(String email) {
		this.controllerPesquisador.desativaPesquisador(email);
	}

	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a
	 * ativação.
	 * 
	 * @param email o email identificador do pesquisador.
	 */
	public void ativaPesquisador(String email) {
		this.controllerPesquisador.ativaPesquisador(email);
	}

	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a
	 * exibição.
	 * 
	 * @param email o email identificador do pesquisador.
	 * @return a representação do pesquisador.
	 */
	public String exibePesquisador(String email) {
		return this.controllerPesquisador.exibePesquisador(email);
	}

	/**
	 * Método que passa ao controlador dos pesquisadores o parâmetro para a
	 * verificação do estado.
	 * 
	 * @param email o email identificador do pesquisador.
	 * @return o estado do pesquisador no sistema.
	 */
	public boolean pesquisadorEhAtivo(String email) {
		return this.controllerPesquisador.pesquisadorEhAtivo(email);
	}
	
	/**
	 * Retorna o controlador da classe Pesquisador
	 * */
	public ControllerPesquisador getControllerPesquisador() {
		return controllerPesquisador;
	}

	/**
	 * US3
	 */

	/**
	 * Método que passa ao controlador dos problemas e objetivos os parâmetros a
	 * serem cadastrados.
	 * 
	 * @param descricao   Descrição do problema.
	 * @param viabilidade Viabilidade do problema ser resolvido.
	 */
	public void cadastraProblema(String descricao, int viabilidade) {
		this.controllerProblemaObjetivo.cadastraProblema(descricao, viabilidade);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos os parâmetros a
	 * serem cadastrados.
	 * 
	 * @param tipo        Tipo do objetivo que pode ser GERAL ou ESPECIFICO.
	 * @param descricao   Descricao do objetivo.
	 * @param aderencia   Problema Aderencia ao problema.
	 * @param viabilidade Viabilidade de o objetivo ser concretizado.
	 */
	public void cadastraObjetivo(String tipo, String descricao, int aderenciaProblema, int viabilidade) {
		this.controllerProblemaObjetivo.cadastraObjetivo(tipo, descricao, aderenciaProblema, viabilidade);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a
	 * remoção.
	 * 
	 * @param codigo Codigo do problema.
	 */
	public void apagarProblema(String codigo) {
		this.controllerProblemaObjetivo.apagarProblema(codigo);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a
	 * remoção.
	 * 
	 * @param codigo Codigo do objetivo.
	 */
	public void apagarObjetivo(String codigo) {
		this.controllerProblemaObjetivo.apagarObjetivo(codigo);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a
	 * exibição.
	 * 
	 * @param codigo Codigo do problema.
	 * @return a represetação do problema.
	 */
	public String exibeProblema(String codigo) {
		return this.controllerProblemaObjetivo.exibeProblema(codigo);
	}

	/**
	 * Método que passa ao controlador dos problemas e objetivos o parâmetro para a
	 * exibição.
	 * 
	 * @param codigo Codigo do objetivo.
	 * @return a represetação do objetivo.
	 */
	public String exibeObjetivo(String codigo) {
		return this.controllerProblemaObjetivo.exibeObjetivo(codigo);
	}
	
	/**
	 * US4
	 */
	
	/**
	 * Método que cadastra a atividade no sistema. 
	 * 
	 * @param descricao - Objetivo da atividade
	 * @param nivelRisco - Nivel de risco que a atividade apresenta
	 * @param descricaoRisco - Descrição que explica o nivel de risco apresentado
	 * @return Código da atividade que acabou de ser cadastrada
	 */
	public String cadastraAtividade(String Descricao, String nivelRisco, String descricaoRisco) {
		return this.controllerAtividade.cadastraAtividade(Descricao, nivelRisco, descricaoRisco);
	}
	
	/**
	 * Método responsável por apagar uma atividade do sistema. 
	 * 
	 * @param codigo - Código da atividade a ser apagada. 
	 */
	public void apagaAtividade(String codigo) {
		this.controllerAtividade.apagaAtividade(codigo);
	}
	
	/**
	 * Método que cadastra um item à atividade indicada. 
	 * 
	 * @param codigo - Código da atividade
	 * @param item - Código do item a ser cadastrado. 
	 */
	public void cadastraItem(String codigo, String item) {
		this.controllerAtividade.cadastraItem(codigo, item);
	}
	
	/**
	 * Exibe informações sobre a atividade e seus respectivos itens.
	 * 
	 * @param codigo - Código da atividade que se deseja
	 * @return - Representação textual da atividade. 
	 */
	public String exibeAtividade(String codigo) {
		return this.controllerAtividade.exibeAtividade(codigo);
	}
	
	/**
	 * Retorna quantos itens ainda estão pendentes na atividade. 
	 * 
	 * @param codigo - Código da atividade
	 * @return - Quantia de itens pendentes. 
	 */
	public int contaItensPendentes(String codigo) {
		return this.controllerAtividade.contaItensPendentes(codigo);
	}
	
	/**
	 * Retorna quantos itens já foram realizados na atividade.
	 * 
	 * @param codigo - Código da atividade
	 * @return - Quantia de itens resolvidos. 
	 */
	public int contaItensRealizados(String codigo) {
		return this.controllerAtividade.contaItensRealizados(codigo);
	}

	
	/**
	 * Retorna o controlador dos módulos Problema-Objetivo
	 * 
	 * @return ControllerProblemaObjetivo
	 * */
	public ControllerProblemaObjetivo getControllerProblema() {
		// TODO Auto-generated method stub
		return this.controllerProblemaObjetivo;
	}

}
