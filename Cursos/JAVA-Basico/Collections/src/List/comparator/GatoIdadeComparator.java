package List.comparator;

import List.model.Gato;

import java.util.Comparator;

public class GatoIdadeComparator implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}
