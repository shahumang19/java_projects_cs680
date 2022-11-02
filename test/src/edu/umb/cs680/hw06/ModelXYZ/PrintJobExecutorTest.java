package edu.umb.cs680.hw06.ModelXYZ;

import edu.umb.cs680.hw06.PritingFramework.PrintJob;
import edu.umb.cs680.hw06.Authentication.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PrintJobExecutorTest {
    
    @Test
    public void verifyPrintJob() throws Exception{
        PrintJob job = new PrintJob("Hello World!!!");
        PrintJobExecutor ex = new PrintJobExecutor();

        User user1 = new User(1, "Sheldon Cooper", "scooper2003");
        SecurityContext ctx = new SecurityContext(user1); 
        assertTrue(ex.execute(job, null, ctx));
    }

    @Test
    public void verifyMultiplePrintJobsSameUser() throws Exception{
        PrintJob job1 = new PrintJob("Hello World!!!");
        PrintJob job2 = new PrintJob("This is my 2nd print job.");
        PrintJobExecutor ex = new PrintJobExecutor();

        User user1 = new User(1, "Sheldon Cooper", "scooper2003");
        SecurityContext ctx = new SecurityContext(user1);
        ex.execute(job1, null, ctx);
        ex.execute(job2, null, ctx);
    }

    @Test
    public void verifyMultiplePrintJobDifferentUsers() throws Exception{
            PrintJob job1 = new PrintJob("Hello World!!!");
            PrintJobExecutor ex1 = new PrintJobExecutor();

            User user1 = new User(1, "Sheldon Cooper", "scooper2003");
            SecurityContext ctx1 = new SecurityContext(user1);
            ex1.execute(job1, null, ctx1);
            
            PrintJob job2 = new PrintJob("Hello World!!!");
            PrintJobExecutor ex2 = new PrintJobExecutor();

            User user2 = new User(2, "Bruce Wayne", "batman1234");
            SecurityContext ctx2 = new SecurityContext(user2);
            
            // Asserting that PrintJobExecutor works with 2nd user
            assertTrue(ex2.execute(job2, null, ctx2));

    }
}
