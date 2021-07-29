package homework2.game;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model(0,100);
        Controller controller = new Controller(view,model);

        controller.play();
    }
}
