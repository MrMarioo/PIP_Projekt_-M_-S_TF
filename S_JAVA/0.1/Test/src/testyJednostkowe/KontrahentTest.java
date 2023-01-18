package testyJednostkowe;

import Data.Kontrahent;
import Data.RodzajAwarii;
import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class KontrahentTest {
    @SneakyThrows
    @Test
    public void testSetNazwa() {
        int idU = 101;
        Kontrahent kontrahent = new Kontrahent(69,"aaaa","jan","mam");
        kontrahent.insert(idU);
        kontrahent.setNazwa("bbbb");
        assertEquals("bbbb", kontrahent.getNazwa());
        JDBC.update("DELETE FROM kontrahent WHERE IDKONTRAHENTA="+kontrahent.getId());
        JDBC.update("DELETE FROM uzytkownik WHERE IDUZYTKOWNIKA="+idU);
    }
    @SneakyThrows
    @Test
    public void testSetImie() {
        int idU = 101;
        Kontrahent kontrahent = new Kontrahent(69,"aaaa","jan","mam");
        kontrahent.insert(idU);
        kontrahent.setImie("bbbb");
        assertEquals("bbbb", kontrahent.getImie());
        JDBC.update("DELETE FROM kontrahent WHERE IDKONTRAHENTA="+kontrahent.getId());
        JDBC.update("DELETE FROM uzytkownik WHERE IDUZYTKOWNIKA="+idU);
    }
    @SneakyThrows
    @Test
    public void testSetNazwisko() {
        int idU = 101;
        Kontrahent kontrahent = new Kontrahent(69,"aaaa","jan","mam");
        kontrahent.insert(idU);
        kontrahent.setNazwisko("bbbb");
        assertEquals("bbbb", kontrahent.getNazwisko());
        JDBC.update("DELETE FROM kontrahent WHERE IDKONTRAHENTA="+kontrahent.getId());
        JDBC.update("DELETE FROM uzytkownik WHERE IDUZYTKOWNIKA="+idU);
    }
}
