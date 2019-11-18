package busca;

import java.util.Optional;

import comparadores.ComparadorResultadoBusca;

public class ResultadoBusca {
	
	private String codigo;
	private String descricao;
	
	private Optional<String> camposInteresses;
	
	public ResultadoBusca(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
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
		return String.format("%s: %s", this.codigo, this.descricao);
	}

}


