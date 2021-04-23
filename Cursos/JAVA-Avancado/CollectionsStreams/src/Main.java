import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> nomes = new ArrayList<String>();

        // ADICIONE 5 NOMES NA LISTA
        nomes.add("Juliana");
        nomes.add("Pedro");
        nomes.add("Carlos");
        nomes.add("Larissa");
        nomes.add("João");

        // NAVEGUE NA LISTA EXIBINDO CADA NOME NO CONSOLE
        for(String nome:nomes){
            System.out.println(nome);
        }

        // SUBSTITUA O NOME 'Carlos' por 'Roberto'
        nomes.set(2, "Roberto");
        System.out.println(nomes);

        //RETORNE O NOME NA POSIÇÃO '1'
        var nome = nomes.get(1);
        System.out.println(nome);

        // REMOVA O NOME DA POSIÇÃO '4'
        nomes.remove(4);
        System.out.println(nomes);

        // REMOVA O NOME 'João'
        nomes.remove("João");
        System.out.println(nomes);

        // RETORNE A QUANTIDADE DE ITENS NA LISTA
        var size = nomes.size();
        System.out.println(size);

        // VERIFIQUE SE O NOME 'Juliano' EXISTE NA LISTA
        System.out.println(nomes.contains("Juliano"));

        // CRIE UMA NOVA LISTA COM OS NOMES:
        var newList = new ArrayList<String>();
        newList.add("Ismael");
        newList.add("Rodrigo");
        System.out.println(newList);

        // ADICIONE TODOS OS ITENS DA NOVA LISTA NA PRIMEIRA LISTA CRIADA
        nomes.addAll(newList);
        System.out.println(nomes);

        // ORDENE OS ITENS DA LISTA POR ORDEM ALFABÉTICA
        Collections.sort(nomes);
        System.out.println(nomes);

        // VERIFIQUE SE A LISTA ESTÁ VAZIA
        System.out.println(nomes.isEmpty());

    }
}
