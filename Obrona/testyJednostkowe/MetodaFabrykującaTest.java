package testyJednostkowe;

import Data.*;
import Data.KlasaPojazdow.CiezkiPojazd;
import Data.KlasaPojazdow.LekkiPojazd;
import Data.KlasaPojazdow.SredniPojazd;
import Data.PojazdFactory.CiezkiPojazdFactory;
import Data.PojazdFactory.LekkiPojazdFactory;
import Data.PojazdFactory.PojazdFactory;
import Data.PojazdFactory.SredniPojazdFactory;
import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;
public class MetodaFabrykującaTest {
    @Test
    public void testLekkiPojazd(){
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        Pracownik pracownik = new Pracownik(1, "PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        PojazdFactory factory = new LekkiPojazdFactory();
        Pojazd lekkiPojazd  = factory.createPojazd(1,zlecenie,"status",kontrahent,rodzajPojazdu);
        assert(lekkiPojazd  instanceof LekkiPojazd);
    }
    @Test
    public void testSredniPojazd(){
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        Pracownik pracownik = new Pracownik(1, "PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        PojazdFactory factory = new SredniPojazdFactory();
        Pojazd sredniPojazd  = factory.createPojazd(1,zlecenie,"status",kontrahent,rodzajPojazdu);
        assert(sredniPojazd  instanceof SredniPojazd);
    }
    @Test
    public void testCiezkiPojazd(){
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        Pracownik pracownik = new Pracownik(1, "PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        PojazdFactory factory = new CiezkiPojazdFactory();
        Pojazd ciezkiPojazd  = factory.createPojazd(1,zlecenie,"status",kontrahent,rodzajPojazdu);
        assert(ciezkiPojazd  instanceof CiezkiPojazd);
    }
}
