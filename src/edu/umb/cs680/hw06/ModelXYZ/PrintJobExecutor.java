package edu.umb.cs680.hw06.ModelXYZ;

import edu.umb.cs680.hw06.Authentication.EncryptedString;
import edu.umb.cs680.hw06.Authentication.SecurityContext;
import edu.umb.cs680.hw06.Authentication.User;
import edu.umb.cs680.hw06.PritingFramework.PrintJob;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PritingFramework.PrintJobExecutor {

    @Override
    protected void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void doAccessControl(SecurityContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void doPrint(PrintJob job, SecurityContext ctx) {
        // TODO Auto-generated method stub
        System.out.println("Model XYZ - ("+ ctx.getUser().getUsername() +") ("+ job.getJobTime().toString() +"): "+job.getData());
    }

    public static void main(String[] args) {
        try {
            PrintJob job = new PrintJob("Hello World!!!");
            PrintJobExecutor ex = new PrintJobExecutor();

            User user1 = new User(1, "Sheldon Cooper", "scooper2003");
            SecurityContext ctx = new SecurityContext(user1);
            ex.execute(job, null, ctx);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
