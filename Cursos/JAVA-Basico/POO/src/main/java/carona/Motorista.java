package carona;

public class Motorista extends Pessoa{
    public Motorista() {
    }

    public Motorista(String name) {
        super(name);
    }

    public void definirMotorista(){

        System.out.println(String.format(
                "O motorista do carro vai ser o %s",this.name)
        );
    }

}
