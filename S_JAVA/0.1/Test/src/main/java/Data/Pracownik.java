package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.sql.SQLException;

public class Pracownik {
    int id;
    Kierownik kierownik;
    String imie;
    String nazwisko;
    String typ;
    String status;

    public Pracownik(int id, Kierownik kierownik, String imie, String nazwisko, String typ, String status) {
        this.id = id;
        this.kierownik = kierownik;//PRACOWNIK
        this.imie = imie;//UZYTKOWNIK
        this.nazwisko = nazwisko;//UZYTKOWNIK
        this.typ = typ;//PRACOWNIK
        this.status = status;//PRACOWNIK
    }
    public Pracownik(int id, String imie, String nazwisko, String typ, String status) {
        this.id = id;
        this.kierownik = new Kierownik(0,"Brak","Brak","Brak", "Brak");;//PRACOWNIK
        this.imie = imie;//UZYTKOWNIK
        this.nazwisko = nazwisko;//UZYTKOWNIK
        this.typ = typ;//PRACOWNIK
        this.status = status;//PRACOWNIK
    }
    @SneakyThrows
    public void setKierownikID(Kierownik kierownik) {
        this.kierownik = kierownik;
        String sql = "UPDATE PRACOWNIK SET KIEROWNIKID = \'"+kierownik.id+"\' WHERE IDPRACOWNIKA = "+id;
        System.out.println(sql);
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

    public void deleteKierownik() {
        this.kierownik = new Kierownik(0,"Brak","Brak","Brak", "Brak");;//PRACOWNIK
    }

    @Override
    public String toString() {
        return "{\"pracownikid\":\"" + id + '\"' +
                ", \"kierownik\":\"" + kierownik.id + '\"' +
                ", \"imie\":\"" + imie + '\"' +
                ", \"nazwisko\":\"" + nazwisko + '\"' +
                ", \"typ\":\"" + typ + '\"' +
                ", \"status\":\"" + status + '\"' +
                '}';
    }
}
