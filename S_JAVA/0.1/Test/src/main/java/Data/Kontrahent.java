package Data;
import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.sql.SQLException;

public class Kontrahent     {

    int id;
    String nazwa;
    String imie;
    String nazwisko;

    public Kontrahent(int id, String nazwa, String imie, String nazwisko) {
        this.id = id;
        this.nazwa = nazwa;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    @SneakyThrows
    public void insert(int idU){
        JDBC.update("INSERT INTO UZYTKOWNIK VALUES('"+idU+"','"+imie+"','"+nazwisko+"','6','log','has')");
        JDBC.update("INSERT INTO KONTRAHENT VALUES('"+id+"','"+idU+"','"+nazwa+"')");
    }
    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    @SneakyThrows
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
        String sql = "UPDATE KONTRAHENT SET NAZWA = \'"+nazwa+"\' WHERE IDKONTRAHENTA = \'"+id+"\'";
        System.out.println(sql);
        bazaUpdate(sql);
    }

    @SneakyThrows
    public void setImie(String imie) {
        this.imie = imie;
        String sql = "UPDATE UZYTKOWNIK SET IMIE = \'"+imie+"\' WHERE IDUZYTKOWNIKA = (SELECT UZYTKOWNIKID FROM KONTRAHENT WHERE IDKONTRAHENTA = \'"+id+"\')";
        //System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
        String sql = "UPDATE UZYTKOWNIK SET NAZWISKO = \'"+nazwisko+"\' WHERE IDUZYTKOWNIKA = (SELECT UZYTKOWNIKID FROM KONTRAHENT WHERE IDKONTRAHENTA = \'"+id+"\')";
        //System.out.println(sql);
        bazaUpdate(sql);
    }


    @SneakyThrows
    private String bazaUpdate(String sql) throws SQLException, JSONException {
        JDBC.update(sql);
        return "Wykonano";
        }

    @Override
    public String toString() {
        return "{\"kontrahentid\":\"" + id + '\"' +
                ", \"nazwa\":\"" + nazwa + '\"' +
                ", \"imie\":\"" + imie + '\"' +
                ", \"nazwisko\":\"" + nazwisko + '\"' +
                '}';
    }
}
