package edu.umb.cs680.hw06.ModelABC;

import edu.umb.cs680.hw06.Authentication.EncryptedString;
import edu.umb.cs680.hw06.Authentication.LoggedIn;
import edu.umb.cs680.hw06.Authentication.SecurityContext;
import edu.umb.cs680.hw06.Authentication.User;
import edu.umb.cs680.hw06.PritingFramework.PrintJob;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PritingFramework.PrintJobExecutor{

    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception {
        ctx.login(pwd);
    }

    @Override
    protected void doAccessControl(SecurityContext ctx) {
        
    }

    @Override
    protected void doPrint(PrintJob job, SecurityContext ctx) {
        if (ctx.getState() instanceof LoggedIn){
            System.out.println("Model ABC - ("+ ctx.getUser().getUsername() +") ("+ job.getJobTime().toString() +"): "+job.getData());
        }
        else{
            System.out.println("!!! [User not logged in] !!!!");
        }
        
    }

    public static void main(String[] args) {
        try {
            PrintJob job = new PrintJob("Hello World!!!");
            PrintJobExecutor ex = new PrintJobExecutor();

            User user1 = new User(1, "Sheldon Cooper", "scooper2003");
            SecurityContext ctx = new SecurityContext(user1);
            ex.execute(job, new EncryptedString(user1.getUsername(), "1234"), ctx);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
