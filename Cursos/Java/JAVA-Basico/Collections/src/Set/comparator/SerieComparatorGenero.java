package Set.comparator;

import Set.model.Serie;

import java.util.Comparator;

public class SerieComparatorGenero implements Comparator<Serie> {
    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getGenero().compareTo(s2.getGenero());
    }
}
