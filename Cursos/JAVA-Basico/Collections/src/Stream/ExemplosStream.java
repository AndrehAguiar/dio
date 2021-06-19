package Stream;

import java.util.*;
import java.util.function.DoubleConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemplosStream {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1","0","4","1","2","3","9","9","6","5");
        System.out.println("\nImprima todos os elementos dessa lista de String: ");
        numerosAleatorios.forEach(System.out::println);

        System.out.println("\nPegue os 5 primeiros números e coloque dentro de um Set: ");
        final Set<String> stringSet = numerosAleatorios
                .stream()
                .limit(5)
                .collect(Collectors.toSet());
        stringSet.forEach(System.out::println);

        System.out.println("\nTransforme esta lista de String em uma lista de Integer: ");
        final List<Integer> integerList = numerosAleatorios
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        integerList.forEach(System.out::println);

        System.out.println("\nPegue os números pares e maiores que 2 e coloque numa lista: ");
        final List<Integer> integerList1 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(el -> el % 2 == 0 && el > 2)
                .collect(Collectors.toList());
        integerList1.forEach(System.out::println);

        System.out.println("\nMostre a média dos números: ");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average().ifPresent(System.out::println);

        System.out.println("\nRemova os números ímpares: ");
        List<Integer> numerosAleatoriosPares = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numerosAleatoriosPares.removeIf(val -> val % 2 != 0);
        numerosAleatoriosPares.forEach(System.out::println);

        System.out.println("\nIgnore os 3 primeiros elementos da lista e imprima o restante: ");
        numerosAleatorios.subList(3, numerosAleatorios.size())
                .forEach(System.out::println);

        System.out.println("\nRetirando os números repetidos da lista, quantos números ficam? " +
                new HashSet<>(numerosAleatorios).size());

        System.out.println("\nMostre o menor valor da lista: ");
        numerosAleatorios.stream().map(Integer::parseInt).min(
                Comparator.comparingInt(Integer::intValue))
                .ifPresent(System.out::println);

        System.out.println("\nMostre o maior valor da lista: ");
        numerosAleatorios.stream().map(Integer::parseInt).max(
                Comparator.comparingInt(Integer::intValue))
                .ifPresent(System.out::println);

        System.out.println("\nPegue apenas os números ímpares e some: ");
        int soma = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(val -> val % 2 != 0)
                .mapToInt(v -> v).sum();
        System.out.println(soma);

        System.out.println("\nMostre a lista na ordem numérica: ");
        numerosAleatorios.stream()
                .map(Integer::parseInt).sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nAgrupe os valores ímpares multiplos de 3 e de 5: ");
        final Map<Boolean, List<Integer>> listMap = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(val -> val % 2 != 0)
                .collect(Collectors.groupingBy(v -> v % 3 == 0 || v % 5 == 0));
        listMap.entrySet().forEach(System.out::println);
    }
}
