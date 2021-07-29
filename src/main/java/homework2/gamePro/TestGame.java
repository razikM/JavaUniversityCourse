package homework2.gamePro;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class TestGame {
    static Model model = new Model();

    @BeforeClass
    public static void init(){
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setSecretValue();
    }

    @Test
    public void testSetSecretValue(){
        int[] arr = new int[99];

        for(int i = 0; i < 1000000; i++){
            Assert.assertTrue(model.getSecretValue() < GlobalConstants.PRIMARY_MAX_BARRIER
                                       && model.getSecretValue() > GlobalConstants.PRIMARY_MIN_BARRIER);
            model.setSecretValue();
        }
    }

    @Test
    public void testCheckValue(){

        for(int i = 0; i < 1000000; i++){
            int value = model.getSecretValue();
            Assert.assertFalse(model.checkValue(value));

            Assert.assertTrue(model.checkValue(value - 1));
            Assert.assertEquals(value - 1,model.getMinBarrier());

            Assert.assertTrue(model.checkValue(value + 100));
            Assert.assertEquals(value + 100,model.getMaxBarrier());

        }
    }
}
