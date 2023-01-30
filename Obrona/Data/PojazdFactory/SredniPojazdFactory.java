package Data.PojazdFactory;

import Data.KlasaPojazdow.SredniPojazd;
import Data.Kontrahent;
import Data.Pojazd;
import Data.RodzajPojazdu;
import Data.Zlecenie;

public class SredniPojazdFactory implements PojazdFactory {
    @Override
    public Pojazd createPojazd(int id, Zlecenie zlecenie, String status, Kontrahent kontrahent, RodzajPojazdu rodzajPojazdu) {
        return new SredniPojazd( id,  zlecenie,  status,  kontrahent,  rodzajPojazdu);
    }
}