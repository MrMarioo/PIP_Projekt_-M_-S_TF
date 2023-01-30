package Data;

import Data.Homologacja.Homologacja;

public class HomologacjaWozu {
    private Homologacja homologacja;
    private static HomologacjaWozu instance = null;

    public boolean certify(Pojazd p){
        return homologacja.homologuj(p);
    }
    public boolean isCertified(Pojazd p)
    {
        return p.getCertified();
    }
    private HomologacjaWozu(Homologacja homologacja) {
       this.homologacja = homologacja;
    }

    public static HomologacjaWozu getInstance(Homologacja homologacja) {
        if (instance == null) {
            instance = new HomologacjaWozu(homologacja);
        }
        return instance;
    }
}
