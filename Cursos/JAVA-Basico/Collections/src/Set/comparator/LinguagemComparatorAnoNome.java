package Set.comparator;

import Set.model.LinguagemFavorita;

import java.util.Comparator;

public class LinguagemComparatorAnoNome implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int ano = Integer.compare(l1.getAnoCriacao(), l2.getAnoCriacao());
        if(ano != 0)
            return ano;
        return l1.getNome().compareTo(l2.getNome());
    }
}
