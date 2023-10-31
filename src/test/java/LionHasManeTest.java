import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionHasManeTest {

    private final String lionSex;
    private final boolean isHaveMane;
    private Lion lion;

    public LionHasManeTest(String lionSex, boolean isHaveMane){
        this.lionSex=lionSex;
        this.isHaveMane=isHaveMane;
    }

    @Parameterized.Parameters
    public static Object[] getLionSex(){
        return new Object[][]{
                {"самец", true},
                {"самка", false}
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
}