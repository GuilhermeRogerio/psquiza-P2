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
	 * @param msg a mensagem definida pra exibição.
	 */
	public void valida(String dado, String msg) {
		this.validaNulo(dado, msg);
		this.validaVazio(dado, msg);
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
	 * @param msg  a mensagem definida pra exibição.
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
        if (texto.length == 1){
            throw new IllegalArgumentException(msg);
        }
        if (!texto[0].contains("https") || !texto[0].contains("http")){
            throw new IllegalArgumentException(msg);
        }
	}

	/**
	 * US3
	 */
	public void validaTipo(String tipo, String msg) {
		if (!tipo.equals("GERAL") && !tipo.equals("ESPECIFICO")) {
			throw new IllegalArgumentException(msg);
		}
	}

	public void validaInteiros(int inteiro, String msg) {
		if (inteiro < 1 || inteiro > 5) {
			throw new IllegalArgumentException(msg);
		}
	}

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

}
