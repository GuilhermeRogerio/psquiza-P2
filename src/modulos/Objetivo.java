package modulos;

import util.Validador;

/**
 * Representação de um objetivo.
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
	 * Codigo identificador do objetivo.
	 */
	private String codigo;
	/**
	 * Viabilidade de o objetivo ser concretizado
	 */
	private int viabilidade;
	/**
	 * Soma da aderencia + viabilidade.
	 */
	private int valor;
	
	private boolean associado;

	/**
	 * Constroi um objetivo,inicia o validador e calcula o valor.
	 * 
	 * @param tipo        Tipo do objetivo que pode ser GERAL ou ESPECIFICO.
	 * @param descricao   Descricao do objetivo.
	 * @param aderencia   Aderencia ao problema
	 * @param viabilidade Viabilidade de o objetivo ser concretizado
	 */
	public Objetivo(String tipo, String descricao, int aderencia, int viabilidade) {
		this.validador = new Validador();
		this.validador.validaObjetivo(tipo, descricao, aderencia, viabilidade);
		this.tipo = tipo;
		this.descricao = descricao;
		this.aderencia = aderencia;
		this.codigo = "O";
		this.viabilidade = viabilidade;
		this.valor = aderencia + viabilidade;

	}

	/**
	 * Forma o código do objetivo.
	 * 
	 * @param numero - Código a ser usado no objetivo.
	 */
	public void geraCodigo(int numero) {
		this.codigo += numero;
	}

	/**
	 * Retorna uma string com a representação do objetivo no formato de "Tipo -
	 * descricao - valor".
	 */
	public String toString() {
		return this.codigo + " - " + this.tipo + " - " + this.descricao + " - " + this.valor;
	}
	
	/**
	 * toString usado para exibir o resultado de busca
	 * 
	 * @return {@link String}
	 */
	public String toStringBusca() {		
		return String.format("%s: %s | ",this.codigo, this.descricao);
	}

	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * US5
	 */
	
	public boolean isAssociado() {
		return associado;
	}

	public void setAssociado(boolean estadoOjetivo) {
		this.associado = estadoOjetivo;
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
		Objetivo other = (Objetivo) obj;
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
