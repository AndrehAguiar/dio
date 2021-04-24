package digital.innovations.one;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class OptionsPrimitivos{
    public static void main(String[] args) {
        System.out.println("****Valor inteiro opcional****");
        OptionalInt.of(64).ifPresent(System.out::println);

        System.out.println("****Valor decimal opcional****");
        OptionalDouble.of(155d).ifPresent((System.out::println));

        System.out.println("****Valor longo opcional****");
        OptionalLong.of(53L).ifPresent(System.out::println);

    }
}
