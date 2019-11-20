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
	 * Valor que representa o semestre de formação
	 * 
	 */
	private int semestre;
	
	/**
	 * Indice de Eficiencia Academica, IEA
	 * 
	 */
	private double iea;
	
	/**
	 * Construtor da entidade Aluno
	 * 
	 * @param semestre A semestre de formação.
	 * @param iea O IEA do aluno
	 */
	public Aluno(int semestre, double iea) {
		this.semestre = semestre;
		this.iea = iea;
	}
	
	/**
	 * Método que constrói a representação textual do aluno.
	 * 
	 */
	@Override
	public String toString() {
		return this.semestre + "o SEMESTRE" + " - " + this.iea;
	}
	
	/*
	 * Método que altera um atributo do Aluno.
	 * 
	 * @param atributo O atributo a ser alterado.
	 * @param novoValor O novo valor a ser atualizado.
	 */
	public void alteraEspecialidade(String atributo, String novoValor) {
		if ("SEMESTRE".equals(atributo)) {
			this.semestre = Integer.parseInt(novoValor);
		} else if("IEA".equals(atributo)){
			this.iea = Double.parseDouble(novoValor);
		}
	}

	public int getSemestre() {
		return semestre;
	}

	public double getIea() {
		return iea;
	}

}