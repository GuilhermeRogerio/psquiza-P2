package modulos;

public class Professor implements InterfacePesquisador {
	
	private String formacao;
	private String unidade;
	private String data;
	
	public Professor(String formacao, String unidade, String data) {
		this.formacao = formacao;
		this.unidade = unidade;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.formacao + " - " + this.unidade + " - " + this.data;
	}
	
	public void alteraEspecialidade(String atributo, String novoValor) {
		if ("FORMACAO".equals(atributo)) {
			this.formacao = novoValor;
		} else if ("UNIDADE".equals(atributo)) {
			this.unidade = novoValor;
		} else {
			this.data = novoValor;		}
 		}
	

}
