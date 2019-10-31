package modulos;

import java.util.HashMap;

import util.Validador;

/**
 * Representação de Pesquisa no Sistema
 */
public class Pesquisa {

	private String descricao;
	private String camposInteresse[];
	private String codigo;
	private boolean ativa;

	/**
	 * 
	 * @param descricao
	 * @param camposInteresse
	 */
	public Pesquisa(String descricao, String camposInteresse) {

		this.camposInteresse = new String[4];
		this.gerarCamposInteresse(camposInteresse);
		this.descricao = descricao;
		this.ativa = true;

	}

	/**
	 * 
	 * @param pesquisas
	 */
	public void geraCodigo(final HashMap<String, Pesquisa> pesquisas) {

		int count = 1;
		this.codigo = camposInteresse[0].substring(0, 3).toUpperCase();

		for (String key : pesquisas.keySet()) {

			String precode = pesquisas.get(key).getCodigo().substring(0, 3);
			if (precode.equals(this.codigo))
				count++;
		}

		this.codigo += String.valueOf(count);
	}

	/**
	 * 
	 * @param camposString
	 */
	private void gerarCamposInteresse(String camposString) {

		String[] interesses = camposString.split(",");

		if (interesses.length <= this.camposInteresse.length) {

			for (int i = 0; i < interesses.length; i++) {

				final String interesse = interesses[i];

				new Validador().valida(interesse, "Formato do campo de interesse invalido.");
				this.camposInteresse[i] = interesses[i].trim();
			}
		} else {
			throw new IllegalArgumentException("Formato do campo de interesse invalido.");
		}

	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param camposInteresse the camposInteresse to set
	 */
	public void setCamposInteresse(String camposInteresse) {
		this.gerarCamposInteresse(camposInteresse);
	}

	/**
	 * @param ativa the ativa to set
	 */
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	@Override
	public String toString() {
		StringBuilder sbCamposInteresse = new StringBuilder();

		for (String string : camposInteresse) {
			if (string != null)
				sbCamposInteresse.append(string + ", ");
		}

		String camposInteresseString = sbCamposInteresse.toString();
		camposInteresseString = camposInteresseString.substring(0, camposInteresseString.length() - 2);

		return String.format("%s - %s - %s", this.codigo, this.descricao, camposInteresseString);
	}

	/***
	 * 
	 * @param novoConteudo
	 */
	public void setDescricao(String novoConteudo) {
		this.descricao = novoConteudo;
	}

	/**
	 * 
	 * @return void
	 */
	public boolean getAtiva() {
		return this.ativa;
	}

}
