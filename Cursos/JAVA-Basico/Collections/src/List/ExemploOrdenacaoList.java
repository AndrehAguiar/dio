package List;

import List.comparator.GatoCorComparator;
import List.comparator.GatoIdadeComparator;
import List.comparator.GatoNomeIdadeCorComparator;
import List.model.Gato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {

        List<Gato> gatoList = new ArrayList<Gato>(){{

            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));

        }};
        System.out.println("\n--- Ordem de Inserção ---");
        System.out.println(gatoList);

        System.out.println("\n--- Ordem Aleatória ---");
        Collections.shuffle(gatoList);
        System.out.println(gatoList);

        System.out.println("\n--- Ordem Natural (Nome) ---");
        Collections.sort(gatoList);
        System.out.println(gatoList);

        System.out.println("\n--- Ordem Idade ---");
        // Collections.sort(gatoList, new GatoIdadeComparator());
        gatoList.sort(new GatoIdadeComparator());
        System.out.println(gatoList);

        System.out.println("\n--- Ordem Cor ---");
        gatoList.sort(new GatoCorComparator());
        System.out.println(gatoList);

        System.out.println("\n--- Ordem Nome/Cor/Idade ---");
        gatoList.sort(new GatoNomeIdadeCorComparator());
        System.out.println(gatoList);
    }
}
