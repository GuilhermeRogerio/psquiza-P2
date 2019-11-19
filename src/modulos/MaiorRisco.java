package modulos;

public class MaiorRisco implements Estrategia {

	@Override
	public String proximaAtividade(Pesquisa pesquisa) {
		return pesquisa.maiorRisco();
	}

}
