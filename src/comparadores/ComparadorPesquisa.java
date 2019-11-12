package comparadores;

import modulos.Pesquisa;

import java.util.Comparator;

public class ComparadorPesquisa implements Comparator<Pesquisa> {
    @Override
    public int compare(Pesquisa pesquisa, Pesquisa t1) {
        return pesquisa.getCodigo().compareTo(t1.getCodigo());
    }
}
