package controladores;

import java.util.HashMap;
import java.util.Map;

import modulos.Objetivo;
import modulos.Problema;
import util.Validador;

/**
 * Classe que gerencia os problemas e objetivos.
 * 
 * @author Guilherme Rogerio
 *
 */
public class ControllerProblemaObjetivo {
	/**
	 * Mapa de problemas.
	 */
	private Map<String, Problema> problemas;
	/**
	 * Mapa de objetivos.
	 */
	private Map<String, Objetivo> objetivos;
	/**
	 * Objeto para validar os parametros.
	 */
	private Validador validador;
	/**
	 * Codigo do problema.
	 */
	private String codigoProblema;
	/**
	 * Codigo do objetivo.
	 */
	private String codigoObjetivo;
	/**
	 * Contador para o codigo do problema.
	 */
	private int contProblema;
	/**
	 * Contador para o codigo do objetivo.
	 */
	private int contObjetivo;

	public ControllerProblemaObjetivo() {
		this.problemas = new HashMap<>();
		this.validador = new Validador();
		this.objetivos = new HashMap<>();
		this.contProblema = 1;
		this.contObjetivo = 1;
	}

	/**
	 * Cadastra um problema no sistema.
	 * 
	 * @param descricao   Descrição do problema
	 * @param viabilidade Viabilidade do problema ser resolvido
	 */
	public void cadastraProblema(String descricao, int viabilidade) {
		this.codigoProblema = "P" + contProblema++;
		this.validador.valida(descricao, "Campo descricao nao pode ser nulo ou vazio.");
		this.validador.validaInteiros(viabilidade, "Valor invalido de viabilidade.");
		this.problemas.put(codigoProblema, new Problema(descricao, viabilidade));
	}

	/**
	 * Cadastra um objetivo no sistema.
	 * 
	 * @param tipo              Tipo do objetivo que pode ser GERAL ou ESPECIFICO
	 * @param descricao         Descricao do objetivo
	 * @param aderenciaProblema Aderencia ao problema
	 * @param viabilidade       Viabilidade de o objetivo ser concretizado
	 */
	public void cadastraObjetivo(String tipo, String descricao, int aderenciaProblema, int viabilidade) {
		this.codigoObjetivo = "O" + contObjetivo++;
		this.validador.valida(tipo, "Campo tipo nao pode ser nulo ou vazio.");
		this.validador.valida(descricao, "Campo descricao nao pode ser nulo ou vazio.");
		this.validador.validaTipo(tipo, "Valor invalido de tipo.");
		this.validador.validaInteiros(aderenciaProblema, "Valor invalido de aderencia");
		this.validador.validaInteiros(viabilidade, "Valor invalido de viabilidade.");
		this.objetivos.put(codigoObjetivo, new Objetivo(tipo, descricao, aderenciaProblema, viabilidade));
	}

	/**
	 * Retorna a representação textual de um problema cadastrado no sistema.
	 * 
	 * @param codigo Codigo do problema
	 * @return A representação textual do problema
	 */
	public String exibeProblema(String codigo) {
		if (problemas.containsKey(codigo)) {
			return codigo + " - " + this.problemas.get(codigo).toString();
		} else {
			throw new IllegalArgumentException("Problema nao encontrado");
		}

	}

	/**
	 * Retorna a representação textual de um objetivo cadastrado no sistema.
	 * 
	 * @param codigo Codigo do objetivo
	 * @return A representação textual do objetivo
	 */
	public String exibeObjetivo(String codigo) {
		if (objetivos.containsKey(codigo)) {
			return codigo + " - " + this.objetivos.get(codigo).toString();
		} else {
			throw new IllegalArgumentException("Objetivo nao encontrado");
		}
	}

	/**
	 * Remove um problema já cadastrado no sistema.
	 * 
	 * @param codigo Codigo do problema
	 */
	public void apagarProblema(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (problemas.containsKey(codigo)) {
			this.problemas.remove(codigo);
		} else {
			throw new IllegalArgumentException("Problema nao encontrado");
		}

	}

	/**
	 * Remove um objetivo já cadastrado no sistema.
	 * 
	 * @param codigo Codigo do objetivo
	 */
	public void apagarObjetivo(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (objetivos.containsKey(codigo)) {
			this.objetivos.remove(codigo);
		} else {
			throw new IllegalArgumentException("Objetivo nao encontrado");
		}
	}

}
