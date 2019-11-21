package modulos;

import java.io.Serializable;

import util.Validador;

/**
 * Representação de um problema.
 * 
 * @author Guilherme Rogerio
 *
 */
public class Problema implements Serializable {
	/**
	 * Descrição do problema.
	 */
	private String descricao;
	/**
	 * Viabilidade do problema ser resolvido.
	 */
	private int viabilidade;
	/**
	 * Objeto para validar os parametros.
	 */
	private Validador validador;
	/**
	 * Codigo identificador do problema.
	 */
	private String codigo;

	/**
	 * Constroi um problema e inicia o validador.
	 * 
	 * @param descricao   Descrição do problema.
	 * @param viabilidade Viabilidade do problema ser resolvido.
	 */
	public Problema(String descricao, int viabilidade) {
		this.descricao = descricao;
		this.viabilidade = viabilidade;
		this.codigo = "P";
	}

	/**
	 * Método que cria o código do problema.
	 * 
	 * @param numero - Código a ser usado no problema.
	 */
	public void geraCodigo(int numero) {
		this.codigo += numero;
	}
	
	
	/**
	 * Método que retorna uma string com a representação textual de problema no formato de
	 * "Descrição - viabiladade".
	 */
	public String toString() {
		return this.codigo + " - " + this.descricao + " - " + this.viabilidade;
	}
	
	/**
	 * Metodo que cria a representacao textual usada para exibir o resultado de busca
	 * 
	 * @return A representação textual.
	 */
	public String toStringBusca() {		
		return String.format("%s: %s | ",this.codigo, this.descricao);
	}

	/**
	 * Metodo que retorna o codigo do problema.
	 * 
	 * @return O codigo do problema.
	 */
	public String getCodigo() {
		return codigo;
	}
	
    /**
     * Método que retorna um valor que indica a posição do objeto na memória.
     *
     * @return O valor da posição do codigo.
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/*
    * Método que realiza a comparação de dois objetos e retorna se são iguais ou não.
    *
    * @return O valor boleano da comparação.
    */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Problema other = (Problema) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public String getDescricao() {
		return descricao;
	}

}
