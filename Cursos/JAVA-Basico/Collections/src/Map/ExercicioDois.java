package Map;

import Map.model.Livro;
import Map.model.Pessoa;

import java.util.*;

public class ExercicioDois {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("André", 39);
        Pessoa p2 = new Pessoa("João", 31);
        Pessoa p3 = new Pessoa("André", 25);
        Livro l1 = new Livro("Uma Breve História do Tempo", 256);
        Livro l2 = new Livro("O Poder do Hábito", 408);
        Livro l3 = new Livro("21 Lições Para o Século 21", 432);

        Map<Pessoa, Set<Livro>> livrosPessoa = new HashMap<Pessoa, Set<Livro>>() {{
            put(p1, new HashSet<Livro>() {{
                add(l1);
                add(l3);
            }});
            put(p2, new HashSet<Livro>() {{
                add(l2);
                add(l3);
            }});
            put(p3, new HashSet<Livro>() {{
                add(l1);
                add(l2);
                add(l3);
            }});
        }};
        livrosPessoa.entrySet().forEach(System.out::println);

        System.out.println("\nOrdenação por nome e idade da pessoa: ");
        Set<Pessoa> pessoaMap = new TreeSet<Pessoa>() {{
            add(p1);
            add(p2);
            add(p3);
        }};
        Map<Pessoa, Set<Livro>> livrosPessoaLinked = new LinkedHashMap<>();
        for (Pessoa pessoa : pessoaMap) {
            livrosPessoaLinked.put(pessoa, livrosPessoa.get(pessoa));
        }
        livrosPessoaLinked.entrySet().forEach(System.out::println);

        System.out.println("\nOrdenação por nome e idade da pessoa e quantidade de páginas do livro: \n");
        for (Map.Entry<Pessoa, Set<Livro>> entry : livrosPessoaLinked.entrySet()) {
            Set<Livro> livrosTreeSet = new TreeSet<>(new LivrosComparatorPaginas());
            livrosTreeSet.addAll(entry.getValue());
            livrosPessoaLinked.put(entry.getKey(), livrosTreeSet);
        }
        for (Map.Entry<Pessoa, Set<Livro>> entry : livrosPessoaLinked.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);
            System.out.println("\n");
        }

    }
}

class LivrosComparatorPaginas implements Comparator<Livro> {
    @Override
    public int compare(Livro l1, Livro l2) {
        return Integer.compare(l1.getPaginas(), l2.getPaginas());
    }
}
