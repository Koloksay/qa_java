import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;


    @Test
    public void getSoundTest(){
        Cat cat = new Cat(feline);
        String actualResult = cat.getSound();
        String expectedResult = "Мяу";
        //Assert
        assertEquals("Ожидается слово 'Мяу'", expectedResult, actualResult);
    }

    @Test
    public void getFoodTest() throws RuntimeException {
        Cat cat = new Cat(feline);
        try {
            cat.getFood();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Mockito.verify(feline,Mockito.times(1)).eatMeat();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
