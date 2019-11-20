package modulos;

import java.io.Serializable;

public class Professor implements InterfacePesquisador, Serializable {
	
	/**
	 * Area de formacao
	 */
	private String formacao;
	
	/**
	 * Unidade Alocada
	 */
	private String unidade;
	
	/**
	 * Data de contratação
	 */
	private String data;
	
	/**
	 * Construtor de Professor
	 * 
	 * @param formacao
	 * @param unidade
	 * @param data
	 */
	public Professor(String formacao, String unidade, String data) {
		this.formacao = formacao;
		this.unidade = unidade;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.formacao + " - " + this.unidade + " - " + this.data;
	}
	
	/**
	 * Altera atributos do professor
	 */
	public void alteraEspecialidade(String atributo, String novoValor) {
		if ("FORMACAO".equals(atributo)) {
			this.formacao = novoValor;
		} else if ("UNIDADE".equals(atributo)) {
			this.unidade = novoValor;
		} else {
			this.data = novoValor;		}
 		}
	

}