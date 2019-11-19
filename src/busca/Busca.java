package busca;

import java.util.ArrayList;
import java.util.List;

import controladores.ControllerGeral;
import modulos.Atividade;
import modulos.Objetivo;
import modulos.Pesquisa;
import modulos.Pesquisador;
import modulos.Problema;
import util.Validador;


/**
 *Classe representativa para a realização de buscas no sistema
 *
 * 
 */
public class Busca {
	
	private List <ResultadoBusca> resulEncontrados;
	private ControllerGeral cg;
	private Validador validador;
	
	public Busca(ControllerGeral controller){

		this.resulEncontrados = new ArrayList<>();
		this.validador = new Validador();
		this.cg = controller;
	}
	
	/**
	 * M�todo p�blico que realiza uma busca a partir de um termo nas entidades:
	 * 	
	 * 	- Pesquisa
	 * 	- Pesquisador
	 * 	- Problemas
	 *  - Objetivos
	 *  - Atividades
	 *  
	 *  @param termo
	 *  @param buscaNumerada: define se os resultados encontrados serão
	 *  enumerados
	 * */
	public String busca(String termo, boolean buscaNumerada) {
		
		validador.valida(termo, "Campo termo nao pode ser nulo ou vazio.");
		
		StringBuilder sb = new StringBuilder();
		
		List<ResultadoBusca> resultPesquisa = buscaPesquisa(termo);
		List<ResultadoBusca> resultPesquisador = buscaPesquisador(termo);
		List<ResultadoBusca> resultProblema = buscaProblema(termo);
		List<ResultadoBusca> resultObjetivo = buscaObjetivo(termo);
		List<ResultadoBusca> resultAtividade = buscaAtividade(termo);
		
		this.resulEncontrados = new ArrayList<ResultadoBusca>();
		
		///Busca em pesquisa		
		this.resulEncontrados.addAll(resultPesquisa);									
		
		///Busca em pesquisador		
		this.resulEncontrados.addAll(resultPesquisador);	

		
		///Busca em problema	
		this.resulEncontrados.addAll(resultProblema);			
		
		///Busca em objetivo
		this.resulEncontrados.addAll(resultObjetivo);	

		///Busca em atividade
		this.resulEncontrados.addAll(resultAtividade);	

		if(this.resulEncontrados.size()==0 && !buscaNumerada)
			throw new Error("Entidade nao encontrada.");	
		if(this.resulEncontrados.size()==0 && buscaNumerada)
			throw new Error("Nenhum resultado encontrado");
			
		
		for(ResultadoBusca res : this.resulEncontrados) {
			sb.append(res+" | ");
		}
		
		String tmp = sb.toString();
		tmp = tmp.substring(0, tmp.length()-3);
		return tmp;		
	}

	/**
	 * Metodo interno para a busca espec�fica de Pesquisa
	 * 
	 * @param String termo
	 * @return List<ResultadoBusca>
	 * */
	private List<ResultadoBusca> buscaPesquisa(String termo) {
		
		List<ResultadoBusca> matchsList = new ArrayList<ResultadoBusca>();		
		List<Pesquisa> pesquisas = this.cg.getControllerPesquisa().getPesquisas();
		
		for (final Pesquisa pesquisa : pesquisas) {			
			
			final ResultadoBusca result = new ResultadoBusca(pesquisa.getCodigo(), pesquisa.getDescricao());
			
			if(result.match(termo))
				matchsList.add(result);
							
			//if(pesquisa.getAtividades().size() > 0) {				
			
				result.setCamposInteresses(pesquisa.getCamposInteresse());
				
				if(result.matchInteresses(termo)) {
					matchsList.add(new ResultadoBusca(pesquisa.getCodigo(), pesquisa.getCamposInteresse()));
				}
				
			//}			
		}		
		
		matchsList.sort(ResultadoBusca.getComparador());
		return matchsList;
	}
	
