package modulos;

import java.io.Serializable;

import util.Validador;

/**
 * Representação de um objetivo.
 * 
 * @author Guilherme Rogerio
 *
 */
public class Objetivo implements Serializable{
	
	/**
	 * Tipo do objetivo que pode ser GERAL ou ESPECIFICO.
	 * 
	 */
	private String tipo;
	
	/**
	 * Descricao do objetivo.
	 * 
	 */
	private String descricao;
	
	/**
	 * Objeto para validar os parâmetros.
	 * 
	 */
	private Validador validador;
	
	/**
	 * Aderencia ao problema.
	 * 
	 */
	private int aderencia;
	
	/**
	 * Código identificador do objetivo.
	 * 
	 */
	private String codigo;
	
	/**
	 * Viabilidade de o objetivo ser concretizado.
	 * 
	 */
	private int viabilidade;
	
	/**
	 * Soma da aderencia + viabilidade.
	 * 
	 */
	private int valor;
	
	/**
	 * Valor booleano que represenata se o objetivo está associado.
	 * 
	 */
	private boolean associado;

	/**
	 * Constroi um objetivo,inicia o validador e calcula o valor.
	 * 
	 * @param tipo        O tipo do objetivo que pode ser GERAL ou ESPECIFICO.
	 * @param descricao   A descricão do objetivo.
	 * @param aderencia   A aderência ao problema
	 * @param viabilidade A viabilidade de o objetivo ser concretizado
	 */
	public Objetivo(String tipo, String descricao, int aderencia, int viabilidade) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.aderencia = aderencia;
		this.codigo = "O";
		this.viabilidade = viabilidade;
		this.valor = aderencia + viabilidade;

	}

	/**
	 * Método que constrói o código do objetivo.
	 * 
	 * @param numero O código a ser usado no objetivo.
	 */
	public void geraCodigo(int numero) {
		this.codigo += numero;
	}

	/**
	 * Método que constrói a representação textual do objetivo.
	 * 
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
	
	/**
	 * Método que retorna se o objeto está associado.
	 * 
	 * @return "True" para associado ou "False" para não associado.
	 */
	public boolean isAssociado() {
		return associado;
	}

	/**
	 * Método que retorna muda o estado de associação do objetivo.
	 * 
	 * @param estadoOjetivo O valor booleano "True" para associar e "False" para desassociar;
	 */
	public void setAssociado(boolean estadoOjetivo) {
		this.associado = estadoOjetivo;
	}

    /**
     * Método que retorna um valor que indica a posição do objeto na memória.
     *
     * @return o valor da posição do código
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

    /**
     * Método que realiza a comparação de dois objetos e retorna se são iguais ou não.
     *
     * @return o valor boleano da comparação.
     */
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

	/**
	 * Método que retorna a descrição do objetivo.
	 * 
	 * @return A descrição  do objetivo.
	 */
	public String getDescricao() {
		return descricao;
	}
}
