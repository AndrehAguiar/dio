package Set;

import Set.comparator.SerieComparatorDuracao;
import Set.comparator.SerieComparatorGenero;
import Set.comparator.SerieComparatorNomeGeneroDuracao;
import Set.model.Serie;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("\n--- Ordem aleatória ---");
        Set<Serie> serieSet = new HashSet<Serie>() {{
            add(new Serie("got", "fatasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that 70's show", "comédia", 25));
        }};
        for (Serie serie : serieSet) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("\n--- Ordem de inserção ---");
        Set<Serie> serieLinkedSet = new LinkedHashSet<Serie>() {{
            add(new Serie("got", "fatasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that 70's show", "comédia", 25));
        }};
        for (Serie serie : serieLinkedSet) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("\n--- Ordem natural (TempoEpisodio) ---");
        Set<Serie> serieTreeSet = new TreeSet<>(serieLinkedSet);
        for (Serie serie : serieTreeSet) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("\n--- Ordem Nome/Gênero/TempoEpisodio---");
        Set<Serie> serieTreeSetSorted = new TreeSet<>(new SerieComparatorNomeGeneroDuracao());
        serieTreeSetSorted.addAll(serieSet);
        for (Serie serie : serieTreeSetSorted) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("\n--- Ordem Gênero ---");
        Set<Serie> serieTreeSetSortedGenero = new TreeSet<>(new SerieComparatorGenero());
        serieTreeSetSortedGenero.addAll(serieSet);
        for (Serie serie : serieTreeSetSortedGenero) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("\n--- Ordem TempoEpisodio ---");
        Set<Serie> serieTreeSetSortedDuracao = new TreeSet<>(new SerieComparatorDuracao());
        serieTreeSetSortedDuracao.addAll(serieSet);
        for (Serie serie : serieTreeSetSortedDuracao) {
            System.out.println(serie.getNome() + " - " +
                    serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

    }
}
