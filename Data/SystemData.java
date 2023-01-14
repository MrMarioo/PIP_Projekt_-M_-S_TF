package Data;

import java.util.ArrayList;
import java.util.Map;

public class SystemData {
    public ArrayList<Pracownik> pracownicy;
    public ArrayList<Pojazd> pojazdy;
    public ArrayList<Zadanie> zadania;
    public ArrayList<Awaria> awarie;
    public ArrayList<Zlecenie> zlecenia;
    public Map<String, Pracownik> zespoly;

    public ArrayList<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(ArrayList<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public ArrayList<Pojazd> getPojazdy() {
        return pojazdy;
    }

    public void setPojazdy(ArrayList<Pojazd> pojazdy) {
        this.pojazdy = pojazdy;
    }

    public ArrayList<Zadanie> getZadania() {
        return zadania;
    }

    public void setZadania(ArrayList<Zadanie> zadania) {
        this.zadania = zadania;
    }

    public ArrayList<Awaria> getAwarie() {
        return awarie;
    }

    public void setAwarie(ArrayList<Awaria> awarie) {
        this.awarie = awarie;
    }

    public ArrayList<Zlecenie> getZlecenia() {
        return zlecenia;
    }

    public void setZlecenia(ArrayList<Zlecenie> zlecenia) {
        this.zlecenia = zlecenia;
    }

    public Map<String, Pracownik> getZespoly() {
        return zespoly;
    }

    public void setZespoly(Map<String, Pracownik> zespoly) {
        this.zespoly = zespoly;
    }
}
