public class Funcionario extends Pessoa{

    private String cargo;
    private Double salario;

    public Funcionario() {
    }

    public Funcionario(String name, String cargo, Double salario) {
        super(name);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
