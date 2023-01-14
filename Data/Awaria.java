package Data;

public class Awaria {
    int id;
    Pojazd pojazd;
    Zadanie zadanie;
    String data;
    RodzajAwarii rodzajAwarii;
    String opis;
    String adres;

    public Awaria(int id, Pojazd pojazd, Zadanie zadanie, String data, RodzajAwarii rodzajAwarii, String opis, String adres) {
        this.id = id;
        this.pojazd = pojazd;
        this.zadanie = zadanie;
        this.data = data;
        this.rodzajAwarii = rodzajAwarii;
        this.opis = opis;
        this.adres = adres;
    }

    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
    }

    public void setZadanie(Zadanie zadanie) {
        this.zadanie = zadanie;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setRodzajAwarii(RodzajAwarii rodzajAwarii) {
        this.rodzajAwarii = rodzajAwarii;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Awaria{" +
                "id=" + id +
                ", pojazd=" + pojazd +
                ", zadanie=" + zadanie +
                ", data='" + data + '\'' +
                ", rodzajAwarii=" + rodzajAwarii +
                ", opis='" + opis + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
