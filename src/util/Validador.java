package util;

/**
 * Representação da classe exclusiva para tratamento de excessões.
 *
 */
public class Validador {

	/**
	 * Método responsável pelo tratamento da excessões do sistema.
	 * 
	 * @param dado o atributo a se validar.
	 * @param msg  a mensagem definida pra exibição.
	 */
	public void valida(String dado, String msg) {
		this.validaNulo(dado, msg);
		this.validaVazio(dado, msg);
	}
	

	/**
	 * US1
	 */

	/**
	 * Método responsável pelo validação da quantidade de caracteres dos campos de
	 * interesse da pesquisa.
	 * 
	 * @param entrada do campo de interesse da Pesquisa.
	 * @param msg     a mensagem definida pra exibição.
	 */
	public void validaTamanhoEntrada(String entrada, String msg) {
		if (entrada.length() > 255 || entrada.length() < 3)
			throw new IllegalArgumentException(msg);
	}

	/**
	 * Método responsável pelo alteracao dos campos de interesse da pesquisa.
	 * 
	 * @param entrada do campo de interesse apara ateração da Pesquisa.
	 * @param msg     a mensagem definida pra exibição.
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
	 * @param dado o atributo a se validar.
	 * @param msg  a mensagem definida pra exibição.
	 */

	private void validaVazio(String dado, String msg) {
		if (dado.trim().equals("")) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Método responsável pelo tratamento de entradas nulas.
	 *
	 * @param dado o atributo a se validar.
	 * @param msg  a mensagem definida pra exibição.
	 */
	private void validaNulo(String dado, String msg) {
		if (dado == null) {
			throw new NullPointerException(msg);
		}
	}

	/**
	 * Método responsável pelo validação do email do pesquisador.
	 * 
	 * @param email o email do pesquisador.
	 * @param msg   a mensagem definida pra exibição.
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
	 * @param foto a foto do pesquisador.
	 * @param msg  a mensagem definida pra exibição.
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
	 * @param tipo Tipo do objetivo que pode ser GERAL ou ESPECIFICO.
	 * @param msg  mensagem desejada.
	 */
	public void validaTipo(String tipo, String msg) {
		if (!tipo.equals("GERAL") && !tipo.equals("ESPECIFICO")) {
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * Método responsável pelo validação dos valores inteiros.
	 * 
	 * @param inteiro Numero inteiro.
	 * @param msg     a mensagem desejada.
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
	 * @param tipo        Tipo do objetivo que pode ser GERAL ou ESPECIFICO.
	 * @param descricao   Descricao do objetivo.
	 * @param aderencia   Aderencia ao problema.
	 * @param viabilidade Viabilidade de o objetivo ser concretizado.
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
	 * @param descricao   Descrição do problema.
	 * @param viabilidade Viabilidade do problema ser resolvido.
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
	
	public void validaNivelRisco(String nivelRisco, String msg) {
		if ((!nivelRisco.equals("BAIXO")) && (!nivelRisco.equals("MEDIO")) && (!nivelRisco.equals("ALTO"))) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * US6
	 */
	
	public void validaData(String data) {
		if ((data.length() != 10) || (Integer.parseInt(data.substring(0, data.length() - 8)) > 31) || 
		(Integer.parseInt(data.substring(3, data.length() - 5)) > 12)) {
			throw new IllegalArgumentException("Atributo data com formato invalido.");
		}
	}
}
