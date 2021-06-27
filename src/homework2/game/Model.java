package homework2.game;

import java.util.Random;

public class Model {
    private int number;
    private int start;
    private int end;
    private int index;
    private int[] guesses;

    public Model(int start, int end){
        Random random = new Random();

        number = random.nextInt((end - start) + 1) + start;
        this.start = start;
        this.end = end;
        index = 0;
        guesses = new int[(end - start) + 1];
    }

    public int getNumber(){
        return number;
    }

    public int getStart(){
        return start;
    }

    public void setStart(int start){
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int[] getGuesses(){
        return guesses;
    }

    public void addGuess(int guess){
        if(!(index >= guesses.length || index < 0)) {
            guesses[index++] = guess;
        }
    }

    public String guessesToString(){
        String result = "";

        for(int i = 0; i <= index - 1; i++){
            result += guesses[i];
            if(i < index - 1){
                result += " ";
            }
        }
        return result;
    }
}
