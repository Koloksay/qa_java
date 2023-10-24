import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

// 1. Вызов метода doesHaveMane(), если "Самец"
// 2. Вызов метода doesHaveMane(), если "Самка"
// 3. Вызов метода doesHaveMane(), если другое значение
// 4. Вызов метода getKittens(), создать Мок что запрашивает


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

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        Lion lionInvalidSex = new Lion(feline,"Invalid");
    }
}
