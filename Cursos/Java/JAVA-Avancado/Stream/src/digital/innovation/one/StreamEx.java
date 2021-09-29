package digital.innovation.one;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx {
    public static void main(String[] args) {
        // CRIA A LISTA VAZIA
        List<String> names = new ArrayList<>();

        // ADICONA ELEMENTOS NA LISTA
        names.add("Pedro");
        names.add("Thayse");
        names.add("Marcelo");
        names.add("Carla");
        names.add("Juliana");
        names.add("Thiago");
        names.add("Rafael");

        // RETORNA A CONTAGEM DE ELEMNETOS DO STREAM
        System.out.println("\n\nContagem :: \n"+names.stream().count());

        // RETORNA O ELEMENTO COM MAIOR NUMERO DE LETRAS
        System.out.println("\n\nMAIOR número de letras :: \n"
                +names.stream().max(Comparator.comparingInt(String::length)));

        // RETORNA O ELEMENTO COM MENOR NUMERO DE LETRAS
        System.out.println("\n\nMENOR número de letras :: \n"
                +names.stream().min(Comparator.comparingInt(String::length)));

        // RETORNA OS ELEMENTOS QUE CONTÊM A LETRA 'r'
        System.out.println("\n\nElemento com a letra 'r' :: \n"
                +names.stream().filter((name)->
                name.toLowerCase().contains("r")).collect(Collectors.toList()));

        // RETORNA UMA NOVA COLEÇÃO COM OS ELEMENTOS E A QUANTIDADE DE LETRAS
        System.out.println("\n\nRETORNA os elementos e a quantidade de letras :: \n"
                +names.stream().map((name)->
                name.concat(" - ").concat(String.valueOf(name.length())))
                .collect(Collectors.toList()));

        // RETORNA SOMENTE OS 3 PRIMEIROS ELEMENTOS
        System.out.println("\n\nRETORNA os 3 primeiros elementos :: \n"
                +names.stream().limit(3).collect(Collectors.toList()));

        // EXIBE CADA ELEMENTO NO CONSOLE E RETORNA A MESMA COLEÇÃO
        System.out.println("RETORNA os elementos :: \n"
                +names.stream().peek(System.out::println).collect(Collectors.toList()));

        // EXIBE CADA ELEMENTO NO CONSOLE SEM RETORNAR OUTRA COLEÇÃO
        System.out.println("\n\nRETORNA os elementos novamente :: \n");
        names.stream().forEach(System.out::println);

        // RETORNA TRUE SE TODOS OS ELEMENTOS POSSUEM A LETRA 'W'
        System.out.println("\n\nRETORNA true se todos elementos têm 'W' :: \n"
                +names.stream().allMatch((name)->name.contains("W")));

        // RETORNA TRUE SE ALGUM O ELEMENTO POSSUEM A LETRA 'a'
        System.out.println("\n\nRETORNA true se tem algum elemento com 'a' :: \n"
                +names.stream().anyMatch((name)->name.contains("a")));

        // RETORNA TRUE SE NENHUM ELEMENTO POSSUEM A LETRA 'a'
        System.out.println("\n\nRETORNA true se nenhum elemento com 'a' :: \n"
                +names.stream().noneMatch((name)->name.contains("a")));

        // RETORNA TRUE SE TODOS OS ELEMENTOS POSSUEM A LETRA 'a'
        System.out.println("\n\nRETORNA o primeiro elemento da coleção :: \n"
                +names.stream().findFirst());

        System.out.println("\n\nOPERAÇÃO ENCADEADA :: \n");
        System.out.println(names.stream()
        .peek(System.out::println)
        .map(name ->
                name.concat(" - ").concat(String.valueOf(name.length())))
        .peek(System.out::println)
        //.filter((name)->
        //        name.toLowerCase().contains("r"))
        //.collect(Collectors.toList()));
        //.collect(Collectors.joining(", ")));
        //.collect(Collectors.toSet()));
        .collect(Collectors.groupingBy(name -> name.substring(name.indexOf("-") + 1))));
    }
}
