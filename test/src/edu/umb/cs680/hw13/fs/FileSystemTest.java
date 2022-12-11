package edu.umb.cs680.hw13.fs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class FileSystemTest {
    
    @Test
    public void verifySingleFileSystemInstance(){
        assertSame(FileSystem.getFileSystem(), FileSystem.getFileSystem());
    }

    @Test
    public void verifyRootDirectoryAppend(){
        Directory dir = new Directory(null, "temp");
        FileSystem fs = FileSystem.getFileSystem();

        fs.appendRootDirectory(dir);

        assertSame(dir, fs.getRootDirectories().getLast());
    }

    @AfterAll
    public static void cleanUp() {
        FileSystem.getFileSystem().getRootDirectories().clear();
    }
}
