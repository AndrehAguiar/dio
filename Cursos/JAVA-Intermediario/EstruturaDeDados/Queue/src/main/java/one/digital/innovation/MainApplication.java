package one.digital.innovation;

import java.util.LinkedList;
import java.util.Queue;

public class MainApplication {
    public static void main(String[] args) {
        Queue<Carro> carros = new LinkedList<>();

        carros.add(new Carro("Ford"));
        carros.add(new Carro("Chevrolet"));
        carros.add(new Carro("Volkswagen"));

        System.out.println(carros.add(new Carro("Peugeot")));
        System.out.println(carros);

        System.out.println(carros.offer(new Carro("Fiat")));
        System.out.println(carros);

        System.out.println(carros.peek());
        System.out.println(carros);

        System.out.println(carros.poll());
        System.out.println(carros);

        System.out.println(carros.isEmpty());
        System.out.println(carros.size());
    }
}
