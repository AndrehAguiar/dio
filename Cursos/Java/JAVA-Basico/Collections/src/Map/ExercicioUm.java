package Map;

import java.util.*;

public class ExercicioUm {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário e relacione os estados e suas populações: ");
        Map<String, Integer> popEstado = new HashMap<String, Integer>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(popEstado);

        System.out.println("\nSubstitua a população do estado do RN por 3.534.165");
        popEstado.put("RN", 3534165);
        System.out.println("A população do RN é: " + popEstado.get("RN"));

        System.out.println("\nConfira se o estado PB está no dicionário, caso não esteja, adicione: PB - 4.039.277: " + popEstado.containsKey("PB"));
        popEstado.put("PB", 4039277);
        System.out.println(popEstado);

        System.out.println("\nExiba a população PE: " + popEstado.get("PE"));

        Map<String, Integer> popEstadoLinked = new LinkedHashMap<String, Integer>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};
        System.out.println("\nExiba os estados e suas populações na ordem que foi informado");
        popEstado.entrySet().forEach(System.out::println);

        System.out.println("\nExiba os estados e suas populações na ordem alfabética");
        Map<String, Integer> popEstadoTree = new TreeMap<>(popEstadoLinked);
        popEstadoTree.entrySet().forEach(System.out::println);

        System.out.println("\nExiba o estado com a menor população e sua quantidade");
        final Integer minPop = Collections.min(popEstado.values());
        for (Map.Entry<String, Integer> entry : popEstado.entrySet())
            if (entry.getValue().equals(minPop))
                System.out.println(entry.getKey() + " - " + entry.getValue());

        System.out.println("\nExiba o estado com a maior população e sua quantidade");
        final Integer maxPop = Collections.max(popEstado.values());
        for (Map.Entry<String, Integer> entry : popEstado.entrySet())
            if (entry.getValue().equals(maxPop))
                System.out.println(entry.getKey() + " - " + entry.getValue());

        System.out.println("\nExiba a soma da população desses estados");
        Integer soma = 0;
        for (Map.Entry<String, Integer> entry : popEstado.entrySet())
            soma += entry.getValue();
        System.out.println("A soma das populações é: " + soma);
        System.out.println("\nExiba a média da população deste dicionário de estados: " + soma / popEstado.size());

        System.out.println("\nRemova os estados com a população menor que 4.000.000");
        popEstado.entrySet().removeIf(pop -> pop.getValue() < 4000000);
        System.out.println(popEstado);

        System.out.println("\nApague o dicionário de estados");
        popEstado.clear();
        System.out.println(popEstado);
        System.out.println("\nConfira se o dicionário está vazio: " + popEstado.isEmpty());

    }
}
