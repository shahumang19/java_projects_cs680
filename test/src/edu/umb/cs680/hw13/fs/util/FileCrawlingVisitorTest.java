package edu.umb.cs680.hw13.fs.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.*;

import edu.umb.cs680.hw13.fs.TestFixtureInitializer;
import edu.umb.cs680.hw13.fs.*;
import edu.umb.cs680.hw13.Authentication.*;

public class FileCrawlingVisitorTest {
    private static FileSystem fs;
    private static FileCrawlingVisitor visitor;

    @BeforeAll
    public static void setUpFS(){
        try {
            fs = TestFixtureInitializer.createFS();
            visitor = new FileCrawlingVisitor();
            Directory root = fs.getRootDirectories().get(0);
            User user1 = new User(1, "Sheldon Cooper", "scooper2003");
            SecurityContext ctx = new SecurityContext(user1);
            ctx.login(new EncryptedString(user1.getUsername(), "1234"));

            root.accept(visitor, ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void verifyNumberOfFiles(){
        assertEquals(6, visitor.getFiles().size());
    }

    @Test
    public void verifyGetFilesReturnsFiles(){
        boolean[] expected = {true, true, true, true, true};
        boolean[] actual = new boolean[5];
        LinkedList<File> files = visitor.getFiles();

        for(int index=0; index<5; index++){
            actual[index] = files.get(index).getFileType() == FileType.FILE;
        } 

        assertArrayEquals(expected, actual);
    }

    @Test
    public void VerifyInactiveUserAccess(){
        // Negative test to ensure exception is thrown when inactive user is uses the accept method...
        try {
            Directory root = fs.getRootDirectories().get(0);
            User user2 = new User(2, "Harry", "harry3");
            SecurityContext ctx2 = new SecurityContext(user2);

            root.accept(visitor, ctx2);
            fail("Crawling works without login!!!!");
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    @AfterAll
    public static void cleanUp() {
        fs.getRootDirectories().clear();
    }
}
