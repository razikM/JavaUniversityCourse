package homework4.MVC.model;

public class NotUniqueLoginException extends Exception{
    private String loginData;

    public String getLoginData() {
        return loginData;
    }

    public NotUniqueLoginException(String message, String loginData) {
        super(message);
        this.loginData = loginData;
    }
}
