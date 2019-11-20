package util;

import java.io.Serializable;
import java.util.HashMap;

import modulos.Pesquisa;

/**
 * Representação da classe exclusiva para tratamento de excessões.
 *
 */
public class Validador implements Serializable {

	/**
	 * Método responsável pelo tratamento da excessões do sistema.
	 * 
	 * @param dado o atributo a se validar.
	 * @param msg  a mensagem definida para exibição.
	 */
	public void valida(String dado, String msg) {
		this.validaNulo(dado, msg);
		this.validaVazio(dado, msg);
	}


	/**
	 * US1
	 */

	/**
	 * Método responsável pelo validação da quantidade de caracteres dos campos de interesse da pesquisa.
	 * 
	 * @param entrada O campo de interesse da Pesquisa.
	 * @param msg     A mensagem definida para exibição.
	 */
	public void validaTamanhoEntrada(String entrada, String msg) {
		if (entrada.length() > 255 || entrada.length() < 3)
			throw new IllegalArgumentException(msg);
	}

	/**
	 * Método responsável pelo alteracao dos campos de interesse da pesquisa.
	 * 
	 * @param entrada O campo de interesse apara alteração da Pesquisa.
	 * @param msg     A mensagem definida para exibição.
	 */
	public void validaAtributo(String entrada, String msg) {
		if (!entrada.equals("CAMPO") && !entrada.equals("DESCRICAO"))
			throw new IllegalArgumentException("Nao e possivel alterar esse valor de pesquisa.");
	}

	/**
	 * US2
	 */

	/**
	 * Método responsável pelo tratamento de entradas vazias.
	 *
	 * @param dado O atributo a se validar.
	 * @param msg  A mensagem definida para exibição.
	 */

