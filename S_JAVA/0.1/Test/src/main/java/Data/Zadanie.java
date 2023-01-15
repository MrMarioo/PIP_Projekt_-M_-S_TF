package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.sql.SQLException;

public class Zadanie {
    int id;
    Pojazd pojazd;
    Pracownik pracownik;
    String data;
    String opis;
    String status;
    Pracownik kierownik;

    public Zadanie(int id, Pojazd pojazd, Pracownik pracownik, String data, String opis, String status, Pracownik kierownik) {
        this.id = id;
        this.pojazd = pojazd;
        this.pracownik = pracownik;
        this.data = data;
        this.opis = opis;
        this.status = status;
        this.kierownik = kierownik;
    }
    @SneakyThrows
    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
        String sql = "UPDATE ZADANIE SET POJAZDID = \'"+pojazd.id+"\' WHERE IDZADANIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
        String sql = "UPDATE ZADANIE SET PRACOWNIKID = \'"+pracownik.id+"\' WHERE IDZADANIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setData(String data) {
        this.data = data;
        String sql = "UPDATE ZADANIE SET DATA = \'"+data+"\' WHERE IDZADANIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setOpis(String opis) {
        this.opis = opis;
        String sql = "UPDATE ZADANIE SET STATUS = \'"+status+"\' WHERE IDZADANIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setStatus(String status) {
        this.status = status;
        String sql = "UPDATE ZADANIE SET STATUS = \'"+status+"\' WHERE IDZADANIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setKierownik(Pracownik kierownik) {
        this.kierownik = kierownik;
        String sql = "UPDATE ZADANIE SET KIEROWNIKID = \'"+kierownik.id+"\' WHERE IDZADANIA = "+id;
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
        return "{\"zadanieid\":\"" + id + '\"' +
                ", \"pojazdid\":\"" + pojazd.id + '\"' +
                ", \"pracownikid\":\"" + pracownik.id + '\"' +
                ", \"data\":\"" + data + '\"' +
                ", \"opis\":\"" + opis + '\"' +
                ", \"status\":\"" + status + '\"' +
                ", \"kierownikid\":\"" + kierownik.id + '\"' +
                '}';
    }
}
