package modulos;

import java.util.Objects;

public class Pesquisador {

    private String nome;

    private String funcao;

    private String biografia;

    private String email;

    private String foto;

    private boolean ativo;

    public Pesquisador(String nome, String  funcao, String biografia, String email, String foto) {
        this.nome = nome;
        this.funcao = funcao;
        this.biografia = biografia;
        this.email = email;
        this.foto = foto;
        this.ativo = true;
    }

    @Override
    public String toString() {
        return nome + " (" + funcao + ")" +  " - " + biografia + " - " + email + " - " + foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean getAtivo(){
        return this.ativo;
    }

    public boolean setAtivo(boolean novoEstado){
        this.ativo = novoEstado;
        return this.ativo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pesquisador that = (Pesquisador) o;
        return email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

}
