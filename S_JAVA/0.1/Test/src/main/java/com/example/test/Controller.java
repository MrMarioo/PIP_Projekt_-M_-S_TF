package com.example.test;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import static com.example.test.Details.Data;

@RestController
@CrossOrigin
public class Controller {

    // Handling post request
    @PostMapping("/Login")
    Map<String, Integer> insert(@RequestBody Details ob) throws JSONException, SQLException {
        Vector<JSONObject> data = JDBC.testQuery("1", "SELECT HASLO, LOGIN FROM UZYTKOWNIK WHERE LOGIN = '" + ob.login + "' ");

        // Storing the incoming data in the list
        Data.add(new Details(ob.login, ob.passwd));

        // Iterating using foreach loop
        System.out.println(data.get(0));
        HashMap<String, Integer> map = new HashMap<>();
        map.put("isLogged", 1);
        return map;
    }

    @PostMapping("/Registration")
    @ResponseBody
    Map<String, String> registration(@RequestBody Details ob) throws JSONException, SQLException {
        Vector<JSONObject> data = JDBC.testQuery("1", "SELECT IMIE, NAZWISKO FROM UZYTKOWNIK WHERE LOGIN = '" + ob.login + "' ");

        // Storing the incoming data in the list
        Data.add(new Details(ob.login, ob.passwd));

        // Iterating using foreach loop
        System.out.println(data.get(0));
        HashMap<String, String> map = new HashMap<>();
        map.put("i", "2");
        map.put("Imie1", "Jan");
        map.put("Nazwisko1", "Adamski");
        map.put("Imie2", "Piotr");
        map.put("Nazwisko2", "Tokarski");
        return map;
    }


    @PostMapping("/Pracownik/{id}")
    @ResponseBody
    Map<String, String> pracownikID(@RequestBody Details ob, @PathVariable("id") Integer id) throws JSONException, SQLException
    {
        System.out.println(id);
        return null;
    }

    @PostMapping("/Pracownicy")
    @ResponseBody
    Map<String, String> pracownikID(@RequestBody Details ob) throws JSONException, SQLException
    {
        Vector<JSONObject> data = JDBC.testQuery("1", "SELECT IMIE, NAZWISKO FROM UZYTKOWNIK WHERE LOGIN = '" + ob.login + "' ");
        return null;
    }

}