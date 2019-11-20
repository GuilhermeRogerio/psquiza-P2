package modulos;

import java.io.Serializable;

public interface Estrategia extends Serializable {
	
	public String proximaAtividade(Pesquisa pesquisa);

}
