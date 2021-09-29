package one.digital.innovation;

import java.util.*;

public class MainApplication {
    public static void main(String[] args) {
        Set<Carro> hashCarros = new HashSet<>();

        hashCarros.add(new Carro("Ford"));
        hashCarros.add(new Carro("Chevrolet"));
        hashCarros.add(new Carro("Fiat"));
        hashCarros.add(new Carro("Peugeot"));
        hashCarros.add(new Carro("Renault"));
        hashCarros.add(new Carro("Alfa Romeo"));
        hashCarros.add(new Carro("Volksvagen"));

        System.out.println(hashCarros);

        Set<Carro> treeCarros = new TreeSet<>();

        treeCarros.add(new Carro("Ford"));
        treeCarros.add(new Carro("Chevrolet"));
        treeCarros.add(new Carro("Fiat"));
        treeCarros.add(new Carro("Peugeot"));
        treeCarros.add(new Carro("Renault"));
        treeCarros.add(new Carro("Alfa Romeo"));
        treeCarros.add(new Carro("Volksvagen"));

        System.out.println(treeCarros);
    }
}
