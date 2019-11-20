package comparadores;

import modulos.Pesquisa;
import modulos.Problema;

import java.util.Comparator;
import java.util.Optional;

public class ComparadorProblema implements Comparator<Pesquisa> {
    public int compare(Pesquisa p1, Pesquisa p2) {
        Problema pp1 = p1.getProblema();
        Problema pp2 = p2.getProblema();

        if (pp2 != null && pp1 == null) {
            return 1;
        }
        if (pp2 == null && pp1 != null) {
            return -1;
        }
        if (pp2 != null && pp1 != null) {
            return pp2.getCodigo().compareTo(pp1.getCodigo());
        } else {
            return p2.getCodigo().compareTo(p1.getCodigo());
        }
    }
}
