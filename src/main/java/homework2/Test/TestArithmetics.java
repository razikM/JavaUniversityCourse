package homework2.Test;

import homework2.Calculation.Arithmetics;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.awt.image.TileObserver;

public class TestArithmetics {
    static Arithmetics a;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @Rule
    public Timeout time = new Timeout(1000);

    @BeforeClass
    public static void runT(){
        a = new Arithmetics();
    }

    @Ignore
    @Test
    public void testAdd(){
        double res = a.add(3,7);
        Assert.assertEquals(10, res, 0.000001);
    }

    @Test
    public void testMult(){
        double res = a.mult(3,7);
        Assert.assertEquals(21,res, 0.000001);
    }

    @Test
    public void testDeduct(){
        double res = a.deduct(3,7);
        Assert.assertEquals(-4,res, 0.000001);
    }

    @Test
    public void testDiv(){
        double res = a.divide(10,5);
        Assert.assertEquals(2,res, 0.000001);
    }

    // @Test(expected = ArithmeticExcpetion.class)
    @Test()
    public void testDivException(){
        exp.expect(ArithmeticException.class);
        System.out.println(a.divide(10.0,0.0));
        int a = 10 / 0;
    }

    @Test
    public void testN(){
        while (true){}
    }
}
