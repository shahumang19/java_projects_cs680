package edu.umb.cs680.hw07;

public class TestFixtureInitializer {
    public static FileSystem createFS(){
        FileSystem fs = FileSystem.getFileSystem();
        Directory root = new Directory(null, "root"); 
        fs.appendRootDirectory(root);

        Directory apps = new Directory(root, "apps"); 
        Directory lib = new Directory(root, "lib"); 
        Directory home = new Directory(root, "home"); 
        Directory code = new Directory(home, "code"); 
        
        File x = new File(apps, "x", 20);
        File y = new File(apps, "y", 30);

        File z = new File(lib, "z", 10);

        File d = new File(home, "d", 100);
        File a = new File(code, "a", 200);
        File b = new File(code, "b", 300);
        File c = new File(code, "c", 20);

        return fs;
    }
}