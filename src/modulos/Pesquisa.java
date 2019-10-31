
public class Pesquisa {
	
	private String descr;
	private String camposInteresse[];
	private String codigo;
	private boolean ativa;
	
	Pesquisa(String desc, String campoInteresse){
		
		if(desc==null || desc.trim().isEmpty())
			throw new Error("Descricao nao pode ser nula ou vazia.");
		
		if(campoInteresse==null || campoInteresse.trim().isEmpty())
			throw new Error("Formato do campo de interesse invalido.");
		
		if(campoInteresse.length()>255)
			throw new Error("Formato do campo de interesse invalido.");
		
		this.camposInteresse = new String[4];
		this.camposInteresse[campoInteresse.length()] = campoInteresse;
		ativa = true;
		this.gerarCodigo();
		
	}
	
	void gerarCodigo() {
		this.codigo = camposInteresse[0].substring(0,3) + this.camposInteresse.length;
	}
	
	
	
}
