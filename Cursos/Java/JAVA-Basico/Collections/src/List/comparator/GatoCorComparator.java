package List.comparator;

import List.model.Gato;

import java.util.Comparator;

public class GatoCorComparator implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}
