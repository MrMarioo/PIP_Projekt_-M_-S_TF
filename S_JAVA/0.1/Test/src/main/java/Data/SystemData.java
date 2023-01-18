package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SystemData {
    public Map<Integer,Pracownik> pracownicy = new HashMap<>();
    public Map<Integer,Kierownik> kierownicy = new HashMap<>();
    public Map<Integer,Kontrahent> kontrahenci = new HashMap<>();
    public Map<Integer,Pojazd> pojazdy = new HashMap<>();
    public Map<Integer,Zadanie> zadania = new HashMap<>();
    public Map<Integer,Awaria> awarie = new HashMap<>();
    public Map<Integer,Zlecenie> zlecenia = new HashMap<>();
    public Map<Integer,RodzajPojazdu> rodzajePojazdow = new HashMap<>();
    public Map<Integer,Integer> zespoly = new HashMap<>();
    @SneakyThrows//dziala
    public void selectKierownicy(){
        String sql = "SELECT IDPRACOWNIKA, IMIE, NAZWISKO, NAZWA as TYP, STATUS FROM PRACOWNIK INNER JOIN UZYTKOWNIK ON UZYTKOWNIKID = IDUZYTKOWNIKA INNER JOIN TYPKONTA ON TYPKONTAID = IDTYPKONTA WHERE TYPKONTAID = 2";
        ArrayList<String> el = new ArrayList<>();
        el.add("IDPRACOWNIKA");
        el.add("IMIE");
        el.add("NAZWISKO");
        el.add("TYP");
        el.add("STATUS");
        JSONObject jo = JDBC.select("Kierownicy",el,sql);
        JSONArray ja = jo.getJSONArray("Kierownicy") ;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonObject = ja.getJSONObject(i);
            //Kierownik(int id, String imie, String nazwisko, String typ, String status)
            Kierownik p = new Kierownik(jsonObject.getInt("IDPRACOWNIKA"),
                    jsonObject.getString("IMIE"),
                    jsonObject.getString("NAZWISKO"),
                    jsonObject.getString("TYP"),
                    jsonObject.getString("STATUS"));
            kierownicy.put(jsonObject.getInt("IDPRACOWNIKA"),p);
        }
    }

    @SneakyThrows//dziala
    public void selectPracownicy(){
        String sql = "SELECT IDPRACOWNIKA, KIEROWNIKID, NAZWA as TYP, STATUS, IMIE, NAZWISKO FROM PRACOWNIK INNER JOIN UZYTKOWNIK ON UZYTKOWNIKID = IDUZYTKOWNIKA INNER JOIN TYPKONTA ON TYPKONTAID = IDTYPKONTA WHERE TYPKONTAID IN (3,4,5)";
        ArrayList<String> el = new ArrayList<>();
        el.add("IDPRACOWNIKA");
        el.add("KIEROWNIKID");
        el.add("TYP");
        el.add("STATUS");
        el.add("IMIE");
        el.add("NAZWISKO");
        JSONObject jo = JDBC.select("Pracownicy",el,sql);
        JSONArray ja = jo.getJSONArray("Pracownicy") ;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonObject = ja.getJSONObject(i);
            Pracownik p;
            if(jsonObject.getString("KIEROWNIKID")=="null")
                 p = new Pracownik(jsonObject.getInt("IDPRACOWNIKA"),
                        jsonObject.getString("IMIE"),
                        jsonObject.getString("NAZWISKO"),
                        jsonObject.getString("TYP"),
                        jsonObject.getString("STATUS"));
            else
                p = new Pracownik(jsonObject.getInt("IDPRACOWNIKA"),
                        kierownicy.get(jsonObject.getInt("KIEROWNIKID")),
                        jsonObject.getString("IMIE"),
                        jsonObject.getString("NAZWISKO"),
                        jsonObject.getString("TYP"),
                        jsonObject.getString("STATUS"));
            pracownicy.put(jsonObject.getInt("IDPRACOWNIKA"),p);
        }
    }

    @SneakyThrows//dziala
    public void selectKontrahenci(){
        String sql = "SELECT IDKONTRAHENTA, NAZWA, IMIE, NAZWISKO FROM KONTRAHENT INNER JOIN UZYTKOWNIK ON UZYTKOWNIKID = IDUZYTKOWNIKA";
        ArrayList<String> el = new ArrayList<>();
        el.add("IDKONTRAHENTA");
        el.add("NAZWA");
        el.add("IMIE");
        el.add("NAZWISKO");
        JSONObject jo = JDBC.select("Kontrahenci",el,sql);
        JSONArray ja = jo.getJSONArray("Kontrahenci") ;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonObject = ja.getJSONObject(i);
            Kontrahent p = new Kontrahent(jsonObject.getInt("IDKONTRAHENTA"),
                    jsonObject.getString("NAZWA"),
                    jsonObject.getString("IMIE"),
                    jsonObject.getString("NAZWISKO"));
            kontrahenci.put(jsonObject.getInt("IDKONTRAHENTA"),p);
        }
    }
    @SneakyThrows//dziala
    public void selectRodzPoj(){
        String sql = "SELECT IDRODZAJPOJAZDU, NAZWA, OPIS FROM RODZAJPOJAZDU";
        ArrayList<String> el = new ArrayList<>();
        el.add("IDRODZAJPOJAZDU");
        el.add("NAZWA");
        el.add("OPIS");
        JSONObject jo = JDBC.select("RodzPoj",el,sql);
        JSONArray ja = jo.getJSONArray("RodzPoj") ;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonObject = ja.getJSONObject(i);
            //RodzajPojazdu(int id, String opis, String nazwa)
            RodzajPojazdu p = new RodzajPojazdu(jsonObject.getInt("IDRODZAJPOJAZDU"),
                    jsonObject.getString("OPIS"),
                    jsonObject.getString("NAZWA"));
            rodzajePojazdow.put(jsonObject.getInt("IDRODZAJPOJAZDU"),p);
        }
    }
    @SneakyThrows
    public void selectPojazdy(){
        String sql = "SELECT IDPRACOWNIKA, KIEROWNIKID, NAZWA, STATUS, IMIE, NAZWISKO FROM PRACOWNIK INNER JOIN UZYTKOWNIK ON UZYTKOWNIKID = IDUZYTKOWNIKA INNER JOIN TYPKONTA ON TYPKONTAID = IDTYPKONTA WHERE TYPKONTAID IN (5,6)";
        ArrayList<String> el = new ArrayList<>();
        el.add("IDPOJAZDU");
        el.add("ZLECENIEID");
        el.add("STATUS");
        el.add("KONTRAHENTID");
        JSONObject jo = JDBC.select("Pojazdy",el,sql);
        JSONArray ja = jo.getJSONArray("Pojazdy") ;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonObject = ja.getJSONObject(i);
            //Pojazd(int id, Zlecenie zlecenie, String status, Kontrahent kontrahent)
            /*Pojazd p = new Pojazd(jsonObject.getInt("IDPRACOWNIKA"),
                    kierownicy.get(jsonObject.getInt("KIEROWNIKID")),
                    jsonObject.getString("IMIE"),
                    jsonObject.getString("NAZWISKO"),
                    jsonObject.getString("TYP"),
                    jsonObject.getString("STATUS"));
            pojazdy.put(jsonObject.getInt("IDPPRACOWNIKA"),p);*/
        }
    }
    @SneakyThrows
    public void selectZadania(){
        String sql = "SELECT IDKONTRAHENTA, NAZWA, IMIE, NAZWISKO FROM KONTRAHENT INNER JOIN UZYTKOWNIK ON UZYTKOWNIKID = IDUZYTKOWNIKA";
        ArrayList<String> el = new ArrayList<>();
        el.add("IDKONTRAHENTA");
        el.add("NAZWA");
        el.add("IMIE");
        el.add("NAZWISKO");
        JSONObject jo = JDBC.select("Kontrahenci",el,sql);
        JSONArray ja = jo.getJSONArray("Kontrahenci") ;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonObject = ja.getJSONObject(i);
            Kontrahent p = new Kontrahent(jsonObject.getInt("IDKONTRAHENTA"),
                    jsonObject.getString("NAZWA"),
                    jsonObject.getString("IMIE"),
                    jsonObject.getString("NAZWISKO"));
            kontrahenci.put(jsonObject.getInt("IDKONTRAHENTA"),p);
        }
    }
    @SneakyThrows
    public void selectAwarie(){
        String sql = "SELECT IDKONTRAHENTA, NAZWA, IMIE, NAZWISKO FROM KONTRAHENT INNER JOIN UZYTKOWNIK ON UZYTKOWNIKID = IDUZYTKOWNIKA";
        ArrayList<String> el = new ArrayList<>();
        el.add("IDKONTRAHENTA");
        el.add("NAZWA");
        el.add("IMIE");
        el.add("NAZWISKO");
        JSONObject jo = JDBC.select("Kontrahenci",el,sql);
        JSONArray ja = jo.getJSONArray("Kontrahenci") ;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonObject = ja.getJSONObject(i);
            Kontrahent p = new Kontrahent(jsonObject.getInt("IDKONTRAHENTA"),
                    jsonObject.getString("NAZWA"),
                    jsonObject.getString("IMIE"),
                    jsonObject.getString("NAZWISKO"));
            kontrahenci.put(jsonObject.getInt("IDKONTRAHENTA"),p);
        }
    }
    @SneakyThrows//dziala
    public void selectZlecenia(){
        String sql = "SELECT IDZLECENIA, IDKONTRAHENTA, DATA, ADRES, STATUS, CENA, RODZAJPOJAZDUID FROM ZLECENIE INNER JOIN KONTRAHENT ON kontrahent.uzytkownikid = ZLECENIE.uzytkownikid";
        ArrayList<String> el = new ArrayList<>();
        el.add("IDZLECENIA");
        el.add("IDKONTRAHENTA");
        el.add("DATA");
        el.add("ADRES");
        el.add("STATUS");
        el.add("CENA");
        el.add("RODZAJPOJAZDUID");
        JSONObject jo = JDBC.select("Zlecenia",el,sql);
        JSONArray ja = jo.getJSONArray("Zlecenia") ;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonObject = ja.getJSONObject(i);
            //public Zlecenie(int id, Kontrahent kontrahent, String data, String adres, String status, double cena, String rodzajPojazdu)
            Zlecenie p = new Zlecenie(jsonObject.getInt("IDZLECENIA"),
                    kontrahenci.get(jsonObject.getInt("IDKONTRAHENTA")),
                    jsonObject.getString("DATA"),
                    jsonObject.getString("ADRES"),
                    jsonObject.getString("STATUS"),
                    jsonObject.getDouble("CENA"),
                    rodzajePojazdow.get(jsonObject.getInt("RODZAJPOJAZDUID")));
            zlecenia.put(jsonObject.getInt("IDZLECENIA"),p);
        }
    }
    @SneakyThrows
    public void createZespoły(){
        for (Integer key : kierownicy.keySet())
            zespoly.put(kierownicy.get(key).id,0);
        for (Integer key : pracownicy.keySet())
            pracownicy.get(key).deleteKierownik();
        for (Integer key : pracownicy.keySet()){
                for (Integer key1 : zespoly.keySet())
                    if(zespoly.get(key1)<5){
                        pracownicy.get(key).setKierownikID(kierownicy.get(key1));
                        int buff = zespoly.get(key1);
                        zespoly.replace(key1, buff+1);
                        break;
                    }
        }

    }


}
