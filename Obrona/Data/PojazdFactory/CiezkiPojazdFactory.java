package Data.PojazdFactory;

import Data.KlasaPojazdow.CiezkiPojazd;
import Data.Kontrahent;
import Data.Pojazd;
import Data.RodzajPojazdu;
import Data.Zlecenie;

public class CiezkiPojazdFactory implements PojazdFactory {
    @Override
    public Pojazd createPojazd(int id, Zlecenie zlecenie, String status, Kontrahent kontrahent, RodzajPojazdu rodzajPojazdu) {
        return new CiezkiPojazd( id,  zlecenie,  status,  kontrahent,  rodzajPojazdu);
    }
}