package controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparadores.ComparadorObjetivo;
import comparadores.ComparadorPesquisa;
import comparadores.ComparadorProblema;
import modulos.Atividade;
import modulos.Objetivo;
import modulos.Pesquisa;
import modulos.Problema;
import util.Validador;

public class ControllerPesquisa {

	/**
	 * Verificador das entradas para o tratamento.
	 *
	 */
	private Validador validador;

	/**
	 * Mapa onde os pesquisas serão armazenados para as operações do sistema.
	 * 
	 */
	private Map<String, Pesquisa> pesquisas;

	/**
	 * Construtor do mapa e do verificador do validador.
	 */
	public ControllerPesquisa() {
		this.validador = new Validador();
		this.pesquisas = new HashMap<String, Pesquisa>();
	}

	/**
	 * Método das pesquisas a serem cadastrados
	 * 
	 * @author adyssonfs
	 * @param descricao: resumo descritivo da pesquisa
	 * @param campoDeInteresse: areas que são abrangidas pela pesquisa. A entrada
	 *        deve ser até 255 caracteres. Cada area é separada por vírgula
	 */
	public String cadastraPesquisa(String descricao, String campoDeInteresse) {

		this.validador.valida(descricao, "Descricao nao pode ser nula ou vazia.");
		this.validador.validaTamanhoEntrada(campoDeInteresse, "Formato do campo de interesse invalido.");

		Pesquisa pesquisa = new Pesquisa(descricao, campoDeInteresse);

		String codigoPesquisa = this.geraCodigo(campoDeInteresse);
		pesquisa.setCodigo(codigoPesquisa);
		this.pesquisas.put(codigoPesquisa, pesquisa);
		return codigoPesquisa;
	}

	/**
	 * Método retorna codigo para uma pesquisa baseado no campo de interesse
	 * 
	 * @author adyssonfs
	 * @param campoDeInteresse
	 * @return String
	 */
	private String geraCodigo(String campoDeInteresse) {

		int count = 1;
		String codigo = campoDeInteresse.substring(0, 3).toUpperCase();

		for (String key : pesquisas.keySet()) {

			String precode = pesquisas.get(key).getCodigo().substring(0, 3).toUpperCase();

			if (precode.equals(codigo))
				count++;
		}

		codigo += String.valueOf(count);
		return codigo;
	}

	/**
	 * Método usado para a alteração em pesquisa
	 * 
	 * @author adyssonfs
	 * @param codigo: identificador da pesquisa
	 * @param campoASerAlterado: pode ser "CAMPO" ou "DESCRICAO"
	 */
	public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {

		this.validador.validaAtributo(conteudoASerAlterado, "Nao e possivel alterar esse valor de pesquisa.");

		if (!pesquisas.containsKey(codigo))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");

		Pesquisa pesquisa = this.pesquisas.get(codigo);

		if (!pesquisa.getAtiva())
			throw new Error("Pesquisa desativada.");

		if (conteudoASerAlterado.equals("CAMPO")) {
			this.validador.valida(novoConteudo, "Formato do campo de interesse invalido.");
			pesquisa.setCamposInteresse(novoConteudo);
		} else {
			this.validador.valida(novoConteudo, "Descricao nao pode ser nula ou vazia.");
			pesquisa.setDescricao(novoConteudo);
		}
	}

	/**
	 * Método para efetuar o encerramento de uma pesquisa
	 * 
	 * @author adyssonfs
	 * @param codigo: identificador da pesquisa
	 * @param motivo: motivação para o encerramento da pesquisa"
	 */
	public void encerraPesquisa(String codigo, String motivo) {

		this.validador.valida(motivo, "Motivo nao pode ser nulo ou vazio.");

		if (!pesquisas.containsKey(codigo))
			throw new Error("Pesquisa nao encontrada.");

		Pesquisa pesquisa = this.pesquisas.get(codigo);

		if (!pesquisa.getAtiva())
			throw new Error("Pesquisa desativada.");

		pesquisa.setAtiva(false);
	}

	/**
	 * Método passa configurar a ativação da pesquisa
	 * 
	 * @author adyssonfs
	 * @param codigo: identificador da pesquisa
	 */
	public void ativaPesquisa(String codigo) {

		if (!pesquisas.containsKey(codigo))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");

		Pesquisa pesquisa = this.pesquisas.get(codigo);

		if (pesquisa.getAtiva())
			throw new Error("Pesquisa ja ativada.");

		pesquisa.setAtiva(true);
	}

	/**
	 * Método faz a exibição da pesquisa no formato "CODIGO - Descricao -
	 * ComposDeInteresse"
	 * 
	 * @author adyssonfs
	 * @param codigo: identificador da pesquisa
	 */
	public String exibePesquisa(String codigo) {

		this.validador.valida(codigo, "Codigo nao pode ser nulo ou vazio.");

		if (!pesquisas.containsKey(codigo))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");

		Pesquisa pesquisa = this.pesquisas.get(codigo);
		return pesquisa.toString();
	}

