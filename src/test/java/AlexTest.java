import com.example.Alex;
import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AlexTest {

    @Test
    public void testHasMane() throws Exception {
        Feline feline = new Feline();
        Alex alex = new Alex(feline);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void testGetFriends() throws Exception {
        Feline feline = new Feline();
        Alex alex = new Alex(feline);
        assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        Feline feline = new Feline();
        Alex alex = new Alex(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline feline = new Feline();
        Alex alex = new Alex(feline);
        assertEquals(0, alex.getKittens());
    }
}
