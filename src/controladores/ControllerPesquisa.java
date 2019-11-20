package controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparadores.ComparadorObjetivo;
import comparadores.ComparadorPesquisa;
import comparadores.ComparadorProblema;
import modulos.Atividade;
import modulos.Estrategia;
import modulos.MaiorDuracao;
import modulos.MaiorRisco;
import modulos.MaisAntiga;
import modulos.MenosPendencias;
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
	private Estrategia estrategia;

	/**
	 * Construtor do mapa e do verificador do validador.
	 * 
	 */
	public ControllerPesquisa() {
		this.validador = new Validador();
		this.pesquisas = new HashMap<String, Pesquisa>();
		this.estrategia = new MaisAntiga();
	}

	/**
	 * Método que repassa os parâmetros para os cadastros das pesquisas.
	 * 
	 * @param descricao O resumo da pesquisa.
	 * @param campoDeInteresse A área abrangidas pela pesquisa.
	 * @return O código da pesquisa.
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
	 * Método que repassa os parâmetros para o retorno código para uma pesquisa.
	 * 
	 * @param campoDeInteresse O campo de interesse da pesquisa.
	 * @return O codigo da pesquisa.
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
	 * Método que repassa os parâmetros para a alteração na pesquisa.
	 * 
	 * @param codigo O identificador da pesquisa.
	 * @param campoASerAlterado O atributo a ser alterado.
	 */
	public void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {
		this.validador.validaAtributo(conteudoASerAlterado, "Nao e possivel alterar esse valor de pesquisa.");
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		Pesquisa pesquisa = this.pesquisas.get(codigo);
		if (!pesquisa.getAtiva()) {
			throw new Error("Pesquisa desativada.");
		}
		if (conteudoASerAlterado.equals("CAMPO")) {
			this.validador.valida(novoConteudo, "Formato do campo de interesse invalido.");
			pesquisa.setCamposInteresse(novoConteudo);
		} else {
			this.validador.valida(novoConteudo, "Descricao nao pode ser nula ou vazia.");
			pesquisa.setDescricao(novoConteudo);
		}
	}

	/**
	 * Método que repassa os parâmetros para o encerramento da pesquisa.
	 * 
	 * @param codigo O identificador da pesquisa.
	 * @param motivo A motivação para o encerramento da pesquisa".
	 */
	public void encerraPesquisa(String codigo, String motivo) {
		this.validador.valida(motivo, "Motivo nao pode ser nulo ou vazio.");
		if (!pesquisas.containsKey(codigo)) {
			throw new Error("Pesquisa nao encontrada.");
		}
		Pesquisa pesquisa = this.pesquisas.get(codigo);
		if (!pesquisa.getAtiva()) {
			throw new Error("Pesquisa desativada.");
		}
		pesquisa.setAtiva(false);
	}

	/**
	 * Método que repassa os parâmetros para a ativação da pesquisa.
	 * 
	 * @param codigo O identificador da pesquisa.
	 */
	public void ativaPesquisa(String codigo) {
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		Pesquisa pesquisa = this.pesquisas.get(codigo);
		if (pesquisa.getAtiva()) {
			throw new Error("Pesquisa ja ativada.");
		}
		pesquisa.setAtiva(true);
	}

	/**
	 * Método que repassa os parâmetros para exibição da pesquisa.
	 * 
	 * @param codigo O identificador da pesquisa.
	 * @param A representação textual da pesquisa.
	 */
	public String exibePesquisa(String codigo) {
		this.validador.valida(codigo, "Codigo nao pode ser nulo ou vazio.");
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		Pesquisa pesquisa = this.pesquisas.get(codigo);
		return pesquisa.toString();
	}

	/**
	 * Método que repassa os parâmetros para a verificação do estado da pesquisa.
	 * 
	 * @param codigo Oidentificador da pesquisa.
	 * @return O resultdo do estado da pesquisa.
	 */
	public boolean pesquisaEhAtiva(String codigo) {
		this.validador.valida(codigo, "Codigo nao pode ser nulo ou vazio.");
		if (!pesquisas.containsKey(codigo)) {
			throw new IllegalArgumentException("Pesquisa nao encontrada.");
		}
		Pesquisa pesquisa = this.pesquisas.get(codigo);
		return pesquisa.getAtiva();
	}
	
	/**
	 * US5
	 */
	
	/**
	 * Método que repassa os parâmetros para a associação do problema na pesquisa.
	 *
	 * @param idPesquisa O identificador da pesquisa.
	 * @param problema O problema a ser associado.
	 * @return O resultado da associação do problema.
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

	/**
	 * Método que repassa os parâmetros para a desassociação do problema na pesquisa.
	 * 
	 * @param idPesquisa O identificador da pesquisa.
	 * @return O resultado da desassociação do problema.
	 */
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
	
	/**
	 * Método que repassa os parâmetros para a associação do objetivo na pesquisa.
	 *
	 * @param idPesquisa O identificador da pesquisa.
	 * @param objetivo O objetivo a ser adicionado.
	 * @param idObjetivo O identificador do objetivo.
	 * @return O resultado da ação de associação do objetivo.
	 */
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

	/**
	 * Método que repassa os atributos para a associação do objetivo na pesquisa.
	 *
	 * @param idPesquisa O identificador da pesquisa.
	 * @param idObjetivo O identificador do objetivo.
	 * @return O resultado da desassociação do objetivo.
	 */
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

	/**
	 * Método que recebe a lista de pesquisas e a formata para ser exibido.
	 *
	 * @param lista A lista de pesquisas.
	 * @return A lista de pesquisas formatada.
	 */
	private String percorreLista(ArrayList<Pesquisa> lista){
		String listar= "";
		for (Pesquisa dados : lista) {
			listar += dados.toString() + " | " ;
		}
		return listar.substring(0, listar.length()-3);
	}

	/**
	 * Método responsável pela forma de ordenação da lista de pesquisas.
	 *
	 * @param ordem A criterio de ordenação da lista.
	 * @return A lista ordenada seguindo o criterio definido.
	 */
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
	 * Método que repassa os parâmetros para asssociar uma atividade a uma pesquisa.
	 * 
	 * @param codigoPesquisa O código da pesquisa.
	 * @param atividade     O código da atividade.
	 * @return O resultado a associação da atividade.
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
	 * Método que repassa os parâmetros para a desassociação da atividade de uma pesquisa.
	 * 
	 * @param codigoPesquisa O código da pesquisa.
	 * @param atividade      O código da atividade.
	 * @return O resultado a desasociação da atividade.
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
     * Método que retorna a pesquisa.
     * 
     * @return A pesquisa desejada.
     */
    public Pesquisa getPesquisa(String codigo) {
    	if(this.pesquisas.containsKey(codigo)) {
    		return this.pesquisas.get(codigo);
    	}
    	else {
    		throw new Error("Pesquisa nao encontrada.");  	
    	}
    }
    
    /**
     * Método retorna um Lista de Pesquisas cadastradas
     * 
     * @return List<Pesquisa>
     */
    public List<Pesquisa> getPesquisas() {
    	
    	List<Pesquisa> listPesquisa = new ArrayList<>();
    	
    	for (String key : this.pesquisas.keySet()) 
			listPesquisa.add(this.pesquisas.get(key));
		
    	
		return listPesquisa;
    }
    
    public void configuraEstrategia(String estrategia) {
    	this.validador.valida(estrategia, "Estrategia nao pode ser nula ou vazia.");
    	switch (estrategia) {
		case "MAIS_ANTIGA":
			this.estrategia = new MaisAntiga();
			break;
		case "MENOS_PENDENCIAS":
			this.estrategia = new MenosPendencias();
			break;
		case "MAIOR_RISCO":
			this.estrategia = new MaiorRisco();
			break;
		case "MAIOR_DURACAO":
			this.estrategia = new MaiorDuracao();
			break;

		default:
			throw new IllegalArgumentException("Valor invalido da estrategia");
			
		}
    }
    
    public String proximaAtividade(String codigoPesquisa) {
    	this.validador.valida(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
    	if(this.pesquisas.containsKey(codigoPesquisa)) {
    		if(this.pesquisas.get(codigoPesquisa).getAtiva()) {
    			this.pesquisas.get(codigoPesquisa).TemPendencia();
    			return this.estrategia.proximaAtividade(this.pesquisas.get(codigoPesquisa));
    		}else {
    			throw new IllegalArgumentException("Pesquisa desativada.");
    		}
    	}else {
    		throw new IllegalArgumentException("Pesquisa nao encontrada.");
    	}
    	
    }
   
    
    public String menorId(String codigoPesquisa) {
    	return this.pesquisas.get(codigoPesquisa).menorId();
    }
}
