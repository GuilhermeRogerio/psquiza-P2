package modulos;

import java.util.ArrayList;
import util.Validador;

public class Atividade {
	
	/**
	 * Descrição da atividade
	 */
	private String descricao;

	/**
	 * Resultados (items) da atividade.
	 */
	private ArrayList<Item> resultados;
	
	/**
	 * Nivel de risco da atividade
	 */
	private String nivelRisco;
	
	/**
	 * Descrição que justifica o nivel de risco da atividade
	 */
	private String descricaoRisco;
	
	/**
	 * Codigo identificador da atividade
	 */
	private String codigo;
	
	/**
	 * Instância validador
	 */
	private Validador validador;
	
	
	/**
	 * Construtor de Atividade de uma pesquisa científica
	 * 
	 * @param descricao - Descrição da atividade
	 * @param nivelRisco - Nivel de risco da atividade
	 * @param descricaoRisco - Descrição do risco da atividade
	 */
	public Atividade(String descricao, String nivelRisco, String descricaoRisco) {
		this.descricao = descricao;
		this.nivelRisco = nivelRisco;
		this.descricaoRisco = descricaoRisco;
		this.resultados = new ArrayList();
		this.codigo = "A";
		this.validador = new Validador();
	}
	
	/**
	 * Método responsável por lista a representação textual dos itens da atividade
	 * 
	 * @return - Todos os itens cadastrados da atividade
	 */
	public String listaItens() {
		if (this.resultados.size() > 0) {
			String retorno = "";
			for (Item item : this.resultados) {
				retorno += item.toString() + " | ";
			}
			return retorno;
		} else {
			return "";
		}
	}
	
	/**
	 * Método que cadastra um item na atividade
	 * 
	 * @param item - Código do item a ser cadastrado
	 */
	public void cadastraItem(String item) {
		this.validador.valida(item, "Campo codigo nao pode ser nulo ou vazio.");
		if (this.resultados.contains(item)) {
			throw new IllegalArgumentException("Item já existente nessa atividade");
		} else {
			Item novoItem = new Item(item);
			this.resultados.add(novoItem);
		}
	}
	
	
	/**
	 * Retorna quantos itens ainda estão pendentes na atividade. 
	 * 
	 * @return Número que representa quantos itens estão pendentes
	 */
	public int contaItensPendentes() {
		int contador = 0;
		for (Item item : this.resultados) {
			if (item.getStatus().equals("PENDENTE")) {
				contador += 1;
			}
		}
		return contador;
	}
	
	/**
	 * Retorna quantos itens foram realizados na atividade. 
	 * 
	 * @return Número que representa quantos itens foram realizados
	 */
	public int contaItensRealizados() {
		int contador = 0;
		for (Item item : this.resultados) {
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
	 * Forma o código da atividade
	 * 
	 * @param numero - Código a ser usado na atividade
	 */
	public void concatenaCodigo(int numero) {
		this.codigo += numero;
	}
	
	/**
	 * Recupera o código da atividade
	 * 
	 * @return - Código da atividade
	 */
	public String getCodigo() {
		return this.codigo;
	}
	
	
	@Override
	public String toString() {
		String retorno = this.descricao + " (" + this.nivelRisco + " - " + this.descricaoRisco + ")" + " | " + listaItens();
		return retorno.substring(0, retorno.length() - 3);
	}
	
	/**
	 * toString usado para exibir o resultado de busca
	 * 
	 * @return {@link String}
	 */
	public String toStringBusca() {		
		return String.format("%s: %s | ",this.codigo, this.descricao);
	}
	
	

}