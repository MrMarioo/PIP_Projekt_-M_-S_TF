package main.java.testyJednostkowe;

import Data.*;
import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class KierownikTest {
    @Test
    public void testSetNazwisko(){
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        kierownik.setNazwisko("NoweNazwisko");
        assertEquals("NoweNazwisko", kierownik.getNazwisko());
    }
    @Test
    public void testSetTyp(){
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        kierownik.setTyp("NowyTyp");
        assertEquals("NowyTyp", kierownik.getTyp());
    }
}
