package controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modulos.Pesquisador;
import util.Validador;

/**
 * Classe que representa controlador dos pesquisadores do sistema.
 * 
 */
public class ControllerPesquisador {

    /**
     * Verificador das entradas para o tratamento.
     *
     */
    private Validador validador;

    /**
     * Mapa onde os pesquisadores serão armazenados para as operações do sistema.
     * 
     */
    private HashMap<String, Pesquisador> mapaPesquisador;

    /**
     * Construtor do mapa e do verificador do validador.
     * 
     */
    public ControllerPesquisador(){
        this.mapaPesquisador = new HashMap<>();
        this.validador = new Validador();
    }

    /**
     * Método que cadastra os pesquisadores no sistema.
     * 
     * @param nome A nome do pesquisador.
     * @param funcao A função do pesquisador.
     * @param biografia A biografia do pesquisador.
     * @param email O email do pesquisador.
     * @param foto A foto do pesquisador.
     */
    public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto){
        this.validador.valida(nome, "Campo nome nao pode ser nulo ou vazio.");
        this.validador.valida(funcao,"Campo funcao nao pode ser nulo ou vazio.");
        this.validador.valida(biografia, "Campo biografia nao pode ser nulo ou vazio.");
        this.validador.valida(email, "Campo email nao pode ser nulo ou vazio.");
        this.validador.valida(foto, "Campo fotoURL nao pode ser nulo ou vazio.");
        this.validador.validaEmail(email, "Formato de email invalido.");
        this.validador.validaFotoURL(foto, "Formato de foto invalido.");
        Pesquisador pesquisador = new Pesquisador(nome, funcao, biografia, email, foto);
        this.mapaPesquisador.put(email, pesquisador);
    }
    /**
     * Método que passa os parâmetros realiza alterações no pesquisador.
     * 
     * @param email O email idetificador do pesquisador.
     * @param atributo O atributo a ser alterado.
     * @param novoValor O novo valor do atributo.
     */
    public void alteraPesquisador(String email, String atributo, String novoValor) {
        this.validador.valida(atributo, "Atributo nao pode ser vazio ou nulo.");
        this.validaAlteraPesquisador(atributo, novoValor);
        if(this.mapaPesquisador.containsKey(email)) {
        	Pesquisador pesquisador = this.mapaPesquisador.get(email);
            if (atributo.equals("NOME")) {
            	pesquisador.setNome(novoValor);
	        } else if (atributo.equals("FUNCAO")) {
	            pesquisador.setFuncao(novoValor);
	        } else if (atributo.equals("BIOGRAFIA")) {
	            pesquisador.setBiografia(novoValor);
	        } else if (atributo.equals("FOTO")) {
	            this.validador.validaFotoURL(novoValor, "Formato de foto invalido.");
	            pesquisador.setFoto(novoValor);
	        } else if (atributo.equals("EMAIL")) {
	            this.validador.validaEmail(novoValor, "Formato de email invalido.");
	            pesquisador.setEmail(novoValor);
	            this.mapaPesquisador.put(novoValor, pesquisador);
	            this.mapaPesquisador.remove(email);
	        } else if (this.verificaAtributos(atributo)) {
	        	pesquisador.alteraEspecialidade(atributo, novoValor);
	        }
	        else {
	            throw new IllegalArgumentException("Atributo invalido.");
	        }
        } else {
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
        
    }
    
    /**
     * Método que identifica se o atributo passado como parâmetro representa um dos atributos de um pesquisador especializado
     * 
     * @param atributo O atributo a ser comparado
     * @return O boolean informado se o atributo é, ou não, um atributo de um pesquisador do tipo Aluno ou Professor
     */
    private boolean verificaAtributos(String atributo) {
    	return ("FORMACAO".equals(atributo) || "DATA".equals(atributo) || "UNIDADE".equals(atributo) || 
    			"SEMESTRE".equals(atributo) || "IEA".equals(atributo));
    }
    
    /**
     * Método que valida a foto do pesquisador
     * 
     * @param atributo A foto do pesquisador
     * @param novoValor A foto atualizada
     */
    private void validaAlteraPesquisador(String atributo, String novoValor) {
    	if ("FOTO".equals(atributo)) {
    		this.validador.valida(novoValor, "Campo fotoURL nao pode ser nulo ou vazio.");
    	} else {
    		this.validador.valida(novoValor, "Campo " + atributo.toLowerCase() + " nao pode ser nulo ou vazio.");
    	}
    }

    /**
     * Método que realiza a desativação do pesquisador no sistema.
     * 
     * @param email O email idetificador do pesquisador.
     */
    public void desativaPesquisador(String email) {
        if (this.mapaPesquisador.containsKey(email)) {
            if (!this.mapaPesquisador.get(email).getAtivo()){
                 throw new IllegalArgumentException("Pesquisador inativo.");
             }else {
                this.mapaPesquisador.get(email).setAtivo(false);
            }
        }else{
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
    }

    /**
     * Método que realiza a ativação do pesquisador no sistema.
     * 
     * @param email O email idetificador do pesquisador.
     */
    public void ativaPesquisador(String email) {
        if(this.mapaPesquisador.containsKey(email)){
            if(this.mapaPesquisador.get(email).getAtivo()){
                throw new IllegalArgumentException("Pesquisador ja ativado.");
            }else {
                this.mapaPesquisador.get(email).setAtivo(true);
            }
        }else{
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
    }
    
    /**
     * Método que realiza a exibiçãoo um determinado pesquisador.
     * 
     * @param email O email idetificador do pesquisador.
     * @return A representação do pesquisador.
     */
    public String exibePesquisador(String email) {
    	this.validador.valida(email, "Campo email nao pode ser nulo ou vazio.");
        if (mapaPesquisador.containsKey(email)) {
            return this.mapaPesquisador.get(email).toString();
        }else{
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
    }
    
    /**
     * Método que realiza a checagem do estado de um determinado pesquisador.
     * 
     * @param email O email idetificador do pesquisador.
     * @return A estado do pesquisador no sistema.
     */
    public boolean pesquisadorEhAtivo(String email) {
        this.validador.valida(email, "Email nao pode ser vazio ou nulo.");
        if (this.mapaPesquisador.containsKey(email)) {
            return this.mapaPesquisador.get(email).getAtivo();
        }else{
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
    }
    
    /**
     * Método que retorna todos Pesquisadores cadastrados
     * 
     * @return O pesquisador no sistema.
     */
    public List<Pesquisador> getPesquisadores() {
    	List<Pesquisador> pesquisadores = new ArrayList<Pesquisador>();
    	for(String key: this.mapaPesquisador.keySet())
    		pesquisadores.add(this.mapaPesquisador.get(key));
    	return pesquisadores;    	
    }
    
    /**
     * Método que busca um Pesquisador cadastrado.
     * 
     * @param email A chave de busca do pesquisador.
     * @return O Pesquisador.
     */
    public Pesquisador getPesquisador(String email) {
    	this.validador.valida(email, "Email nao pode ser vazio ou nulo.");
    	if (!this.mapaPesquisador.containsKey(email)) {
    		throw new IllegalArgumentException("Pesquisadora nao encontrada.");
    	} else {
    		return this.mapaPesquisador.get(email);
    	}
    }
    
    /**
     * Método que lista pesquisadores do tipo especificado
     * 
     * @param tipo A tipo do pesquisador que se quer listar.
     * @return A representação textual dos pesquisadores.
     */
    public String listaPesquisadores(String tipo) {
    	tipo = tipo.toLowerCase();
    	String retorno = "";
    	for (String email : this.mapaPesquisador.keySet()) {
    		Pesquisador pesquisador = this.mapaPesquisador.get(email);
    		if (tipo.equals(pesquisador.getFuncao())) {
    			retorno += pesquisador.toString() + " | ";
    		}
    	}
    	retorno = retorno.substring(0, retorno.length() - 3);
    	return retorno;
    }
}
