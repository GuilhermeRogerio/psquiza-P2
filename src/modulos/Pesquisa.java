package modulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import comparadores.ComparadorAtividade;
import util.Validador;

/**
 * Representação de Pesquisa no Sistema
 */
public class Pesquisa implements Serializable{

	/**
	 * Atributo que representa a descrição da pesquisa.
	 * 
	 */
	private String descricao;
	
	/**
	 * Atributo que represeta a lista com o campo de interesse.
	 *  
	 */
	private String camposInteresse[];
	
	/**
	 * Atributo que representa o codigo da pesquisa.
	 * 
	 */
	private String codigo;
	
	/**
	 * Atributo que representa o estado da pesquisa.
	 */
	private boolean ativa;
	
	/**
	 * Mapa que contém os objetivos da pesquisa.
	 * 
	 */
	private HashMap<String, Objetivo> objetivos;
	
	/**
	 * 
	 * Atributo que contém o problema da pesquisa.
	 */
	private Problema problema;
	
	/**
	 * Instânciando o objeto estratégia. 
	 * 
	 */
	private Estrategia estrategia;

	/**
	 * Mapa de atividade com as atividades da pesquisa
	 * 
	 */
	private Map<String, Atividade> atividades;

	/**
	 * Construtor da calsse pequisa, inicia as coleções e atribui valores iniciais aos atributos.
	 *  
	 * @param descricao
	 * @param camposInteresse
	 */
	public Pesquisa(String descricao, String camposInteresse) {
		this.camposInteresse = new String[4];
		this.gerarCamposInteresse(camposInteresse);
		this.descricao = descricao;
		this.ativa = true;
		this.atividades = new HashMap<>();
		this.objetivos = new HashMap<>();
		this.problema = null;
		this.estrategia = new MaisAntiga();

	}

