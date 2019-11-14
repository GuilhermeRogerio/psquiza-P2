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
     * @param nome o nome do pesquisador.
     * @param funcao a função do pesquisador.
     * @param biografia a biografia do pesquisador.
     * @param email o email do pesquisador.
     * @param foto a foto do pesquisador.
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
     * Método que realiza alterações no pesquisador.
     * 
     * @param email o email idetificador do pesquisador.
     * @param atributo o atributo a ser alterado.
     * @param novoValor o novo valor do atributo.
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
    
    private boolean verificaAtributos(String atributo) {
    	return ("FORMACAO".equals(atributo) || "DATA".equals(atributo) || "UNIDADE".equals(atributo) || 
    			"SEMESTRE".equals(atributo) || "IEA".equals(atributo));
    }
    
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
     * @param email o email idetificador do pesquisador.
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
     * @param email o email idetificador do pesquisador.
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
     * Método que realiza a exibição um determinado pesquisador.
     * 
     * @param email o email idetificador do pesquisador.
     * @return a representação do pesquisador.
     */
    public String exibePesquisador(String email) {
        if (mapaPesquisador.containsKey(email)) {
            return this.mapaPesquisador.get(email).toString();
        }else{
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
    }
    
    /**
     * Método que realiza a checagem do estado de um determinado pesquisador.
     * 
     * @param email o email idetificador do pesquisador.
     * @return a estado do pesquisador no sistema.
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
     * @return pesquisador no sistema.
     */
    public List<Pesquisador> getPesquisadores() {
    	
    	List<Pesquisador> pesquisadores = new ArrayList<Pesquisador>();
    	
    	for(String key: this.mapaPesquisador.keySet())
    		pesquisadores.add(this.mapaPesquisador.get(key));
    	
    	return pesquisadores;    	
    }
}
