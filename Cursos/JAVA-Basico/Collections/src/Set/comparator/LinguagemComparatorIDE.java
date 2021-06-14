package Set.comparator;

import Set.model.LinguagemFavorita;

import java.util.Comparator;

public class LinguagemComparatorIDE implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        return l1.getIde().compareTo(l2.getIde());
    }
}
