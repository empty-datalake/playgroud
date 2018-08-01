import org.testng.annotations.*;
import static org.testng.Assert.*;

public class JavaStringCompareTest {
    private JavaStringCompare stringCompare = new JavaStringCompare();
    private Integer count = 100000;

    @Test
    public void testSingleThreadStringConcat() {
        String s = stringCompare.singleThreadStringConcat(count);
        assertEquals(s.length(), count.intValue());
    }

    @Test
    public void testSingleThreadStringBufferAppend() {
        String s = stringCompare.singleThreadStringBufferAppend(count);
        assertEquals(s.length(), count.intValue());
    }

    @Test
    public void testSingleThreadStringBuilderAppend() {
        String s = stringCompare.singleThreadStringBuilderAppend(count);
        assertEquals(s.length(), count.intValue());
    }

    @Test
    public void testMultiThreadStringBufferAppend() throws InterruptedException {
        String s = stringCompare.multiThreadStringBufferAppend(count);
        assertEquals(s.length(), count.intValue()*2);
    }

    @Test
    public void testMultiThreadStringBuilderAppend() throws InterruptedException {
        String s = stringCompare.multiThreadStringBuilderAppend(count);
        assertEquals(s.length(), count.intValue()*2);
    }
}
