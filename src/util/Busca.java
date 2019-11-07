package util;
import java.util.ArrayList;
import java.util.List;

import controladores.*;
import modulos.Pesquisa;


/**
 * Classe responsável pela a execução de buscas gerais
 * no Sistema
 *
 */

public class Busca {
	
	/**Controlador para o interfaceamento com o sistema e a busca*/
	
	private ControllerGeral controller;
	private 
	
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
	
	
	/**
	 * Método realiza uma busca a partir de um termo nas entidades:
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
		
		StringBuilder sb = new StringBuilder();
		
		List<String> resultPesquisa = buscaPesquisa(termo);
		
		for(String res: resultPesquisa)
			sb.append(res+" | ");
		
		return sb.toString().substring(0, sb.toString().length()-3);
		
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
		
		
	}
	
	public int contaResultadosBusca(String termo) {
		
	}
	
	
}
