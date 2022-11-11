package edu.umb.cs680.hw09.fs.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.*;

import edu.umb.cs680.hw09.fs.TestFixtureInitializer;
import edu.umb.cs680.hw09.fs.*;

public class FileCrawlingVisitorTest {
    private static FileSystem fs;
    private static FileCrawlingVisitor visitor;

    @BeforeAll
    public static void setUpFS(){
        fs = TestFixtureInitializer.createFS();
        visitor = new FileCrawlingVisitor();
        Directory root = fs.getRootDirectories().get(0);
        root.accept(visitor);
    }

    @Test
    public void verifyNumberOfFiles(){
        assertEquals(6, visitor.getFiles().size());
    }

    @Test
    public void verifyGetFilesReturnsFiles(){
        boolean[] expected = {false, false, false, false, false};
        boolean[] actual = new boolean[5];
        LinkedList<File> files = visitor.getFiles();

        for(int index=0; index<5; index++){
            actual[index] = files.get(index).isDirectory();
        } 

        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyGetFiles(){
        String[] expected = {"x", "y", "a", "b", "y", "c"};
        String[] actual = new String[6];
        LinkedList<File> files = visitor.getFiles();

        for(int index=0; index<6; index++){
            actual[index] = files.get(index).getName();
        } 

        assertArrayEquals(expected, actual);
    }
}
