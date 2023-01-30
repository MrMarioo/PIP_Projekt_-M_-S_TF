package Data;

import Data.PojazdFactory.LekkiPojazdFactory;
import Data.PojazdFactory.PojazdFactory;
import com.example.test.JDBC;
import lombok.SneakyThrows;
import netscape.javascript.JSObject;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Zlecenie {
    int id;
    Kontrahent kontrahent;
    String data;
    String adres;
    String status;
    int cena;
    RodzajPojazdu rodzajPojazdu;

    public Zlecenie(int id, Kontrahent kontrahent, String data, String adres, String status, int cena, RodzajPojazdu rodzajPojazdu) {
        this.id = id;
        this.kontrahent = kontrahent;
        this.data = data;
        this.adres = adres;
        this.status = status;
        this.cena = cena;
        this.rodzajPojazdu = rodzajPojazdu;
    }

    @SneakyThrows
    public void insert(){
        JDBC.update("INSERT INTO Zlecenie VALUES('"+id+"','"+kontrahent.id+"','"+data+"','"+adres+"','"+status+"','"+cena+"','"+rodzajPojazdu.id+"')");
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

    public int getCena() {
        return cena;
    }

    public RodzajPojazdu getRodzajPojazdu() {
        return rodzajPojazdu;
    }

    @SneakyThrows
    public void setKontrahent(Kontrahent kontrahent) {
        this.kontrahent = kontrahent;
        String sql = "UPDATE ZLECENIE SET IDKONTRAHENTA = \'"+kontrahent.id+"\' WHERE IDZLECENIA = "+id;
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
        System.out.println(status);
        if(status.equals("zaakceptowany")){
            sql = "INSERT INTO Pojazd Values (pojazdyID.nextVal,'"+rodzajPojazdu.id+"','"+id+"','W trakcie budowy')";
            System.out.println(sql);
            bazaUpdate(sql);
            sql = "select max(IDPOJAZDU) id from POJAZD";
            ArrayList<String> el = new ArrayList<>();
            el.add("id");
            JSONObject jo = JDBC.select("sekwencja",el,sql);
            JSONArray ja = jo.getJSONArray("sekwencja");
            jo = ja.getJSONObject(0);
            int lastID = jo.getInt("id");
            PojazdFactory lekkiPojazdFactory = new LekkiPojazdFactory();
            Pojazd nowyPojazd = lekkiPojazdFactory.createPojazd(lastID,this,"W trakcie budowy",kontrahent,rodzajPojazdu);
            SystemData.pojazdy.put(lastID, nowyPojazd);
            String[] zadania = new String[8];
            zadania[0]="Montaż karoserii";
            zadania[1]="Montaż silnika";
            zadania[2]="Instalacja systemu alarmowego";
            zadania[3]="Montaż wyposażenia";
            zadania[4]="Przegląd techniczny";
            zadania[5]="Montaż podwozia";
            zadania[6]="Instalacja elektryczna";
            zadania[7]="Montaż kabiny kierowcy";
            sql = "SELECT TO_CHAR (SYSDATE, 'YYYY-MM-DD') \"NOW\" FROM DUAL";
            el.clear();
            el.add("NOW");
            jo = JDBC.select("czas",el,sql);
            ja = jo.getJSONArray("czas");
            jo = ja.getJSONObject(0);
            String data = jo.getString("NOW");
            Pracownik p = new Pracownik(0,"Brak","Brak","Brak","Brak");
            Random rand = new Random();
            Object[] keys = SystemData.kierownicy.keySet().toArray();
            Kierownik k = SystemData.kierownicy.get(0);
            for (Integer key : SystemData.kierownicy.keySet())
                if(key!=0)
                    if(SystemData.kierownicy.get(key).getStatus().equals("Wolny")) {
                        SystemData.kierownicy.get(key).setStatus("Zajety");
                        k = SystemData.kierownicy.get(key);
                        break;
                    }
            for(int i=0;i<8;i++) {
                if(k.id!=0)
                    sql = "INSERT INTO Zadanie Values (zadaniaID.nextVal,'" + lastID + "',null,'"+data+"','"+zadania[i]+"','Nie przydzielono',"+k.id+")";
                else
                    sql = "INSERT INTO Zadanie Values (zadaniaID.nextVal,'" + lastID + "',null,'"+data+"','"+zadania[i]+"','Nie przydzielono',null)";

                System.out.println(sql);
                JDBC.update(sql);
                sql = "select max(IDPOJAZDU) id from POJAZD";
                el.clear();
                el.add("id");
                jo = JDBC.select("sekwencja",el,sql);
                ja = jo.getJSONArray("sekwencja");
                jo = ja.getJSONObject(0);
                int lastIDZad = jo.getInt("id");
                String stat = "Nie przypisano";
                if(k.id!=0)
                    stat = "Nie przydzielono";
                Zadanie zadanie = new Zadanie(lastIDZad,nowyPojazd,p,data,zadania[i],stat,k);
                SystemData.zadania.put(lastIDZad, zadanie);
            }
        }


    }
    @SneakyThrows
    public void setCena(int cena) {
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
    @SneakyThrows
    public JSONObject toJSON(){
        JSONObject jo = new JSONObject();
        jo.put("zlecenieid",id);
        jo.put("kontrahent",kontrahent.id);
        jo.put("data",data);
        jo.put("adres",adres);
        jo.put("status",status);
        jo.put("cena",cena);
        jo.put("rodzajPojazdu",rodzajPojazdu.nazwa);
        System.out.println(jo.toString());
        return jo;
    }
}
