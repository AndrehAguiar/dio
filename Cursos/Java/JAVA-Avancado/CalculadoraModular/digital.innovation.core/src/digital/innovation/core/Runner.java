package digital.innovation.core;

import digital.innovation.utils.Calculadora;

public class Runner {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        var resultSum = calculadora.sum(15, 5);
        var resultSub = calculadora.sub(15, 5);
        var resultDiv = calculadora.div(15, 5);
        var resultMult = calculadora.mult(15, 5);

        System.out.println(resultSum);
        System.out.println(resultSub);
        System.out.println(resultDiv);
        System.out.println(resultMult);
    }
}
