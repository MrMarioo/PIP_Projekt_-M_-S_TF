package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.ArrayList;

public class Testing {
    @Test
    public void testZespoly(){
        /*Kierownik kier1 = new Kierownik(3,"0Jan", "Jan","Kierownik","Dostepny");
        Pracownik p1 = new Pracownik(2,kier1, "0Jan", "Jan", "Pracownik", "Dostepny");
        System.out.println(p1);

        p1.setImie("Dostepny");
        System.out.println(p1);
        ArrayList<String> el = new ArrayList<>();
        el.add("Imie");
        //JSONObject jo = JDBC.select("Uzytkownik",el,"select * from Uzytkownik");
        Zlecenie z1 = new Zlecenie(1,1,"2022-10-11","poziomkowa 14","Zatwierdzono", 1500.5D,2);
        System.out.println(z1);
        z1.setAdres("Kalinowa 13");
        System.out.println(z1);
        Kontrahent k1 = new Kontrahent(1,"SP Daleszyce", "Piotr", "Piotrowski");
        Pojazd poj = new Pojazd(1, z1, "dostepny",k1);
        Zadanie zad = new Zadanie(1,poj,p1,"2022-10-11","Opis","W trakcie",p1);
        System.out.println(zad);*/
        
        SystemData systemData = new SystemData();
        systemData.selectRodzPoj();
        systemData.selectKontrahenci();
        systemData.selectZlecenia();
        systemData.selectKierownicy();
        systemData.selectPracownicy();
        for (Integer key : systemData.pracownicy.keySet()){
            System.out.println(systemData.pracownicy.get(key));
        }
        systemData.createZespoly();
        for (Integer key : systemData.pracownicy.keySet()){
            System.out.println(systemData.pracownicy.get(key));
        }
    }
}
