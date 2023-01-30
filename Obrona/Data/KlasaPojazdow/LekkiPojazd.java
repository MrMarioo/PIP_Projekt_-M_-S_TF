package Data.KlasaPojazdow;

import Data.Kontrahent;
import Data.Pojazd;
import Data.PojazdFactory.PojazdFactory;
import Data.RodzajPojazdu;
import Data.Zlecenie;

public class LekkiPojazd extends Pojazd {

    public LekkiPojazd(int id, Zlecenie zlecenie, String status, Kontrahent kontrahent, RodzajPojazdu rodzajPojazdu) {
        super(id, zlecenie, status, kontrahent, rodzajPojazdu);
    }

    @Override
    public Zlecenie getZlecenie(){ return zlecenie;}
    @Override
    public Kontrahent getKontrahent() {return kontrahent;}
    @Override
    public String getStatus() {  return status; }
    @Override
    public int getId() {return id;}

}
