package util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controladores.*;
import modulos.*;


/**
 * Classe responsável pela a execução de buscas gerais
 * no Sistema
 *
 */

public class Busca {
	
	/**Controlador para o interfaceamento com o sistema e a busca*/
	
	private ControllerGeral controller;
	private Validador validador;
	private int contResultados = 0;
	
	public Busca(ControllerGeral controller){
		this.controller = controller;
		this.validador = new Validador();
	}
	
	
	/**
	 * Metodo interno para a busca específica de Pesquisa
	 * 
	 * @param String termo
	 * @return List<String>
	 * */
	private List<String> buscaPesquisa(String termo) {
		
		List<String> matchsList = new ArrayList<String>();
		
		ControllerPesquisa ctrlPesquisa = this.controller.getControllerPesquisa();
		List<Pesquisa> pesquisas = ctrlPesquisa.getPesquisas();
		
		for (Pesquisa pesquisa : pesquisas) {
			
			final String stringPesquisa = pesquisa.toStringBusca();
			
			if(stringPesquisa.contains(termo))
				matchsList.add(stringPesquisa);
		}
		
		//Collections.reverse(matchsList);
		return matchsList;
	}
	
	/**
	 * Metodo interno para a busca específica de Pesquisador
	 * 
	 * @param String termo
	 * @return List<String>
	 * */
	private List<String> buscaPesquisador(String termo) {
		
		List<String> matchsList = new ArrayList<String>();
		
		ControllerPesquisador ctrlPesquisador = this.controller.getControllerPesquisador();
		List<Pesquisador> pesquisadores = ctrlPesquisador.getPesquisadores();
		
		for (Pesquisador pesquisador : pesquisadores) {
			
			final String stringPesquisa = pesquisador.getBiografia();
			
			
			if(stringPesquisa.contains(termo))
				matchsList.add(pesquisador.toStringBusca());
		}
		
		Collections.reverse(matchsList);
		return matchsList;
	}

	
	/**
	 * Metodo interno para a busca específica de Problemas
	 * 
	 * @param String termo
	 * @return List<String>
	 * */
	private List<String> buscaProblema(String termo) {
		
		List<String> matchsList = new ArrayList<String>();
		
		ControllerProblemaObjetivo ctrlProblema = this.controller.getControllerProblema();
		List<Problema> problemas = ctrlProblema.getProblemas();
		
		for (Problema problema : problemas) {
			
			final String stringProblemas = problema.getDescricao();
			
			if(stringProblemas.contains(termo))
				matchsList.add(problema.toStringBusca());
		}
		
		Collections.reverse(matchsList);
		return matchsList;
	}
	
	/**
	 * Metodo interno para a busca específica de Objetivos
	 * 
	 * @param String termo
	 * @return List<String>
	 * */
	private List<String> buscaObjetivo(String termo) {
		
		List<String> matchsList  = new ArrayList<String>();
		
		ControllerProblemaObjetivo ctrlProblema = this.controller.getControllerProblema();
		
		List<Objetivo> objetivos = ctrlProblema.getObjetivos();
		
		for (Objetivo objetivo : objetivos) {
			
			final String stringObjetivos = objetivo.toStringBusca();
			
			if(stringObjetivos.contains(termo))
				matchsList .add(stringObjetivos);
		}
		
		Collections.reverse(matchsList);

		return matchsList;
	}
	
	/**
	 * Metodo interno para a busca específica de Atividades
	 * 
	 * @param String termo
	 * @return List<String>
	 * */
	private List<String> buscaAtividade(String termo) {
		
		List<String> matchsList  = new ArrayList<String>();
		
		ControllerAtividade ctrlAtividade = this.controller.getControllerAtividade();
		
		List<Atividade> atividades = ctrlAtividade.getaAtividades();
		
		for (Atividade atividade : atividades) {
			
			final String stringAtividade = atividade.toStringBusca();
			
			if(stringAtividade.contains(termo))
				matchsList .add(stringAtividade);
		}
		
		Collections.reverse(matchsList);

		return matchsList;
	}
	
	
	/**
	 * Método público que realiza uma busca a partir de um termo nas entidades:
	 * 	
	 * 	- Pesquisa
	 * 	- Pesquisador
	 * 	- Problemas
	 *  - Objetivos
	 *  - Atividades
	 *  
	 *  @author adyssonfs
	 *  @param termo
	 * */
	public String busca(String termo) {
		
		validador.valida(termo, "Campo termo nao pode ser nulo ou vazio.");
		
		StringBuilder sb = new StringBuilder();
		
		List<String> resultPesquisa = buscaPesquisa(termo);
		List<String> resultPesquisador = buscaPesquisador(termo);
		List<String> resultProblema = buscaProblema(termo);
		List<String> resultObjetivo = buscaObjetivo(termo);
		List<String> resultAtividade = buscaAtividade(termo);
		
		///Busca em pesquisa		
		for(String res: resultPesquisa) {
			
			sb.append(res);
			contResultados++;
		}
									
		
		///Busca em pesquisador		
		for(String res: resultPesquisador) {	
			
				sb.append(res);
				contResultados++;
			
		}	
		
		///Busca em problema	
		for(String res: resultProblema) {
			
			sb.append(res);
			contResultados++;
		}
			
		
		///Busca em objetivo
		for(String res: resultObjetivo)	{
				sb.append(res);
				contResultados++;
		}
		
		///Busca em atividade
		for(String res: resultAtividade) {
				sb.append(res);
				contResultados++;
		}
		
		if(contResultados==0)
			throw new Error("Entidade nao encontrada.");
		
			
		String tmp = sb.toString();
		tmp = tmp.substring(0,tmp.length()-3);
		return tmp;
		
	}
	
	/**
	 * Método realiza uma busca a partir de um termo 
	 * com um determinada posicao nos resultados da busca
	 * nas entidades:
	 * 	
	 * 	- Pesquisa
	 * 	- Pesquisador
	 * 	- Problemas
	 *  - Objetivos
	 *  - Atividades
	 *  
	 *  @author adyssonfs
	 *  @param termo
	 * */
	public String buscaLimit(String termo, int numeroDoResultado) {
		
		validador.valida(termo, "Campo termo nao pode ser nulo ou vazio.");
		validador.validaPositivo(numeroDoResultado, "Numero do resultado nao pode ser negativo");
		
		String[] resultados = busca(termo).split(" | ");
		
		return resultados[numeroDoResultado];
	}
	
	


	public int contaResultadosBusca(String termo) {
		
		
		validador.valida(termo, "Campo termo nao pode ser nulo ou vazio.");
		
		contResultados = 0;
		
		busca(termo);
		
		if(contResultados==0)
			throw new Error("Nenhum resultado encontrado");
		
		return contResultados;
	}
	
	
}
