import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class com_test {
    @Test
    public void getPrintStream(){
        Time timeMock = mock(Time.class);
        when(timeMock.execute())
                .then(0);
    }

    @Test
    public  void sumTest(){
        Calc calc = new Calc();

        int result = calc.sum(2,2);

        assertEquals(4,result);
    }
    @Test
    public  void subTest(){
        Calc calc = new Calc();

        int result = calc.sub(2,2);

        assertEquals(0,result);
    }
    @Test
    public  void mulTest(){
        Calc calc = new Calc();

        int result = calc.mul(2,2);

        assertEquals(4,result);
    }
    @Test
    public  void divTest(){
        Calc calc = new Calc();

        int result = calc.div(2,2);

        assertEquals(1,result);
    }
}

