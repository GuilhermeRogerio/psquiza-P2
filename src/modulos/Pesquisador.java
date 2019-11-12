package modulos;

import java.util.HashMap;
import java.util.Objects;

import util.Validador;

/**
 * Classe destinada a alocação as informação do pesquisador.
 *
 */
public class Pesquisador {
	
    /**
     * Texto que representa o nome do pesquisador.
     *
     */
	private String nome;

    /**
     * Texto que representa a função do pesquisador.
     *
     */
	private String funcao;
	
    /**
     * Texto que representa a biografia do pesquisador.
     *
     */
	private String biografia;
	
    /**
     * Texto que representa o email do pesquisador.
     *
     */
	private String email;
	
    /**
     * Texto que representa a foto do pesquisador.
     *
     */
	private String foto;
	
    /**
     * Valor booleano que representa o estado do pesquisador no sistema.
     *
     */
	private boolean ativo;
	
	/**
	 * Interface que representa a especialização do Pesquisandor (Aluno ou Professor).
	 */
	private InterfacePesquisador especialidade;
	
	/**
	 * Conjunto que armazena as pesquisas aos quais o pesquisador está asssociado.
	 */
	private HashMap<String, Pesquisa> pesquisas;
	
	/**
	 * Validador
	 */
	private Validador validador;
    
	/**
	 * Construtor do pesquisador.
	 * Cada pesquisador terá nome, funcao, biografia, email e uma foto.
	 * 
	 * @param nome o nome do pesquisador.
	 * @param funcao a função do pesquisador.
	 * @param biografia a biografia do pesquisador.
	 * @param email o email o pesquisador
	 * @param foto a foto do pesquisador.
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
	}
	
	/**
	 * Método que cadastra especialidade ALUNO
	 * 
	 * @param semestre - Semestre de formação
	 * @param iea - Indice de eficiencia academica.
	 */
	public void cadastraEspecialidadeAluno(int semestre, double iea) {
		this.validador.validaEspecialidadeAluno(this.funcao);
		InterfacePesquisador aluno = new Aluno(semestre, iea);
		this.especialidade = aluno;
	}
	
	/**
	 * Método que cadastra especialidade PROFESSOR
	 * 
	 * @param formacao - Area de formação
	 * @param unidade - Unidade de alocação
	 * @param data - Data de contratação
	 */
	public void cadastraEspecialidadeProfessor(String formacao, String unidade, String data) {
		this.validador.validaEspecialidadeProfessor(this.funcao);
		InterfacePesquisador professor = new Professor(formacao, unidade, data);
		this.especialidade = professor;
	}
	
	/**
	 * Altera algum dado cadastral da especialidade do pesquisador
	 * 
	 * @param atributo - Dado a ser alterado
	 * @param novoValor - Dado para substituição
	 */
	public void alteraEspecialidade(String atributo, String novoValor) {
		this.especialidade.alteraEspecialidade(atributo, novoValor);
	}
	
	/**
	 * Associa o Pesquisador à determinada pesquisa
	 * 
	 * @param idPesquisa - Identificação da pesquisa
	 * @param pesquisa - Pesquisa a ser associada
	 * @return - Boolean representando se a ação foi, ou não, bem sucedida.
	 */
	public boolean associaPesquisador(String idPesquisa, Pesquisa pesquisa) {
		this.validador.validaPesquisa(pesquisa, idPesquisa, this.pesquisas);
		if (!this.pesquisas.containsKey(idPesquisa)) {
			this.pesquisas.put(idPesquisa, pesquisa);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Desassocia o pesquisador a determinada pesquisa
	 * 
	 * @param idPesquisa - Identificação da pesquisa
	 * @param pesquisa - Pesquisa a ser associada
	 * @return - Boolean representando se a ação foi, ou não, bem sucedida.
	 */
	public boolean desassociaPesquisador(String idPesquisa, Pesquisa pesquisa) {
		this.validador.validaPesquisa(pesquisa, idPesquisa, this.pesquisas);
		if (this.pesquisas.containsKey(idPesquisa)) {
			this.pesquisas.remove(idPesquisa, pesquisa);
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
     * Representação textual do pesquisador.
     *
     * @return o texto representando o pesquisador.
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
	 * Realiza a alteração do valor do atributo nome.
     *
	 * @param nome o novo nome do pesquisador.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Realiza a alteração do valor do atributo função.
     *
	 * @param funcao a nova função do pesquisador.
	 */
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	/**
	 * Realiza a alteração do valor do atributo biografia.
     *
	 * @param biografia a nova biografia do pesquisador.
	 */
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	/**
	 * Realiza a alteração do valor do atributo telefone.
     *
	 * @param email o novo email do pesquisador.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Realiza a alteração do valor do atributo foto.
     *
	 * @param foto a nova foto do pesquisador.
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
    /**
     * Método que retorna o valor do atributo ativo.
     *
     * @return o valor do atributo.
     */
	public boolean getAtivo() {
		return this.ativo;
	}
	/**
	 * Realiza a alteração do valor do atributo ativo.
     *
	 * @param novoEstado o novo estado do pesquisador.
	 * @return o estado do pesquisador.
	 */
	public boolean setAtivo(boolean novoEstado) {
		this.ativo = novoEstado;
		return this.ativo;
	}
	
    /**
     * Realiza a comparação de dois objetos retorna se são iguais ou não.
     *
     * @return o valor boleano da comparação.
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
     * Retorna um valor que indica a posição do objeto na memória.
     *
     * @return o valor da posição do email.
     */
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

}
