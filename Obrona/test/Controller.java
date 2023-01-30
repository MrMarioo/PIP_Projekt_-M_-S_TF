package com.example.test;

import Data.*;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.testng.internal.collections.Pair;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import static com.example.test.Details.Data;

@RestController
@CrossOrigin
public class Controller {

    @PostMapping("/Login/{login}/{haslo}")//dziala
    String registration(@PathVariable("login") String login,@PathVariable("haslo") String haslo) throws JSONException, SQLException {
        ArrayList el = new ArrayList<>();
        el.add("login");
        el.add("haslo");

        JSONObject data = JDBC.select("pass",el, "SELECT login, haslo FROM UZYTKOWNIK");
        JSONArray ja = data.getJSONArray("pass");
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonObject = ja.getJSONObject(i);
            System.out.println(jsonObject.getString("login"));
            System.out.println(login);
            if(jsonObject.getString("login").equals(login)) {
                if (jsonObject.getString("haslo").equals(haslo))
                    return "{\"Status\":\"Logged\"}";
                else
                    return "{\"Status\":\"Bad Password\"}";
            }
        }
        return "{\"Status\":\"Bad Login\"}";
    }

    @PostMapping("/Main")//dziala
    String statystyka() throws JSONException, SQLException {
        ArrayList el = new ArrayList<>();
        el.add("tab");
        el.add("il");

        SystemData.selectRodzPoj();
        SystemData.selectKontrahenci();
        SystemData.selectZlecenia();
        SystemData.selectPojazdy();
        SystemData.selectAwarie();
        SystemData.selectPracownicy();
        SystemData.selectKierownicy();
        SystemData.selectZadania();

        SystemData.createZespoly();
        return "{\"Status\":\"Done\"}";
    }
    @PostMapping("/Pracownik/{id}")
    String pracownik(@PathVariable("id") int id) throws JSONException, SQLException
    {
        JSONObject jo = SystemData.pracownicy.get(id).toJSON();
        System.out.println(jo.toString());
        return jo.toString();
    }

    @PostMapping("/Pracownik/Usun/{id}")
    String pracownikUsun(@PathVariable("id") int id) throws JSONException, SQLException
    {
        SystemData.pracownicy.get(id).setStatus("Zwolniony");
        return "{\"Status\":\"Deleted\"}";
    }
    @PostMapping("/Kierownik/Usun/{id}")
    String kierownikUsun(@PathVariable("id") int id) throws JSONException, SQLException
    {
        SystemData.kierownicy.get(id).setStatus("Zwolniony");
        Kierownik k = SystemData.kierownicy.get(0);
        for (Integer key : SystemData.kierownicy.keySet()){

            if(SystemData.kierownicy.get(key).getStatus().equals("Wolny"))
            {
                k=SystemData.kierownicy.get(key);
                break;
            }
        }

        for (Integer key : SystemData.zadania.keySet()){
            if(SystemData.zadania.get(key).getKierownik().getId()==id)
                if(!SystemData.zadania.get(key).getStatus().equals("Wykonano")){
                    SystemData.zadania.get(key).setKierownik(SystemData.kierownicy.get(0));
                    if(k.getId()!=0)
                        SystemData.zadania.get(key).setKierownik(SystemData.kierownicy.get(k.getId()));
            }
        }
        for (Kierownik key : SystemData.zespolyPracownicy.keySet()){
            if(key.getId()==id) {
                for (Pracownik pracownik : SystemData.zespolyPracownicy.get(key)) {
                    pracownik.setKierownikID(SystemData.kierownicy.get(0));
                }
                SystemData.zespolyPracownicy.get(key).clear();
                SystemData.createZespoly();
                break;
            }
        }
        return "{\"Status\":\"Deleted\"}";
    }

    @PostMapping("/Pracownicy")
    String pracownicy() throws JSONException, SQLException
    {
        JSONArray ja = new JSONArray();
        for (Integer key : SystemData.pracownicy.keySet()){
           ja.put(SystemData.pracownicy.get(key).toJSON());
        }
        JSONObject jo = new JSONObject();
        jo.put("pracownicy",ja);
        System.out.println(jo.toString());
        return jo.toString();
    }
    @PostMapping("/Pracownik/Update/{id}/{data}/{label}")
    String pracownicyUpdate(@PathVariable("id") int id, @PathVariable("data") String data,@PathVariable("label") String label) throws JSONException, SQLException
    {
        System.out.println(data);
        switch(label){
        case "Imie":
            SystemData.pracownicy.get(id).setImie(data);
            break;
        case "Nazwisko":
            SystemData.pracownicy.get(id).setNazwisko(data);
            break;
        case "Kierownik":
            SystemData.pracownicy.get(id).setKierownikID(SystemData.kierownicy.get(Integer.parseInt(data)));
            break;
        };
        return "{\"Status\":\"Updated\"}";
    }

    @PostMapping("/Kierownicy")
    String kierownicy() throws JSONException, SQLException
    {
        JSONArray ja = new JSONArray();
        for (Integer key : SystemData.kierownicy.keySet()){
            ja.put(SystemData.kierownicy.get(key).toJSON());
        }
        JSONObject jo = new JSONObject();
        jo.put("kierownicy",ja);
        System.out.println(jo.toString());
        return jo.toString();
    }
    @PostMapping("/Kierownik/Update/{id}/{data}/{label}")
    String kierownicyUpdate(@PathVariable("id") int id, @PathVariable("data") String data,@PathVariable("label") String label) throws JSONException, SQLException
    {
        System.out.println(data);
        switch(label){
            case "Imie":
                SystemData.kierownicy.get(id).setImie(data);
                break;
            case "Nazwisko":
                SystemData.kierownicy.get(id).setNazwisko(data);
                break;
        };
        return "{\"Status\":\"Updated\"}";
    }
    @PostMapping("/Kierownik/{id}")
    String kierownik(@PathVariable("id") int id) throws JSONException, SQLException
    {
        JSONObject jo = SystemData.kierownicy.get(id).toJSON();
        System.out.println(jo.toString());
        return jo.toString();
    }

    @PostMapping("/Pojazdy")
    String pojazdy() throws JSONException, SQLException
    {
        JSONArray ja = new JSONArray();
        for (Integer key : SystemData.pojazdy.keySet()){
            ja.put(SystemData.pojazdy.get(key).toJSON());
        }
        JSONObject jo = new JSONObject();
        jo.put("pojazdy",ja);
        System.out.println(jo.toString());
        return jo.toString();
    }
    @PostMapping("/Pojazd/{id}")
    String getPojazd(@PathVariable("id") int id) throws JSONException, SQLException
    {
        JSONObject jo = SystemData.pojazdy.get(id).toJSON();
        System.out.println(jo.toString());
        return jo.toString();
    }
    @PostMapping("/Zlecenia")
    String zlecenia() throws JSONException, SQLException
    {
        JSONArray ja = new JSONArray();
        for (Integer key : SystemData.zlecenia.keySet()){
            ja.put(SystemData.zlecenia.get(key).toJSON());
        }
        JSONObject jo = new JSONObject();
        jo.put("zlecenia",ja);
        System.out.println(jo.toString());
        return jo.toString();
    }
    @PostMapping("/Zlecenie/{id}")
    String getZlecenie(@PathVariable("id") int id) throws JSONException, SQLException
    {
        JSONObject jo = SystemData.zlecenia.get(id).toJSON();
        System.out.println(jo.toString());
        return jo.toString();
    }
    @PostMapping("/Zlecenie/Change/{data}")
    String changeZlecenie(@PathVariable("data") String data) throws JSONException, SQLException
    {
        System.out.println("Siema");
        JSONObject json = new JSONObject(data);
        int id = json.getInt("ID");
        String state = json.getString("STATE");
        SystemData.zlecenia.get(id).setStatus(state);
        SystemData.selectZadania();
        return "{\"Status\":\"Updated\"}";
    }
    @PostMapping("/Zlecenie/Insert/{data}")
    String insertZlecenie(@PathVariable("data") String data) throws JSONException, SQLException
    {
        JSONObject json = new JSONObject(data);
        String idKontrahenta = json.getString("kId");
        String adres = json.getString("adres");
        String cena = json.getString("cena");
        cena = cena.replace('.',',');
        String idRodzajuPojazdu = json.getString("rPojazdu");
        String sql = "INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'"+idKontrahenta+"',(SELECT TO_CHAR (SYSDATE, 'YYYY-MM-DD') \"NOW\" FROM DUAL),'"+adres+"','w trakcie rozparzenia','"+cena+"','"+idRodzajuPojazdu+"')";
        System.out.println(sql);
        JDBC.update(sql);
        SystemData.selectZlecenia();
        return "{\"Status\":\"Dodano\"}";
    }
    @PostMapping("/Zlecenie/GetData")
    String getDataToCreateZlecenie() throws JSONException, SQLException
    {
        JSONArray ja = new JSONArray();
        JSONArray ja1 = new JSONArray();
        JSONArray res = new JSONArray();
        JSONObject jo = new JSONObject();
        JSONObject jo1 = new JSONObject();
        JSONObject jo2 = new JSONObject();
        for (Integer key : SystemData.kontrahenci.keySet()){
            ja.put(SystemData.kontrahenci.get(key).toJSON());
        }
        jo.put("kontrahenci",ja);
        res.put(jo);
        for (Integer key : SystemData.rodzajePojazdow.keySet()){
            ja1.put(SystemData.rodzajePojazdow.get(key).toJSON());
        }
        jo1.put("rodzajePojazdow",ja1);
        res.put(jo1);
        jo2.put("data",res);
        System.out.println(jo2.toString());
        return jo2.toString();
    }
    @PostMapping("/Zadania")
    String zadania() throws JSONException, SQLException
    {
        JSONArray ja = new JSONArray();
        for (Integer key : SystemData.zadania.keySet()){
            ja.put(SystemData.zadania.get(key).toJSON());
        }
        JSONObject jo = new JSONObject();
        jo.put("zadania",ja);
        System.out.println(jo.toString());
        return jo.toString();
    }
    @PostMapping("/Zadanie/{id}")
    String zadanie(@PathVariable("id") int id) throws JSONException, SQLException
    {
        JSONObject jo = SystemData.zadania.get(id).toJSON();
        System.out.println(jo.toString());
        return jo.toString();
    }
    @PostMapping("/Zadanie/Pracownicy/{id}")
    String dostPracownicy(@PathVariable("id") int id) throws JSONException, SQLException
    {
        JSONArray ja = new JSONArray();
        for (Pracownik pracownik :SystemData.zespolyPracownicy.get(SystemData.zadania.get(id).getKierownik())) {
            ja.put(pracownik.toJSON());
        }
        JSONObject jo = new JSONObject();
        jo.put("Pracownicy",ja);
        System.out.println(jo.toString());
        return jo.toString();
    }
    @PostMapping("/Zadanie/Pracownicy/Zatwierdz/{id}/{pracid}")
    String ZadanieZmienPrac(@PathVariable("id") int id, @PathVariable("pracid") String pracid) throws JSONException, SQLException
    {
        Pracownik p = SystemData.zadania.get(id).getPracownik();
        boolean wolny = true;
        for (Integer key : SystemData.zadania.keySet()){
            if(SystemData.zadania.get(key).getPracownik().getId()==p.getId())
                if(SystemData.zadania.get(key).getStatus().equals("W trakcie")) {
                    wolny = false;
                    break;
                }
        }
        SystemData.zadania.get(id).setPracownik(SystemData.pracownicy.get(Integer.parseInt(pracid)));
        if(wolny)
            SystemData.zadania.get(id).getPracownik().setStatus("Wolny");
        return "{\"Status\":\"Updated\"}";
    }
    @PostMapping("/Zadanie/Wykonaj/{id}")
    String zadanieZakoncz(@PathVariable("id") int id) throws JSONException, SQLException
    {
        SystemData.zadania.get(id).setStatus("Wykonano");
        return "{\"Status\":\"Updated\"}";
    }
    @PostMapping("/Zadania/Rozdziel")
    String zadaniaRozdiel() throws JSONException, SQLException
    {
        System.out.println("Siema");
        SystemData.przydzielZadania();
        return "{\"Status\":\"Done\"}";
    }
    @PostMapping("/Zespoły")
    String zespoly() throws JSONException, SQLException
    {
        JSONArray ja = new JSONArray();
        for (Kierownik key : SystemData.zespolyPracownicy.keySet()){
            ja.put(key.toJSON());
            for (Pracownik pracownik : SystemData.zespolyPracownicy.get(key)) {
                ja.put(pracownik.toJSON());;
            }
        }
        JSONObject jo = new JSONObject();
        jo.put("zespoly",ja);
        System.out.println(jo.toString());
        return jo.toString();
    }

}
