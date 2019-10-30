package util;

public class Validador {
	
	public void validaStringVazia(String string, String msg) {
		if(string.trim().equals(""))
			throw new IllegalArgumentException(msg);
	}
	
	public void validaStringNull(String string, String msg) {
		if(string == null)
			throw new NullPointerException(msg);
		
	}
	public void validaTipo(String tipo,String msg) {
		if(!tipo.equals("GERAL") && !tipo.equals("ESPECIFICO")) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public void validaInteiros(int inteiro,String msg) {
		if(inteiro < 1 || inteiro > 5) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	public void validaObjetivo(String tipo, String descricao,int aderencia,int viabilidade) {
		if(tipo == null) {
			throw new NullPointerException();
		}

		if(descricao == null) {
			throw new NullPointerException();
		}
		
		if(tipo.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		
		if(descricao.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		
		if(aderencia < 1 || aderencia > 5) {
			throw new IllegalArgumentException();
		}
		
		if(viabilidade < 1 || viabilidade > 5) {
			throw new IllegalArgumentException();
		}
	}
	
	public void validaProblema(String descricao,int viabilidade) {
		if(descricao == null) {
			throw new NullPointerException();
		}
		
		if(descricao.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		
		if(viabilidade < 1 || viabilidade > 5) {
			throw new IllegalArgumentException();
		}
	}

}
