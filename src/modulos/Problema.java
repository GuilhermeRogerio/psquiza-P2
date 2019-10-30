package modulos;

import util.Validador;

/**
 * Representação de um problema
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
	 * Constroi um problema
	 * 
	 * @param descricao   Descrição do problema
	 * @param viabilidade Viabilidade do problema ser resolvido
	 */
	public Problema(String descricao, int viabilidade) {
		this.validador = new Validador();
		this.validador.validaProblema(descricao, viabilidade);
		this.descricao = descricao;
		this.viabilidade = viabilidade;
	}

	/**
	 * Retorna uma string com a representação textual de problema no formato de
	 * "Descrição - viabiladade".
	 */
	public String toString() {
		return this.descricao + " - " + this.viabilidade;
	}

}
