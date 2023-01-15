package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.sql.SQLException;

public class RodzajAwarii {
    int id;
    String nazwa;
    int priorytet;
    @SneakyThrows
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
        String sql = "UPDATE RODZAJAWARII SET NAZWA = \'"+nazwa+"\' WHERE IDRODZAJAWARII = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setPriorytet(int priorytet) {
        this.priorytet = priorytet;
        String sql = "UPDATE RODZAJAWARII SET PRIORYTET = \'"+priorytet+"\' WHERE IDRODZAJAWARII = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    private String bazaUpdate(String sql) throws SQLException, JSONException {
        JDBC.update(sql);
        return "Wykonano";
    }
    @Override
    public String toString() {
        return "RodzajAwarii{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", priorytet=" + priorytet +
                '}';
    }
}
