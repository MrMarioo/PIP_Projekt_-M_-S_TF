package main.java.testyJednostkowe;

import Data.*;
import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;


public class PracownikTest {
    @Test
    public void testSetImie(){
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        Pracownik pracownik = new Pracownik(1,kierownik, "PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");
        pracownik.setImie("NoweTestImie");
        assertEquals("NoweTestImie", pracownik.getImie());
    }
    @Test
    public void testSetStatus(){
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        Pracownik pracownik = new Pracownik(1, kierownik,"PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");
        pracownik.setStatus("NowyStatus");
        assertEquals("NowyStatus", pracownik.getStatus());
    }
}
