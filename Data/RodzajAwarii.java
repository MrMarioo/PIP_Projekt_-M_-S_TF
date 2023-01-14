package Data;

public class RodzajAwarii {
    int id;
    String nazwa;
    int priorytet;

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setPriorytet(int priorytet) {
        this.priorytet = priorytet;
    }

    @Override
    public String toString() {
        return "RodzajAwarii{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", priorytet=" + priorytet +
                '}';
    }
}
