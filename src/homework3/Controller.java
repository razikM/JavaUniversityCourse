package homework3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    public static final String LASTNAME_REGEX = "([A-Z][a-z]*(( |-)[A-Z][a-z]*)?)+";
    public static final String NICKNAME_REGEX = "\\w+";

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

    /**
     * Asks a user for an input specified by entry parameter which should match
     * the given regex. In case the match is successful user's input shall be returned,
     * otherwise user is asked for the input again.
     *
     * @param scanner The scanner object to read from the console.
     * @param entry   The String object which specifies the input for the user.
     * @param regex   The String object which represents the regular expression
     *                the user's input should fulfill.
     * @return        String object the input of the user which match the given regular expression.
     */
     String readEntryFromConsole(Scanner scanner, String entry, String regex){
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
