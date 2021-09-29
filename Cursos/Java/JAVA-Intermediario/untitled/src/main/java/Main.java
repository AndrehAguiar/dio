import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*        int k = 2, N = 5;
        int result, max = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i+1; j <= N; j++) {
                result = i & j;
                if(result < k && result > max){
                    max = result;
                }
            }
        }
        System.out.println(max);*/

/*        NumberFormat numberFormated;

        Locale usLocale = new Locale("en", "US");
        numberFormated = NumberFormat.getCurrencyInstance(usLocale);
        System.out.println(numberFormated.format(2.00));

        Locale idLocale = new Locale("hi", "IN");
        numberFormated = NumberFormat.getCurrencyInstance(idLocale);
        System.out.println(numberFormated.format(2.00));

        Locale cnLocale = new Locale("zh", "CN");
        numberFormated = NumberFormat.getCurrencyInstance(cnLocale);
        System.out.println(numberFormated.format(2.00));

        Locale frLocale = new Locale("fr", "FR");
        numberFormated = NumberFormat.getCurrencyInstance(frLocale);
        System.out.println(numberFormated.format(2.00));*/

        Scanner leitor = new Scanner(System.in);
        String N;
        while(leitor.hasNext()){

            N = leitor.next();
            if(N.equals("-1")){
                break;
            }

            if(N.startsWith("0x")){
                System.out.println(Long.parseLong(N.substring(2), 16));
            }else{
                System.out.println(String.format("0x"+String.valueOf(
                        Integer.toHexString(Integer.parseInt(N))
                        ).toUpperCase()
                ));
            }

        }
    }
}
