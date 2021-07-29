package homework2.game;

import java.util.Scanner;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
    }

    public void play(){
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running){
            view.printMsg("Please guess a number");
            view.printMsg("The interval is [" + model.getStart() + "," + model.getEnd() + "]");
            view.printMsg("Your try:");
            int input;

            try {
                input = Integer.parseInt(scanner.nextLine());
            } catch (Exception e){
                view.printErr("Please try again");
                continue;
            }

            if(input >= model.getStart() && input <= model.getEnd()){
                if(input == model.getNumber()){
                    view.printMsg("You guessed! The number was " + model.getNumber());
                    running = false;
                    model.addGuess(input);
                    view.printMsg("Your guesses were:\n" + model.guessesToString());
                } else if(input > model.getNumber()){
                    view.printMsg("The number is smaller than your input");
                    model.setEnd(input - 1);
                    model.addGuess(input);
                } else {
                    view.printMsg("The number is greater than your input");
                    model.setStart(input + 1);
                    model.addGuess(input);
                }
            } else {
                view.printErr("Your input is not valid");
                view.printErr("Please try again");
            }
        }
    }

}
