package modulos;

import util.Validador;

/**
 * Representação de um objetivo
 * 
 * @author Guilherme Rogerio
 *
 */
public class Objetivo {
	/**
	 * Tipo do objetivo que pode ser GERAL ou ESPECIFICO.
	 */
	private String tipo;
	/**
	 * Descricao do objetivo.
	 */
	private String descricao;
	/**
	 * Objeto para validar os parametros.
	 */
	private Validador validador;
	/**
	 * Aderencia ao problema.
	 */
	private int aderencia;
	/**
	 * Viabilidade de o objetivo ser concretizado
	 */
	private int viabilidade;
	/**
	 * Soma da aderencia + viabilidade.
	 */
	private int valor;

	/**
	 * Constroi um objetivo e calcula o valor.
	 * 
	 * @param tipo        Descricao do objetivo
	 * @param descricao   Objeto para validar os parametros
	 * @param aderencia   Aderencia ao problema
	 * @param viabilidade Viabilidade de o objetivo ser concretizado
	 */
	public Objetivo(String tipo, String descricao, int aderencia, int viabilidade) {
		this.validador = new Validador();
		this.validador.validaObjetivo(tipo, descricao, aderencia, viabilidade);
		this.tipo = tipo;
		this.descricao = descricao;
		this.aderencia = aderencia;
		this.viabilidade = viabilidade;
		this.valor = aderencia + viabilidade;

	}

	/**
	 * Retorna uma string com a representação do objetivo no formato de "Tipo -
	 * descricao - valor".
	 */
	public String toString() {
		return this.tipo + " - " + this.descricao + " - " + this.valor;
	}

}
