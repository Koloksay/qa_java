import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionTest {

    private final String lionSex;
    private final boolean isHaveMane;
    private Lion lion;

    public LionTest(String lionSex, boolean isHaveMane){
        this.lionSex=lionSex;
        this.isHaveMane=isHaveMane;
    }

    @Parameterized.Parameters
    public static Object[] getLionSex(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    Feline feline=Mockito.mock(Feline.class);

    @Before
    public void setUp() throws Exception {
        lion = new Lion(feline, lionSex);
    }
    @Test
    public void testHasMane() {
        boolean actual = lion.doesHaveMane();
        assertEquals(isHaveMane, actual);
    }

    @Test
    public void testGetKittens() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
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