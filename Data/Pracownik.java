package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.sql.SQLException;

public class Pracownik {
    int id;
    int kierownikID;
    String imie;
    String nazwisko;
    String typ;
    String status;

    public Pracownik(int id, int kierownikID, String imie, String nazwisko, String typ, String status) {
        this.id = id;
        this.kierownikID = kierownikID;//PRACOWNIK
        this.imie = imie;//UZYTKOWNIK
        this.nazwisko = nazwisko;//UZYTKOWNIK
        this.typ = typ;//PRACOWNIK
        this.status = status;//PRACOWNIK
    }
    @SneakyThrows
    public void setKierownikID(int kierownikID) {
        this.kierownikID = kierownikID;
        String sql = "UPDATE PRACOWNIK SET KIEROWNIKID = \'"+kierownikID+"\' WHERE IDPRACOWNIKA = "+id;
        //System.out.println(sql);
        bazaUpdate(sql);
    }
    @SneakyThrows
    public void setImie(String imie) {
        this.imie = imie;
        String sql = "UPDATE UZYTKOWNIK SET IMIE = \'"+imie+"\' WHERE IDUZYTKOWNIKA = (SELECT UZYTKOWNIKID FROM PRACOWNIK WHERE IDPRACOWNIKA = \'"+id+"\')";
        //System.out.println(sql);
        bazaUpdate(sql);
    }

    @SneakyThrows
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
        String sql = "UPDATE UZYTKOWNIK SET NAZWISKO = \'"+nazwisko+"\' WHERE IDUZYTKOWNIKA = (SELECT UZYTKOWNIKID FROM PRACOWNIK WHERE IDPRACOWNIKA = \'"+id+"\')";
        //System.out.println(sql);
        bazaUpdate(sql);
    }

    @SneakyThrows
    public void setTyp(String typ) {
        this.typ = typ;
        String sql = "UPDATE PRACOWNIK SET TYP = \'"+typ+"\' WHERE IDPRACOWNIKA = "+id;
        //System.out.println(sql);
        bazaUpdate(sql);
    }

    @SneakyThrows
    public void setStatus(String status) {
        this.status = status;
        String sql = "UPDATE PRACOWNIK SET STATUS = \'"+status+"\' WHERE IDPRACOWNIKA = "+id;
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
        return "{\"pracownikid\":\"" + id + '\"' +
                ", \"kierownikID\":\"" + kierownikID + '\"' +
                ", \"imie\":\"" + imie + '\"' +
                ", \"nazwisko\":\"" + nazwisko + '\"' +
                ", \"typ\":\"" + typ + '\"' +
                ", \"status\":\"" + status + '\"' +
                '}';
    }
}
