package modulos;

import java.io.Serializable;

public interface InterfacePesquisador extends Serializable{
	
	public String toString();
	public void alteraEspecialidade(String atributo, String novoValor);

}
