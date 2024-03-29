package edu.umb.cs680.hw09.fs.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import edu.umb.cs680.hw09.fs.*;
import edu.umb.cs680.hw09.fs.TestFixtureInitializer;

public class CountingVisitorTest {
    private static FileSystem fs;
    private static CountingVisitor visitor;

    @BeforeAll
    public static void setUpFS(){
        fs = TestFixtureInitializer.createFS();
        visitor = new CountingVisitor();
        Directory root = fs.getRootDirectories().get(0);
        root.accept(visitor);
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

    @AfterAll
    public static void cleanUp() {
        fs.getRootDirectories().clear();
    }
}
