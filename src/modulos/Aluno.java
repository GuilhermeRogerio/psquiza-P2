package modulos;

import java.io.Serializable;

/**
 * Classe que representa a especialidade Aluno.
 * 
 */
public class Aluno implements InterfacePesquisador, Serializable {
	
	/**
	 * Valor que representa o semestre de formação.
	 * 
	 */
	private int semestre;
	
	/**
	 * Indice de Eficiencia Academica, IEA.
	 * 
	 */
	private double iea;
	
	/**
	 * Construtor da entidade Aluno.
	 * 
	 * @param semestre A semestre de formação.
	 * @param iea O IEA do aluno.
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

	/**
	 * Metodo que retorna o semetre do aluno.
	 * 
	 * @return O semetre de entrada do aluno.
	 */
	public int getSemestre() {
		return semestre;
	}

	/**
	 * Metodo que retorna o iea do aluno.
	 * 
	 * @return O indice de eficiencia academica.
	 */
	public double getIea() {
		return iea;
	}

}