package psquiza;

import easyaccept.EasyAccept;
import us3.ControllerUs3;

public class ControllerGeral {
	
	private ControllerUs3 controllerUs3;
	
	public ControllerGeral() {
		controllerUs3 = new ControllerUs3();
	}
	
	public void cadastraProblema(String descricao,int viabilidade) {
		this.controllerUs3.cadastraProblema(descricao, viabilidade);
	}
	
	public void cadastraObjetivo(String tipo, String descricao,int aderenciaProblema,int viabilidade) {
		this.controllerUs3.cadastraObjetivo(tipo, descricao, aderenciaProblema, viabilidade);
	}
	
	public void apagarProblema(String codigo) {
		this.controllerUs3.apagarProblema(codigo);
	}
	
	public void apagarObjetivo(String codigo) {
		this.controllerUs3.apagarObjetivo(codigo);
	}
	
	public String exibeProblema(String codigo) {
		return this.controllerUs3.exibeProblema(codigo);
	}
	
	public String exibeObjetivo(String codigo) {
		return this.controllerUs3.exibeObjetivo(codigo);
	}

}
