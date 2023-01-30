package Data.PojazdFactory;

import Data.Kontrahent;
import Data.Pojazd;
import Data.RodzajPojazdu;
import Data.Zlecenie;

public interface PojazdFactory {
    Pojazd createPojazd(int id, Zlecenie zlecenie, String status, Kontrahent kontrahent, RodzajPojazdu rodzajPojazdu);
}
