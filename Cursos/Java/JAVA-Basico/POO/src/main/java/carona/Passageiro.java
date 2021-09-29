package carona;

public class Passageiro extends Pessoa{

    public Passageiro() {
    }

    public Passageiro(String name) {
        super(name);
    }

    public void definirPassageiro(){
        System.out.println(String.format(
                "O %s vai ser um dos passageiros", this.name)
        );
    }
}
