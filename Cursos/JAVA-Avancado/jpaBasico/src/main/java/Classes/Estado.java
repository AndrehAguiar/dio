package Classes;

import javax.persistence.*;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cod;

    public Estado(int id, String name, String cod) {
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Estado(String name, String cod) {
        this.name = name;
        this.cod = cod;
    }

    public Estado() {
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

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Classes.Estado{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                '}';
    }
}
