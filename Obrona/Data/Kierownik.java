package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.sql.SQLException;

public class Kierownik {
    int id;
    String imie;
    String nazwisko;
    String typ;
    String status;

    public Kierownik(int id, String imie, String nazwisko, String typ, String status) {
        this.id = id;
        this.imie = imie;//UZYTKOWNIK
        this.nazwisko = nazwisko;//UZYTKOWNIK
        this.typ = typ;//PRACOWNIK
        this.status = status;//PRACOWNIK
    }
    @SneakyThrows
    public void setImie(String imie) {
        this.imie = imie;
        String sql = "UPDATE UZYTKOWNIK SET IMIE = \'"+imie+"\' WHERE IDUZYTKOWNIKA = (SELECT UZYTKOWNIKID FROM PRACOWNIK WHERE IDPRACOWNIKA = \'"+id+"\')";
        System.out.println(sql);
        bazaUpdate(sql);
    }

    @SneakyThrows
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
        String sql = "UPDATE UZYTKOWNIK SET NAZWISKO = \'"+nazwisko+"\' WHERE IDUZYTKOWNIKA = (SELECT UZYTKOWNIKID FROM PRACOWNIK WHERE IDPRACOWNIKA = \'"+id+"\')";
        System.out.println(sql);
        bazaUpdate(sql);
    }

    @SneakyThrows
    public void setTyp(String typ) {
        this.typ = typ;
        String sql = "UPDATE PRACOWNIK SET TYP = \'"+typ+"\' WHERE IDPRACOWNIKA = "+id;
        System.out.println(sql);
        bazaUpdate(sql);
    }

    @SneakyThrows
    public void setStatus(String status) {
        this.status = status;
        String sql = "UPDATE PRACOWNIK SET STATUS = \'"+status+"\' WHERE IDPRACOWNIKA = "+id;
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
        if(this!=null)
            return "{\"pracownikid\":\"" + id + '\"' +
                    ", \"imie\":\"" + imie + '\"' +
                    ", \"nazwisko\":\"" + nazwisko + '\"' +
                    ", \"typ\":\"" + typ + '\"' +
                    ", \"status\":\"" + status + '\"' +
                    '}';
        else return "brak";
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getTyp() {
        return typ;
    }

    public String getStatus() {
        return status;
    }

    @SneakyThrows
    public JSONObject toJSON(){

        JSONObject jo = new JSONObject();
        jo.put("pracownikid", id);
        jo.put("imie", imie);
        jo.put("nazwisko", nazwisko);
        jo.put("typ", typ);
        jo.put("status", status);
        System.out.println(jo.toString());
        return jo;

    }
}
