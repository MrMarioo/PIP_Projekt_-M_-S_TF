package Data;

public class RodzajPojazdu {
    int id;
    String opis;
    String nazwa;

    public RodzajPojazdu(int id, String opis, String nazwa) {
        this.id = id;
        this.opis = opis;
        this.nazwa = nazwa;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "{\"zlecenieid\":\"" + id + '\"' +
                ", \"id\":\"" + id + '\"' +
                ", \"opis\":\"" + opis + '\"' +
                ", \"nazwa\":\"" + nazwa + '\"' +
                '}';
    }
}
