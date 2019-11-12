package modulos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import util.Validador;

/**
 * Representação de Pesquisa no Sistema
 */
public class Pesquisa {

	private String descricao;
	private String camposInteresse[];
	private String codigo;
	private boolean ativa;
	private Map<String,Atividade> atividades;

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
		this.atividades = new HashMap<>();

	}

	public boolean addAtividade(String codigoAtividade,Atividade atividade) {
		if(!atividades.containsKey(codigoAtividade)) {
			this.atividades.put(codigoAtividade, atividade);
			this.atividades.get(codigoAtividade).setEhAssociada();
			return true;
		}else {
			return false;
		}
	}
	
	/*public boolean ehAssociada(Atividade atividade) {
		if(this.atividades.contains(atividade)) {
			return true;
		}else {
			return false;
		}
	}*/

	public boolean removeAtividade(String codigoAtividade) {
		if(atividades.get(codigoAtividade) != null) {
			this.atividades.get(codigoAtividade).setNaoAssociada();
			this.atividades.remove(codigoAtividade);
			return true;
		}else {
			return false;
		}
		
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
	
	public void setAssociada(String codigoAtividade) {
		this.atividades.get(codigoAtividade).setEhAssociada();
	}
	
	public void setNaoAssociada(String codigoAtividade) {
		this.atividades.get(codigoAtividade).setNaoAssociada();
	}

	public void setCodigo(String codigoPesquisa) {
		this.codigo = codigoPesquisa;
	}

}
