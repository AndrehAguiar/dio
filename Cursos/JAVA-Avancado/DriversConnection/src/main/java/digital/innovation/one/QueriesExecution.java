package digital.innovation.one;

import java.util.ArrayList;
import java.util.List;

public class QueriesExecution {
    public static void main(String[] args) {

//=================> TESTE ALUNO <==================//
        /*
        AlunoDAO alunoDAO = new AlunoDAO();

        List<Aluno> alunos = alunoDAO.list();
        alunos.stream().forEach(System.out::println);

        Aluno alunoSelected = alunoDAO.getById(1);
        System.out.println(alunoSelected);

        Aluno alunoNew = new Aluno("Matheus",43,"SP");
        alunoDAO.create(alunoNew);

        alunos = alunoDAO.list();
        alunos.stream().forEach(System.out::println);

        alunoDAO.delete(6);
        alunoDAO.delete(7);

        alunos = alunoDAO.list();
        alunos.stream().forEach(System.out::println);

        Aluno alunoUpdate = alunoDAO.getById(3);
        alunoUpdate.setNome("Joaquim");
        alunoUpdate.setIdade(18);
        alunoUpdate.setEstado("MG");

        alunoDAO.update(alunoUpdate);

        alunos = alunoDAO.list();
        alunos.stream().forEach(System.out::println);
        */

//=================> TESTE CURSO <==================//
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> cursos = cursoDAO.list();
        cursos.stream().forEach(System.out::println);

        /*
        Curso javaCurso = new Curso("JAVA", 100L);
        Curso sqlCurso = new Curso("SQL", 80L);
        Curso springCurso = new Curso("SPRING", 30L);
        Curso nodeCurso = new Curso("NODE", 70L);
        Curso logicaCurso = new Curso("LOGICA", 10L);

        cursoDAO.create(javaCurso);
        cursoDAO.create(sqlCurso);
        cursoDAO.create(springCurso);
        cursoDAO.create(nodeCurso);
        cursoDAO.create(logicaCurso);

        cursos = cursoDAO.list();
        cursos.stream().forEach(System.out::println);

        cursoDAO.delete(5);

        cursos = cursoDAO.list();
        cursos.stream().forEach(System.out::println);

        Curso cursoUpdate = cursoDAO.getById(3);
        cursoUpdate.setDuracaHoras(70L);
        cursoDAO.update(cursoUpdate);
        */

        cursos = cursoDAO.list();
        cursos.stream().forEach(System.out::println);

    }
}
