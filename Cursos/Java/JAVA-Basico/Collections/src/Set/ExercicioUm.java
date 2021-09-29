package Set;

import java.util.*;

public class ExercicioUm {
    public static void main(String[] args) {
        System.out.println("\nCrie um conjunto contendo as cores do arco-íris: ");
        Set<String> arcoIrisCores = new HashSet<String>(){{
           addAll(Arrays.asList(
                   "Vermelho","Laranja","Amarelo","Verde","Azul","Anil","Violeta"));
        }};
        System.out.println("\nExiba todas as cores uma abaixo da outra: ");
        arcoIrisCores.forEach(System.out::println);

        System.out.println("\nA quantidade de cores que o arco-íris tem: " + arcoIrisCores.size());
        System.out.println("\nExiba as cores em ordem alfabética: ");
        Set<String> arcoIrisCoresSetTree = new TreeSet<>(arcoIrisCores);
        arcoIrisCoresSetTree.forEach(System.out::println);

        System.out.println("\nExiba as cores na ordem inversa da que foi informada: ");
        Set<String> arcoIrisLinkedSet = new LinkedHashSet<>(Arrays.asList(
                "Vermelho","Laranja","Amarelo","Verde","Azul","Anil","Violeta"));

        List<String> listCores = new ArrayList<>(arcoIrisLinkedSet);
        Collections.reverse(listCores);
        listCores.forEach(System.out::println);

        System.out.println("\nExiba todas as cores que começam com a letra 'v'");
        for (String cor : arcoIrisLinkedSet) {
            if (cor.toLowerCase().startsWith("v"))
                System.out.println(cor);
        }

        System.out.println("\nRemova todas as cores que não começam com a letra 'v'");
        arcoIrisLinkedSet.removeIf(cor -> !cor.toLowerCase().startsWith("v"));
        System.out.println(arcoIrisLinkedSet);

        arcoIrisCores.clear();
        System.out.println("\nLimpe o conjunto: " + arcoIrisCores.isEmpty());
        System.out.println("\nConfira se o conjunto está vazio: " + arcoIrisCores);

    }
}