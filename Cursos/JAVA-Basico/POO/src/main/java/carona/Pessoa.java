package carona;

public class Pessoa {
    protected String name;

    public Pessoa() {
    }

    public Pessoa(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void entrarNoCarro(){
        System.out.println(String.format(
                "%s entrou no carro!", this.name)
        );
    }
}
