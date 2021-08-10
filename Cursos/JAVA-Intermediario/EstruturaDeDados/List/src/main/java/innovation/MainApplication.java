package innovation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MainApplication {
    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro("Ford"));
        carros.add(new Carro("Chevrolet"));
        carros.add(new Carro("Volkswagen"));

        System.out.println(carros.add(new Carro("Peugeot")));
        System.out.println(carros);

        System.out.println(carros.contains(new Carro("Peugeot")));
        System.out.println(carros);
        System.out.println(carros.get(2));

        System.out.println(carros.isEmpty());
        System.out.println(carros.size());

        System.out.println(carros.indexOf(new Carro("Volkswagen")));
        System.out.println(carros);
        System.out.println(carros.remove(2));
        System.out.println(carros);
    }
}
