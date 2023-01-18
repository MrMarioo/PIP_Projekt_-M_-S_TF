package testyJednostkowe;

import Data.RodzajAwarii;
import com.example.test.JDBC;
import lombok.SneakyThrows;
import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;


public class AwariaRodzajTest {
    @SneakyThrows
    @Test
    public void testSetNazwa() {
        RodzajAwarii rodzajAwarii = new RodzajAwarii(69,"aaaa",2);
        rodzajAwarii.insert();
        rodzajAwarii.setNazwa("Awaria silnika");
        assertEquals("Awaria silnika", rodzajAwarii.getNazwa());
        JDBC.update("DELETE FROM RODZAJAWARII WHERE IDRODZAJUAWARII="+rodzajAwarii.getId());
    }
    @SneakyThrows
    @Test
    public void testSetPriorytet() {
        RodzajAwarii rodzajAwarii = new RodzajAwarii(69,"aaaa",2);
        rodzajAwarii.insert();
        rodzajAwarii.setPriorytet(1);
        assertEquals(1, rodzajAwarii.getPriorytet());
        JDBC.update("DELETE FROM RODZAJAWARII WHERE IDRODZAJUAWARII="+rodzajAwarii.getId());
    }
}