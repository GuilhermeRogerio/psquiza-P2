package controladores;

import java.util.HashMap;

import modulos.Pesquisa;
import util.Validador;

class ControllerPesquisa {

    /**
     * Verificador das entradas para o tratamento.
     *
     */
    private Validador validador;

    /**
     * Mapa onde os pesquisas serão armazenados para as operações do sistema.
     * 
     */
    private HashMap<String, Pesquisa> pesquisas;

    ControllerPesquisa() {
        this.validador = new Validador();
        this.pesquisas = new HashMap<String, Pesquisa>();
    }

    String cadastraPesquisa(String descricao, String campoDeInteresse) {

        this.validador.valida(descricao, "Descricao nao pode ser nula ou vazia.");
        this.validador.validaTamanhoEntrada(campoDeInteresse, "Formato do campo de interesse invalido.");

        Pesquisa pesquisa = new Pesquisa(descricao, campoDeInteresse);
        pesquisa.geraCodigo(pesquisas);
        
        String codigoPesquisa = pesquisa.getCodigo();        
        this.pesquisas.put(codigoPesquisa, pesquisa);
        return codigoPesquisa;
    }

    void alteraPesquisa(String codigo, String conteudoASerAlterado, String novoConteudo) {

        this.validador.validaAtributo(conteudoASerAlterado, "Nao e possivel alterar esse valor de pesquisa.");
        

        if (!pesquisas.containsKey(codigo))
            throw new IllegalArgumentException("Pesquisa nao encontrada.");

        Pesquisa pesquisa = this.pesquisas.get(codigo);
        
        if(!pesquisa.getAtiva())
            throw new Error("Pesquisa desativada.");

        if (conteudoASerAlterado.equals("CAMPO")) {
            this.validador.valida(novoConteudo, "Formato do campo de interesse invalido.");
        	 pesquisa.setCamposInteresse(novoConteudo);
        }          
        else {
            this.validador.valida(novoConteudo, "Descricao nao pode ser nula ou vazia.");
            pesquisa.setDescricao(novoConteudo);
        }
    }

    void encerraPesquisa(String codigo, String motivo) {

        this.validador.valida(motivo, "Motivo nao pode ser nulo ou vazio.");

        if (!pesquisas.containsKey(codigo))
            throw new Error("Pesquisa nao encontrada.");

        Pesquisa pesquisa = this.pesquisas.get(codigo);

        if (!pesquisa.getAtiva())
            throw new Error("Pesquisa desativada.");

        pesquisa.setAtiva(false);
    }

    void ativaPesquisa(String codigo) {

        if (!pesquisas.containsKey(codigo))
            throw new IllegalArgumentException("Pesquisa nao encontrada.");

        Pesquisa pesquisa = this.pesquisas.get(codigo);

        if (pesquisa.getAtiva())
            throw new Error("Pesquisa ja ativada.");

        pesquisa.setAtiva(true);
    }

    String exibePesquisa(String codigo) {
    	
    	this.validador.valida(codigo, "Codigo nao pode ser nulo ou vazio.");

        if (!pesquisas.containsKey(codigo))
            throw new IllegalArgumentException("Pesquisa nao encontrada.");

        Pesquisa pesquisa = this.pesquisas.get(codigo);
        return pesquisa.toString();
    }

    boolean pesquisaEhAtiva(String codigo) {
    	
    	this.validador.valida(codigo, "Codigo nao pode ser nulo ou vazio.");

        if (!pesquisas.containsKey(codigo))
            throw new IllegalArgumentException("Pesquisa nao encontrada.");

        Pesquisa pesquisa = this.pesquisas.get(codigo);
        return pesquisa.getAtiva();
    }

}
