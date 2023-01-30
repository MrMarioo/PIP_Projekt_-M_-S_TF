package Data;

import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class RodzajPojazdu {
    int id;
    String opis;
    String nazwa;

    public RodzajPojazdu(int id, String opis, String nazwa) {
        this.id = id;
        this.opis = opis;
        this.nazwa = nazwa;
    }
    @SneakyThrows
    public void insert(){
        JDBC.update("INSERT INTO RodzajPojazdu VALUES('"+id+"','"+nazwa+"','"+opis+"')");
    }
    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + '\"' +
                ", \"opis\":\"" + opis + '\"' +
                ", \"nazwa\":\"" + nazwa + '\"' +
                '}';
    }
    @SneakyThrows
    public JSONObject toJSON(){
        JSONObject jo = new JSONObject();
        jo.put("rodzajpojazduid",id);
        jo.put("opis",opis);
        jo.put("nazwa",nazwa);
        System.out.println(jo.toString());
        return jo;
    }
}
