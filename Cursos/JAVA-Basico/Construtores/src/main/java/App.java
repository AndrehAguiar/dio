public class App {

    public static void main(String[] args) {

        Carro uno = new Carro("Fiat", "Uno", 2001);
        uno.setVariante("Fire");

        System.out.println(String.format("%s %s %s %s",
                uno.getMarca(),
                uno.getModelo(),
                uno.getAno(),
                uno.getVariante()));
    }
}
