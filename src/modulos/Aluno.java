package modulos;

import java.io.Serializable;

/**
 * Representação da especialidade Aluno
 * 
 * @author Matheus Filipe
 *
 */
public class Aluno implements InterfacePesquisador, Serializable {
	
	/**
	 * Semestre de formação
	 */
	private int semestre;
	
	/**
	 * Indice de Eficiencia Academica, IEA
	 */
	private double iea;
	
	/**
	 * Construtor da entidade Aluno
	 * 
	 * @param semestre - Semestre de formação
	 * @param iea - IEA do aluno
	 */
	public Aluno(int semestre, double iea) {
		this.semestre = semestre;
		this.iea = iea;
	}
	
	@Override
	public String toString() {
		return this.semestre + "o SEMESTRE" + " - " + this.iea;
	}
	
	/**
	 * Método que altera um atributo do Aluno
	 * 
	 * @param atributo - Atributo a ser alterado
	 * @param novoValor - Valor atualizado
	 */
	public void alteraEspecialidade(String atributo, String novoValor) {
		if ("SEMESTRE".equals(atributo)) {
			this.semestre = Integer.parseInt(novoValor);
		} else {
			this.iea = Double.parseDouble(novoValor);
		}
	}

}