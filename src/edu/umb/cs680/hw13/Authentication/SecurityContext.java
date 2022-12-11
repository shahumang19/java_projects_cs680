package edu.umb.cs680.hw13.Authentication;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class SecurityContext {
    private User user;
    private State currentState;
    private LinkedList<LocalDateTime> loginTimeStamp = null;

    // The value in real life scenario can be much bigger. 
    private static final int LOGIN_SESSION_SECONDS = 300;

    public SecurityContext(User user){
        this.user = user;
        this.currentState = LoggedOut.getInstance();
        this.loginTimeStamp = new LinkedList<LocalDateTime>();
    }

    public void changeState(State newState){
        this.currentState = newState;
    }

    public void login(EncryptedString pwd) throws Exception{
        this.currentState.login(this, pwd);
    }

    public void logout(){
        this.currentState.logout(this);
    }

    public boolean isActive(){
        if (!this.loginTimeStamp.isEmpty()){
            long duration = Duration.between(this.loginTimeStamp.getLast(), LocalDateTime.now()).toMillis();
            if ((TimeUnit.MILLISECONDS.toSeconds(duration) <= SecurityContext.LOGIN_SESSION_SECONDS) && (this.currentState instanceof LoggedIn) ){
                return true;
            }
        }
        return false;
    }

    public State getState(){
        return this.currentState;
    }

    public User getUser(){
        return this.user;
    }

    public LinkedList<LocalDateTime> getLoginTimeStamp(){
        return this.loginTimeStamp;
    }

    protected void updateLoginTimeStamp(){
        this.loginTimeStamp.add(LocalDateTime.now());
    }

    public static void main(String[] args) {
        try {
            // %%%%%%%%%%%%%%%% Testing with user1 %%%%%%%%%%%%%%%%
            User user1 = new User(1, "Sheldon Cooper", "scooper2003");

            SecurityContext ctx = new SecurityContext(user1);

            ctx.login(new EncryptedString(user1.getUsername(), "flash"));
            System.out.println("LoggedIn user1 state : "+ctx.getState());
            ctx.logout();
            System.out.println("LoggedOut user1 state : "+ctx.getState());
            System.out.println("Is user active? : "+ctx.isActive());
            ctx.login(new EncryptedString(user1.getUsername(), "flash"));
            System.out.println("Again LoggedIn user1 state : "+ctx.getState());
            System.out.println("Is user active? : "+ctx.isActive());

            // %%%%%%%%%%%%%%%% Testing with user2 %%%%%%%%%%%%%%%%
            User user2 = new User(1, "Howard Wolowitz", "howie1234");

            SecurityContext ctx2 = new SecurityContext(user2);
            
            ctx2.login(new EncryptedString(user2.getUsername(), "tudum"));
            System.out.println("LoggedIn user1 state : "+ctx2.getState());
            ctx2.logout();
            System.out.println("LoggedOut user1 state : "+ctx2.getState());
            System.out.println("Is user active? : "+ctx2.isActive());
            ctx2.login(new EncryptedString(user2.getUsername(), "tudum"));
            System.out.println("Again LoggedIn user1 state : "+ctx2.getState());
            System.out.println("Is user active? : "+ctx2.isActive());


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
