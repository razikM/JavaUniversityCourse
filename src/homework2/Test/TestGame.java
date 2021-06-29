package homework2.Test;

import homework2.game.Model;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestGame {
    static Model model;

    @BeforeClass
    public static void modelInit(){
        model = new Model(0,100);
    }

    @Test
    public void testGuessesToString(){
        String result = "1 2 3 4 5";
        Model model1 = new Model(0,100);

        for(int i = 1; i < 6; i++){
            model.addGuess(i);
        }

        String result1 = "";
        for(int i = 0; i <= 100; i++){
            result1 += i;

            if(i < 100){
                result1 += " ";
            }
        }

        for (int i = 0; i < 200; i++){
            model1.addGuess(i);
        }

        Assert.assertEquals(result,model.guessesToString());
        Assert.assertEquals(result1,model1.guessesToString());
    }
}

