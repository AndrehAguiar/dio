package Map;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário que reacione os modelos e seus respectivos consumos: ");
        Map<String, Double> carrosPopulares = new HashMap<String, Double>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares);

        System.out.println("\nSubstitua o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("\nConfira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));

        System.out.println("\nExiba o consumo do uno: " + carrosPopulares.get("uno"));

        System.out.println("\nExiba os modelos: ");
        final Set<String> strings = carrosPopulares.keySet();
        strings.forEach(System.out::println);

        System.out.println("\nExiba os consumos dos carros: ");
        final Collection<Double> values = carrosPopulares.values();
        values.forEach(System.out::println);

        System.out.println("\nExiba o modelo mais econômico e seu consumo: ");
        final Double maxEficiente = Collections.max(carrosPopulares.values());
        final Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaxEficiente = "";
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(maxEficiente)) {
                modeloMaxEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " +
                        modeloMaxEficiente + " - " + maxEficiente);
            }
        }

        System.out.println("\nExiba o modelo menos econômico e seu consumo: ");
        final Double minEficiente = Collections.min(carrosPopulares.values());
        String modeloMinEficiente = "";
        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(minEficiente)) {
                modeloMinEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " +
                        modeloMinEficiente + " - " + minEficiente);
            }
        }

        System.out.println("\nExiba a soma dos consumos: ");
        Iterator<Double> it = carrosPopulares.values().iterator();
        Double soma = 0.;
        while (it.hasNext()) {
            soma += it.next();
        }
        System.out.println("A soma dos consumos é: " + soma);
        System.out.println("\nExiba a média dos consumos: " + soma/carrosPopulares.size());

        System.out.println("\nRemova os modelos com o consumo igual a 15,6 km/l: ");
        carrosPopulares.values().removeIf(consumo -> consumo.equals(15.6));
        System.out.println(carrosPopulares);

        System.out.println("\nExiba todos os carros na ordem em que foram informados: ");
        Map<String, Double> carrosPopularesLinked = new LinkedHashMap<String, Double>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopularesLinked);

        System.out.println("\nExiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carrosPopularesTree = new TreeMap<>(carrosPopularesLinked);
        System.out.println(carrosPopularesTree);

        System.out.println("\nApague o dicionário de carros: ");
        carrosPopulares.clear();
        System.out.println("\nConfira se o dicionário está vazio: " + carrosPopulares.isEmpty());
    }
}