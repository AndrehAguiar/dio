package Stream;

import Stream.model.Contato;

import java.util.*;

public class RefatoracaoOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("\n--- Ordem Aleatória ---");
        Map<Integer, Contato> agenda = new HashMap<Integer, Contato>() {{
            put(1, new Contato("Simba", 555555));
            put(4, new Contato("Cami", 111111));
            put(3, new Contato("Jon", 222222));
        }};
        for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("\n--- Ordem de Inserção ---");
        Map<Integer, Contato> agendaLinked = new LinkedHashMap<Integer, Contato>() {{
            put(1, new Contato("Simba", 555555));
            put(4, new Contato("Cami", 111111));
            put(3, new Contato("Jon", 222222));
        }};
        for (Map.Entry<Integer, Contato> entry : agendaLinked.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("\n--- Ordenado pelo ID ---");
        Map<Integer, Contato> agendaTree = new TreeMap<>(agenda);
        for (Map.Entry<Integer, Contato> entry : agendaTree.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("\n--- Ordenado pelo telefone contato ---");
/*      Set<Map.Entry<Integer, Contato>> agendaSet = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
                return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
            }
        });*/
/*        Set<Map.Entry<Integer, Contato>> agendaSet = new TreeSet<>(Comparator.comparing(new Function<Map.Entry<Integer, Contato>, Integer>() {
            @Override
            public Integer apply(Map.Entry<Integer, Contato> integerContatoEntry) {
                return integerContatoEntry.getValue().getNumero();
            }
        }));*/
        Set<Map.Entry<Integer, Contato>> agendaSet = new TreeSet<>(Comparator.comparing(
                integerContatoEntry -> integerContatoEntry.getValue().getNumero()));

        agendaSet.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : agendaSet) {
            System.out.println(entry.getKey() + " - " +
                    entry.getValue().getNome() + ": " + entry.getValue().getNumero());
        }

        System.out.println("\n--- Ordenado pelo nome do contato ---");
        Set<Map.Entry<Integer, Contato>> agendaSet1 = new TreeSet<Map.Entry<Integer, Contato>>(Comparator.comparing(
                integerContatoEntry -> integerContatoEntry.getValue().getNome()));

        agendaSet1.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry : agendaSet1) {
            System.out.println(entry.getKey() + " - " +
                    entry.getValue().getNome() + ": " + entry.getValue().getNumero());
        }
    }
}
