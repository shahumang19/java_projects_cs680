package edu.umb.cs680.hw10.fs.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import edu.umb.cs680.hw10.Authentication.*;
import edu.umb.cs680.hw10.fs.*;
import edu.umb.cs680.hw10.fs.TestFixtureInitializer;

public class CountingVisitorTest {
    private static FileSystem fs;
    private static CountingVisitor visitor;

    @BeforeAll
    public static void setUpFS(){
        try {
            fs = TestFixtureInitializer.createFS();
            visitor = new CountingVisitor();
            Directory root = fs.getRootDirectories().get(0);
            User user1 = new User(1, "Sheldon Cooper", "scooper2003");
            SecurityContext ctx = new SecurityContext(user1);
            ctx.login(new EncryptedString(user1.getUsername(), "1234"));

            root.accept(visitor, ctx);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Test
    public void verifyDirectoryCount(){
        int expected = 5;
        assertEquals(expected, visitor.getDirNum());
    }

    @Test
    public void verifyFileCount(){
        int expected = 6;
        assertEquals(expected, visitor.getFileNum());
    }

    @Test
    public void verifyLinkCount(){
        int expected = 2;
        assertEquals(expected, visitor.getLinkNum());
    }

    @Test
    public void VerifyInactiveUserAccess(){
        // Negative test to ensure exception is thrown when inactive user is uses the accept method...
        try {
            Directory root = fs.getRootDirectories().get(0);
            User user2 = new User(2, "Harry", "harry3");
            SecurityContext ctx2 = new SecurityContext(user2);

            root.accept(visitor, ctx2);
            fail("Counting works without login!!!!");
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    @AfterAll
    public static void cleanUp() {
        fs.getRootDirectories().clear();
    }
}