	/**
	 * Método para a verificação da atividade da pesquisa
	 * 
	 * @author adyssonfs
	 * @param codigo: identificador da pesquisa
	 */
	public boolean pesquisaEhAtiva(String codigo) {

		this.validador.valida(codigo, "Codigo nao pode ser nulo ou vazio.");

		if (!pesquisas.containsKey(codigo))
			throw new IllegalArgumentException("Pesquisa nao encontrada.");

		Pesquisa pesquisa = this.pesquisas.get(codigo);
		return pesquisa.getAtiva();
	}
	
	/**
	 * US5
	 */
	public boolean associaProblema(String idPesquisa, Problema problema) {
		if (this.pesquisas.containsKey(idPesquisa)) {
			if (this.pesquisaEhAtiva(idPesquisa)) {
				return this.pesquisas.get(idPesquisa).associaProblema(problema);
			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
		} else {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
	}

	public boolean desassociaProblema(String idPesquisa) {
		if (this.pesquisas.containsKey(idPesquisa)) {
			if (this.pesquisaEhAtiva(idPesquisa)) {
				return this.pesquisas.get(idPesquisa).desassociaProblema();
			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
		} else {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
	}

	public boolean associaObjetivo(String idPesquisa, Objetivo objetivo, String idObjetivo) {
		if (this.pesquisas.containsKey(idPesquisa)) {
			if (this.pesquisaEhAtiva(idPesquisa)) {
				return this.pesquisas.get(idPesquisa).associaObjetivo(objetivo, idObjetivo);
			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
		} else {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
	}

	public boolean desassociaObjetivo(String idPesquisa, String idObjetivo) {
		if (this.pesquisas.containsKey(idPesquisa)) {
			if (this.pesquisaEhAtiva(idPesquisa)) {
				return this.pesquisas.get(idPesquisa).desassociaObjetivo(idObjetivo);
			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
		} else {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
	}

	private String percorreLista(ArrayList<Pesquisa> lista){
		String listar= "";
		for (Pesquisa dados : lista) {
			listar += dados.toString() + " | " ;
		}
		return listar.substring(0, listar.length()-3);
	}

	public String listaPesquisas(String ordem) {
		ArrayList<Pesquisa> listaPesquisas = new ArrayList<>(this.pesquisas.values());
		String result = "";
		if (ordem.equals("PROBLEMA")) {
			listaPesquisas.sort(new ComparadorProblema());
			result = this.percorreLista(listaPesquisas);
		} else if (ordem.equals("OBJETIVOS")) {
			listaPesquisas.sort(new ComparadorObjetivo());
			result = this.percorreLista(listaPesquisas);
		} else if (ordem.equals("PESQUISA")) {
			listaPesquisas.sort(new ComparadorPesquisa());
			result = this.percorreLista(listaPesquisas);
		} else {
			throw new IllegalArgumentException("Valor invalido da ordem");
		}
		return result;
	}

	/**
	 * Associa uma atividade a uma pesquisa.
	 * 
	 * @param codigoPesquisa Código da pesquisa.
	 * @param atividade      Código da atividade.
	 * @return "True" se a associação for bem sucedida e "False" se a associação não
	 *         acontecer.
	 */
	public boolean associaAtividade(String codigoPesquisa, String codigoAtividade, Atividade atividade) {
		this.validador.valida(codigoPesquisa, "Campo codigoPesquisa nao pode ser nulo ou vazio.");
		if (pesquisas.containsKey(codigoPesquisa)) {
			if (pesquisas.get(codigoPesquisa).getAtiva()) {
				return pesquisas.get(codigoPesquisa).addAtividade(codigoAtividade, atividade);

			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}
		} else {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}

	}

	/**
	 * Desassocia uma atividade de uma pesquisa.
	 * 
	 * @param codigoPesquisa Código da pesquisa.
	 * @param atividade      Código da atividade.
	 * @return "True" se a desassociação for bem sucedida e "False" se a
	 *         desassociação não acontecer.
	 */
	public boolean desassociaAtividade(String codigoPesquisa, String codigoAtividade) {
		this.validador.valida(codigoPesquisa, "Campo codigoPesquisa nao pode ser nulo ou vazio.");
		if (pesquisas.containsKey(codigoPesquisa)) {
			if (pesquisas.get(codigoPesquisa).getAtiva()) {
				return this.pesquisas.get(codigoPesquisa).removeAtividade(codigoAtividade);
			} else {
				throw new IllegalArgumentException("Pesquisa desativada.");
			}

		} else {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
	}
	
	/**
     * Método que retorna Pesquisa a partir codigo
     * 
     * @return Pesquisa
     */
    public Pesquisa getPesquisa(String codigo) {
    	
    	if(this.pesquisas.containsKey(codigo))
    		return this.pesquisas.get(codigo);
    	else
    		throw new Error("Pesquisa nao encontrada.");  	
    }
    
    /**
     * M�todo retorna um Lista de Pesquisas cadastradas
     * 
     * @return List<Pesquisa>
     */
    public List<Pesquisa> getPesquisas() {
    	
    	List<Pesquisa> listPesquisa = new ArrayList<>();
    	
    	for (String key : this.pesquisas.keySet()) 
			listPesquisa.add(this.pesquisas.get(key));
		
    	
		return listPesquisa;
	}

}
