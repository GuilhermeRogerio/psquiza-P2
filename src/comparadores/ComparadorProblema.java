package comparadores;

import modulos.Pesquisa;
import modulos.Problema;

import java.util.Comparator;
import java.util.Optional;

public class ComparadorProblema implements Comparator<Pesquisa> {
    public int compare(Pesquisa p1, Pesquisa p2) {
        Optional<Problema> pp1 = p1.getProblema();
        Optional<Problema> pp2 = p2.getProblema();

        if (pp2.isPresent() && !pp1.isPresent()) {
            return 1;
        }
        if (!pp2.isPresent() && pp1.isPresent()) {
            return -1;
        }
        if (pp2.isPresent() && pp1.isPresent()) {
            return pp2.get().getCodigo().compareTo(pp1.get().getCodigo());
        } else {
            return p2.getCodigo().compareTo(p1.getCodigo());
        }
    }
}
