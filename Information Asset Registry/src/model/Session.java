package model;

public class Session {
    private static User currentUser;
    
    public Session() {
        CoreUtil.init();
        currentUser = new User();
    }
    
    public User currentUser() {
        return currentUser;
    }
}
