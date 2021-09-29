package Classes;

import javax.persistence.*;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    private Curso curso;

    public Matricula(long id, Curso curso, Aluno aluno) {
        this.id = id;
        this.aluno = aluno;
        this.curso = curso;
    }

    public Matricula(Curso curso, Aluno aluno) {
        this.aluno = aluno;
        this.curso = curso;
    }

    public Matricula() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", curso=" + curso +
                '}';
    }
}
