package modulos;

import util.Validador;

/**
 * Representação de um problema.
 * 
 * @author Guilherme Rogerio
 *
 */
public class Problema {
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
		this.validador = new Validador();
		this.validador.validaProblema(descricao, viabilidade);
		this.descricao = descricao;
		this.viabilidade = viabilidade;
		this.codigo = "P";
	}

	/**
	 * Forma o código do problema.
	 * 
	 * @param numero - Código a ser usado no problema.
	 */
	public void geraCodigo(int numero) {
		this.codigo += numero;
	}

	/**
	 * Retorna uma string com a representação textual de problema no formato de
	 * "Descrição - viabiladade".
	 */
	public String toString() {
		return this.codigo + " - " + this.descricao + " - " + this.viabilidade;
	}

	public String getCodigo() {
		return codigo;
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
