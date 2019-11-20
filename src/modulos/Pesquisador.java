package modulos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import util.Validador;

/**
 * Classe destinada a alocação as informação do pesquisador.
 *
 */
public class Pesquisador implements Serializable {
	
    /**
     * Atributo que representa o nome do pesquisador.
     *
     */
	private String nome;

    /**
     * Atributo que representa a função do pesquisador.
     *
     */
	private String funcao;
	
    /**
     * Atributo que representa a biografia do pesquisador.
     *
     */
	private String biografia;
	
    /**
     * Atributo que representa o email do pesquisador.
     *
     */
	private String email;
	
    /**
     * Atributo que representa a foto do pesquisador.
     *
     */
	private String foto;
	
    /**
     * Atributo booleano que representa o estado do pesquisador no sistema.
     *
     */
	private boolean ativo;
	
	/**
	 * Interface que representa a especialização do Pesquisandor (Aluno ou Professor).
	 * 
	 */
	private InterfacePesquisador especialidade;
	
	/**
	 * Conjunto que armazena as pesquisas aos quais o pesquisador está asssociado.
	 * 
	 */
	private HashMap<String, Pesquisa> pesquisas;
	
	/**
     * Verificador das entradas de tratamento.
     * 
     */
	private Validador validador;
    
	/**
	 * Construtor do pesquisador.
	 * Cada pesquisador terá nome, funcao, biografia, email e uma foto.
	 * 
	 * @param nome O nome do pesquisador.
	 * @param funcao A função do pesquisador.
	 * @param biografia A biografia do pesquisador.
	 * @param email O email o pesquisador
	 * @param foto A foto do pesquisador.
	 */
	public Pesquisador(String nome, String funcao, String biografia, String email, String foto) {
		this.nome = nome;
		this.funcao = funcao;
		this.biografia = biografia;
		this.email = email;
		this.foto = foto;
		this.ativo = true;
		this.pesquisas = new HashMap<>();
		this.especialidade = null;
		this.validador = new Validador();
	}
	
	/**
	 * Método que cadastra especialidade ALUNO.
	 * 
	 * @param semestre O semestre de formação.
	 * @param iea O indice de eficiencia academica.
	 */
	public void cadastraEspecialidadeAluno(int semestre, double iea) {
		this.validador.validaEspecialidadeAluno(this.funcao);
		InterfacePesquisador aluno = new Aluno(semestre, iea);
		this.especialidade = aluno;
	}
	
	/**
	 * Método que cadastra especialidade PROFESSOR.
	 * 
	 * @param formacao A área de formação.
	 * @param unidade A unidade de alocação.
	 * @param data A data de contratação.
	 */
	public void cadastraEspecialidadeProfessor(String formacao, String unidade, String data) {
		this.validador.validaEspecialidadeProfessor(this.funcao);
		InterfacePesquisador professor = new Professor(formacao, unidade, data);
		this.especialidade = professor;
	}
	
	/**
	 * Método que altera algum dado cadastral da especialidade do pesquisador.
	 * 
	 * @param atributo O atributo a ser alterado.
	 * @param novoValor O novo valor para substituição.
	 */
	public void alteraEspecialidade(String atributo, String novoValor) {
		this.especialidade.alteraEspecialidade(atributo, novoValor);
	}
	
	/**
	 * Método que associa o Pesquisador à determinada pesquisa.
	 * 
	 * @param idPesquisa O identificador da pesquisa.
	 * @param pesquisa A pesquisa a ser associada.
	 * @return "True" para bem sucedido ou "False" para mal sucedido.
	 */
	public boolean associaPesquisa(String idPesquisa, Pesquisa pesquisa) {
		this.validador.validaPesquisa(pesquisa, idPesquisa, this.pesquisas);
		if (!this.pesquisas.containsKey(idPesquisa)) {
			this.pesquisas.put(idPesquisa, pesquisa);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Méotod que desassocia o pesquisador a determinada pesquisa;
	 * 
	 * @param idPesquisa O identificador da pesquisa.
	 * @param pesquisa A pesquisa a ser associada.
	 * @return "True" para bem sucedido ou "False" para mal sucedido.
	 */
	public boolean desassociaPesquisa(String idPesquisa, Pesquisa pesquisa) {
		this.validador.validaPesquisa(pesquisa, idPesquisa, this.pesquisas);
		if (this.pesquisas.containsKey(idPesquisa)) {
			this.pesquisas.remove(idPesquisa, pesquisa);
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Método que constrói a representação textual do aluno.
	 * 
     * @return A representação textual representando o pesquisador.
     */
	@Override
	public String toString() {
		String retorno = nome + " (" + funcao + ")" + " - " + biografia + " - " + email + " - " + foto;
		if (this.especialidade != null) {
			retorno += " - " + this.especialidade.toString();
		}
		return retorno;
	}
	
	/**
	 * Método que constrói a representação textual usada para exibir o resultado de busca.
	 * 
	 * @return A representação textual representando a busca.
	 */
	public String toStringBusca() {

		return String.format("%s: %s | ",this.email, this.biografia);
	}

	/**
	 * Método que realiza a alteração do valor do atributo nome.
     *
	 * @param nome O novo nome do pesquisador.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que realiza a alteração do valor do atributo função.
     *
	 * @param funcao A nova função do pesquisador.
	 */
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	/**
	 * Método que realiza a alteração do valor do atributo biografia.
     *
	 * @param biografia A nova biografia do pesquisador.
	 */
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	/**
	 * Método que realiza a alteração do valor do atributo telefone.
     *
	 * @param email O novo email do pesquisador.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Método que realiza a alteração do valor do atributo foto.
     *
	 * @param foto A nova foto do pesquisador.
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	/**
     * Método que retorna o valor do atributo biografia.
     *
     * @return A biografia do pesquisador.
     */
	
    /**
     * Método que retorna o valor do atributo ativo.
     *
     * @return Se o pesquisador está ativo.
     */
	public boolean getAtivo() {
		return this.ativo;
	}
	
	/**
	 * Méotodo que retorna a funcao do pesquisador
	 * 
	 */
	public String getFuncao() {
		return this.funcao;
	}
	
	 /**
     * Método que retorna todas as pesquisas cadastrados.
     * 
     * @return A lista de pesquisas.
     */
    public List<Pesquisa> getPesquisas() {
    	List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
    	for(String key: this.pesquisas.keySet()) {
    		pesquisas.add(this.pesquisas.get(key));
    	}
    	return pesquisas;    	
    }

	
	/**
	 * Método que realiza a alteração do valor do atributo ativo.
     *
	 * @param novoEstado O  novo estado do pesquisador.
	 * @return O estado do pesquisador.
	 */
	public boolean setAtivo(boolean novoEstado) {
		this.ativo = novoEstado;
		return this.ativo;
	}
	
    /**
     * Método que realiza a comparação de dois objetos e retorna se são iguais ou não.
     *
     * @return O valor boleano da comparação.
     */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pesquisador that = (Pesquisador) o;
		return email.equals(that.email);
	}
	
    /**
     * Método que retorna um valor que indica a posição do objeto na memória.
     *
     * @return O valor da posição do email.
     */
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	/**
	 * Método que retorna a biografia do pesquisador.
	 * 
	 * @return A biografia do pesquisador.
	 */
	public String getBiografia() {
		return biografia;
	}

	/**
	 * Método que retorna o email do pesquisador.
	 * 
	 * @return O email do pesquisador.
	 */
	public String getEmail() {
		return email;
	}

}
