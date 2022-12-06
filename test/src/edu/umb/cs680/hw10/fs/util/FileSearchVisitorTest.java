package edu.umb.cs680.hw10.fs.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.*;

import edu.umb.cs680.hw10.fs.TestFixtureInitializer;
import edu.umb.cs680.hw10.fs.*;
import edu.umb.cs680.hw10.Authentication.*;

public class FileSearchVisitorTest {
    private static FileSystem fs;
    private static FileSearchVisitor visitor;
    private static Directory root;
    private static SecurityContext ctx;    

    @BeforeAll
    public static void setUpFS(){
        try {
            User user1 = new User(1, "Sheldon Cooper", "scooper2003");
            ctx = new SecurityContext(user1);
            ctx.login(new EncryptedString(user1.getUsername(), "1234"));
            
            fs = TestFixtureInitializer.createFS();
            root = fs.getRootDirectories().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifySingleFileFound() throws Exception{
        visitor = new FileSearchVisitor("a");
        root.accept(visitor, ctx);
        LinkedList<File> files = visitor.getFoundFiles();
        assertEquals("a", files.get(0).getName());
    }

    @Test
    public void verifyMultipleFilesFound() throws Exception{
        String[] expected = {"y", "y"};
        String[] actual = new String[2];
        visitor = new FileSearchVisitor("y");
        root.accept(visitor, ctx);
        LinkedList<File> files = visitor.getFoundFiles();

        for(int index=0; index<2; index++){
            actual[index] = files.get(index).getName();
        } 

        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyNoFilesFound() throws Exception{
        visitor = new FileSearchVisitor("unknown");
        root.accept(visitor, ctx);
        LinkedList<File> files = visitor.getFoundFiles();

        assertEquals(0, files.size());
    }

    @Test
    public void VerifyInactiveUserAccess(){
        // Negative test to ensure exception is thrown when inactive user is uses the accept method...
        try {
            visitor = new FileSearchVisitor("a");
            Directory root = fs.getRootDirectories().get(0);
            User user2 = new User(2, "Harry", "harry3");
            SecurityContext ctx2 = new SecurityContext(user2);

            root.accept(visitor, ctx2);
            fail("Searching works without login!!!!");
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    @AfterAll
    public static void cleanUp() {
        fs.getRootDirectories().clear();
    }
}