	/**
	 * Adiciona uma atividade.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @param atividade       Atividade a ser adicionada.
	 * @return "True" se a adição for bem sucedida e "False" se a adição não
	 *         acontecer.
	 */
	public boolean addAtividade(String codigoAtividade, Atividade atividade) {
		if (!atividades.containsKey(codigoAtividade)) {
			this.atividades.put(codigoAtividade, atividade);
			this.atividades.get(codigoAtividade).setEhAssociada();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Remove uma atividade.
	 * 
	 * @param codigoAtividade Código da atividade.
	 * @return "True" se a remoção for bem sucedida e "False" se a remocão não
	 *         acontecer.
	 */
	public boolean removeAtividade(String codigoAtividade) {
		if (atividades.get(codigoAtividade) != null) {
			this.atividades.get(codigoAtividade).setNaoAssociada();
			this.atividades.remove(codigoAtividade);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @param camposString
	 */
	private void gerarCamposInteresse(String camposString) {

		String[] interesses = camposString.split(",");

		if (interesses.length <= this.camposInteresse.length) {

			for (int i = 0; i < interesses.length; i++) {

				final String interesse = interesses[i];

				new Validador().valida(interesse, "Formato do campo de interesse invalido.");
				this.camposInteresse[i] = interesses[i].trim();
			}
		} else {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}

	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param camposInteresse the camposInteresse to set
	 */
	public void setCamposInteresse(String camposInteresse) {
		this.gerarCamposInteresse(camposInteresse);
	}

	/**
	 * @param ativa the ativa to set
	 */
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	@Override
	public String toString() {
		StringBuilder sbCamposInteresse = new StringBuilder();

		for (String string : camposInteresse) {
			if (string != null)
				sbCamposInteresse.append(string + ", ");
		}

		String camposInteresseString = sbCamposInteresse.toString();
		camposInteresseString = camposInteresseString.substring(0, camposInteresseString.length() - 2);

		return String.format("%s - %s - %s", this.codigo, this.descricao, camposInteresseString);
	}

	/**
	 * toString usado para exibir o resultado de busca
	 * 
	 * @return {@link String}
	 */
	public String toStringBusca() {

		StringBuilder sbCamposInteresse = new StringBuilder();

		for (String string : camposInteresse) {
			if (string != null)
				sbCamposInteresse.append(string + ", ");
		}

		String camposInteresseString = sbCamposInteresse.toString();
		camposInteresseString = camposInteresseString.substring(0, camposInteresseString.length() - 2);

		return String.format("%s: %s - %s | ", this.codigo, this.descricao, camposInteresseString);
	}

	/***
	 * 
	 * @param novoConteudo
	 */
	public void setDescricao(String novoConteudo) {
		this.descricao = novoConteudo;
	}

	/**
	 * 
	 * @return void
	 */
	public boolean getAtiva() {
		return this.ativa;
	}

	public void setAssociada(String codigoAtividade) {
		this.atividades.get(codigoAtividade).setEhAssociada();
	}

	public void setNaoAssociada(String codigoAtividade) {
		this.atividades.get(codigoAtividade).setNaoAssociada();
	}

	public void setCodigo(String codigoPesquisa) {
		this.codigo = codigoPesquisa;
	}
	/**
	 * Método que associa o problema na pesquisa.
	 *
	 * @param problema o problema a ser associado
	 * @return o resultado da associação do problema
	 */
	public boolean associaProblema(Problema problema) {
		boolean retorno = false;
		if (problema != this.problema) {
			if (this.problema == null) {
				this.problema = problema;
				retorno = true;

			} else if (this.problema != null) {
				throw new IllegalArgumentException("Pesquisa ja associada a um problema.");
			}
		}

		return retorno;
	}
	
	/**
	 * Método que desassocia o problema da pesquisa.
	 *
	 * @return o resultado da desassociação do problema
	 */
	public boolean desassociaProblema() {
		boolean retorno = false;
		if(this.problema != null) {
			this.problema = null;
			retorno = true;
		}
		return retorno;
	}

	public boolean associaObjetivo(Objetivo objetivo, String idObjetivo) {
		boolean retorno = false;
		if (!this.objetivos.containsKey(idObjetivo)) {
			if (objetivo.isAssociado()) {
				throw new IllegalArgumentException("Objetivo ja associado a uma pesquisa.");
			}
			this.objetivos.put(idObjetivo, objetivo);
			this.objetivos.get(idObjetivo).setAssociado(true);
			retorno = true;
		}
		return retorno;
	}

	public boolean desassociaObjetivo(String idObjetivo) {
		boolean retorno = false;
		if (this.objetivos.containsKey(idObjetivo)) {
			this.objetivos.get(idObjetivo).setAssociado(false);
			this.objetivos.remove(idObjetivo);
			retorno = true;
		}
		return retorno;
	}

	/**
	 * Método que retorna o problema da pesquisa.
	 *
	 * @return o problema da pesquisa
	 */
	public Problema getProblema() {
		return this.problema;
	}

	/**
	 * Método que retorna a quantidade de objetivos na pesquisa.
	 *  
	 * @return  A quantidade de objetivos.
	 */
	public int getQuantiadeDeObjetivos() {
		return this.objetivos.size();
	}

	/**
	 * Método que analisa os ids dos objetivos procurando o maior
	 * 
	 * @return O maior id dos objetivos.
	 */
	public String maiorId() {
		String variavelId = "";
		for (String id : objetivos.keySet()) {
			if (id == "") {
				variavelId = id;
			} else {
				if (variavelId.compareTo(id) < 0) {
					variavelId = id;
				}
			}
		}
		return variavelId;
	}

	/**
	 * Método retorna todas as atividade da pesquisa.
	 * 
	 * @return A lista das atividades da pesquisa.
	 */
	public List<Atividade> getAtividades() {

		List<Atividade> atividades = new ArrayList<>();

		for (String key : this.atividades.keySet()) {
			atividades.add(this.atividades.get(key));
		}

		return atividades;
	}

	/**
	 * Método retorna uma lista de Objetivos associados à uma pesquisa.
	 * 
	 * @return A lista de objetivos.
	 */
	public List<Objetivo> getObjetivos() {

		List<Objetivo> objetivos = new ArrayList<>();

		for (String key : this.objetivos.keySet())
			objetivos.add(this.objetivos.get(key));

		return objetivos;

	}

	/**
	 * Método que retorna os campos de interesse da pesquisa.
	 * 
	 * @return A lista com os interesse da pesquisa.
	 */
	public String[] getCamposInteresse() {
		return camposInteresse;
	}

	/**
	 * Método que busca a atividade com a maior duração.
	 * 
	 * @return O identificador da atividade.
	 */
	public String maiorDuracao() {
		String id = "";
		int maior = 0;
		for (String atividades : this.atividades.keySet()) {
			if (this.atividades.get(atividades).contaItensPendentes() > 0) {
				if (this.atividades.get(atividades).getDuracao() > maior) {
					maior = this.atividades.get(atividades).getDuracao();
					id = this.atividades.get(atividades).getCodigo();
				}
			}
		}
		return id;
	}

	/**
	 * Método que busca a atividade com menos itens pendentes.
	 * 
	 * @return O identificador da atividade.
	 */
	public String menosPendencias() {
		String id = "";
		for (String atividades : this.atividades.keySet()) {
			if (this.atividades.get(atividades).contaItensPendentes() == 1) {
				id = this.atividades.get(atividades).getCodigo();
				break;
			}
		}
		return id;

	}

	/**
	 * Método que busca a atividade com o maior risco.
	 *
	 * @return O identificador da atividade.
	 */
	public String maiorRisco() {
		String id = "";
		for (String atividades : this.atividades.keySet()) {
			if (this.atividades.get(atividades).contaItensPendentes() > 0) {
				if (this.atividades.get(atividades).getNivelRisco().equals("ALTO"))
					id = this.atividades.get(atividades).getCodigo();

			}
		}
		return id;
	}

	/**
	 * Método que busca a atividade mais antiga.
	 * 
	 * @return O identificador da atividade.
	 */
	public String maisAntiga() {
		String id = "";
		ArrayList<Atividade> lista = new ArrayList<>(this.atividades.values());
		lista.sort(new ComparadorAtividade());
		for (Atividade atividades : lista) {
			if (atividades.contaItensPendentes() > 0) {
				id = atividades.getCodigo();
			}
		}
		return id;
	}

	/**
	 * Método que verfica se as atividades contém itens pendentes.
	 */
	public void TemPendencia() {
		ArrayList<Atividade> lista = new ArrayList<>(this.atividades.values());
		int cont = 0;
		for (Atividade atividades : lista) {
			cont += atividades.contaItensPendentes();
		}
		if (cont == 0) {
			throw new IllegalArgumentException("Pesquisa sem atividades com pendencias.");
		}
	}
	
	/**
	 * Método que retorna a descrição da pesquisa.
	 * 
	 * @return A descrição da pesquisa.
	 */
	public String getDescricao() {
		return descricao;
	}

}
