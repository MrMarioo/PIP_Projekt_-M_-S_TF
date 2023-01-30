package Data;

import Data.PojazdFactory.PojazdFactory;
import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.sql.SQLException;

public abstract class Pojazd  {
    protected int id;
    protected Kontrahent kontrahent;
    protected Zlecenie zlecenie;
    protected String status;
    protected RodzajPojazdu rodzajPojazdu;
    protected boolean certified;

    public int getId() {
        return id;
    }
    public boolean getCertified() { return certified;}
    public Kontrahent getKontrahent() {
        return kontrahent;
    }

    public Zlecenie getZlecenie() {
        return zlecenie;
    }

    public void setCertified(boolean certified) { this.certified = certified;}
    public String getStatus() {
        return status;
    }

    public Pojazd(int id, Zlecenie zlecenie, String status, Kontrahent kontrahent,RodzajPojazdu rodzajPojazdu) {
        this.id = id;
        this.zlecenie = zlecenie;
        this.status = status;
        this.kontrahent = kontrahent;
        this.rodzajPojazdu = rodzajPojazdu;
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
    @SneakyThrows
    public JSONObject toJSON(){
        JSONObject jo = new JSONObject();
        jo.put("pojazdid",id);
        jo.put("kontrahentid",kontrahent.id);
        jo.put("zlecenieid",zlecenie.id);
        jo.put("status",status);
        System.out.println(jo.toString());
        return jo;
    }

}
