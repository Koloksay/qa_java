import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {

    private List<String> expectedFoodList;
    private final String lionSex = "самец";
    private Lion lion;


    Feline feline=Mockito.mock(Feline.class);
    @Before
    public void setUp() throws Exception {
        lion = new Lion(feline, lionSex);
    }

    @Test
    public void testGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFoodList);
        assertEquals(expectedFoodList, lion.getFood());
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        Lion lionInvalidSex = new Lion(feline, "Invalid");
    }

    @Test
    public void testInvalidSexErrorMessage() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(feline, "Invalid");
        });

        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
