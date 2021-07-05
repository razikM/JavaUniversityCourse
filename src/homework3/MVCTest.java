package homework3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.PrintStream;
import java.util.Scanner;

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
