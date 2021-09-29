import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class Inference {

    public static void main(String[] args) {
       // printSoma(1,5,7,2);
        //printNomeCompleto("Andre", "Aguiar");
        connectionAndPrintJavaOracle();
    }

    private static void connectionAndPrintJavaOracle() {

        // JDK 8
        try{
            var url = new URL("https://docs.oracle.com/javase/10/language/");
            var urlConnection = url.openConnection();

            try(var bufferedReader = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())))) {
                System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printNomeCompleto(String nome, String sobrenome){
        var nomeCompleto = String.format("%s %s", nome, sobrenome); // Inferencia
        System.out.println(nomeCompleto);
    }

    public static void printSoma(int... numeros){
        var soma = 0;                               // Inferencia
        if(numeros.length > 0){
            for(var numero :numeros){               // Inferencia
                soma+=numero;
            }
            var result = String.format("A soma é :: %s", soma);
            System.out.println(result);
        }
    }
}
