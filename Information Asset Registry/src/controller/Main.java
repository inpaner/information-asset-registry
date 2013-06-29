package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LogInFrame;
import model.User;

public class Main {
    private User user;
    private LogInFrame frame;
    
    public static void main(String[] args) {
        new Main().login();
    }
    
    private void login() {
        frame = new LogInFrame();
        frame.addLoginListener(loginListener());
    }
    
    private ActionListener loginListener() {
        return new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            user = User.login(frame.username(), frame.password());
            System.out.println(user.username());
        }
        };
    }
}
