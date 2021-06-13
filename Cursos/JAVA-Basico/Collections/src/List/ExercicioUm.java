package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExercicioUm {
    public static void main(String[] args) {
        Double soma = 0.;
        double media = 0.;
        List<String> listMeses = new ArrayList<String>() {{
            addAll(Arrays.asList("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho"));
        }};
        List<Double> listTemp = new ArrayList<Double>() {{
            addAll(Arrays.asList(25.3, 31.5, 27.9, 29.1, 28.7, 32.3));
        }};

        for (Double temp : listTemp) {
            soma += temp;
        }
        media = soma / listTemp.size();
        for (int i = 0; i < listTemp.size(); i++) {
            Double temp = listTemp.get(i);
            if (temp > media)
                System.out.println(temp + " - " + listMeses.get(i));
        }
    }
}
