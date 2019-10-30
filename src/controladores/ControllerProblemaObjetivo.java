package controladores;

import java.util.HashMap;
import java.util.Map;

import modulos.Objetivo;
import modulos.Problema;
import util.Validador;

public class ControllerProblemaObjetivo {

	private Map<String, Problema> problemas;
	private Map<String, Objetivo> objetivos;
	private Validador validador;
	private String codigoProblema;
	private String codigoObjetivo;
	private int contProblema;
	private int contObjetivo;

	public ControllerProblemaObjetivo() {
		this.problemas = new HashMap<>();
		this.validador = new Validador();
		this.objetivos = new HashMap<>();
		this.contProblema = 1;
		this.contObjetivo = 1;
	}

	public void cadastraProblema(String descricao, int viabilidade) {
		this.codigoProblema = "P" + contProblema++;
		this.validador.valida(descricao, "Campo descricao nao pode ser nulo ou vazio.");
		this.validador.validaInteiros(viabilidade, "Valor invalido de viabilidade.");
		this.problemas.put(codigoProblema, new Problema(descricao, viabilidade));
	}

	public void cadastraObjetivo(String tipo, String descricao, int aderenciaProblema, int viabilidade) {
		this.codigoObjetivo = "O" + contObjetivo++;
		this.validador.valida(tipo, "Campo tipo nao pode ser nulo ou vazio.");
		this.validador.valida(descricao, "Campo descricao nao pode ser nulo ou vazio.");
		this.validador.validaTipo(tipo, "Valor invalido de tipo.");
		this.validador.validaInteiros(aderenciaProblema, "Valor invalido de aderencia");
		this.validador.validaInteiros(viabilidade, "Valor invalido de viabilidade.");
		this.objetivos.put(codigoObjetivo, new Objetivo(tipo, descricao, aderenciaProblema, viabilidade));
	}

	public String exibeProblema(String codigo) {
		if (problemas.containsKey(codigo)) {
			return codigo + " - " + this.problemas.get(codigo).toString();
		} else {
			throw new IllegalArgumentException("Problema nao encontrado");
		}

	}

	public String exibeObjetivo(String codigo) {
		if (objetivos.containsKey(codigo)) {
			return codigo + " - " + this.objetivos.get(codigo).toString();
		} else {
			throw new IllegalArgumentException("Objetivo nao encontrado");
		}
	}

	public void apagarProblema(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (problemas.containsKey(codigo)) {
			this.problemas.remove(codigo);
		} else {
			throw new IllegalArgumentException("Problema nao encontrado");
		}

	}

	public void apagarObjetivo(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (objetivos.containsKey(codigo)) {
			this.objetivos.remove(codigo);
		} else {
			throw new IllegalArgumentException("Objetivo nao encontrado");
		}
	}

}
