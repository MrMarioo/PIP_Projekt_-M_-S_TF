package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.sql.SQLException;

public class Zadanie {
    int id;
    Pojazd pojazd;
    Pracownik pracownik;
    String data;
    String opis;
    String status;
    Kierownik kierownik;

    public int getId() {
        return id;
    }

    public Pojazd getPojazd() {
        return pojazd;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public String getData() {
        return data;
    }

    public String getOpis() {
        return opis;
    }

    public String getStatus() {
        return status;
    }

    public Kierownik getKierownik() {
        return kierownik;
    }



    public Zadanie(int id, Pojazd pojazd, Pracownik pracownik, String data, String opis, String status, Kierownik kierownik) {
        this.id = id;
        this.pojazd = pojazd;
        this.pracownik = pracownik;
        this.data = data;
        this.opis = opis;
        this.status = status;
        this.kierownik = kierownik;
    }
    public Zadanie(int id, Pojazd pojazd, String data, String opis, String status, Kierownik kierownik) {
        this.id = id;
        this.pojazd = pojazd;
        this.pracownik = SystemData.pracownicy.get(0);
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
        if(status.equals("Wykonano")) {
            pracownik.setStatus("Wolny");
            SystemData.przydzielZadania();
            SystemData.sprawdzPojazd(pojazd);
        }
    }
    @SneakyThrows
    public void setKierownik(Kierownik kierownik) {
        this.kierownik = kierownik;
        String sql ="";
        if(kierownik.id!=0)
            sql = "UPDATE ZADANIE SET KIEROWNIKID = \'"+kierownik.id+"\' WHERE IDZADANIA = "+id;
        else
            sql = "UPDATE ZADANIE SET KIEROWNIKID = null WHERE IDZADANIA = "+id;
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
    @SneakyThrows
    public JSONObject toJSON(){
        JSONObject jo = new JSONObject();
        jo.put("zadanieid",id);
        jo.put("pojazdid",pojazd.id);
        jo.put("pracownikid",pracownik.id);
        jo.put("data",data);
        jo.put("opis",opis);
        jo.put("status",status);
        jo.put("kierownikid",kierownik.id);
        System.out.println(jo.toString());
        return jo;
    }
}
