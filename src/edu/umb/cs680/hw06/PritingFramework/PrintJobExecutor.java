package edu.umb.cs680.hw06.PritingFramework;

import edu.umb.cs680.hw06.Authentication.EncryptedString;
import edu.umb.cs680.hw06.Authentication.SecurityContext;

public abstract class PrintJobExecutor {
    public boolean execute(PrintJob job, EncryptedString pwd, SecurityContext ctx) throws Exception{
        try{
            doAuthentication(pwd, ctx);
            doAccessControl(ctx);
            doPrint(job, ctx);
            return true;
        }catch(Exception e){
            doErrorHandling();
            throw e;
        }
    }

    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception;
    protected abstract void doAccessControl(SecurityContext ctx);
    protected abstract void doPrint(PrintJob job, SecurityContext ctx);

    protected void doErrorHandling(){
        System.out.println("Some Error handling happening!!");
    }

}
