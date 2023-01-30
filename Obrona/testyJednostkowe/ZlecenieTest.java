package testyJednostkowe;

import Data.Kontrahent;
import Data.RodzajPojazdu;
import Data.SystemData;
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
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        zlecenie.setAdres("Test");
        assertEquals("Test", zlecenie.getAdres());
    }
    @Test
    public void testSetKontrahent() {
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        Kontrahent kontrahent1 = new Kontrahent(2,"KontrahentNazwa1","KontrahentImie1","KontrahentNazwisko1");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        zlecenie.setKontrahent(kontrahent1);
        assertEquals(kontrahent1, zlecenie.getKontrahent());
    }
    @Test
    public void testSetData() {
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        zlecenie.setData("2022-9-10");
        assertEquals("2022-9-10", zlecenie.getData());
    }
    @Test
    public void testSetStatus() {
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        zlecenie.setStatus("Test");
        assertEquals("Test", zlecenie.getStatus());
    }
    @Test
    public void testSetCena() {
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        zlecenie.setCena(1);
        assertEquals(1, zlecenie.getCena());
    }

    @SneakyThrows
    @Test
    public void testSetStatusZaakceptowano() {
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        kontrahent.insert(1);
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        rodzajPojazdu.insert();
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        zlecenie.insert();
        zlecenie.setStatus("Zaakceptowano");
        assertEquals("Zaakceptowano", zlecenie.getStatus());
        assertEquals(8, SystemData.zadania.size());
        String[] zadania = new String[8];
        zadania[0]="Montaż karoserii";
        zadania[1]="Montaż silnika";
        zadania[2]="Instalacja systemu alarmowego";
        zadania[3]="Montaż wyposażenia";
        zadania[4]="Przegląd techniczny";
        zadania[5]="Montaż podwozia";
        zadania[6]="Instalacja elektryczna";
        zadania[7]="Montaż kabiny kierowcy";
        int i=0;
        for (Integer key : SystemData.zadania.keySet()){
            assertEquals(zadania[i],SystemData.zadania.get(key).getOpis());
        }
        assertEquals(1, SystemData.pojazdy.size());
        for (Integer key : SystemData.pojazdy.keySet()){
            assertEquals(kontrahent,SystemData.pojazdy.get(key).getKontrahent());
            assertEquals(zlecenie,SystemData.pojazdy.get(key).getZlecenie());
            assertEquals(rodzajPojazdu,SystemData.pojazdy.get(key).getZlecenie().getRodzajPojazdu());
        }
        JDBC.update("DELETE * FROM Zadanie");
        JDBC.update("DELETE * FROM POJAZD");
        JDBC.update("DELETE * FROM ZLECENIE");
        JDBC.update("DELETE * FROM KONTRAHENT");
        JDBC.update("DELETE * FROM UZYTKOWNIK");
        JDBC.update("DELETE * FROM rodzajPojazdu");


    }
}
