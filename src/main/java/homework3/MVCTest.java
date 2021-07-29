package homework3;

import homework3.controller.Controller;
import homework3.view.View;
import org.junit.BeforeClass;

public class MVCTest {
    private static View view;
    private static Model model;
    private static Controller controller;

    @BeforeClass
    public static void init(){
        view = new View();
        model = new Model();
        controller = new Controller(model,view);
    }

    // TODO: Need to figure out how to simulate user input
//    @Test
//    public void testReadEntryFromConsole(){
//        PrintStream printStream = new PrintStream(System.out);
//        Scanner scanner = new Scanner(System.in);
//        System.setIn(new ByteArrayInputStream("Razinkin".getBytes()));
//        Assert.assertEquals("Razinkin",
//                controller.readEntryFromConsole(scanner,"",Controller.LASTNAME_REGEX));
//    }
}
