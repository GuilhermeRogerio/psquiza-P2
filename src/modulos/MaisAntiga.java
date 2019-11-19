package modulos;

import controladores.ControllerPesquisa;

public class MaisAntiga implements Estrategia {

	
	@Override
	public String proximaAtividade(Pesquisa pesquisa) {
		return pesquisa.maisAntiga();
	}

	

}
