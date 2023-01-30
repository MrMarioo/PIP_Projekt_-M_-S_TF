package testyJednostkowe;

import Data.*;
import Data.Homologacja.FasadaHomologacji;
import Data.Homologacja.Homologacja;
import Data.Homologacja.InstytutHomologacji;
import Data.PojazdFactory.CiezkiPojazdFactory;
import Data.PojazdFactory.PojazdFactory;
import org.junit.Test;
public class SingletonHomolagacjaTest {

    @Test
    public void testGetInstance() {
        InstytutHomologacji instytucja = new InstytutHomologacji();
        // Tworzymy obiekt fasady homologacji z instytucj
        Homologacja fasada = new FasadaHomologacji(instytucja);
        HomologacjaWozu instance1 = HomologacjaWozu.getInstance(fasada);
        HomologacjaWozu instance2 = HomologacjaWozu.getInstance(fasada);
        assert (instance1 == instance2);
    }
    @Test
    public void testCertify() {
        InstytutHomologacji instytucja = new InstytutHomologacji();
        // Tworzymy obiekt fasady homologacji z instytucj
        Homologacja fasada = new FasadaHomologacji(instytucja);
        HomologacjaWozu instance = HomologacjaWozu.getInstance(fasada);
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        Pracownik pracownik = new Pracownik(1, "PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        PojazdFactory factory = new CiezkiPojazdFactory();
        Pojazd ciezkiPojazd  = factory.createPojazd(1,zlecenie,"status",kontrahent,rodzajPojazdu);

        boolean result = instance.certify(ciezkiPojazd);
        assert (result == true);
    }
}
