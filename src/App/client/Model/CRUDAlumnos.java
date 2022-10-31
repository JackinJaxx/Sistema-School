package App.client.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CRUDAlumnos implements CRUD {
    private ConnectDB connectDB;

    public CRUDAlumnos() {
        connectDB = ConnectDB.getInstance();
    }

    @Override
    public int create(Object model) {
        return 0;
    }

    @Override
    public ArrayList<Object> read() {
        ResultSet result;
        Alumnos objAlumnos;
        ArrayList<Object> listAlumnos = new ArrayList<>();
        connectDB.connectDatabase();
        try {
            Statement statement = connectDB.getConnection().createStatement();
            result = statement.executeQuery("SELECT * FROM alumnos");
            while (result.next()) {
                objAlumnos = new Alumnos(
                        result.getString("matricula"),
                        result.getString("correo"),
                        result.getString("password"),
                        result.getString("nombre"),
                        result.getString("apellido_paterno"),
                        result.getString("apellido_materno"),
                        result.getInt("edad"));
                listAlumnos.add(objAlumnos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listAlumnos;
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
