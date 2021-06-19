package Stream.comparator;

import Stream.model.Contato;

import java.util.Comparator;
import java.util.Map;

public class ContatoComparatorNome implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return o1.getValue().getNome().compareTo(o2.getValue().getNome());
    }
}
