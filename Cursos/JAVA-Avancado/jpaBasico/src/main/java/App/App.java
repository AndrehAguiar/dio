package App;

import Classes.Aluno;
import Classes.Curso;
import Classes.Estado;
import Classes.Matricula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("App");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

/*        entityManager.persist(new Estado("Rio de Janeiro", "RJ"));
        entityManager.persist(new Estado("São Paulo", "SP"));
        entityManager.persist(new Estado("Minas Gerais", "MG"));
        entityManager.persist(new Estado("Espirito Santo", "ES"));
        entityManager.persist(new Estado("Ceara", "CE"));
        entityManager.persist(new Estado("Bahia", "BA"));
        entityManager.persist(new Estado("Acre", "AC"));
        entityManager.persist(new Estado("Amazonas", "AM"));*/

/*        entityManager.persist(new Curso("JAVA", 100));
        entityManager.persist(new Curso("SQL", 80));
        entityManager.persist(new Curso("SPRING", 30));
        entityManager.persist(new Curso("NODE", 70));
        entityManager.persist(new Curso("LOGICA", 10));*/

/*        Estado rj = entityManager.find(Estado.class, 41);
        Estado sp = entityManager.find(Estado.class, 42);
        Estado mg = entityManager.find(Estado.class, 43);
        Estado es = entityManager.find(Estado.class, 44);
        Estado ce = entityManager.find(Estado.class, 45);
        Estado ba = entityManager.find(Estado.class, 46);

        System.out.println(new Aluno("Andre", 39, mg));
        entityManager.persist(new Aluno("Andre", 39, mg));
        entityManager.persist(new Aluno("Bruna", 35, rj));
        entityManager.persist(new Aluno("Alex", 18, ba));
        entityManager.persist(new Aluno("Cristina", 25, ba));*/


/*        Aluno andre = entityManager.find(Aluno.class, 1);
        Aluno bruna = entityManager.find(Aluno.class, 2);
        Aluno alex = entityManager.find(Aluno.class, 3);
        Aluno cristina = entityManager.find(Aluno.class, 4);

        Curso java = entityManager.find(Curso.class, 26);
        Curso sql = entityManager.find(Curso.class, 27);
        Curso spring = entityManager.find(Curso.class, 28);
        Curso node = entityManager.find(Curso.class, 29);
        Curso logica = entityManager.find(Curso.class, 30);

        entityManager.persist(new Matricula(java, andre));
        entityManager.persist(new Matricula(spring, andre));
        entityManager.persist(new Matricula(logica, alex));
        entityManager.persist(new Matricula(sql,bruna));
        entityManager.persist(new Matricula(node,cristina));*/

        Estado es = entityManager.find(Estado.class, 44);
        entityManager.persist(new Aluno("Tati", 28, es));

        Aluno tati = entityManager.find(Aluno.class, 5);
        Curso node = entityManager.find(Curso.class, 29);
        entityManager.persist(new Matricula(node,tati));

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
