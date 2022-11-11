package edu.umb.cs680.hw09.fs.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.*;

import edu.umb.cs680.hw09.fs.TestFixtureInitializer;
import edu.umb.cs680.hw09.fs.*;

public class FileSearchVisitorTest {
    private static FileSystem fs;
    private static FileSearchVisitor visitor;
    private static Directory root;

    @BeforeAll
    public static void setUpFS(){
        fs = TestFixtureInitializer.createFS();
        root = fs.getRootDirectories().get(0);
    }

    @Test
    public void verifySingleFileFound(){
        visitor = new FileSearchVisitor("a");
        root.accept(visitor);
        LinkedList<File> files = visitor.getFoundFiles();
        assertEquals("a", files.get(0).getName());
    }

    @Test
    public void verifyMultipleFilesFound(){
        String[] expected = {"y", "y"};
        String[] actual = new String[2];
        visitor = new FileSearchVisitor("y");
        root.accept(visitor);
        LinkedList<File> files = visitor.getFoundFiles();

        for(int index=0; index<2; index++){
            actual[index] = files.get(index).getName();
        } 

        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyNoFilesFound(){
        visitor = new FileSearchVisitor("unknown");
        root.accept(visitor);
        LinkedList<File> files = visitor.getFoundFiles();

        assertEquals(0, files.size());
    }
}
