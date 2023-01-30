package main.java.testyJednostkowe;

import Data.*;
import Data.PojazdFactory.CiezkiPojazdFactory;
import Data.PojazdFactory.LekkiPojazdFactory;
import Data.PojazdFactory.PojazdFactory;
import Data.PojazdFactory.SredniPojazdFactory;
import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ZadanieTest {
    @Test
    public void testSetStatus(){
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        Pracownik pracownik = new Pracownik(1, "PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        PojazdFactory sredniPojazdFactory = new SredniPojazdFactory();
        Pojazd pojazd = sredniPojazdFactory.createPojazd(1,zlecenie,"status",kontrahent,rodzajPojazdu);
        Zadanie zadanie = new Zadanie(1, pojazd, pracownik,"2022-9-10","opis", "status", kierownik);
        zadanie.setStatus("Test");
        assertEquals("Test", zadanie.getStatus());

    } 
    @Test
    public void testSetOpis(){
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        Pracownik pracownik = new Pracownik(1, "PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        PojazdFactory lekkiPojazdFactory = new LekkiPojazdFactory();
        Pojazd pojazd = lekkiPojazdFactory.createPojazd(1,zlecenie,"status",kontrahent,rodzajPojazdu);
        Zadanie zadanie = new Zadanie(1, pojazd, pracownik,"2022-9-10","opis", "status", kierownik);

        zadanie.setOpis("TestOpis");
        assertEquals("TestOpis", zadanie.getOpis());
    }
    @SneakyThrows
    @Test
    public void testSetPojazd(){
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        Pracownik pracownik = new Pracownik(1, "PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        PojazdFactory sredniPojazdFactory = new SredniPojazdFactory();
        PojazdFactory ciezkiPojazdFactory = new CiezkiPojazdFactory();
        Pojazd pojazd = sredniPojazdFactory.createPojazd(1,zlecenie,"status",kontrahent,rodzajPojazdu);
        Pojazd pojazd1 = ciezkiPojazdFactory.createPojazd(200,zlecenie,"status2",kontrahent,rodzajPojazdu);
        JDBC.update("INSERT INTO POJAZD VALUES(200,null,null,'status')");
        Zadanie zadanie = new Zadanie(1, pojazd, pracownik,"2022-9-10","opis", "status", kierownik);

        zadanie.setPojazd(pojazd1);
        assertEquals(pojazd1, zadanie.getPojazd());
        JDBC.update("DELETE FROM POJAZD where IDPOJAZDU = 200");
    }
    @SneakyThrows
    @Test
    public void testSetKierownik(){
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        Pracownik pracownik = new Pracownik(1, "PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        Kierownik kierownik2 = new Kierownik(100,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        Pracownik pracownik2 = new Pracownik(100, "PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");

        /*JDBC.update("INSERT INTO PRACOWNIK VALUES(100,null,'KierownikImie','KierownikNazwisko','KierownikTyp,'KierownikStatus')");
        JDBC.update("INSERT INTO KIEROWNIK VALUES(100,'KierownikImie','KierownikNazwisko','KierownikTyp,'KierownikStatus')");*/

        PojazdFactory ciezkiPojazdFactory = new CiezkiPojazdFactory();
        Pojazd pojazd = ciezkiPojazdFactory.createPojazd(1,zlecenie,"status",kontrahent,rodzajPojazdu);
        Zadanie zadanie = new Zadanie(1, pojazd, pracownik,"2022-9-10","opis", "status", kierownik);
        zadanie.setKierownik(kierownik2);
        assertEquals(kierownik2, zadanie.getKierownik());
    }

}