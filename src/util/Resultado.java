package util;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import controladores.*;
import modulos.*;

/**
 * Classe utilit�ria para a exibi��o de Resultados 
 * de uma pesquisa salvo em arquivos de texto
 *  * 
 * */
public class Resultado {
	
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
    	sb.append("- Pesquisa: "+pesquisa.toString()+"\n\n");
    	
    	
    	//Pesquisadores
    	List<Pesquisador> pesquisadores = buscaPesquisadores(codigoPesquisa);
    	sb.append("\t - Pesquisadores: \n\n");
    	for(Pesquisador pesquisador: pesquisadores){    		
    		sb.append("\t\t - "+pesquisador.toString()+"\n");    		
    	}
    	
    	//Problemas
    	sb.append("\t - Problemas: \n\n");   	
    	 
    	Problema problema = pesquisa.getProblema().get(); //TODO: Modificar os prblemas*/
    	
    	if(problema!=null)
    		sb.append("\t\t - "+problema.toString()+"\n");
    	
    	
    	//Objetivos
    	sb.append("\t - Objetivos: \n\n");
    	List<Objetivo> objetivos = pesquisa.getObjetivos();
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
     * M�todo respons�vel por salvas resultados obtidos a cerca
     * de uma pesquisa em um arquivo de texto
     * 
     * @param codigo <{@link String}     * 
     * */
	public void gravarResultados(String codigoPesquisa) {
    	
    	validador.valida(codigoPesquisa, "Pesquisa nao pode ser nula ou vazia.");
    	
    	/*   
    	 * - Pesquisa: C�DIGO - Descri��o - Campo de interesse

    - Resultados:

        - DESCRI��O

            - ITEM1 - DURA��O - DESCRI��O_RESULTADO

            - ITEM2 - DURA��O - DESCRI��O_RESULTADO

        - DESCRI��O

            - ITEM4 - DURA��O - DESCRI��O_RESULTADO

            - ITEM5 - DURA��O - DESCRI��O_RESULTADO

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
