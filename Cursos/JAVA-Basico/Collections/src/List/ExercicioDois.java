package List;

import java.util.*;

public class ExercicioDois {

    public static Scanner scan = new Scanner(System.in);
    public static Integer out = 0;

    public static void main(String[] args) {
        List<String> questions = new ArrayList<String>() {{
            addAll(Arrays.asList(
                    "Telefonou para a vítima?",
                    "Esteve no local do crime?",
                    "Mora perto da vítima?",
                    "Devia para a vítima?",
                    "Já trabalhou com a vítma?"));
        }};
        for (String s : questions) {
            System.out.println(s);
            String reply = scan.next();
            if (reply.toLowerCase(Locale.ROOT).equals("sim")) {
                out += 1;
            }
        }
        if (out < 2) {
            System.out.println("Inocente");
        } else if (out == 2) {
            System.out.println("Suspeita");
        } else if (out <= 4) {
            System.out.println("Cúmplice");
        } else {
            System.out.println("Assassina");
        }
    }
}
