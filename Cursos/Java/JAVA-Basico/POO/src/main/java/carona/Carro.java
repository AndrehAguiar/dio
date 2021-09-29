package carona;

public class Carro {
    protected Motorista motorista;
    protected Passageiro[] passageiros = new Passageiro[4];
    protected String[] ocupantes = new String[5];

    private int qtdOcupantes = 0;
    private int qtdPassageiros = 0;

    public Carro() {
    }

    public Carro(Motorista motorista, Passageiro[] passageiros, String[] ocupantes) {
        this.motorista = motorista;
        this.passageiros = passageiros;
        this.ocupantes = ocupantes;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
        this.addOcupante(this.motorista.name);
        this.verificarLotacao();
        this.verificarVagas();
    }

    public void sairDoCarro(String str) {
        for (int i = 0; i < this.qtdPassageiros; i++){
            if(this.passageiros[i]!=null){
                if(this.passageiros[i].name.equals(str)){
                    this.passageiros[i] = null;
                    this.qtdOcupantes--;
                    this.qtdPassageiros--;
                }
            }
            if(this.ocupantes[i]!=null){
                if(this.ocupantes[i].equals(str)){
                    this.ocupantes[i] = null;
                    this.qtdOcupantes--;
                    this.qtdPassageiros--;
                }
            }
        }
        System.out.println(String.format(
                "%s saiu do carro", str
        ));
        this.verificarLotacao();
        this.verificarVagas();
    }
    public void setPassageiro(Passageiro passageiro){
        this.passageiros[qtdPassageiros] = passageiro;
        this.addOcupante(this.passageiros[qtdPassageiros].name);
        this.qtdPassageiros++;
        this.verificarLotacao();
        this.verificarVagas();
    }

    public void addOcupante(String str){
        this.ocupantes[qtdOcupantes]=str;
        this.qtdOcupantes++;
        this.verificarLotacao();
        this.verificarVagas();
    }

    public void verificarLotacao(){
        System.out.println(String.format(
                "O carro tem %s pessoas", this.qtdOcupantes
        ));
    }
    public void verificarVagas(){
        System.out.println(String.format(
                "O carro tem mais %s vagas", (this.ocupantes.length - this.qtdOcupantes)
        ));
    }
}
