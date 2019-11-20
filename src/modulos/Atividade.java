package modulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import util.Validador;

public class Atividade implements Serializable {

	/**
	 * Descrição da atividade.
	 * 
	 */
	private String descricao;

	/**
	 * Resultados (items) da atividade.
	 * 
	 */
	private List<Item> items;
	
	/**
	 * Lista de resultados.
	 * 
	 */
	private List<String> resultados;
	
	/**
	 * booleano que representa se uma atividade está associada a uma pesquisa.
	 * 
	 */
	private boolean ehAssociada;

	/**
	 * Nivel de risco da atividade.
	 * 
	 */
	private String nivelRisco;

	/**
	 * Descrição que justifica o nivel de risco da atividade.
	 * 
	 */
	private String descricaoRisco;

	/**
	 * Codigo identificador da atividade.
	 * 
	 */
	private String codigo;

	/**
	 * Instância validador.
	 * 
	 */
	private Validador validador;
	
	/**
	 * Codigo identificador dos resultado.
	 * 
	 */
	private int contResultado;
	
	/**
	 * A quantidade de horas gastas em determinada atividade.
	 * 
	 */
	private int duracao;

	/**
	 * Construtor de Atividade de uma pesquisa científica.
	 * 
	 * @param descricao      A descrição da atividade.
	 * @param nivelRisco     O nivel de risco da atividade.
	 * @param descricaoRisco A descrição do risco da atividade.
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
	 * Método responsável por listar a representação textual dos itens da atividade.
	 * 
	 * @return Os itens cadastrados da atividade.
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
	 * @param item O identificador do item a ser cadastrado.
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
	 * Metódo que retorna a quantidade de itens pendentes na atividade.
	 * 
	 * @return O número da quantidade de itens pendentes.
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
	 * Método que retorna a quantidade de itens realizados na atividade.
	 * 
	 * @return O número da quantidade de itens realizados.
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
	 * Método que gera o código da atividade.
	 * 
	 * @param numero O código a ser usado na atividade.
	 */
	public void concatenaCodigo(int numero) {
		this.codigo += numero;
	}

	/**
	 * Método que recupera o código da atividade.
	 * 
	 * @return O código da atividade.
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * Método que constrói a representação textual da atividade.
	 * 
	 */
	@Override
	public String toString() {
		String retorno = this.descricao + " (" + this.nivelRisco + " - " + this.descricaoRisco + ")" + " | "
				+ listaItens();
		return retorno.substring(0, retorno.length() - 3);
	}

	/**
	 * Método que executa uma atividade já associada a uma pesquisa.
	 * 
	 * @param codigoAtividade O identificador da atividade.
	 * @param item            O item a ser executado.
	 * @param duracao         A quantidade de horas gastas nessa execução.
	 */
	public void executaAtividade(String codigoAtividade, int item, int duracao) {
		for (int i = 0; i < items.size(); i++) {
			items.get(item - 1).setStatus("REALIZADO");

		}
		this.duracao += duracao;
	}

	/**
	 * Método que adiciona um resultado.
	 * 
	 * @param resultado O resultado a ser adicionado.
	 * @return O identificador do resultado.
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
	 * Método qu remove um resultado.
	 * 
	 * @param numeroResultado O resultado a ser removido.
	 * @return O identificador do resultado.
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
	 * Método que lista todos os resultados.
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

	/**
	 * Método que retorna o valor do atributo duração.
	 * 
	 * @return
	 */
	public int getDuracao() {
		return duracao;
	}
	
	/**
	 * Método que retorna o valor do atributo descrição.
	 * 
	 * @return
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Método que altera a atividade para associada.
	 * 
	 */
	public void setEhAssociada() {
		this.ehAssociada = true;
	}

	/**
	 * Método que retorna se a atividade está associada.
	 * 
	 * @return "True" para associada e "False" para não associada.
	 */
	public boolean isEhAssociada() {
		return ehAssociada;
	}

	/**
	 * Método que altera a atividade para não associada.
	 * 
	 */
	public void setNaoAssociada() {
		this.ehAssociada = false;
	}

	/**
	 * Método que retorna o status do item.
	 * 
	 * @param item O item a ser verificado.
	 * @return A verificação do item.
	 */
	public String getStatus(int item) {
		return this.items.get(item - 1).getStatus();
	}
	
	/**
	 * Métode de representação textual usado para exibir o resultado de busca
	 * 
	 * @return A representação da busca.
	 */
	public String toStringBusca() {		
		return String.format("%s: %s | ",this.codigo, this.descricao);
	}
		
	/**
	 * 
	 * @return
	 */
	public List<String> getResultados() {
		return resultados;
	}
	
	/**
	 * Método que retorna os itens da lista.
	 * 
	 * @return Os itens contidos na lista.
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * Método que retorna o nivel de risco.
	 * 
	 * @return O nivel de risco.
	 */
	public String getNivelRisco() {
		return nivelRisco;
	}
	
	/**
	 * Método que retornar a descrição do risco.
	 * 
	 * @return A descrição do risco.
	 */
	public String getDescricaoRisco() {
		return descricaoRisco;
	}

	

}