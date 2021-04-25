package Classes;

import javax.persistence.*;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int duracaoHoras;

    public Curso(int id, String name, int duracaoHoras) {
        this.id = id;
        this.name = name;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso(String name, int duracaoHoras) {
        this.name = name;
        this.duracaoHoras = duracaoHoras;
    }

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuracaoHoras() {
        return duracaoHoras;
    }

    public void setDuracaoHoras(int duracaoHoras) {
        this.duracaoHoras = duracaoHoras;
    }

    @Override
    public String toString() {
        return "Classes.Curso{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duracaoHoras=" + Curso.this.duracaoHoras +
                '}';
    }
}
