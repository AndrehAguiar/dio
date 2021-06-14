package Set.comparator;

import Set.model.LinguagemFavorita;

import java.util.Comparator;

public class LinguagemComparatorNomeAnoIDE implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareToIgnoreCase(l2.getNome());
        if(nome != 0)
            return nome;
        int ano = Integer.compare(l1.getAnoCriacao(), l2.getAnoCriacao());
        if(ano != 0)
            return ano;
        return l1.getIde().compareTo(l2.getIde());
    }
}
