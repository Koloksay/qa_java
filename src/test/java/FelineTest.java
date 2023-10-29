import com.example.Feline;
import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        //Вызов getFood("Хищник") и возвращаем заданный список значений
        feline.eatMeat();
        Mockito
                .verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
    String result = feline.getFamily();
    assertEquals("Кошачьи", result);
    }

    @Test
    public void testGetKittens() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testGetKittensWithCount() {
        int kittensCount = 5;
        int result = feline.getKittens(kittensCount);
        assertEquals(kittensCount, result);
    }
}