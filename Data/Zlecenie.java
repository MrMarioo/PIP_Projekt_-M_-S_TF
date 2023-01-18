package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.sql.SQLException;

public class Zlecenie {
    int id;
    Kontrahent kontrahent;
    String data;
    String adres;
    String status;
    double cena;
    RodzajPojazdu rodzajPojazdu;

    public Zlecenie(int id, Kontrahent kontrahent, String data, String adres, String status, double cena, RodzajPojazdu rodzajPojazdu) {
        this.id = id;
        this.kontrahent = kontrahent;
        this.data = data;
        this.adres = adres;
        this.status = status;
        this.cena = cena;
        this.rodzajPojazdu = rodzajPojazdu;
    }

    public int getId() {
        return id;
    }

    public Kontrahent getKontrahent() {
        return kontrahent;
    }

    public String getData() {
        return data;
    }

    public String getAdres() {
        return adres;
    }

    public String getStatus() {
        return status;
    }

    public double getCena() {
        return cena;
    }

    public RodzajPojazdu getRodzajPojazdu() {
        return rodzajPojazdu;
    }

    @SneakyThrows
    public void setKontrahent(Kontrahent kontrahent) {
        this.kontrahent = kontrahent;
        String sql = "UPDATE ZLECENIE SET uzytkownikID = \'"+kontrahent.id+"\' WHERE IDZLECENIA = "+id;
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
        if(status=="Zaakceptowano");

    }
    @SneakyThrows
    public void setCena(double cena) {
        this.cena = cena;
        String sql = "UPDATE ZLECENIE SET cena = \'"+cena+"\' WHERE IDZLECENIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }

    /*@SneakyThrows
    public void setRodzajPojazduID(String rodzajPojazdu) {
        this.rodzajPojazdu = rodzajPojazdu;
        String sql = "UPDATE ZLECENIE SET RODZAJPOJAZDUID = \'"+rodzajPojazduID+"\' WHERE IDZLECENIA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }*/
    //do przerobienia na pobranie id za pomoca nazwy i update w bazie

    @SneakyThrows
    private String bazaUpdate(String sql) throws SQLException, JSONException {
        JDBC.update(sql);
        return "Wykonano";
    }

    @Override
    public String toString() {
        return "{\"zlecenieid\":\"" + id + '\"' +
                ", \"kontrahent\":\"" + kontrahent + '\"' +
                ", \"data\":\"" + data + '\"' +
                ", \"adres\":\"" + adres + '\"' +
                ", \"status\":\"" + status + '\"' +
                ", \"cena\":\"" + cena + '\"' +
                ", \"rodzajPojazdu\":\"" + rodzajPojazdu + '\"' +
                '}';
    }
}
