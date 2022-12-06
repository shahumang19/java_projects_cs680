package edu.umb.cs680.hw09.fs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class LinkTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = TestFixtureInitializer.createFS();
    }

    private String[] linkToStringArray(Link l){ 
        String[] fileInfo = {l.getName(), ""+l.getSize(), l.getParent().getName(), l.getTarget().getName()}; 
        return fileInfo; 
    }

    @Test
    public void verifyDLinkSearch(){
        String expected = "d";
        Link l = Link.searchAndReturnFirstLink(fs, "d");
        assertEquals(expected, l.getName());
    }

    @Test
    public void verifyUnknownFileSearch(){
        assertNull(Link.searchAndReturnFirstLink(fs, "unknown"));
    }

    @Test
    public void verifyDLinkEquality(){
        String[] expected = {"d", "0", "root", "pictures"};
        Link l = Link.searchAndReturnFirstLink(fs, "d");
        assertArrayEquals(expected, linkToStringArray(l));
    }

    @Test
    public void verifyDLinkTarget(){
        Directory expected = Directory.searchAndReturnFirstDirectory(fs, "pictures");
        Link l = Link.searchAndReturnFirstLink(fs, "d");
        assertSame(expected, l.getTarget());
    }

    @Test
    public void verifyELinkTargetSize(){
        File expected = File.searchAndReturnFirstFile(fs, "x");
        Link l = Link.searchAndReturnFirstLink(fs, "e");
        l.getTarget().setSize(45);
        assertEquals(expected.getSize(), l.getTarget().getSize());
    }

    @AfterAll
    public static void cleanUp() {
        fs.getRootDirectories().clear();
    }
}
