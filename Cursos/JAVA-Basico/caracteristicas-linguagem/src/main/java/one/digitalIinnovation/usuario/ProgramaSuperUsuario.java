package one.digitalIinnovation.usuario;

public class ProgramaSuperUsuario {
    public static void main(String[] args) {
        final var superUsuario = new SuperUsuario("root", "123456");

        superUsuario.getLogin();

        superUsuario.getSenha();

        String root = superUsuario.nome;
    }
}
