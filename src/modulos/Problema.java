package modulos;

import util.Validador;

public class Problema {
	
	private String descricao;
	private int viabilidade;
	private Validador validador;
	
	
	public Problema(String descricao, int viabilidade) {
		this.validador = new Validador();
		this.validador.validaProblema(descricao, viabilidade);
		this.descricao = descricao;
		this.viabilidade = viabilidade;
	}
	
	public String toString() {
		return this.descricao + " - " +  this.viabilidade;
	}

}
