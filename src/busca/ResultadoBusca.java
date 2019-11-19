package busca;

import java.util.Optional;

import javax.net.ssl.SSLContext;

import comparadores.ComparadorResultadoBusca;

public class ResultadoBusca {
	
	private String codigo;
	private String descricao = null;	
	private String[] camposInteresses=null;
	
	public ResultadoBusca(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public ResultadoBusca(String codigo, String[] camposInteresse) {
		this.camposInteresses = camposInteresse;
		this.codigo = codigo;
	}

	public boolean match(String termo){
		termo = termo.toLowerCase();
		return this.descricao.toLowerCase().contains(termo);
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public static ComparadorResultadoBusca getComparador() {
		return new ComparadorResultadoBusca();
	}
	
	@Override
	public String toString() {
		
		if(descricao != null)
			return String.format("%s: %s", this.codigo, this.descricao);
		else {
			StringBuilder sbCamposInteresse = new StringBuilder();

			for (String string : camposInteresses)
				if (string != null)
					sbCamposInteresse.append(string + ", ");			

			String camposInteresseString = sbCamposInteresse.toString();
			camposInteresseString = camposInteresseString.substring(0, camposInteresseString.length() - 2);
			return String.format("%s: %s", this.codigo, camposInteresseString);
		}
	}
	
	
	public boolean matchInteresses(String termo) {
		
		if(camposInteresses == null)
			return false;	
		
		
		for (String string : camposInteresses) {
			
			if(string == null)
				continue;
			
			if(string.contains(termo)) {				
				return true;
			}
				
		}
		
		
		return false;
	}
	
	public void setCamposInteresses(String[] camposInteresses) {
		this.camposInteresses = camposInteresses;
	}

}