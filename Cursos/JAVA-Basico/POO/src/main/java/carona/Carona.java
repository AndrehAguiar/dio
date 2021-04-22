package carona;

public class Carona {
    public static void main(String[] args) {
        Carro carro = new Carro();
        Motorista motorista = new Motorista("Andre");

        carro.verificarLotacao();
        motorista.definirMotorista();
        motorista.entrarNoCarro();
        carro.setMotorista(motorista);
        System.out.println(String.format(
                "O %s está como motorista", carro.motorista.name
        ));

        Passageiro passageiro = new Passageiro("Bruno");
        passageiro.definirPassageiro();
        passageiro.entrarNoCarro();
        carro.setPassageiro(passageiro);

        passageiro = new Passageiro("Thiago");
        passageiro.definirPassageiro();
        passageiro.entrarNoCarro();
        carro.setPassageiro(passageiro);

        passageiro = new Passageiro("Felipe");
        passageiro.definirPassageiro();
        passageiro.entrarNoCarro();
        carro.setPassageiro(passageiro);

        passageiro = new Passageiro("Cristiano");
        passageiro.definirPassageiro();
        passageiro.entrarNoCarro();
        carro.setPassageiro(passageiro);

        carro.sairDoCarro("Bruno");
        carro.sairDoCarro("Felipe");
        carro.sairDoCarro("Andre");

    }
}
