package testyJednostkowe;

import Data.Kontrahent;
import Data.RodzajPojazdu;
import Data.Zlecenie;
import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ZlecenieTest {
    @Test
    public void testSetAdres() {
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",0.5,rodzajPojazdu);
        zlecenie.setAdres("Test");
        assertEquals("Test", zlecenie.getAdres());
    }
    @Test
    public void testSetKontrahent() {
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        Kontrahent kontrahent1 = new Kontrahent(2,"KontrahentNazwa1","KontrahentImie1","KontrahentNazwisko1");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",0.5,rodzajPojazdu);
        zlecenie.setKontrahent(kontrahent1);
        assertEquals(kontrahent1, zlecenie.getKontrahent());
    }
    @Test
    public void testSetData() {
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",0.5,rodzajPojazdu);
        zlecenie.setData("2022-9-10");
        assertEquals("2022-9-10", zlecenie.getData());
    }
    @Test
    public void testSetStatus() {
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",0.5,rodzajPojazdu);
        zlecenie.setStatus("Test");
        assertEquals("Test", zlecenie.getStatus());
    }
    @Test
    public void testSetCena() {
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",0.5,rodzajPojazdu);
        zlecenie.setCena(1.5);
        assertEquals(1.5, zlecenie.getCena());
    }

}
