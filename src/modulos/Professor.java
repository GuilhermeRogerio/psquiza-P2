package modulos;

import java.io.Serializable;

/**
 * Classe que representa o professor.
 * 
 */
public class Professor implements InterfacePesquisador, Serializable {
	
	/**
	 * Atributo que representa a área de formacao do professor.
	 * 
	 */
	private String formacao;
	
	/**
	 * Atributo que representa a unidade alocada.
	 * 
	 */
	private String unidade;
	
	/**
	 * Atributo que representa a data de contratação.
	 * 
	 */
	private String data;
	
	/**
	 * Construtor da classe Professor
	 * 
	 * @param formacao A formação do professor.
	 * @param unidade A unidade alocadatributoa.
	 * @param data A data de contratação do professor.
	 */
	public Professor(String formacao, String unidade, String data) {
		this.formacao = formacao;
		this.unidade = unidade;
		this.data = data;
	}
	
	/**
	 * Método que constrói a representação textual do professor.
	 * 
	 * @return A representação textual do professor.
	 */
	@Override
	public String toString() {
		return this.formacao + " - " + this.unidade + " - " + this.data;
	}
	
	/**
	 * Método que altera atributos do professor.
	 * 
	 * @param atributo O atributo a ser modificado.
	 * @param novoValor O novo valor do atributo.
	 */
	public void alteraEspecialidade(String atributo, String novoValor) {
		if ("FORMACAO".equals(atributo)) {
			this.formacao = novoValor;
		} else if ("UNIDADE".equals(atributo)) {
			this.unidade = novoValor;
		} else if ("DATA".equals(atributo)){
			this.data = novoValor;		
								}
 		}

	/**
	 * Metodo que retorna a formação do professor.
	 * 
	 * @return A formação do professor.
	 */
	public String getFormacao() {
		return formacao;
	}

	/**
	 * Metodo que retorna a unidade do professor.
	 * 
	 * @return A unidade alocada do professor.
	 */
	public String getUnidade() {
		return unidade;
	}
	
	/**
	 * Metodo que retorna a data de contratação do professor.
	 * 
	 * @return A data da contratação.
	 */
	public String getData() {
		return data;
	}
	
	
	

}