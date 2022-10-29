package edu.umb.cs680.hw06.PritingFramework;

import edu.umb.cs680.hw06.Authentication.EncryptedString;
import edu.umb.cs680.hw06.Authentication.SecurityContext;

public abstract class PrintJobExecutor {
    public void execute(PrintJob job, EncryptedString pwd, SecurityContext ctx) throws Exception{
        doAuthentication(pwd, ctx);
        doAccessControl(ctx);
        doPrint(job, ctx);
        doErrorHandling();
    }

    protected abstract void doAuthentication(EncryptedString pwd, SecurityContext ctx) throws Exception;
    protected abstract void doAccessControl(SecurityContext ctx);
    protected abstract void doPrint(PrintJob job, SecurityContext ctx);

    protected void doErrorHandling(){
        System.out.println("Some Error handling happening!!");
    }

}
