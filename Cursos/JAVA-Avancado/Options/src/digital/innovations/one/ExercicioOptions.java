package digital.innovations.one;

import java.util.Optional;

public class ExercicioOptions {
    public static void main(String[] args) {

        // CRIE COM ESTADO VAZIO, ESTADO PRESENTE E COM NULL
        // SE PRESENTE, EXIBA O VALOR NO CONSOLE

        Optional<String> stringOptional = Optional.of("Valor opcional");
        stringOptional.ifPresentOrElse(System.out::println, () -> System.out.println("OPTIONAL NÃO PRESENTE"));

        // SE VAZIO EXIBA 'OPTIONAL VAZIO' no console
        Optional<Long> longOptional = Optional.empty();
        longOptional.ifPresentOrElse(System.out::println, () ->System.out.println("OPTIONAL VAZIO"));

        // SE PRESENTE, TRANSFORME O VALOR E EXIBA NO CONSOLE
        stringOptional.map((valor)-> valor.concat("*****MAPEADO")).ifPresent(System.out::println);

        // SE PRESENTE ATRIBUA EM UMA VARIAVEL
        if(stringOptional.isPresent()){
            var variavel = stringOptional.get();
            System.out.println("SE PRESENTE VARIAVEL ::"+variavel);
        }

        Optional<Double> doubleOptional = Optional.ofNullable(null);
        doubleOptional.ifPresentOrElse(System.out::println, () -> System.out.println("OPTIONAL NULL"));



        longOptional.get();

        // SE PRESENTE, FILTRE O OPTIONAL COM UMA DETERMINADA REGRA
        Optional<Integer> idade = doubleOptional.of(27);
        var maiorQueDez = idade.filter(valor -> valor > 18);
        maiorQueDez.ifPresentOrElse(System.out::println, () -> System.out.println("IDADE MENOR QUE 18"));


        //SE VAZIO LANCE UMA EXCEÇÃO 'IlegaçStateException'
        System.out.println(longOptional.orElseThrow(IllegalStateException::new));
    }

}
