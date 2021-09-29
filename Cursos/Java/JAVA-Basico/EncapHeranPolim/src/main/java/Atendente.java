public class Atendente extends Funcionario{

    private Double imposto = 0.01;

    public Atendente() {
    }

    public Atendente(String name, Double salario) {
        super(name, "Atendente", salario);
    }

    public Double getImposto() {
        return imposto;
    }

    public Double calcularImposto(){
        return this.getSalario() * this.imposto;
    }
}
