package edu.umb.cs680.hw13.Authentication;

public class LoggedOut implements State {
    private LoggedOut(){}

    private static LoggedOut instance = null;

    public static LoggedOut getInstance() {
        if(instance == null) {
            instance = new LoggedOut();
        }
        return instance;
    }

    @Override
    public void login(SecurityContext ctx, EncryptedString pwd) throws Exception{
        if ( Authenticator.authenticate(ctx, pwd) ){ 
            ctx.changeState(LoggedIn.getInstance());
            ctx.updateLoginTimeStamp();
        }else{
            throw new Exception("Invalid Credentials!!!");
        }
    }

    @Override
    public void logout(SecurityContext ctx){
        
    }
}
