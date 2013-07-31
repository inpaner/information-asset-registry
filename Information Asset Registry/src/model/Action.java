package model;

public enum Action {
    LOGIN("Login"), 
    LOGOUT("Logout");
    
    private String text;
    Action(String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return text;
    }

}
