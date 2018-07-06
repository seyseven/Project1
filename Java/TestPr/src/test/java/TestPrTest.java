import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestPrTest{
    @Test
    public void getValueEqualsSet(){
        TestPr testPr = new TestPr();
        testPr.setValue(10);

        int value = testPr.getValue();

        assertEquals(10,value);
    }
    @Test
    public void when_1() {
        TestPr testPrMock = mock(TestPr.class);

        when(testPrMock.getValue())
                .thenReturn(100);
    }
}