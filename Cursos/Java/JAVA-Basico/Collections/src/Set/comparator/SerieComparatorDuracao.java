package Set.comparator;

import Set.model.Serie;

import java.util.Comparator;

public class SerieComparatorDuracao implements Comparator<Serie> {
    @Override
    public int compare(Serie s1, Serie s2) {
        int duracao = Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
        if(duracao != 0)
            return duracao;
        return s1.getNome().compareTo(s2.getNome());
    }
}
