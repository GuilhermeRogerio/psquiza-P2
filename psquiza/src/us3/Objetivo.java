package us3;

import util.Validador;

public class Objetivo {
	
	private String tipo;
	private String descricao;
	private Validador validador;
	private int aderencia;
	private int viabilidade;
	private int valor;
	
	public Objetivo(String tipo, String descricao,int aderencia,int viabilidade) {
		this.validador = new Validador();
		this.validador.validaObjetivo(tipo, descricao, aderencia, viabilidade);
		this.tipo = tipo;
		this.descricao = descricao;
		this.aderencia = aderencia;
		this.viabilidade = viabilidade;
		this.valor = aderencia + viabilidade;
		
	}
	
	public String toString() {
		return this.tipo + " - " + this.descricao + " - " + this.valor;
	}

}
