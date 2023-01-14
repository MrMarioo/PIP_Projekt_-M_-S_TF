package Data;

public class Zadanie {
    int id;
    Pojazd pojazd;
    Pracownik pracownik;
    String data;
    String opis;
    String status;
    Pracownik kierownik;

    public Zadanie(int id, Pojazd pojazd, Pracownik pracownik, String data, String opis, String status, Pracownik kierownik) {
        this.id = id;
        this.pojazd = pojazd;
        this.pracownik = pracownik;
        this.data = data;
        this.opis = opis;
        this.status = status;
        this.kierownik = kierownik;
    }

    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setKierownik(Pracownik kierownik) {
        this.kierownik = kierownik;
    }

    @Override
    public String toString() {
        return "{\"zadanieid\":\"" + id + '\"' +
                    ", \"pojazdid\":\"" + pojazd.id + '\"' +
                ", \"pracownikid\":\"" + pracownik.id + '\"' +
                ", \"data\":\"" + data + '\"' +
                ", \"opis\":\"" + opis + '\"' +
                ", \"status\":\"" + status + '\"' +
                ", \"kierownikid\":\"" + kierownik.id + '\"' +
                '}';
    }
}
