package Data.Homologacja;

import Data.Pojazd;

public class FasadaHomologacji implements Homologacja {
    private InstytutHomologacji instytucja;
    public FasadaHomologacji(InstytutHomologacji instytucja) {
        this.instytucja = instytucja;
    }
    public boolean homologuj(Pojazd pojazd) {
        if((instytucja.certyfikacja() ||
                instytucja.ocenaZgodnosci_z_UE() ||
                instytucja.odbiorTechniczny() ||
                instytucja.przewozTowarowNiebezpiecznych() ||
                instytucja.badaniaLaboratoryjne() ||
                instytucja.wyslijDanePojazd(pojazd)
        ))
        {
            pojazd.setCertified(true);
            return true;
        }
        pojazd.setCertified(false);
        return false;
    }
}
