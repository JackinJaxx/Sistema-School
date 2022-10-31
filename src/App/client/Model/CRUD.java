package App.client.Model;

import java.util.ArrayList;

public interface CRUD {

    int create(Object model);
    ArrayList<Object> read();
    int update(Object model);
    String delete(String identificador);
}
