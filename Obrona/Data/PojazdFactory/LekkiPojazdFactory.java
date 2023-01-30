package Data.PojazdFactory;

import Data.KlasaPojazdow.LekkiPojazd;
import Data.Kontrahent;
import Data.Pojazd;
import Data.RodzajPojazdu;
import Data.Zlecenie;

public class LekkiPojazdFactory implements PojazdFactory {
    @Override
    public Pojazd createPojazd(int id, Zlecenie zlecenie, String status, Kontrahent kontrahent, RodzajPojazdu rodzajPojazdu) {
        return new LekkiPojazd( id,  zlecenie,  status,  kontrahent,  rodzajPojazdu);
    }
}