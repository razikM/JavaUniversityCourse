package homework4.MVC.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<User> users;

    public Model(){
        users = new ArrayList<User>();
    }

    public void addUser(String firstName, String login) throws NotUniqueLoginException {
        checkLogin(login);
        users.add(new User(firstName,login));
    }

    public void checkLogin(String login) throws NotUniqueLoginException{
        for(User u: users){
            if(u.getLogin().equals(login)){
                throw new NotUniqueLoginException(login,"Such login already exists");
            }
        }
    }
}
