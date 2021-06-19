package Stream.comparator;

import Stream.model.Contato;

import java.util.Comparator;
import java.util.Map;

public class ContatoComparatorTelefone implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
    }
}
