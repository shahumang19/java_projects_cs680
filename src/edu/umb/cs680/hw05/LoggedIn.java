package edu.umb.cs680.hw05;

public class LoggedIn implements State {

    private LoggedIn(){}

    private static LoggedIn instance = null;

    public static LoggedIn getInstance() {
        if(instance == null) {
            instance = new LoggedIn();
        }
        return instance;
    }

    @Override
    public void login(SecurityContext ctx, EncryptedString pwd) throws Exception{
        if (!ctx.isActive()){
            ctx.changeState(LoggedOut.getInstance());
            ctx.login(pwd);
        }
    }

    @Override
    public void logout(SecurityContext ctx){
        ctx.changeState(LoggedOut.getInstance());
    }
}
