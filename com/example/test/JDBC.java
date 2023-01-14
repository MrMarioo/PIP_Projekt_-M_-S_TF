package com.example.test;

import Data.Pracownik;
import Data.SystemData;
import oracle.sql.json.OracleJsonObject;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class JDBC {

    public static Vector<JSONObject> testQuery(String id, String query) throws SQLException, JSONException {
        // - connect to baza
        String host = "127.0.0.1";
        int port = 1521;
        String database = "xe";
        String user = "system";
        String password = "1234";
        Controller controler;
        String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host + ":" + port + ":" + database;
        Connection connection = DriverManager.getConnection(url);
        int i = 0;
        Vector<JSONObject> data= new Vector<>();//w zalezności od tego co bedzie potrzebne z bazy trzeba bedzie zmieniac pojemnosc tej tablicy (albo najlepiej przerobic na wektor)
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ) {

            while (resultSet.next())
            {
                System.out.println(resultSet.getString(("IMIE")) + "  " + resultSet.getString(("NAZWISKO")));
                JSONObject jo = new JSONObject();
                jo.put("IMIE", String.valueOf(resultSet.getString("IMIE")));
                jo.put("NAZWISKO", resultSet.getString("NAZWISKO"));
                //System.out.println(jo);
                data.add(jo);

            }
            return data;
        }
    }

    public static void update(String query) throws SQLException, JSONException {
        String host = "127.0.0.1";
        int port = 1521;
        String database = "xe";
        String user = "system";
        String password = "1234";
        Controller controler;
        String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host + ":" + port + ":" + database;

        try(
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ) {
                statement.executeUpdate(query);
        }
    }

    public static JSONObject select(String tabName,ArrayList<String> elements, String query) throws SQLException, JSONException {
        String host = "127.0.0.1";
        int port = 1521;
        String database = "xe";
        String user = "system";
        String password = "1234";
        Controller controler;
        String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host + ":" + port + ":" + database;

        try (
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            JSONArray ja = new JSONArray();
            while (resultSet.next()) {
                JSONObject jo = new JSONObject();
                for (int i = 0; i < elements.size(); i++)
                    jo.put(elements.get(i), String.valueOf(resultSet.getString(elements.get(i))));
                ja.put(jo);
            }
            JSONObject mainObj = new JSONObject();
            mainObj.put(tabName, ja);
            String output = mainObj.toString();
            System.out.println(output);
            return mainObj;
        }
    }

}

