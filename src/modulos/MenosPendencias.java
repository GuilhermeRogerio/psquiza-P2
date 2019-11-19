package modulos;

import java.util.List;

import controladores.ControllerPesquisa;

public class  MenosPendencias implements Estrategia{

	@Override
	public String proximaAtividade(Pesquisa pesquisa) {
		return pesquisa.menosPendencias();
	}
}
