package digital.innovation.one;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public List<Aluno> list(){

        // CRIA A LISTA VAZIA
        List<Aluno> alunos = new ArrayList<>();

        try(Connection conn = ConnFactory.getConnection()){
            // PREPARA A CONSULTA SQL
            String sql = "SELECT * FROM aluno";

            // PREPARA STATMENT
            PreparedStatement stmt = conn.prepareStatement(sql);

            // EXECUTA A CONSULTA E ARMAZENA O RETORNO NO OBJ "rs"
            ResultSet rs = stmt.executeQuery();

            // INSERE CADA OBJETO ALUNO NA LISTA
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String estado = rs.getString("estado");

                alunos.add(new Aluno(id,nome,idade,estado));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return alunos;

    }

    public Aluno getById(int id){
        Aluno aluno = new Aluno();

        try(Connection conn = ConnFactory.getConnection()){
            String sql = "SELECT * FROM aluno WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            // INSERE CADA OBJETO ALUNO NA LISTA
            if (rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setEstado(rs.getString("estado"));
            }

            System.out.println("SUCESSO, SELEÇÃO -----> "+aluno);

        }catch (SQLException e){
            System.out.println("FALHA, SELEÇÃO!!");
            e.printStackTrace();
        }
        return aluno;
    }

    public void create(Aluno aluno){
        try(Connection conn = ConnFactory.getConnection()){
            String sql = "INSERT INTO aluno(nome, idade, estado) VALUES(?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("SUCESSO INSERÇÃO -----> "+rowsAffected+" linha(s) afetada(s)");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try(Connection conn = ConnFactory.getConnection()){

            String sql = "DELETE FROM aluno WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("DELETE, SUCESSO!! ----------> "+rowsAffected+" linha(s) afetada(s)");

        }catch (SQLException e){
            System.out.println("DELETE, FALHA");
            e.printStackTrace();
        }
    }

    public void update(Aluno aluno){
        try(Connection conn = ConnFactory.getConnection()){
            String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());
            stmt.setInt(4, aluno.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("UPDATE, SUCESSO! ---------> " + rowsAffected + "linha(s) afetada(s)");

        }catch (SQLException e){
            System.out.println("UPDATE FALHOU!!");
            e.printStackTrace();
        }
    }

}