	/**
	 * Metodo interno para a busca espec�fica de Pesquisador
	 * 
	 * @param String termo
	 * @return List<ResultadoBusca>
	 * */
	private List<ResultadoBusca> buscaPesquisador(String termo) {
		
		List<ResultadoBusca> matchsList = new ArrayList<ResultadoBusca>();		
		List<Pesquisador> pesquisadores = this.cg.getControllerPesquisador().getPesquisadores();
		
		for (Pesquisador pesquisador : pesquisadores) {
			
			ResultadoBusca result = new ResultadoBusca(pesquisador.getEmail(), pesquisador.getBiografia());			
			
			if(result.match(termo))
				matchsList.add(result);
		}
		
		matchsList.sort(ResultadoBusca.getComparador());
		return matchsList;
	}

	
	/**
	 * Metodo interno para a busca espec�fica de Problemas
	 * 
	 * @param String termo
	 * @return List<ResultadoBusca>
	 * */
	private List<ResultadoBusca> buscaProblema(String termo) {
		
		List<ResultadoBusca> matchsList = new ArrayList<ResultadoBusca>();		
		List<Problema> problemas = this.cg.getControllerProblemaObjetivo().getProblemas();
		
		for (Problema problema : problemas) {
			
			ResultadoBusca result = new ResultadoBusca(problema.getCodigo(), problema.getDescricao());			
			
			if(result.match(termo))
				matchsList.add(result);
		}
		
		matchsList.sort(ResultadoBusca.getComparador());
		return matchsList;
	}
	
	/**
	 * Metodo interno para a busca espec�fica de Objetivos
	 * 
	 * @param String termo
	 * @return List<ResultadoBusca>
	 * */
	private List<ResultadoBusca> buscaObjetivo(String termo) {
		
		List<ResultadoBusca> matchsList  = new ArrayList<ResultadoBusca>();				
		List<Objetivo> objetivos = this.cg.getControllerProblemaObjetivo().getObjetivos();
		
		for (Objetivo objetivo : objetivos) {
			
			ResultadoBusca result = new ResultadoBusca(objetivo.getCodigo(), objetivo.getDescricao());			
			
			if(result.match(termo))
				matchsList.add(result);
		}
		
		matchsList.sort(ResultadoBusca.getComparador());
		
		return matchsList;
	}
	
	/**
	 * Metodo interno para a busca espec�fica de Atividades
	 * 
	 * @param String termo
	 * @return List<ResultadoBusca>
	 * */
	private List<ResultadoBusca> buscaAtividade(String termo) {
		
		List<ResultadoBusca> matchsList  = new ArrayList<ResultadoBusca>();
		
		
		List<Atividade> atividades = this.cg.getControllerAtividade().getAtividades();
		
		for (Atividade atividade : atividades) {
			
			ResultadoBusca result = new ResultadoBusca(atividade.getCodigo(), atividade.getDescricao());			
			
			if(result.match(termo))
				matchsList.add(result);
		}
		
		matchsList.sort(ResultadoBusca.getComparador());

		return matchsList;
	}
	
	/**
	 *Metodo retorna um resultado de uma busca em uma determinada posicao
	 *
	 * @param termo
	 * @param numeroDoResultado
	 * */
	public String busca(String termo, int numeroDoResultado) {
		
		validador.valida(termo, "Campo termo nao pode ser nulo ou vazio.");
		
		if(numeroDoResultado<0)
			throw new Error("Numero do resultado nao pode ser negativo");
		
		busca(termo, true);
		
		if(this.resulEncontrados.size() <= numeroDoResultado)
			throw new Error("Entidade nao encontrada.");
			 
		return this.resulEncontrados.get(numeroDoResultado-1).toString();
	}
	
    
	/**
	 *Metodo retorna o numero de resultadod  de uma busca
	 *
	 * @param termo
	 * @param numeroDoResultado
	 * */
	public int contaResultadosBusca(String termo) {
    	
		validador.valida(termo, "Campo termo nao pode ser nulo ou vazio.");

    	busca(termo, true);
    	return this.resulEncontrados.size();
    }
	
	
}
