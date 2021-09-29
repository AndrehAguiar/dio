package digital.innovation.one;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {

    private ConnFactory() {
        throw new UnsupportedOperationException();
    }

    public static Connection getConnection() {

        Connection conn = null;
        try(InputStream input = ConnFactory.class.getClassLoader().getResourceAsStream("connection.properties")){

            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String port = prop.getProperty("db.port");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append(":")
                    .append(port).append("/")
                    .append(dataBaseName);

            String connURL = sb.toString();
            try {
                conn = DriverManager.getConnection(connURL, user, password);
                System.out.println("CONNECTION SUCCESS!!");

            } catch (SQLException e) {
                System.out.println("CONNECTION FAILED!!");
                throw new RuntimeException(e);

            }
        }catch (IOException e){
            System.out.println("FALHA AO TENTAR CARREGAR ARQUIVOS DE PRORPIEDADES DA CONEXÃO");
            e.printStackTrace();
        }
        return conn;
    }
}
