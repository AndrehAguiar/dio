package Map;

import Map.comparator.LivroComparatorNome;
import Map.comparator.LivroComparatorPaginas;
import Map.model.Livro;

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("\n--- Ordem Aleatória ---");
        Map<String, Livro> livroMap = new HashMap<String, Livro>(){{
           put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
           put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
           put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};
        for(Map.Entry<String, Livro> livro : livroMap.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("\n--- Ordem de Inserção ---");
        Map<String, Livro> livroMapLinked = new LinkedHashMap<String, Livro>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
        }};
        for(Map.Entry<String, Livro> livro : livroMapLinked.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("\n--- Ordem Alfabética Autores ---");
        Map<String, Livro> livroMapTree = new TreeMap<>(livroMapLinked);
        for(Map.Entry<String, Livro> livro : livroMapTree.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("\n--- Ordem Alfabética nomes dos livros ---");
        Set<Map.Entry<String, Livro>> livroSetTreeNome = new TreeSet<>(new LivroComparatorNome());
        livroSetTreeNome.addAll(livroMap.entrySet());
        for(Map.Entry<String, Livro> livro : livroSetTreeNome)
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("\n--- Ordem quantidade de páginas dos livros ---");
        Set<Map.Entry<String, Livro>> livroSetTreePaginas = new TreeSet<>(new LivroComparatorPaginas());
        livroSetTreePaginas.addAll(livroMap.entrySet());
        for(Map.Entry<String, Livro> livro : livroSetTreePaginas)
            System.out.println(livro.getKey() + " - " +
                    livro.getValue().getNome() + " - " +
                    livro.getValue().getPaginas());
    }
}
