package one.digital.innovation;

import java.util.Stack;

public class MainApplication {
    public static void main(String[] args) {

        Stack<Carro> carros = new Stack<>();

        carros.push(new Carro("Ford"));
        carros.push(new Carro("Chevrolet"));
        carros.push(new Carro("Fiat"));

        System.out.println(carros);
        System.out.println(carros.pop());
        System.out.println(carros);
        System.out.println(carros.peek());
        System.out.println(carros);

        System.out.println(carros.empty());

    }
}
