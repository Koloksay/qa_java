import com.example.Alex;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AlexTest {

    @Test
    public void testHasMane() throws Exception {
        Alex alex = new Alex();
        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void testGetFriends() throws Exception {
        Alex alex = new Alex();
        assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        Alex alex = new Alex();
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittens() throws Exception {
        Alex alex = new Alex();
        assertEquals(0, alex.getKittens());
    }
}
