package digital.innovation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorJDBC {
    public static void main(String[] args) throws SQLException {

        String urlConnection = "jdbc:mysql://localhost/digitalinnovation";
        try (Connection conn =DriverManager.getConnection(urlConnection, "root", "password")) {
            System.out.println("CONNECTION SUCCESS!!");
        }catch (SQLException e){
            System.out.println("CONNECTION FAILED!!");
        }

        String driver = "mysql";
        String dataBaseAddress = "localhost";
        String port = "3306";
        String dataBaseName = "digitalinnovation";
        String user = "root";
        String password = "password";

        StringBuilder sb = new StringBuilder( "jdbc:")
                .append(driver).append("://")
                .append(dataBaseAddress).append(":")
                .append(port).append("/")
                .append(dataBaseName);

        String connURL = sb.toString();
        try (Connection conn =DriverManager.getConnection(connURL, user, password)) {
            System.out.println("CONNECTION SUCCESS!!");
        }catch (SQLException e){
            System.out.println("CONNECTION FAILED!!");
        }

    }
}
