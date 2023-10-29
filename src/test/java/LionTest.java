import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;


    private Lion lionMale;
    private Lion lionFemale;

    @Before
    public void setUp() throws Exception {
        lionMale = new Lion(feline, "Самец");
        lionFemale = new Lion(feline, "Самка");
    }
    // проверяет, что метод возвращает True, если было передано "Самец" и False, если нет
    @Test
    public void testHasMane() {
        assertTrue(lionMale.doesHaveMane());
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lionMale.getKittens());
        assertEquals(1, lionFemale.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lionMale.getFood());
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lionFemale.getFood());
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        Lion lionInvalidSex = new Lion(feline, "Invalid");
    }

    @Test
    public void testInvalidSexErrorMessage() {
        try {
            Lion lionInvalidSex = new Lion(feline, "Invalid");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}