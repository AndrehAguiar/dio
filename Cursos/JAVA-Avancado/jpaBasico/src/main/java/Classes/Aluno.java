package Classes;

import javax.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int idade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;

    public Aluno(int id, String name, int idade, Estado estado) {
        this.id = id;
        this.name = name;
        this.idade = idade;
        this.estado = estado;
    }

    public Aluno(String name, int idade, Estado estado) {
        this.name = name;
        this.idade = idade;
        this.estado = estado;
    }

    public Aluno() {
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idade=" + idade +
                ", estado=" + estado +
                '}';
    }
}
