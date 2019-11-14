package comparadores;

import modulos.Pesquisa;

import java.util.Comparator;

public class ComparadorObjetivo implements Comparator<Pesquisa> {

    @Override
    public int compare(Pesquisa p1, Pesquisa p2) {
        if (p2.getQuantiadeDeObjetivos() > p1.getQuantiadeDeObjetivos()) {
            return 1;
        } else if (p2.getQuantiadeDeObjetivos() < p1.getQuantiadeDeObjetivos()) {
            return -1;
        } else {
            if (p1.getQuantiadeDeObjetivos() == 0 && p2.getQuantiadeDeObjetivos() == 0) {
                return p2.getCodigo().compareTo(p1.getCodigo());
            }else{
                return p2.maiorId().compareTo(p1.maiorId());
            }
        }
    }
}
