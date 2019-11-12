package controladores;

import java.util.HashMap;

import modulos.Atividade;
import util.Validador;

/**
 * Controller da atividade.
 * 
 * @author matheusfls-ccc (Matheus Filipe de Lima Souza)
 *
 */
public class ControllerAtividade {

	/**
	 * Mapa que guarda as atividades cadastradas.
	 */
	private HashMap<String, Atividade> atividades;

	/**
	 * Validador, que verifica os parâmetros dos métodos para tratamento.
	 */
	private Validador validador;

	/**
	 * Código utilizado para identificar as atividades.
	 */
	private int codigo;

	/**
	 * Construtor do controller, que será utilizado pelo controller geral.
	 */
	public ControllerAtividade() {
		this.atividades = new HashMap<>();
		this.validador = new Validador();
		this.codigo = 1;
	}

	/**
	 * Método que cadastra a atividade no sistema.
	 * 
	 * @param descricao      - Objetivo da atividade
	 * @param nivelRisco     - Nivel de risco que a atividade apresenta
	 * @param descricaoRisco - Descrição que explica o nivel de risco apresentado
	 * @return Código da atividade que acabou de ser cadastrada
	 */
	public String cadastraAtividade(String descricao, String nivelRisco, String descricaoRisco) {
		this.validador.valida(descricao, "Campo Descricao nao pode ser nulo ou vazio.");
		this.validador.valida(nivelRisco, "Campo nivelRisco nao pode ser nulo ou vazio.");
		this.validador.valida(descricaoRisco, "Campo descricaoRisco nao pode ser nulo ou vazio.");
		this.validador.validaNivelRisco(nivelRisco, "Valor invalido do nivel do risco.");
		Atividade atividade = new Atividade(descricao, nivelRisco, descricaoRisco);
		atividade.concatenaCodigo(this.codigo);
		this.atividades.put((atividade.getCodigo()), atividade);
		this.codigo += 1;
		return atividade.getCodigo();
	}

	/**
	 * Método responsável por apagar uma atividade do sistema.
	 * 
	 * @param codigo - Código da atividade a ser apagada.
	 */
	public void apagaAtividade(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (!this.atividades.containsKey(codigo)) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		} else {
			this.atividades.remove(codigo);
		}

	}

	/**
	 * Método que cadastra um item à atividade indicada.
	 * 
	 * @param codigo - Código da atividade
	 * @param item   - Código do item a ser cadastrado.
	 */
	public void cadastraItem(String codigo, String item) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		this.validador.valida(item, "Item nao pode ser nulo ou vazio.");
		if (!this.atividades.containsKey(codigo)) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		} else {
			this.atividades.get(codigo).cadastraItem(item);
		}
	}

	/**
	 * Exibe informações sobre a atividade e seus respectivos itens.
	 * 
	 * @param codigo - Código da atividade que se deseja
	 * @return - Representação textual da atividade.
	 */
	public String exibeAtividade(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (!this.atividades.containsKey(codigo)) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		} else {
			return this.atividades.get(codigo).toString();
		}
	}

	/**
	 * Retorna quantos itens ainda estão pendentes na atividade.
	 * 
	 * @param codigo - Código da atividade
	 * @return - Quantia de itens pendentes.
	 */
	public int contaItensPendentes(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (!this.atividades.containsKey(codigo)) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		} else {
			return this.atividades.get(codigo).contaItensPendentes();
		}
	}

	/**
	 * Retorna quantos itens já foram realizados na atividade.
	 * 
	 * @param codigo - Código da atividade
	 * @return - Quantia de itens resolvidos.
	 */
	public int contaItensRealizados(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (!this.atividades.containsKey(codigo)) {
			throw new IllegalArgumentException("Atividade nao encontrada");
		} else {
			return this.atividades.get(codigo).contaItensRealizados();
		}
	}
	
	public Atividade getAtividade(String id) {
		return this.atividades.get(id);
	}

	/**
	 * Executa uma atividade já associada a uma pesquisa.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @param item            Item a ser executado.
	 * @param duracao         Quantidade de horas gastas nessa execução.
	 */
	public void executaAtividade(String codigoAtividade, int item, int duracao) {
		this.validador.valida(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		this.validador.validaItem(item, "Item nao pode ser nulo ou negativo.");
		this.validador.validaItem(duracao, "Duracao nao pode ser nula ou negativa.");
		if(item -1 >this.atividades.size()) {
			throw new IllegalArgumentException("Item nao encontrado.");
		}
		else if(this.atividades.get(codigoAtividade).getStatus(item).equals("REALIZADO")) {
			throw new IllegalArgumentException("Item ja executado.");
		}else {
			this.atividades.get(codigoAtividade).executaAtividade(codigoAtividade, item, duracao);
		}
		
		
	}

	/**
	 * Cadastra os resultados obtidos por item da atividade.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @param resultado       Resultado da atividade.
	 * @return Número identificador do resultado.
	 */
	public int cadastraResultado(String codigoAtividade, String resultado) {
		this.validador.valida(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		this.validador.valida(resultado, "Resultado nao pode ser nulo ou vazio.");
		return this.atividades.get(codigoAtividade).addResultado(resultado);
	}

	/**
	 * Remove os resultados obtidos por item da atividade.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @param numeroResultado Número identificador do resultado.
	 * @return "True" se a remoção for bem sucedida e "False" se a remocão não
	 *         acontecer.
	 */
	public boolean removeResultado(String codigoAtividade, int numeroResultado) {
		this.validador.valida(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		this.validador.validaItem(numeroResultado, "numeroResultado nao pode ser nulo ou negativo.");
		if (this.atividades.containsKey(codigoAtividade)) {
			return this.atividades.get(codigoAtividade).removeResultado(numeroResultado);
		} else {
			throw new IllegalArgumentException("Atividade nao encontrada");
		}

	}

	/**
	 * Retorna a quantidade de horas gastas em determinada atividade.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @return A quantidade de horas gastas em determinada atividade.
	 */
	public int getDuracao(String codigoAtividade) {
		this.validador.valida(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		if (this.atividades.containsKey(codigoAtividade)) {
			return this.atividades.get(codigoAtividade).getDuracao();
		} else {
			throw new IllegalArgumentException("Atividade nao encontrada");
		}
	}

	/**
	 * Lista todos os resultados de uma determinada atividade.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @return Os resultados de uma determinada atividade.
	 */
	public String listaResultados(String codigoAtividade) {
		this.validador.valida(codigoAtividade, "Campo codigoAtividade nao pode ser nulo ou vazio.");
		if(this.atividades.containsKey(codigoAtividade)) {
			return this.atividades.get(codigoAtividade).listaResultados();
		}else {
			throw new IllegalArgumentException("Atividade nao encontrada");
		}
		
	}

}