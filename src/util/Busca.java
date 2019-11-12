package util;
import java.util.ArrayList;
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
	
	Busca(){
		this.controller = new ControllerGeral();
	}
	
	
	private List<String> buscaPesquisa(String termo) {
		
		List<String> resultados = new ArrayList<String>();
		
		ControllerPesquisa ctrlPesquisa = this.controller.getControllerPesquisa();
		List<Pesquisa> pesquisas = ctrlPesquisa.getPesquisas();
		
		for (Pesquisa pesquisa : pesquisas) {
			
			final String stringPesquisa = pesquisa.toString();
			
			if(stringPesquisa.matches(termo))
				resultados.add(stringPesquisa);
		}
		
		return resultados;
	}
	
	private List<String> buscaPesquisador(String termo) {
		
		List<String> resultados = new ArrayList<String>();
		
		ControllerPesquisador ctrlPesquisador = this.controller.getControllerPesquisador();
		List<Pesquisador> pesquisadores = ctrlPesquisador.getPesquisadores();
		
		for (Pesquisador pesquisador : pesquisadores) {
			
			final String stringPesquisadores = pesquisador.toString();
			
			if(stringPesquisadores.matches(termo))
				resultados.add(stringPesquisadores);
		}
		
		return resultados;
	}

	
	/**
	 * 
	 * 
	 * */
	private List<String> buscaProblema(String termo) {
		
		List<String> resultados = new ArrayList<String>();
		
		ControllerProblemaObjetivo ctrlProblema = this.controller.getControllerProblema();
		List<Problema> problemas = ctrlProblema.getProblemas();
		
		for (Problema problema : problemas) {
			
			final String stringProblemas = problema.toString();
			
			if(stringProblemas.matches(termo))
				resultados.add(stringProblemas);
		}
		
		return resultados;
	}
	
	private List<String> buscaObjetivo(String termo) {
		
		List<String> resultados = new ArrayList<String>();
		
		ControllerProblemaObjetivo ctrlProblema = this.controller.getControllerProblema();
		
		List<Objetivo> objetivos = ctrlProblema.getObjetivos();
		
		for (Objetivo objetivo : objetivos) {
			
			final String stringObjetivos = objetivo.toString();
			
			if(stringObjetivos.matches(termo))
				resultados.add(stringObjetivos);
		}
		
		return resultados;
	}
	
	private List<String> buscaAtividade(String termo) {
		
		List<String> resultados = new ArrayList<String>();
		
		ControllerAtividade ctrlAtividade = this.controller.getControllerAtividade();
		
		List<Atividade> atividades = ctrlAtividade.getaAtividades();
		
		for (Atividade atividade : atividades) {
			
			final String stringAtividade = atividade.toString();
			
			if(stringAtividade.matches(termo))
				resultados.add(stringAtividade);
		}
		
		return resultados;
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
		
		return busca(termo, 0);
		
	}
	
	/**
	 * Método realiza uma busca a partir de um termo 
	 * com um limite máximo de busca nas entidades:
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
	public String busca(String termo, int numeroDoResultado) {
		
		validador.valida(termo, "Campo termo nao pode ser nulo ou vazio.");
		validador.validaPositivo(numeroDoResultado, "Numero do resultado nao pode ser negativo.");
		
		
		
		int cont = 0;
		
		StringBuilder sb = new StringBuilder();
		
		///Busca em pesquisa
		List<String> resultPesquisa = buscaPesquisa(termo);		
		
		for(String res: resultPesquisa) {
			
			if(cont <= numeroDoResultado) 
				sb.append(resultPesquisa+" | ");
			
			if(numeroDoResultado!=0)cont++;
						
		}
			
		
		///Busca em pesquisador
		List<String> resultPesquisador = buscaPesquisador(termo);
		
		for(String res: resultPesquisador) {
			
			if(cont<= numeroDoResultado) 
				sb.append(res+" | ");
			
			if(numeroDoResultado!=0)cont++;
		}
		
		///Busca em Problema
		List<String> resultProblema = buscaProblema(termo);
		
		for(String res: resultProblema) {
			if(cont<= numeroDoResultado) 
				sb.append(res+" | ");
			
			if(numeroDoResultado!=0)cont++;
		}
		
		//Busca em Objetivos
		List<String> resultObjetivos = buscaObjetivo(termo);
		
		for(String res: resultObjetivos) {
			if(cont<= numeroDoResultado) 
				sb.append(res+" | ");
			
			if(numeroDoResultado!=0)cont++;
		}
		
		//Busca em Atividades
		List<String> resultAtividades = buscaAtividade(termo);
		
		for(String res: resultAtividades) {
			if(cont<= numeroDoResultado) 
				sb.append(res+" | ");
			
			if(numeroDoResultado!=0)cont++;
		}
			
		
		return sb.toString().substring(0, sb.toString().length()-3);
	}
	
	


	public int contaResultadosBusca(String termo) {
		return 0;
	}
	
	
}
