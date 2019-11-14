package util;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import controladores.*;
import modulos.*;

/**
 * Classe utilitária para a exibição de Resultados 
 * de uma pesquisa salvo em arquivos de texto
 *  * 
 * */
public class Resultado {
	
	private ControllerGeral controller;
	private Validador validador;
	
	public Resultado(ControllerGeral controller){
		this.controller = controller;
		this.validador = new Validador();
	}
	
    
	/**
	 * Método interno que retorna uma lista de pequisadores
	 * associado a uma pesquisa
	 * 
	 * @param <{@link String}
	 * @return List<Pesquisador>
	 * 
	 * */
	private List<Pesquisador> buscaPesquisadores(String codigo) {
    	
    	List<Pesquisador> pesquisadores = new ArrayList<>();
    	
    	ControllerPesquisador contlPesquisador = this.controller.getControllerPesquisador();
    	List<Pesquisador> todosPesquisadores = contlPesquisador.getPesquisadores();
    	
    	for(Pesquisador pesquisador: todosPesquisadores){
    		List<Pesquisa> pesquisasDeste = pesquisador.getPesquisas();
    		
    		for(Pesquisa pesquisaDeste: pesquisasDeste) {
    			if(pesquisaDeste.getCodigo().equals(codigo)) {
    				pesquisadores.add(pesquisador);
    				break;
    			}
    		}
    	}
    	
    	return pesquisadores;
    	
	}

    		
	/**
	 * Método interno que retorna uma pesquisa a 
	 * partir de um código identificador
	 * 
	 * @param codigo <{@link String}
	 * @return <@ link Pesquisa>
	 * */
	private Pesquisa buscaPesquisa(String codigo) {
		
		ControllerPesquisa contrlPesquisa = this.controller.getControllerPesquisa();
		Pesquisa pesquisa = contrlPesquisa.getPesquisa(codigo);	
		
		return pesquisa;
	}
	

    /**
     * Método responsável por salvar dados a cerca
     * de uma pesquisa em um arquivo de texto
     * 
     * @param codigo <{@link String}     * 
     * */
	public void gravarResumo(String codigoPesquisa) {
    	
    	validador.valida(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
    	
    	StringBuilder sb = new StringBuilder();
    	
    	//Pesquisa
    	final Pesquisa pesquisa = buscaPesquisa(codigoPesquisa);    	
    	sb.append("- Pesquisa: "+pesquisa.toString()+"\n\n");
    	
    	
    	//Pesquisadores
    	List<Pesquisador> pesquisadores = buscaPesquisadores(codigoPesquisa);
    	sb.append("\t - Pesquisadores: \n\n");
    	for(Pesquisador pesquisador: pesquisadores){    		
    		sb.append("\t\t - "+pesquisador.toString()+"\n");    		
    	}
    	
    	//Problemas
    	sb.append("\t - Problemas: \n\n");   	
    	 
    	List<Problema> problemas = new ArrayList<Problema>(); //TODO: Modificar os prblemas*/
    	for(Problema problema: problemas) 
    		sb.append("\t\t - "+problema.toString()+"\n");
    	
    	
    	//Objetivos
    	sb.append("\t - Objetivos: \n\n");
    	List<Objetivo> objetivos = new ArrayList<Objetivo>(); //TODO: Modificar os objetivos*/
    	for(Objetivo objetivo: objetivos) 
    		sb.append("\t\t - "+objetivo.toString()+"\n");
    	
    	
    	//Atividades    	
    	sb.append("\t - Atividades: \n");    	
    	List<Atividade> atividades = pesquisa.getAtividades();
    	
    	for(Atividade atividade: atividades) {
    		sb.append("\t\t - "+atividade.getDescricao()+"\n\n");
    		
    		List<Item> itens = atividade.getItems();
    		
    		for(Item item: itens) {
    			sb.append("\t\t\t - "+item.toString()+"\n");
    		}
    	}

    	
    	final String fileName = pesquisa.getCodigo();
    	File arquivo;
    	
    	if(System.getProperty("os.name").contains("Windows"))
    		arquivo = new File(fileName+"_.txt");
    	else
    		arquivo = new File(fileName+".txt");

    		
    	
    	try {
    		FileWriter fw = new FileWriter(arquivo, false);
    		
    		fw.write(sb.toString());
    		
    		fw.close();
    	}catch (Exception e) {
			throw new Error("Erro na manipulacao de arquivos "+e.getMessage());
		}    		
    }
    	
    	
	/**
     * Método responsável por salvas resultados obtidos a cerca
     * de uma pesquisa em um arquivo de texto
     * 
     * @param codigo <{@link String}     * 
     * */
	public void gravarResultados(String codigoPesquisa) {
    	
    	validador.valida(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
    	
    	/*   
    	 * - Pesquisa: CÓDIGO - Descrição - Campo de interesse

    - Resultados:

        - DESCRIÇÃO

            - ITEM1 - DURAÇÃO - DESCRIÇÃO_RESULTADO

            - ITEM2 - DURAÇÃO - DESCRIÇÃO_RESULTADO

        - DESCRIÇÃO

            - ITEM4 - DURAÇÃO - DESCRIÇÃO_RESULTADO

            - ITEM5 - DURAÇÃO - DESCRIÇÃO_RESULTADO

    	 * */
    	
    	StringBuilder sb = new StringBuilder();    	
    	final Pesquisa pesquisa = buscaPesquisa(codigoPesquisa);
    	
    	sb.append("\t- Pesquisa: "+pesquisa.toString()+"\n\n");
    	sb.append(" - Resultados: \n");
    	
    	//Atividades    	
    	List<Atividade> atividades = pesquisa.getAtividades();
    	
    	for(Atividade atividade: atividades) {
    		sb.append("\t\t - "+atividade.getDescricao()+"\n");
    		
    		List<String> resultados = atividade.getResultados();
    		
    		for(String resultado: resultados) {
    			sb.append("\t\t\t - "+resultado+"\n");
    		}   		
    		
    	}
    	
    	
    	final String fileName = pesquisa.getCodigo();
    	File arquivo = new File(fileName+"-Resultados.txt");
    	
    	try {
    		FileWriter fw = new FileWriter(arquivo, false);    		
    		fw.write(sb.toString());    		
    		fw.close();
    	}catch (Exception e) {
			throw new Error("Erro na manipulacao de arquivos "+e.getMessage());
		}	
    	
    }

}
