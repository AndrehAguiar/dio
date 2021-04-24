package digital.innovation.one;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public List<Curso> list(){

        // CRIA A LISTA VAZIA
        List<Curso> cursos = new ArrayList<>();

        try(Connection conn = ConnFactory.getConnection()){
            // PREPARA A CONSULTA SQL
            String sql = "SELECT * FROM curso";

            // PREPARA STATMENT
            PreparedStatement stmt = conn.prepareStatement(sql);

            // EXECUTA A CONSULTA E ARMAZENA O RETORNO NO OBJ "rs"
            ResultSet rs = stmt.executeQuery();

            // INSERE CADA OBJETO ALUNO NA LISTA
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int duracaoHoras = rs.getInt("duracao_horas");

                cursos.add(new Curso(id,nome,duracaoHoras));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cursos;

    }

    public Curso getById(int id){
        Curso curso = new Curso();

        try(Connection conn = ConnFactory.getConnection()){
            String sql = "SELECT * FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            // INSERE CADA OBJETO CURSO NA LISTA
            if (rs.next()){
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDuracaHoras(rs.getLong("duracao_horas"));
            }

            System.out.println("SUCESSO, SELEÇÃO -----> "+curso);

        }catch (SQLException e){
            System.out.println("FALHA, SELEÇÃO!!");
            e.printStackTrace();
        }
        return curso;
    }

    public void create(Curso curso){
        try(Connection conn = ConnFactory.getConnection()){
            String sql = "INSERT INTO curso(nome, duracao_horas) VALUES(?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setLong(2, curso.getDuracaoHoras());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("SUCESSO INSERÇÃO -----> "+rowsAffected+" linha(s) afetada(s)");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try(Connection conn = ConnFactory.getConnection()){

            String sql = "DELETE FROM curso WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("DELETE, SUCESSO!! ----------> "+rowsAffected+" linha(s) afetada(s)");

        }catch (SQLException e){
            System.out.println("DELETE, FALHA");
            e.printStackTrace();
        }
    }

    public void update(Curso curso){
        try(Connection conn = ConnFactory.getConnection()){
            String sql = "UPDATE curso SET nome = ?, duracao_horas = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setLong(2, curso.getDuracaoHoras());
            stmt.setInt(3, curso.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("UPDATE, SUCESSO! ---------> " + rowsAffected + "linha(s) afetada(s)");

        }catch (SQLException e){
            System.out.println("UPDATE FALHOU!!");
            e.printStackTrace();
        }
    }
}
