package psquiza;

import easyaccept.EasyAccept;

public class Facade {
	
	private ControllerGeral controllerGeral;

	public static void main(String[] args) {
		args = new String[] { "us3.Facade", "testes_aceitacao/use_case_3.txt"};
		EasyAccept.main(args);
	}
	
	public Facade() {
		controllerGeral = new ControllerGeral();
	}
	
	public void cadastraProblema(String descricao,int viabilidade) {
		this.controllerGeral.cadastraProblema(descricao, viabilidade);
	}
	
	public void cadastraObjetivo(String tipo, String descricao,int aderenciaProblema,int viabilidade) {
		this.controllerGeral.cadastraObjetivo(tipo, descricao, aderenciaProblema, viabilidade);
	}
	
	public void apagarProblema(String codigo) {
		this.controllerGeral.apagarProblema(codigo);
	}
	
	public void apagarObjetivo(String codigo) {
		this.controllerGeral.apagarObjetivo(codigo);
	}
	
	public String exibeProblema(String codigo) {
		return this.controllerGeral.exibeProblema(codigo);
	}
	
	public String exibeObjetivo(String codigo) {
		return this.controllerGeral.exibeObjetivo(codigo);
	}
	
	

}
