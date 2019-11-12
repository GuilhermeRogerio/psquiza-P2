package modulos;

public class Aluno implements InterfacePesquisador {
	
	private int semestre;
	private double iea;
	
	public Aluno(int semestre, double iea) {
		this.semestre = semestre;
		this.iea = iea;
	}
	
	@Override
	public String toString() {
		return this.semestre + " - " + this.iea;
	}
	
	public void alteraEspecialidade(String atributo, String novoValor) {
		if ("SEMESTRE".equals(atributo)) {
			this.semestre = Integer.parseInt(novoValor);
		} else {
			this.iea = Double.parseDouble(novoValor);
		}
	}

}
