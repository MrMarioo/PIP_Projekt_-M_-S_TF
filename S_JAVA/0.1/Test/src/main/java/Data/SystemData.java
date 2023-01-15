package Data;

import java.util.ArrayList;
import java.util.Map;

public class SystemData {
    public Map<Integer,Pracownik> pracownicy;
    public Map<Integer,Pojazd> pojazdy;
    public Map<Integer,Zadanie> zadania;
    public Map<Integer,Awaria> awarie;
    public Map<Integer,Zlecenie> zlecenia;
    public Map<Kierownik, Pracownik> zespoly;

    public Map<Integer,Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(Map<Integer,Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public Map<Integer,Pojazd> getPojazdy() {
        return pojazdy;
    }

    public void setPojazdy(Map<Integer,Pojazd> pojazdy) {
        this.pojazdy = pojazdy;
    }

    public Map<Integer,Zadanie> getZadania() {
        return zadania;
    }

    public void setZadania(Map<Integer,Zadanie> zadania) {
        this.zadania = zadania;
    }

    public Map<Integer,Awaria> getAwarie() {
        return awarie;
    }

    public void setAwarie(Map<Integer,Awaria> awarie) {
        this.awarie = awarie;
    }

    public Map<Integer,Zlecenie> getZlecenia() {
        return zlecenia;
    }

    public void setZlecenia(Map<Integer,Zlecenie> zlecenia) {
        this.zlecenia = zlecenia;
    }

    public Map<Kierownik, Pracownik> getZespoly() {
        return zespoly;
    }

    public void setZespoly(Map<Kierownik, Pracownik> zespoly) {
        this.zespoly = zespoly;
    }
}