	private void validaVazio(String dado, String msg) {
		if (dado.trim().equals("")) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Método responsável pelo tratamento de entradas nulas.
	 *
	 * @param dado O atributo a se validar.
	 * @param msg  A mensagem definida para exibição.
	 */
	private void validaNulo(String dado, String msg) {
		if (dado == null) {
			throw new NullPointerException(msg);
		}
	}

	/**
	 * Método responsável pelo validação do email do pesquisador.
	 * 
	 * @param email O email do pesquisador.
	 * @param msg   A mensagem definida para exibição.
	 */
	public void validaEmail(String email, String msg) {
		String[] texto = email.split("@");
		if (texto.length != 2) {
			throw new IllegalArgumentException(msg);
		}

		char[] texto1 = texto[0].trim().toCharArray();
		char[] texto2 = texto[1].trim().toCharArray();

		if (texto1.length == 0 || texto2.length == 0) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Método responsável pelo validação da foto do pesquisador.
	 * 
	 * @param foto A foto do pesquisador.
	 * @param msg  A mensagem definida para exibição.
	 */
	public void validaFotoURL(String fotoURL, String msg) {
		String[] texto = fotoURL.split("://");
		if (texto.length == 1) {
			throw new IllegalArgumentException(msg);
		}
		if (!texto[0].contains("https") || !texto[0].contains("http")) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * US3
	 */

	/**
	 * Método responsável pelo validação do tipo do objetivo.
	 * 
	 * @param tipo O tipo do objetivo.
	 * @param msg A mensagem definida para exibição.
	 */
	public void validaTipo(String tipo, String msg) {
		if (!tipo.equals("GERAL") && !tipo.equals("ESPECIFICO")) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Método responsável pelo validação dos valores inteiros.
	 * 
	 * @param inteiro O número inteiro.
	 * @param msg    A mensagem definida para exibição.
	 */
	public void validaInteiros(int inteiro, String msg) {
		if (inteiro < 1 || inteiro > 5) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public void validaItem(int item,String msg) {
		if(item < 0) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Método responsável pelo validação do objetivo.
	 * 
	 * @param tipo        O tipo do objetivo.
	 * @param descricao   A descricao do objetivo.
	 * @param aderencia   A aderência ao problema.
	 * @param viabilidade A viabilidade de o objetivo.
	 */
	public void validaObjetivo(String tipo, String descricao, int aderencia, int viabilidade) {
		if (tipo == null) {
			throw new NullPointerException();
		}
		if (descricao == null) {
			throw new NullPointerException();
		}
		if (tipo.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (descricao.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (aderencia < 1 || aderencia > 5) {
			throw new IllegalArgumentException();
		}
		if (viabilidade < 1 || viabilidade > 5) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Método responsável pelo validação do problema.
	 * 
	 * @param descricao   A descrição do problema.
	 * @param viabilidade A viabilidade do problema ser resolvido.
	 */
	public void validaProblema(String descricao, int viabilidade) {
		if (descricao == null) {
			throw new NullPointerException();
		}
		if (descricao.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		if (viabilidade < 1 || viabilidade > 5) {
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * US4
	 */
	
	/**
	 * Método responsável pela validação do nivel de risco.
	 * 
	 * @param nivelRisco O nível de risco.
	 * @param msg A mensagem definida para exibição.
	 */
	public void validaNivelRisco(String nivelRisco, String msg) {
		if ((!nivelRisco.equals("BAIXO")) && (!nivelRisco.equals("MEDIO")) && (!nivelRisco.equals("ALTO"))) {
			throw new IllegalArgumentException(msg);
		}
	}
	

	/**
	 * US6
	 */
	
	/**
	 * Método responsável pela validação da data.
	 * 
	 * @param data A data de contratração do professor.
	 */
	public void validaData(String data) {
		if ((data.length() != 10) || (Integer.parseInt(data.substring(0, data.length() - 8)) > 31) || 
		(Integer.parseInt(data.substring(3, data.length() - 5)) > 12)) {
			throw new IllegalArgumentException("Atributo data com formato invalido.");
		}
	}
	
	/**
	 * Método responsável pela validação da pesquisa.
	 * 
	 * @param pesquisa A pesquisa a ser adicionada.
	 * @param idPesquisa O identificador da pequisa.
	 * @param pesquisas O mapa das pesquisas.
	 */
	public void validaPesquisa(Pesquisa pesquisa, String idPesquisa, HashMap<String, Pesquisa> pesquisas) {
		if (!pesquisa.getAtiva()) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
	}
	
	/**
	 * Método reponsável pela validação da especialidade do professor.
	 * 
	 * @param funcao A função do professor.
	 */
	public void validaEspecialidadeProfessor(String funcao) {
		if ("estudante".equals(funcao) || "externo".equals(funcao)) {
			throw new IllegalArgumentException("Pesquisador nao compativel com a especialidade.");
		}
	}
	
	/**
	 * Método responsável pela validação da especialidade do aluno.
	 * 
	 * @param funcao A função do aluno.
	 */
	public void validaEspecialidadeAluno(String funcao) {
		if ("professor".equals(funcao) || "externo".equals(funcao)) {
			throw new IllegalArgumentException("Pesquisador nao compativel com a especialidade.");
		}
	}
	
	/**
	 * Método responsável pela verificação se a pesquisa está ativada.
	 * 
	 * @param pesquisa A pesquisa para verificação.
	 */
	public void validaPesquisaAtivada(Pesquisa pesquisa) {
		if (!pesquisa.getAtiva()) {
			throw new IllegalArgumentException("Pesquisa desativada.");
		}
	}

	
	/**US8*/
	/**
	 * Método responsável pela verificação se o numero é positivo.
	 * 
	 * @param num O número a ser verificado.
	 * @param msg A mensagem definida para exibição.
	 */
	public void validaPositivo(int num, String msg) {
		if(num < 0)
			throw new IllegalArgumentException(msg);
	}
	
	/**
	 * Método responsável pela verificação do semestre.
	 * 
	 * @param semestre O número do semestre.
	 */
	public void validaSemestre(int semestre) {
		if (semestre < 1) {
			throw new IllegalArgumentException("Atributo semestre com formato invalido.");
		}
	}
	
	/**
	 * Método responsável pela validação do iea.
	 * 
	 * @param iea O iea do aluno;
	 */
	public void validaIEA(double iea) {
		if ((iea < 0) || (iea > 10)) {
			throw new IllegalArgumentException("Atributo IEA com formato invalido.");
		}
	}
	
	/**
	 * Método responsável pela validação da função.
	 * 
	 * @param funcao A função a ser validada.
	 */
	public void validaFuncao(String funcao) {
		if (!"externo".equals(funcao.toLowerCase()) && !"aluna".equals(funcao.toLowerCase()) && !"professora".equals(funcao.toLowerCase())) {
			throw new IllegalArgumentException("Tipo " + funcao + " inexistente.");
		}
	}
}
