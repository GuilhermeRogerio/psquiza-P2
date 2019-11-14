package comparadores;

import modulos.Pesquisa;

import java.util.Comparator;

public class ComparadorPesquisa implements Comparator<Pesquisa> {
    @Override
    public int compare(Pesquisa p1, Pesquisa p2) {
        return p2.getCodigo().compareTo(p1.getCodigo());
    }
}
