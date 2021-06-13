package List;

import java.util.*;

public class ExemploList {
    public static void main(String[] args) {
        List<Double> notas = new ArrayList<>();
        System.out.println("Crie uma lista e adicione as sete notas: ");

        notas.add(7.);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.);
        notas.add(7.);
        notas.add(0.);
        notas.add(3.6);

        System.out.println(notas);

        System.out.println("\nExiba a posição 5.0: " + notas.indexOf(5.));

        System.out.println("\nAdicione a nota 8.0 na posição 4: ");
        notas.add(4, 8.);
        System.out.println(notas);

        System.out.println("\nSubstitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5.), 6.);
        System.out.println(notas);

        System.out.println("\nConfira se a nota 5.0 está na lista: " + notas.contains(5.));

        System.out.println("\nExiba todas as notas na ordem que foram informadas: ");
        notas.forEach(System.out::println);

        System.out.println("\nExiba a terceira nota adicionada: " + notas.get(2));
        System.out.println(notas);

        System.out.println("\nExiba a menor nota: " + Collections.min(notas));
        System.out.println("\nExiba a maior nota: " + Collections.max(notas));

        System.out.println("Exiba a soma dos valores: ");
        Iterator<Double> it = notas.iterator();
        Double soma = 0.;
        while (it.hasNext()) {
            soma += it.next();
        }

        System.out.println("\nA soma das notas é: " + soma);
        System.out.println("\n Exiba a média das notas: " + (soma/notas.size()));

        System.out.println("\nRemova a nota 0: ");
        notas.remove(0.);
        System.out.println(notas);

        System.out.println("\nRemova a nota na posição 0: ");
        notas.remove(0);
        System.out.println(notas);

        System.out.println("\nRemova as notas menores que 7: ");
        notas.removeIf(aDouble -> aDouble < 7);
        System.out.println(notas);

        System.out.println("\nApague toda a lista: ");
        notas.clear();
        System.out.println(notas);

        System.out.println("Confira se a lista está vazia: " + notas.isEmpty());

        // Resolva os exercícios utilizando os métodos da implementação LinkedList:
        System.out.println("\nCrie uma lista chamada notas2 e"+
                "adicione todos os elementos da list ArrayList nessa nova lista: ");

        LinkedList<Double> notas2 = new LinkedList<>(
                Arrays.asList(7., 8.5, 9.3, 5., 7., 0., 3.6));
        System.out.println("\nMostre a primeira nota da nova lista sem removê-lo: ");
        System.out.println(notas2.getFirst());
        System.out.println(notas2.pop());
        System.out.println(notas2);

    }
}
