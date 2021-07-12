package homework4.MVC.model;

public class User {
    private final String firstName;
    private final String login;

    User(String firstName, String login){
        this.firstName = firstName;
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }

}
