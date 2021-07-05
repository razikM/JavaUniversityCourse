package homework3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private final String LASTNAME_REGEX = "([A-Z][a-z]*(( |-)[A-Z][a-z]*)?)+";
    private final String NICKNAME_REGEX = "\\w+";

    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void processUser(){
        Scanner scanner = new Scanner(System.in);
        model.setLastname(readEntryFromConsole(scanner,"Lastname", LASTNAME_REGEX));
        model.setNickname(readEntryFromConsole(scanner,"Nickname", NICKNAME_REGEX));
    }

    private String readEntryFromConsole(Scanner scanner, String entry, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        while(true){
            view.printMsg("Enter your " + entry + ":");

            String ln = scanner.nextLine();
            matcher = pattern.matcher(ln);

            if(matcher.matches()){
                return ln;
            } else {
                view.printErr(entry + " is not accepted. Try again.");
                continue;
            }
        }
    }
}
