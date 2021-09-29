package Set;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        System.out.println("\nCrie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7., 8.5, 9.3, 5., 7., 0., 3.6));
        System.out.println(notas);

        System.out.println("\nConfira se a nota 5.0 está no conjunto: " + notas.contains(5.));
        System.out.println("\nExiba a menor nota: " + Collections.min(notas));
        System.out.println("\nExiba a maior nota: " + Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("\nExiba a soma dos valores: " + soma);
        System.out.println("\nExiba a média dos valores: " + soma / notas.size());
        System.out.println("\nRemova a nota 0: ");
        notas.remove(0.);
        System.out.println(notas);

        System.out.println("\nRemova as notas menores que 7 e exiba a lista: ");
        notas.removeIf(nota -> nota < 7.);
        System.out.println("\n" + notas);

        Set<Double> linkedNotas = new LinkedHashSet<>();
        linkedNotas.add(7.);
        linkedNotas.add(8.5);
        linkedNotas.add(9.3);
        linkedNotas.add(7.);
        linkedNotas.add(0.);
        linkedNotas.add(3.6);
        System.out.println("\n" + linkedNotas);

        System.out.println("\nExiba todas as notas na ordem crescente: ");
        Set<Double> treeNotas = new TreeSet<>(linkedNotas);
        System.out.println("\n" + treeNotas);

        System.out.println("\nApague todo o conjunto: ");
        notas.clear();
        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
        System.out.println("Confira se o conjunto está vazio: " + linkedNotas.isEmpty());
        System.out.println("Confira se o conjunto está vazio: " + treeNotas.isEmpty());
    }
}
