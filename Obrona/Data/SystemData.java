package Data;

import Data.PojazdFactory.LekkiPojazdFactory;
import Data.PojazdFactory.PojazdFactory;
import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SystemData {
    public static Map<Integer,Pracownik> pracownicy = new HashMap<>();
    public static Map<Integer,Kierownik> kierownicy = new HashMap<>();
    public static Map<Integer,Kontrahent> kontrahenci = new HashMap<>();
    public static Map<Integer,Pojazd> pojazdy = new HashMap<>();
    public static Map<Integer,Zadanie> zadania = new HashMap<>();
    public static Map<Integer,Awaria> awarie = new HashMap<>();
    public static Map<Integer,Zlecenie> zlecenia = new HashMap<>();
    public static Map<Integer,RodzajPojazdu> rodzajePojazdow = new HashMap<>();
    public static Map<Kierownik,ArrayList<Pracownik>> zespolyPracownicy = new HashMap<>();
    @SneakyThrows//dziala
    public static void selectKierownicy(){
        kierownicy.clear();
        kierownicy.put(0,new Kierownik(0,"brak","brak","brak","brak"));
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
    public static void selectPracownicy(){
        pracownicy.clear();
        pracownicy.put(0,new Pracownik(0,kierownicy.get(0),"brak","brak","brak","brak"));
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
            if(jsonObject.getString("KIEROWNIKID").equals("null"))
                 p = new Pracownik(jsonObject.getInt("IDPRACOWNIKA"),
                         kierownicy.get(0),
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
    public static void selectKontrahenci(){
        kontrahenci.clear();
        kontrahenci.put(0,new Kontrahent(0,"brak","brak","brak"));
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
    public static void selectRodzPoj(){
        rodzajePojazdow.clear();
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
    @SneakyThrows//dziala
    public static void selectPojazdy(){
        pojazdy.clear();
        String sql = "SELECT IDPOJAZDU, RODZAJID, ZLECENIEID, KONTRAHENTID, POJAZD.STATUS FROM POJAZD INNER JOIN ZLECENIE ON ZLECENIEID=IDZLECENIA";
        ArrayList<String> el = new ArrayList<>();
        el.add("IDPOJAZDU");
        el.add("RODZAJID");
        el.add("ZLECENIEID");
        el.add("KONTRAHENTID");
        el.add("STATUS");
        JSONObject jo = JDBC.select("Pojazdy",el,sql);
        JSONArray ja = jo.getJSONArray("Pojazdy") ;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonObject = ja.getJSONObject(i);
            //Pojazd(int id, Zlecenie zlecenie, String status, Kontrahent kontrahent)
            PojazdFactory lekkiPojazdFactory = new LekkiPojazdFactory();
            Pojazd p = lekkiPojazdFactory.createPojazd(jsonObject.getInt("IDPOJAZDU"),
                    zlecenia.get(jsonObject.getInt("ZLECENIEID")),
                    jsonObject.getString("STATUS"),
                    kontrahenci.get(jsonObject.getInt("KONTRAHENTID")),
                    rodzajePojazdow.get(jsonObject.getInt("RODZAJID")));
            pojazdy.put(jsonObject.getInt("IDPOJAZDU"),p);
        }
    }
    @SneakyThrows
    public static void selectZadania(){
        //Zadanie(int id, Pojazd pojazd, Pracownik pracownik, String data, String opis, String status, Kierownik kierownik)
        zadania.clear();
        String sql = "Select IDZADANIA, POJAZDID, PRACOWNIKID, DATA, OPIS, STATUS, KIEROWNIKID  from zadanie";
        ArrayList<String> el = new ArrayList<>();
        el.add("IDZADANIA");
        el.add("POJAZDID");
        el.add("PRACOWNIKID");
        el.add("DATA");
        el.add("OPIS");
        el.add("STATUS");
        el.add("KIEROWNIKID");
        JSONObject jo = JDBC.select("Zadania",el,sql);
        JSONArray ja = jo.getJSONArray("Zadania");
        Zadanie z;
        Pracownik p;
        Kierownik k;
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonObject = ja.getJSONObject(i);
            if(jsonObject.getString("PRACOWNIKID").equals("null"))
                p = SystemData.pracownicy.get(0);
            else
                p =pracownicy.get(jsonObject.getInt("PRACOWNIKID"));
            if(jsonObject.getString("KIEROWNIKID").equals("null"))
                k = SystemData.kierownicy.get(0);
            else
                k =kierownicy.get(jsonObject.getInt("KIEROWNIKID"));

            z = new Zadanie(jsonObject.getInt("IDZADANIA"),
                    pojazdy.get(jsonObject.getInt("POJAZDID")),
                    p,
                    jsonObject.getString("DATA"),
                    jsonObject.getString("OPIS"),
                    jsonObject.getString("STATUS"),
                    k);

            zadania.put(jsonObject.getInt("IDZADANIA"), z);
        }
    }
    @SneakyThrows
    public static void selectAwarie(){
        awarie.clear();
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
    public static void selectZlecenia(){
        zlecenia.clear();
        String sql = "SELECT IDZLECENIA, KONTRAHENTID, DATA, ADRES, STATUS, CENA, RODZAJPOJAZDUID FROM ZLECENIE";
        ArrayList<String> el = new ArrayList<>();
        el.add("IDZLECENIA");
        el.add("KONTRAHENTID");
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
                    kontrahenci.get(jsonObject.getInt("KONTRAHENTID")),
                    jsonObject.getString("DATA"),
                    jsonObject.getString("ADRES"),
                    jsonObject.getString("STATUS"),
                    jsonObject.getInt("CENA"),
                    rodzajePojazdow.get(jsonObject.getInt("RODZAJPOJAZDUID")));
            zlecenia.put(jsonObject.getInt("IDZLECENIA"),p);
        }
    }
    @SneakyThrows
    public static void createZespoly(){
        zespolyPracownicy.clear();
        Map<Integer,Integer> zespoly = new HashMap<>();
        int pSize = pracownicy.size()-1;
        int kSize = kierownicy.size()-1;
        for (Integer key : kierownicy.keySet())
            if(key!=0) {
                if(kierownicy.get(key).getStatus().equals("Zwolniony"))
                    kSize--;
                else {
                    zespoly.put(kierownicy.get(key).id, 0);
                    zespolyPracownicy.put(kierownicy.get(key), new ArrayList<>());
                }
            }

        for (Integer key : pracownicy.keySet())
            if(key!=0) {
                if (pracownicy.get(key).getStatus().equals("Zwolniony"))
                    pSize--;
                else
                    pracownicy.get(key).deleteKierownik();
            }
        for (Integer key : pracownicy.keySet()){
                for (Integer key1 : zespoly.keySet())
                    if(zespoly.get(key1)<pSize/kSize) {
                        if (!pracownicy.get(key).getStatus().equals("Zwolniony") && pracownicy.get(key).getId() != 0 ) {
                            pracownicy.get(key).setKierownikID(kierownicy.get(key1));
                            zespolyPracownicy.get(kierownicy.get(key1)).add(pracownicy.get(key));
                            int buff = zespoly.get(key1);
                            zespoly.replace(key1, buff + 1);
                            break;
                        }
                    }
        }
    }
    @SneakyThrows
    public static void przydzielZadania() {
        for (Integer key : zadania.keySet())
            if(zadania.get(key).pracownik.id==0){
                Kierownik k = zadania.get(key).getKierownik();
                for (Integer key1 : pracownicy.keySet()){
                    if(pracownicy.get(key1).getId()!=0 && pracownicy.get(key1).getStatus().equals("Wolny")
                            && pracownicy.get(key1).getKierownik() == k){
                        //System.out.println("ELO");
                        zadania.get(key).setPracownik(pracownicy.get(key1));
                        zadania.get(key).setStatus("W trakcie");
                        pracownicy.get(key1).setStatus("Zajety");
                        break;
                    }
                }
            }
    }

    @SneakyThrows
    public static void sprawdzPojazd(Pojazd pojazd) {
        Kierownik kierownik = null;
        for (Integer key : zadania.keySet())
            if (zadania.get(key).pojazd.id == pojazd.id) {
                kierownik = zadania.get(key).getKierownik();
                if(zadania.get(key).status.equals("W trakcie"))
                    return;
            }
        pojazdy.get(pojazd.getId()).setStatus("Zakończono budowe");
        kierownicy.get(kierownik.getId()).setStatus("Wolny");
        przydzielZadaniaKierownik(kierownicy.get(kierownik.getId()));
    }

    @SneakyThrows
    public static void przydzielZadaniaKierownik(Kierownik kierownik) {
        if(!kierownik.getStatus().equals("Wolny"))
            return;
        Pojazd pojazd = null;
        for (Integer key : zadania.keySet())
            if (zadania.get(key).kierownik.getId() == 0) {
                pojazd = zadania.get(key).getPojazd();
                break;
            }
        if(pojazd==null)
            return;
        for (Integer key : zadania.keySet())
            if (zadania.get(key).pojazd.getId() == pojazd.getId())
                zadania.get(key).setKierownik(kierownicy.get(kierownik.getId()));

        kierownicy.get(kierownik.getId()).setStatus("Zajety");
    }

}
