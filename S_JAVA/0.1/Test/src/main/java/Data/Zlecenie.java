package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.sql.SQLException;

public class Zlecenie {
    int id;
    int uzytkownikID;
    String data;
    String adres;
    String status;
    double cena;
    int rodzajPojazduID;

    public Zlecenie(int id, int uzytkownikID, String data, String adres, String status, double cena, int rodzajPojazduID) {
        this.id = id;
        this.uzytkownikID = uzytkownikID;
        this.data = data;
        this.adres = adres;
        this.status = status;
        this.cena = cena;
        this.rodzajPojazduID = rodzajPojazduID;
    }

    @SneakyThrows
    public void setUzytkownikID(int uzytkownikID) {
        this.uzytkownikID = uzytkownikID;
        String sql = "UPDATE ZLECENIE SET uzytkownikID = \'"+uzytkownikID+"\' WHERE IDZLECENIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setData(String data) {
        this.data = data;
        String sql = "UPDATE ZLECENIE SET data = \'"+data+"\' WHERE IDZLECENIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setAdres(String adres) {
        this.adres = adres;
        String sql = "UPDATE ZLECENIE SET adres = \'"+adres+"\' WHERE IDZLECENIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setStatus(String status) {
        this.status = status;
        String sql = "UPDATE ZLECENIE SET status = \'"+status+"\' WHERE IDZLECENIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setCena(double cena) {
        this.cena = cena;
        String sql = "UPDATE ZLECENIE SET cena = \'"+cena+"\' WHERE IDZLECENIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }

    @SneakyThrows
    public void setRodzajPojazduID(int rodzajPojazduID) {
        this.rodzajPojazduID = rodzajPojazduID;
        String sql = "UPDATE ZLECENIE SET RODZAJPOJAZDUID = \'"+rodzajPojazduID+"\' WHERE IDZLECENIA = "+id;
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
        return "{\"zlecenieid\":\"" + id + '\"' +
                ", \"uzytkownikID\":\"" + uzytkownikID + '\"' +
                ", \"data\":\"" + data + '\"' +
                ", \"adres\":\"" + adres + '\"' +
                ", \"status\":\"" + status + '\"' +
                ", \"cena\":\"" + cena + '\"' +
                ", \"rodzajPojazduID\":\"" + rodzajPojazduID + '\"' +
                '}';
    }
}
