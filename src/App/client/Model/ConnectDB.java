package App.client.Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    //connectDatabase postgresql
    private final String url = "jdbc:postgresql://localhost:5432/alumnosmaestrosdb";
    private final String user = "postgres";
    private final String password = "alejandro1807";
    private static ConnectDB instance;
    private Connection connection = null;

    public Connection getConnection() {
        return connection;
    }

    private ConnectDB() {
    }
    public static ConnectDB getInstance(){
        if(instance == null){
            instance = new ConnectDB();
        }
        return instance;
    }
    public Boolean connectDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + e);
            return false;
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.print("Conexión a base de datos " + url + " ... Ok");
                return true;
            }
        } catch (SQLException e) {
            System.out.print("Error al conectar a la base de datos " + url + ": " + e);
        }
        return false;
    }
}
