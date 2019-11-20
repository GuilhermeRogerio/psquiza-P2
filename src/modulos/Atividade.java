package modulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.Validador;

public class Atividade implements Serializable {

	/**
	 * Descrição da atividade
	 */
	private String descricao;

	/**
	 * Resultados (items) da atividade.
	 */
	private List<Item> items;
	/**
	 * Lista de resultados.
	 */
	private List<String> resultados;
	/**
	 * booleano que representa se uma atividade está associada a uma pesquisa.
	 */
	private boolean ehAssociada;

	/**
	 * Nivel de risco da atividade.
	 */
	private String nivelRisco;

	/**
	 * Descrição que justifica o nivel de risco da atividade.
	 */
	private String descricaoRisco;

	/**
	 * Codigo identificador da atividade.
	 */
	private String codigo;

	/**
	 * Instância validador.
	 */
	private Validador validador;
	/**
	 * Codigo identificador dos resultado.
	 */
	private int contResultado;
	/**
	 * A quantidade de horas gastas em determinada atividade.
	 */
	private int duracao;

	/**
	 * Construtor de Atividade de uma pesquisa científica.
	 * 
	 * @param descricao      - Descrição da atividade.
	 * @param nivelRisco     - Nivel de risco da atividade.
	 * @param descricaoRisco - Descrição do risco da atividade.
	 */
	public Atividade(String descricao, String nivelRisco, String descricaoRisco) {
		this.descricao = descricao;
		this.nivelRisco = nivelRisco;
		this.descricaoRisco = descricaoRisco;
		this.items = new ArrayList();
		this.resultados = new ArrayList<>();
		this.codigo = "A";
		this.contResultado = 0;
		this.duracao = 0;
		this.ehAssociada = false;
		this.validador = new Validador();
	}

	/**
	 * Método responsável por lista a representação textual dos itens da atividade.
	 * 
	 * @return - Todos os itens cadastrados da atividade.
	 */
	public String listaItens() {
		if (this.items.size() > 0) {
			String retorno = "";
			for (Item item : this.items) {
				retorno += item.toString() + " | ";
			}
			return retorno;
		} else {
			return "";
		}
	}

	/**
	 * Método que cadastra um item na atividade.
	 * 
	 * @param item - Código do item a ser cadastrado.
	 */
	public void cadastraItem(String item) {
		this.validador.valida(item, "Campo codigo nao pode ser nulo ou vazio.");
		if (this.items.contains(item)) {
			throw new IllegalArgumentException("Item já existente nessa atividade");
		} else {
			Item novoItem = new Item(item);
			this.items.add(novoItem);
		}
	}

	/**
	 * Retorna quantos itens ainda estão pendentes na atividade.
	 * 
	 * @return Número que representa quantos itens estão pendentes.
	 */
	public int contaItensPendentes() {
		int contador = 0;
		for (Item item : this.items) {
			if (item.getStatus().equals("PENDENTE")) {
				contador += 1;
			}
		}
		return contador;
	}

	/**
	 * Retorna quantos itens foram realizados na atividade.
	 * 
	 * @return Número que representa quantos itens foram realizados.
	 */
	public int contaItensRealizados() {
		int contador = 0;
		for (Item item : this.items) {
			if (item.getStatus().equals("REALIZADO")) {
				contador += 1;
			}
		}
		return contador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	/**
	 * Forma o código da atividade.
	 * 
	 * @param numero - Código a ser usado na atividade.
	 */
	public void concatenaCodigo(int numero) {
		this.codigo += numero;
	}

	/**
	 * Recupera o código da atividade.
	 * 
	 * @return - Código da atividade.
	 */
	public String getCodigo() {
		return this.codigo;
	}

	@Override
	public String toString() {
		String retorno = this.descricao + " (" + this.nivelRisco + " - " + this.descricaoRisco + ")" + " | "
				+ listaItens();
		return retorno.substring(0, retorno.length() - 3);
	}

	/**
	 * Executa uma atividade já associada a uma pesquisa.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @param item            Item a ser executado.
	 * @param duracao         Quantidade de horas gastas nessa execução.
	 */
	public void executaAtividade(String codigoAtividade, int item, int duracao) {
		for (int i = 0; i < items.size(); i++) {
			items.get(item - 1).setStatus("REALIZADO");

		}
		this.duracao += duracao;
	}

	/**
	 * Adiciona um resultado.
	 * 
	 * @param resultado Resultado a ser adicionado.
	 * @return Codigo identificador dos resultado.
	 */
	public int addResultado(String resultado) {
		this.resultados.add(resultado);
		if (!resultado.equals(resultado)) {
			this.contResultado = 0;
		}
		this.contResultado += 1;

		return this.contResultado;
	}

	/**
	 * Remove um resultado.
	 * 
	 * @param numeroResultado
	 * @return Codigo identificador dos resultado.
	 */
	public boolean removeResultado(int numeroResultado) {
		if (numeroResultado - 1 > this.resultados.size()) {
			throw new IllegalArgumentException("Resultado nao encontrado.");
		} else {
			this.resultados.remove(numeroResultado - 1);
			return true;
		}
	}

	/**
	 * Lista todos os resultados.
	 * 
	 * @return Uma string com todos os resultados.
	 */
	public String listaResultados() {
		String retorno = "";
		for (int i = 0; i < resultados.size(); i++) {
			retorno += resultados.get(i).toString() + " | ";
		}
		return retorno = retorno.substring(0, retorno.length() - 3);
	}

	public int getDuracao() {
		return duracao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setEhAssociada() {
		this.ehAssociada = true;
	}

	public boolean isEhAssociada() {
		return ehAssociada;
	}

	public void setNaoAssociada() {
		this.ehAssociada = false;
	}

	public String getStatus(int item) {
		return this.items.get(item - 1).getStatus();
	}
	
	/**
	 * toString usado para exibir o resultado de busca
	 * 
	 * @return {@link String}
	 */
	public String toStringBusca() {		
		return String.format("%s: %s | ",this.codigo, this.descricao);
	}
		
	public List<String> getResultados() {
		return resultados;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public String getNivelRisco() {
		return nivelRisco;
	}
	
	public String getDescricaoRisco() {
		return descricaoRisco;
	}

	

}