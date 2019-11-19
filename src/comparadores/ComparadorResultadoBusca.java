package comparadores;

import java.util.Comparator;
import busca.ResultadoBusca;

public class ComparadorResultadoBusca implements Comparator<ResultadoBusca>{

	@Override
    public int compare(ResultadoBusca p1, ResultadoBusca p2) {
        return p2.getCodigo().compareTo(p1.getCodigo());
    }
	
}
