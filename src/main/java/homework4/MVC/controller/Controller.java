package homework4.MVC.controller;

import homework4.MVC.model.Model;
import homework4.MVC.model.NotUniqueLoginException;
import homework4.MVC.view.TextConstant;
import homework4.MVC.view.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        String regex = "";
        if(String.valueOf(view.getLocale()).equals("ua")){
            regex = RegexContainer.REGEX_NAME_UKR;
        } else if(String.valueOf(view.getLocale()).equals("en")){
            regex = RegexContainer.REGEX_NAME_LAT;
        }

        boolean running = true;
        do{
            try {
                model.addUser(readEntryFromConsole(scanner, TextConstant.FIRST_NAME, regex),
                        readEntryFromConsole(scanner, TextConstant.FIRST_NAME, regex));
                running = false;
            } catch (NotUniqueLoginException e){
                view.printWrongStringInput(e.getLoginData());
            }
        } while (running);

    }

    /**
     * Asks a user for an input specified by entry parameter which should match
     * the given regex. In case the match is successful user's input shall be returned,
     * otherwise user is asked for the input again.
     *
     * @param scanner The scanner object to read from the console.
     * @param entry   The String object which specifies the input for the user.
     * @param regex   The String object which represents the regular expression
     *                the user's input should fulfill.
     * @return String object the input of the user which match the given regular expression.
     */
     String readEntryFromConsole(Scanner scanner, String entry,String regex){
         Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        while(true){
            view.printStringInput(entry);

            String ln = scanner.nextLine();
            matcher = pattern.matcher(ln);

            if(matcher.matches()){
                return ln;
            } else {
                view.printWrongStringInput(entry);
                continue;
            }
        }
    }

}