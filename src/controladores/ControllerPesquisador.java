package controladores;

import java.util.HashMap;

import modulos.Pesquisador;
import util.Validador;

public class ControllerPesquisador {

    private Validador validador;

    private HashMap<String, Pesquisador> mapaPesquisador;

    public ControllerPesquisador(){
        this.mapaPesquisador = new HashMap<>();
        this.validador = new Validador();
    }

    public void cadastraPesquisador(String nome, String funcao, String biografia, String email, String foto){
        this.validador.valida(nome, "Campo nome nao pode ser nulo ou vazio.");
        this.validador.valida(funcao,"Campo funcao nao pode ser nulo ou vazio.");
        this.validador.valida(biografia, "Campo biografia nao pode ser nulo ou vazio.");
        this.validador.valida(email, "Campo email nao pode ser nulo ou vazio.");
        this.validador.valida(foto, "Campo fotoURL nao pode ser nulo ou vazio.");
        this.validador.validaEmail(email, "Formato de email invalido.");
        Pesquisador pesquisador = new Pesquisador(nome, funcao, biografia, email, foto);
        this.mapaPesquisador.put(email, pesquisador);
    }

    public void alteraPesquisador(String email, String atributo, String novoValor) {
        this.validador.valida(atributo, "Atributo nao pode ser vazio ou nulo.");
        if(this.mapaPesquisador.containsKey(email)) {
            if (atributo.equals("NOME")) {
            this.validador.valida(novoValor, "Campo nome nao pode ser nulo ou vazio.");
            this.mapaPesquisador.get(email).setNome(novoValor);
        } else if (atributo.equals("FUNCAO")) {
            this.validador.valida(novoValor, "Campo funcao nao pode ser nulo ou vazio.");
            this.mapaPesquisador.get(email).setFuncao(novoValor);
        } else if (atributo.equals("BIOGRAFIA")) {
            this.validador.valida(novoValor, "Campo biografia nao pode ser nulo ou vazio.");
            this.mapaPesquisador.get(email).setBiografia(novoValor);
        } else if (atributo.equals("FOTO")) {
            this.validador.valida(novoValor, "Campo fotoURL nao pode ser nulo ou vazio.");
            this.validador.validaFotoURL(novoValor, "Formato de foto invalido.");
            this.mapaPesquisador.get(email).setFoto(novoValor);
        } else if (atributo.equals("EMAIL")) {
            this.validador.valida(novoValor, "Campo email nao pode ser nulo ou vazio.");
            this.validador.validaEmail(novoValor, "Formato de email invalido.");
            this.mapaPesquisador.get(email).setEmail(novoValor);
            Pesquisador pesquisador = this.mapaPesquisador.get(email);
            this.mapaPesquisador.put(novoValor, pesquisador);
            this.mapaPesquisador.remove(email);
        } else {
            throw new IllegalArgumentException("Atributo invalido.");
            }
        }else{
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
    }

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

    public String exibePesquisador(String email) {
        if (mapaPesquisador.containsKey(email)) {
            return this.mapaPesquisador.get(email).toString();
        }else{
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
    }

    public boolean pesquisadorEhAtivo(String email) {
        this.validador.valida(email, "Email nao pode ser vazio ou nulo.");
        if (this.mapaPesquisador.containsKey(email)) {
            return this.mapaPesquisador.get(email).getAtivo();
        }else{
            throw new IllegalArgumentException("Pesquisador nao encontrado");
        }
    }
}
