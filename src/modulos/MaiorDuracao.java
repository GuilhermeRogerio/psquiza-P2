package modulos;

import java.util.List;

import controladores.ControllerPesquisa;

public class MaiorDuracao implements Estrategia {
	
	@Override
	public String proximaAtividade(Pesquisa pesquisa) {
		return pesquisa.maiorDuracao();
	}
	
	

}
