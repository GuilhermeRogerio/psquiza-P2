package modulos;

import java.io.Serializable;

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
	 * @param unidade A unidade alocada.
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
		} else {
			this.data = novoValor;		
								}
 		}
	

}