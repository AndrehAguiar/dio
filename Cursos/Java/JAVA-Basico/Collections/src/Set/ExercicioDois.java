package Set;

import Set.comparator.LinguagemComparatorAnoNome;
import Set.comparator.LinguagemComparatorIDE;
import Set.comparator.LinguagemComparatorNomeAnoIDE;
import Set.model.LinguagemFavorita;

import java.util.*;

public class ExercicioDois {
    public static void main(String[] args) {
        System.out.println("Crie uma classe 'LinguagemFavorita': ");
        System.out.println("Crie um conjunto com 3 linguagens: ");
        Set<LinguagemFavorita> linguagemSetLinked = new LinkedHashSet<LinguagemFavorita>(){{
           add(new LinguagemFavorita("Python", 1991, "PyCharm"));
           add(new LinguagemFavorita("Java", 1990, "IntelliJ"));
           add(new LinguagemFavorita("PHP", 1995, "PhpStorm"));
        }};
        System.out.println("\n--- Ordem de Inserção ---");
        linguagemSetLinked.forEach(System.out::println);

        System.out.println("\n--- Ordem Natural (nome)");
        Set<LinguagemFavorita> linguagemSetTree = new TreeSet<>(linguagemSetLinked);
        linguagemSetTree.forEach(System.out::println);

        System.out.println("\n--- Ordem IDE ---");
        Set<LinguagemFavorita> linguagemSetByIDE = new TreeSet<>(new LinguagemComparatorIDE());
        linguagemSetByIDE.addAll(linguagemSetLinked);
        linguagemSetByIDE.forEach(System.out::println);

        System.out.println("\n--- Ordem Ano/Nome ---");
        Set<LinguagemFavorita> linguagemByAnoNome = new TreeSet<>(new LinguagemComparatorAnoNome());
        linguagemByAnoNome.addAll(linguagemSetLinked);
        linguagemByAnoNome.forEach(System.out::println);

        System.out.println("\n--- Ordem Nome/Ano/IDE ---");
        Set<LinguagemFavorita> linguagemByNomeAnoIDE = new TreeSet<>(new LinguagemComparatorNomeAnoIDE());
        linguagemByNomeAnoIDE.addAll(linguagemSetLinked);
        linguagemByNomeAnoIDE.forEach(System.out::println);
    }
}
