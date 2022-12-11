package edu.umb.cs680.hw13.fs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.*;

public class DirectoryTest {

    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS(){
        fs = TestFixtureInitializer.createFS();
    }

    private String[] dirToStringArray(Directory d){ 
        String parentName = "";

        if (d.getParent() == null){
            parentName = "null";
        }else{
            parentName = d.getParent().getName();
        }

        String[] dirInfo = {d.getName(), ""+d.getSize(), parentName, 
                            ""+d.countChildren()}; 
        return dirInfo; 
    }

    @Test
    public void verifyRootSearchDirectory(){
        String expected = "root";
        Directory root = Directory.searchAndReturnFirstDirectory(fs, "root");
        assertEquals(expected, root.getName());
    }

    @Test
    public void verifyPicturesSearchDirectory(){
        String expected = "pictures";
        Directory code = Directory.searchAndReturnFirstDirectory(fs, "pictures");
        assertEquals(expected, code.getName());
    }

    @Test
    public void verifyIsDirectory(){
        assertTrue(Directory.searchAndReturnFirstDirectory(fs, "pictures").getFileType() == FileType.DIRECTORY);
    }

    @Test
    public void verifyUnknownSearchDirectory(){
        assertNull(Directory.searchAndReturnFirstDirectory(fs, "unknown"));
    }

    @Test
    public void verifyRootDirectoryEquality(){
        String[] expected = {"root", "0", "null", "5"};
        Directory root = fs.getRootDirectories().get(0);
        assertArrayEquals(expected, dirToStringArray(root));
    }

    @Test
    public void verifyAppDirectoryEquality(){
        String[] expected = {"apps", "0", "root", "1"};
        Directory app = Directory.searchAndReturnFirstDirectory(fs, "apps");
        assertArrayEquals(expected, dirToStringArray(app));
    }

    @Test
    public void verifyRootDirectoryTotalSize(){
        int expected = 570;
        Directory root = Directory.searchAndReturnFirstDirectory(fs, "root");
        assertEquals(expected, root.getTotalSize());
    }

    @Test
    public void verifyPicturesDirectoryTotalSize(){
        int expected = 500;
        Directory code = Directory.searchAndReturnFirstDirectory(fs, "pictures");
        assertEquals(expected, code.getTotalSize());
    }

    @Test
    public void verifyRootDirectoryChildren(){
        String[] expected = {"apps", "bin", "home", "d", "e"};
        Arrays.sort(expected);
        Directory root = Directory.searchAndReturnFirstDirectory(fs, "root");
        String[] actual = new String[5];
        int index = 0;

        for (FSElement element: root.getChildren()){
            actual[index++] = element.getName();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyHomeDirectoryChildren(){
        String[] expected = {"pictures", "c"};
        Arrays.sort(expected);
        Directory home = Directory.searchAndReturnFirstDirectory(fs, "home");
        String[] actual = new String[2];
        int index = 0;
        for (FSElement element: home.getChildren()){
            actual[index++] = element.getName();
        }
        assertArrayEquals(expected, actual);
    }

    // ############### Comparator Test Cases ###################

    @Test
    public void verifyReverseAlphabeticalOrder(){
        String[] expected = {"apps", "bin", "home", "d", "e"};
        Arrays.sort(expected, Collections.reverseOrder());
        Directory root = Directory.searchAndReturnFirstDirectory(fs, "root");
        String[] actual = new String[5];
        int index = 0;

        for (FSElement element: root.getChildren(new ReverseAlphabeticalComparator())){
            actual[index++] = element.getName();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifySizeBasedOrder(){
        String[] expected = {"y", "a", "b"};
        Directory root = Directory.searchAndReturnFirstDirectory(fs, "pictures");
        String[] actual = new String[3];
        int index = 0;

        for (FSElement element: root.getFiles(new SizeComparator())){
            actual[index++] = element.getName();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyTimeStampOrder(){
        String[] expected = {"apps", "bin", "home"};
        Directory root = Directory.searchAndReturnFirstDirectory(fs, "root");
        String[] actual = new String[3];
        int index = 0;

        for (FSElement element: root.getSubDirectories(new TimeStampComparator())){
            actual[index++] = element.getName();
        }
        assertArrayEquals(expected, actual);
    }
    
    @AfterAll
    public static void cleanUp() {
        fs.getRootDirectories().clear();
    }

    
}
