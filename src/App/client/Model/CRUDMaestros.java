package App.client.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CRUDMaestros implements CRUD {
    private ConnectDB connectDB;

    public CRUDMaestros() {
        connectDB = ConnectDB.getInstance();
    }
    @Override
    public int create(Object model) {
        return 0;
    }

    @Override
    public ArrayList<Object> read() {
        ResultSet result;
        Maestros objMaestros;
        ArrayList<Object> listMaestros = new ArrayList<>();
        connectDB.connectDatabase();
        try {
            Statement statement = connectDB.getConnection().createStatement();
            result = statement.executeQuery("SELECT * FROM maestros");
            while (result.next()) {
                objMaestros = new Maestros(
                        result.getString("matricula"),
                        result.getString("correo"),
                        result.getString("password"),
                        result.getString("nombre"),
                        result.getString("apellido_paterno"),
                        result.getString("apellido_materno"),
                        result.getInt("edad"));
                listMaestros.add(objMaestros);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listMaestros;
    }

    @Override
    public int update(Object model) {
        return 0;
    }

    @Override
    public String delete(String identificador) {
        return null;
    }
}
