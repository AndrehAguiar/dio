public class Supervisor extends Funcionario{

    private double imposto = 0.05;

    public Supervisor() {
    }

    public Supervisor(String name, Double salario) {
        super(name, "Supervisor", salario);
    }

    public double getImposto() {
        return imposto;
    }

    public Double calcularImposto(){
        return this.getSalario() * this.imposto;
    }
}
