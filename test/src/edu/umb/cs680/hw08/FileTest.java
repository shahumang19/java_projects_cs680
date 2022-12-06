package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class FileTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = TestFixtureInitializer.createFS();
    }

    private String[] fileToStringArray(File f){ 
        String[] fileInfo = {f.getName(), ""+f.getSize(), f.getParent().getName()}; 
        return fileInfo; 
    }

    @Test
    public void verifyXFileSearch(){
        String expected = "x";
        File x = File.searchAndReturnFirstFile(fs, "x");
        assertEquals(expected, x.getName());
    }

    @Test
    public void verifyBFileSearch(){
        String expected = "b";
        File b = File.searchAndReturnFirstFile(fs, "b");
        assertEquals(expected, b.getName());
    }

    @Test
    public void verifyUnknownFileSearch(){
        assertNull(File.searchAndReturnFirstFile(fs, "unknown"));
    }

    @Test
    public void verifyIsFile(){
        assertFalse(File.searchAndReturnFirstFile(fs, "b").isDirectory());
    }

    @Test
    public void verifyXFileEquality(){
        String[] expected = {"x", "20", "apps"};
        File x = File.searchAndReturnFirstFile(fs, "x");
        assertArrayEquals(expected, fileToStringArray(x));
    }

    @Test
    public void verifyAFileEquality(){
        String[] expected = {"a", "200", "pictures"};
        File x = File.searchAndReturnFirstFile(fs, "a");
        assertArrayEquals(expected, fileToStringArray(x));
    }

    @AfterAll
    public static void cleanUp() {
        fs.getRootDirectories().clear();
    }
}
