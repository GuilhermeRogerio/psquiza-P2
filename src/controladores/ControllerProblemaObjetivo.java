package controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	 * Codigo utilizado para identificar o problema.
	 */
	private int codigoProblema;
	/**
	 * Codigo utilizado para identificar o objetivo.
	 */
	private int codigoObjetivo;

	/**
	 * Construtor que inicia os mapas e o validador.
	 */
	public ControllerProblemaObjetivo() {
		this.problemas = new HashMap<>();
		this.validador = new Validador();
		this.objetivos = new HashMap<>();
		this.codigoProblema = 1;
		this.codigoObjetivo = 1;
	}

	/**
	 * Cadastra um problema no sistema.
	 * 
	 * @param descricao   Descrição do problema.
	 * @param viabilidade Viabilidade do problema ser resolvido.
	 */
	public void cadastraProblema(String descricao, int viabilidade) {
		this.validador.valida(descricao, "Campo descricao nao pode ser nulo ou vazio.");
		this.validador.validaInteiros(viabilidade, "Valor invalido de viabilidade.");
		Problema problema = new Problema(descricao, viabilidade);
		problema.geraCodigo(this.codigoProblema);
		this.problemas.put(problema.getCodigo(), problema);
		this.codigoProblema += 1;
	}

	/**
	 * Cadastra um objetivo no sistema.
	 * 
	 * @param tipo              Tipo do objetivo que pode ser GERAL ou ESPECIFICO.
	 * @param descricao         Descricao do objetivo.
	 * @param aderenciaProblema Aderencia ao problema.
	 * @param viabilidade       Viabilidade de o objetivo ser concretizado.
	 */
	public void cadastraObjetivo(String tipo, String descricao, int aderenciaProblema, int viabilidade) {
		this.validador.valida(tipo, "Campo tipo nao pode ser nulo ou vazio.");
		this.validador.valida(descricao, "Campo descricao nao pode ser nulo ou vazio.");
		this.validador.validaTipo(tipo, "Valor invalido de tipo.");
		this.validador.validaInteiros(aderenciaProblema, "Valor invalido de aderencia");
		this.validador.validaInteiros(viabilidade, "Valor invalido de viabilidade.");
		Objetivo objetivo = new Objetivo(tipo, descricao, aderenciaProblema, viabilidade);
		objetivo.geraCodigo(this.codigoObjetivo);
		this.objetivos.put(objetivo.getCodigo(), objetivo);
		this.codigoObjetivo += 1;
	}

	/**
	 * Retorna a representação textual de um problema cadastrado no sistema.
	 * 
	 * @param codigo Codigo do problema.
	 * @return A representação textual do problema.
	 */
	public String exibeProblema(String codigo) {
		if (problemas.containsKey(codigo)) {
			return this.problemas.get(codigo).toString();
		} else {
			throw new IllegalArgumentException("Problema nao encontrado");
		}

	}

	/**
	 * Retorna a representação textual de um objetivo cadastrado no sistema.
	 * 
	 * @param codigo Codigo do objetivo.
	 * @return A representação textual do objetivo.
	 */
	public String exibeObjetivo(String codigo) {
		if (objetivos.containsKey(codigo)) {
			return this.objetivos.get(codigo).toString();
		} else {
			throw new IllegalArgumentException("Objetivo nao encontrado");
		}
	}

	/**
	 * Remove um problema já cadastrado no sistema.
	 * 
	 * @param codigo Codigo do problema.
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
	 * @param codigo Codigo do objetivo.
	 */
	public void apagarObjetivo(String codigo) {
		this.validador.valida(codigo, "Campo codigo nao pode ser nulo ou vazio.");
		if (objetivos.containsKey(codigo)) {
			this.objetivos.remove(codigo);
		} else {
			throw new IllegalArgumentException("Objetivo nao encontrado");
		}
	}

	/**
	 * US5
	 */

	public Problema problema(String idProblema) {
		return this.problemas.get(idProblema);
	}

	public Objetivo objetivo(String idObjetivo) {
		return this.objetivos.get(idObjetivo);
	}
	
	/**
     * Método retorna um Lista de Problema cadastradas
     * 
     * @return List<Problema>
     */
    public List<Problema> getProblemas() {
    	
    	List<Problema> listProblema = new ArrayList<>();
    	
    	for (String key : this.problemas.keySet()) 
			listProblema.add(this.problemas.get(key));
		return listProblema;
	}

	public List<Objetivo> getObjetivos() {

		List<Objetivo> objs = new ArrayList<Objetivo>();

		for (String key : this.objetivos.keySet()) {
			objs.add(this.objetivos.get(key));
		}

		return objs;
	}
}
