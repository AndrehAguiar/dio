package Map;

import Map.model.Livro;
import Map.model.Pessoa;

import java.util.*;

public class ExercicioTres {
    public static void main(String[] args) {

        Pessoa autor1 = new Pessoa("Hawking, Stephen", 76);
        Pessoa autor2 = new Pessoa("Duhigg, Charles", 47);
        Pessoa autor3 = new Pessoa("Harari, Yuval Noah", 45);

        System.out.println("Ordem Aleatória");

        Map<Pessoa, Livro> autorLivro = new HashMap<Pessoa, Livro>() {{
            put(autor1, new Livro("Uma Breve História do Tempo", 256));
            put(autor2, new Livro("O Poder do Hábito", 408));
            put(autor3, new Livro("21 Lições Para o Século 21", 432));
        }};
        autorLivro.entrySet().forEach(System.out::println);

        System.out.println("\nOrdem pela idade do autor");
        Set<Map.Entry<Pessoa, Livro>> autorLivroTree = new TreeSet<>(new PessoaComparatorIdade());
        autorLivroTree.addAll(autorLivro.entrySet());
        autorLivroTree.forEach(System.out::println);

        System.out.println("\nOrdem pela quantidade de páginas do livro");
        Set<Map.Entry<Pessoa, Livro>> autorLivroTree1 = new TreeSet<>(new LivroComparatorPagina());
        autorLivroTree1.addAll(autorLivro.entrySet());
        autorLivroTree1.forEach(System.out::println);

        System.out.println("\nOrdem pelo nome do livro");
        Set<Map.Entry<Pessoa, Livro>> autorLivroTree2 = new TreeSet<>(new LivroComparatorNome());
        autorLivroTree2.addAll(autorLivro.entrySet());
        autorLivroTree2.forEach(System.out::println);

    }
}
class PessoaComparatorIdade implements Comparator<Map.Entry<Pessoa, Livro>>{

    @Override
    public int compare(Map.Entry<Pessoa, Livro> o1, Map.Entry<Pessoa, Livro> o2) {
        return Integer.compare(o1.getKey().getIdade(), o2.getKey().getIdade());
    }
}
class LivroComparatorPagina implements Comparator<Map.Entry<Pessoa, Livro>>{

    @Override
    public int compare(Map.Entry<Pessoa, Livro> o1, Map.Entry<Pessoa, Livro> o2) {
        return Integer.compare(o1.getValue().getPaginas(), o2.getValue().getPaginas());
    }
}
class LivroComparatorNome implements Comparator<Map.Entry<Pessoa, Livro>>{

    @Override
    public int compare(Map.Entry<Pessoa, Livro> o1, Map.Entry<Pessoa, Livro> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}