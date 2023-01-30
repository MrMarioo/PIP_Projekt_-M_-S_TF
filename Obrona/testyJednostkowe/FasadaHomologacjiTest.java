package testyJednostkowe;

import Data.*;
import Data.Homologacja.FasadaHomologacji;
import Data.Homologacja.Homologacja;
import Data.Homologacja.InstytutHomologacji;
import Data.PojazdFactory.CiezkiPojazdFactory;
import Data.PojazdFactory.PojazdFactory;
import org.junit.Test;

public class FasadaHomologacjiTest {
    @Test
    public void testFasady()
    {
        InstytutHomologacji instytucja = new InstytutHomologacji();
        Homologacja fasada = new FasadaHomologacji(instytucja);

        HomologacjaWozu homologacjaWozu = HomologacjaWozu.getInstance(fasada);
        Kontrahent kontrahent = new Kontrahent(1,"KontrahentNazwa","KontrahentImie","KontrahentNazwisko");
        RodzajPojazdu rodzajPojazdu = new RodzajPojazdu(1,"RodzajPojazduOpis","RodzajPojazduNazwa");
        Zlecenie zlecenie = new Zlecenie(1,kontrahent,"2022-9-10","ZlecenieAdres","ZlecenieStatus",5,rodzajPojazdu);
        Pracownik pracownik = new Pracownik(1, "PracownikImie", "PracownikNazwisko",  "PracownikTyp",  "PracownikStatus");
        Kierownik kierownik = new Kierownik(1,"KierownikImie","KierownikNazwisko","KierownikTyp","KierownikStatus");
        PojazdFactory factory = new CiezkiPojazdFactory();
        Pojazd ciezkiPojazd  = factory.createPojazd(1,zlecenie,"status",kontrahent,rodzajPojazdu);

        homologacjaWozu.certify(ciezkiPojazd);

        assert (homologacjaWozu.isCertified(ciezkiPojazd) == true) : "Pojazd nie został pomyślnie zhomologowany";
    }
}
