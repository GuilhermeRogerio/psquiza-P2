package modulos;

public class Aluno implements InterfacePesquisador {
	
	private String semestre;
	private String iea;
	
	public Aluno(String semestre, String iea) {
		this.semestre = semestre;
		this.iea = iea;
	}
	
	@Override
	public String toString() {
		return this.semestre + " - " + this.iea;
	}
	
	public void alteraEspecialidade(String atributo, String novoValor) {
		if ("SEMESTRE".equals(atributo)) {
			this.semestre = novoValor;
		} else {
			this.iea = novoValor;
		}
	}

}
