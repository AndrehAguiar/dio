package digital.innovations.one;

import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {
        Optional<String> stringOptional = Optional.of("Valor optional");

        System.out.println(stringOptional.isPresent());
        System.out.println(stringOptional.isEmpty());

        stringOptional.ifPresent(System.out::println);

        Optional<String> stringOptionalNull = Optional.ofNullable(null);

        System.out.println(stringOptionalNull.isPresent());
        System.out.println(stringOptionalNull.isEmpty());
        stringOptionalNull.ifPresentOrElse(System.out::println, ()-> System.out.println("Is empty"));

        stringOptional.ifPresent(System.out::println);

        stringOptional.ifPresentOrElse(System.out::println,
                () -> System.out.println("Valor não está presente"));

        if(stringOptional.isPresent()){
            String valor = stringOptional.get();
            System.out.println(valor);
        }
        stringOptional.map((valor) -> valor.concat("****")).ifPresent(System.out::println);
        stringOptional.orElseThrow(IllegalStateException::new);
    }
}
