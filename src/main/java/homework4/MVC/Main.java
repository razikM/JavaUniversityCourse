package homework4.MVC;

import homework4.MVC.controller.Controller;
import homework4.MVC.model.Model;
import homework4.MVC.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model,view);

        controller.processUser();
    }
}
