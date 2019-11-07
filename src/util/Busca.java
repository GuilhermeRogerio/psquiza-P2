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
			
			final String stringPesquisadores = pesquisadores.toString();
			
			if(stringPesquisadores.matches(termo))
				resultados.add(stringPesquisadores);
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
		
		if(numeroDoResultado == 0) {
			
		}
		
		int cont = 0;
		
		StringBuilder sb = new StringBuilder();
		
		///Busca em pesquisa
		List<String> resultPesquisa = buscaPesquisa(termo);
		
		
		for(int i=0; i< resultPesquisa.size(); i++) {
			sb.append(res+" | ");
		}
			
		
		///Busca em pesquisador
		List<String> resultPesquisador = buscaPesquisador(termo);
		
		for(String res: resultPesquisador)
			sb.append(res+" | ");
		
		return sb.toString().substring(0, sb.toString().length()-3);
	}
	
	public int contaResultadosBusca(String termo) {
		
	}
	
	
}
