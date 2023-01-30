package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.sql.SQLException;

public class Awaria {
    int id;
    Pojazd pojazd;
    Zadanie zadanie;
    String data;
    RodzajAwarii rodzajAwarii;
    String opis;
    String adres;

    public Awaria(int id, Pojazd pojazd, Zadanie zadanie, String data, RodzajAwarii rodzajAwarii, String opis, String adres) {
        this.id = id;
        this.pojazd = pojazd;
        this.zadanie = zadanie;
        this.data = data;
        this.rodzajAwarii = rodzajAwarii;
        this.opis = opis;
        this.adres = adres;
    }
    @SneakyThrows
    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
        String sql = "UPDATE AWARIA SET PRACOWNIKID = \'"+pojazd.id+"\' WHERE IDAWARII = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setZadanie(Zadanie zadanie) {
        this.zadanie = zadanie;
        String sql = "UPDATE AWARIA SET ZADANIEID = \'"+zadanie.id+"\' WHERE IDAWARII = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setData(String data) {
        this.data = data;
        String sql = "UPDATE AWARIA SET DATA = \'"+data+"\' WHERE IDAWARII = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setRodzajAwarii(RodzajAwarii rodzajAwarii) {
        this.rodzajAwarii = rodzajAwarii;
        String sql = "UPDATE AWARIA SET RODZAJAWARIIID = \'"+rodzajAwarii.id+"\' WHERE IDAWARII = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setOpis(String opis) {
        this.opis = opis;
        String sql = "UPDATE AWARIA SET OPIS = \'"+opis+"\' WHERE IDAWARII = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setAdres(String adres) {
        this.adres = adres;
        String sql = "UPDATE AWARIA SET ADRES = \'"+adres+"\' WHERE IDAWARII = "+id;
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
                ", \"zadanieid\":\"" + zadanie.id + '\"' +
                ", \"data\":\"" + data + '\"' +
                ", \"rodzajAwariiID\":\"" + rodzajAwarii.id + '\"' +
                ", \"opis\":\"" + opis + '\"' +
                ", \"adres\":\"" + adres + '\"' +
                '}';
    }
}
