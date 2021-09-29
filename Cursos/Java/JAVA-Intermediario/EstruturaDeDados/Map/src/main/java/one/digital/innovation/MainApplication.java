package one.digital.innovation;

import java.util.*;

public class MainApplication {
    public static void main(String[] args) {

        List<Map<String, String>> alunosList = new ArrayList<>();

        Map<String, String > aluno1 = new HashMap<>();

        aluno1.put("Nome", "João");
        aluno1.put("Idade", "17");
        aluno1.put("Média", "8.5");
        aluno1.put("Turma", "3a");
        alunosList.add(aluno1);

        System.out.println(aluno1);

        System.out.println(aluno1.keySet());
        System.out.println(aluno1.values());

        Map<String, String > aluno2 = new HashMap<>();
        aluno2.put("Nome", "Maria");
        aluno2.put("Idade", "18");
        aluno2.put("Média", "8.9");
        aluno2.put("Turma", "3b");
        alunosList.add(aluno2);

        System.out.println(aluno2);

        System.out.println(aluno2.keySet());
        System.out.println(aluno2.values());

        System.out.println(alunosList);
    }
}
