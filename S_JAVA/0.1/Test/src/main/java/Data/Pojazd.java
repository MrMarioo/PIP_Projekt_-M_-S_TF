package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.sql.SQLException;

public class Pojazd {
    int id;
    Kontrahent kontrahent;
    Zlecenie zlecenie;
    String status;

    public Pojazd(int id, Zlecenie zlecenie, String status, Kontrahent kontrahent) {
        this.id = id;
        this.zlecenie = zlecenie;
        this.status = status;
        this.kontrahent = kontrahent;
    }
    @SneakyThrows
    public void setZlecenie(Zlecenie zlecenie) {
        this.zlecenie = zlecenie;
        String sql = "UPDATE POJAZD SET ZLECENIEID = \'"+zlecenie.id+"\' WHERE IDPOJAZDU = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setStatus(String status) {
        this.status = status;
        String sql = "UPDATE POJAZD SET STATUS = \'"+status+"\' WHERE IDPOJAZDU = "+id;
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
        return "{\"pojazdid\":\"" + id + '\"' +
                ", \"zlecenie\":\"" + zlecenie + '\"' +
                ", \"status\":\"" + status + '\"' +
                '}';
    }

}
