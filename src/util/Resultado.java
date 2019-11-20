package util;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import controladores.*;
import modulos.*;

/**
 * Classe utilit�ria para a exibição de Resultados 
 * de uma pesquisa salvo em arquivos de texto
 *  * 
 * */
public class Resultado implements Serializable {
	
	private ControllerGeral cg;
	private Validador validador;
	
	public Resultado(ControllerGeral controller){
		this.cg = controller;
		this.validador = new Validador();
	}
	
    
	/**
	 * M�todo interno que retorna uma lista de pequisadores
	 * associado a uma pesquisa
	 * 
	 * @param <{@link String}
	 * @return List<Pesquisador>
	 * 
	 * */
	private List<Pesquisador> buscaPesquisadores(String codigo) {
    	
    	List<Pesquisador> pesquisadores = new ArrayList<>();
    	
    	List<Pesquisador> todosPesquisadores = this.cg.getControllerPesquisador().getPesquisadores();
    	
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
	 * M�todo interno que retorna uma pesquisa a 
	 * partir de um c�digo identificador
	 * 
	 * @param codigo <{@link String}
	 * @return <@ link Pesquisa>
	 * */
	private Pesquisa buscaPesquisa(String codigo) {
		
		Pesquisa pesquisa = this.cg.getControllerPesquisa().getPesquisa(codigo);	
		
		return pesquisa;
	}
	

    /**
     * M�todo respons�vel por salvar dados a cerca
     * de uma pesquisa em um arquivo de texto
     * 
     * @param codigo <{@link String}     * 
     * */
	public void gravarResumo(String codigoPesquisa) {
    	
    	validador.valida(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
    	
    	StringBuilder sb = new StringBuilder();
    	
    	//Pesquisa
    	final Pesquisa pesquisa = buscaPesquisa(codigoPesquisa);    	
    	sb.append("\"- Pesquisa: "+pesquisa.toString()+"\n");
    	
    	
    	//Pesquisadores
    	List<Pesquisador> pesquisadores = buscaPesquisadores(codigoPesquisa);
    	sb.append("\t- Pesquisadores: \n");
    	for(Pesquisador pesquisador: pesquisadores){    		
    		sb.append("\t\t- "+pesquisador.toString()+"\n");    		
    	}
    	
    	//Problemas
    	sb.append("\t- Problema: \n");   	
    	 
    	Problema problema = pesquisa.getProblema(); //TODO: Modificar os prblemas*/
    	
    	if(problema!=null)
    		sb.append("\t\t - "+problema.toString()+"\n");
    	
    	
    	//Objetivos
    	sb.append("\t- Objetivos: \n");
    	List<Objetivo> objetivos = pesquisa.getObjetivos();
    	for(Objetivo objetivo: objetivos) 
    		sb.append("\t\t - "+objetivo.toString()+"\n");
    	
    	
    	//Atividades    	
    	sb.append("\t- Atividades: \n");    	
    	List<Atividade> atividades = pesquisa.getAtividades();
    	
    	for(Atividade atividade: atividades) {
    		sb.append("\t\t - "+atividade.getDescricao()+" ("+atividade.getNivelRisco()+" - "+atividade.getDescricaoRisco()+")\n");
    		
    		List<Item> itens = atividade.getItems();
    		
    		for(int i=0; i < itens.size(); i++) {
    			Item item = itens.get(i);
    			sb.append("\t\t\t- "+item.getStatus()+" - ITEM"+(i+1));
    			
    			if(i == itens.size()-1)
    		    	sb.append("\"");
    			else
    				sb.append("\n");
    		}
    	}
    	

    	
    	final String fileName = pesquisa.getCodigo();
    	File arquivo;
    	
    	arquivo = new File("_"+fileName+".txt");

    		
    	
    	try {
    		FileWriter fw = new FileWriter(arquivo, false);
    		
    		fw.write(sb.toString());
    		
    		fw.close();
    	}catch (Exception e) {
			throw new Error("Erro na manipulacao de arquivos "+e.getMessage());
		}    		
    }
    	
    	
	/**
     * M�todo respons�vel por salvas resultados obtidos a cerca
     * de uma pesquisa em um arquivo de texto
     * 
     * @param codigo <{@link String}     * 
     * */
	public void gravarResultados(String codigoPesquisa) {
    	
    	validador.valida(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
    	    	
    	StringBuilder sb = new StringBuilder();    	
    	final Pesquisa pesquisa = buscaPesquisa(codigoPesquisa);
    	
    	sb.append("\"- Pesquisa: "+pesquisa.toString()+"\n");
    	sb.append("\t- Resultados: \n");
    	
    	//Atividades    	
    	List<Atividade> atividades = pesquisa.getAtividades();
    	
    	for(Atividade atividade: atividades) {
    		sb.append("\t\t- "+atividade.getDescricao()+"\n");
    		
    		List<Item> itens = atividade.getItems();
    		
    		for(int i=0; i < itens.size(); i++) {
    			//Item item = itens.get(i);
    			sb.append("\t\t\t- ITEM"+(i+1)+" - "+(atividade.getDuracao()/itens.size()));    			
    			sb.append("\n");
    		}
    		
    		List<String> resultados = atividade.getResultados();    		
    		for(int i=0; i<resultados.size();i++) {
    			String resultado = resultados.get(i);
    			sb.append("\t\t\t- "+resultado);
    			
    			if(i==resultados.size()-1)
    				sb.append("\"\n");
    			else
    				sb.append("\n");
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
