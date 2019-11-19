package comparadores;

import java.util.Comparator;

import modulos.Atividade;
import modulos.Pesquisa;

public class ComparadorAtividade implements Comparator<Atividade> {

	@Override
	public int compare(Atividade o1, Atividade o2) {
		return o1.getCodigo().compareTo(o2.getCodigo());
	}

}
