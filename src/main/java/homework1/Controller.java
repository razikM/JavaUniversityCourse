package homework1;

import java.util.Scanner;

public class Controller {

    private View view;
    private Model model;

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
    }

    public void readInput(){
        Scanner scanner = new Scanner(System.in);
        boolean first = false;
        boolean second = false;

        while(!(first && second)){
            view.printMsgToConsole("Your input:");
            String input = scanner.nextLine();
            if(!first && input.equals("Hello")){
                first = true;
                view.printMsgToConsole("Hello received:)");
            } else if(first && input.equals("world!")){
                second = true;
                view.printMsgToConsole("world! received:)");
            } else {
                view.printErrToConsole("Wrong input. Try one more time!");
            }
        }

        scanner.close();
        view.printMsgToConsole(model.makeASentence("Hello", "world!"));
    }
}
