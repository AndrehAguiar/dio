public class App {
    public static void main(String[] args) {

        Gerente gerVendas = new Gerente("Andre", 3000d);
        System.out.println(String.format("O %s de Vendas %s, vai pagar %s de imposto.\n",
                gerVendas.getCargo(), gerVendas.getName(), gerVendas.calcularImposto()));

        Supervisor supVendas = new Supervisor("Bruno", 5000d);
        System.out.println(String.format("O %s de Vendas %s, vai pagar %s de imposto.\n",
                supVendas.getCargo(), supVendas.getName(), supVendas.calcularImposto()));

        Atendente atendVendas = new Atendente("Tiago", 1500d);
        System.out.println(String.format("O %s de Vendas %s, vai pagar %s de imposto.\n",
                atendVendas.getCargo(), atendVendas.getName(), atendVendas.calcularImposto()));

    }
}
