package edu.umb.cs680.hw15.fs;

import java.util.LinkedList;

public class FileSystem {
    private static LinkedList<Directory> rootDirectories;
    private static FileSystem instance = null;

    private FileSystem(){}

    public static FileSystem getFileSystem(){
        if(FileSystem.instance == null) {
            FileSystem.instance = new FileSystem();
            FileSystem.rootDirectories = new LinkedList<Directory>();
        }
        return instance;
    }

    public void appendRootDirectory(Directory child){
        FileSystem.rootDirectories.add(child);
    }

    public LinkedList<Directory> getRootDirectories(){
        return FileSystem.rootDirectories;
    }
}
