public class Gerente extends Funcionario{

    private double imposto = 0.1;

    public Gerente() {
    }

    public Gerente(String name, Double salario) {
        super(name, "Gerente", salario);
    }

    public double getImposto() {
        return imposto;
    }

    public Double calcularImposto(){
        return this.getSalario() * this.imposto;
    }
}
