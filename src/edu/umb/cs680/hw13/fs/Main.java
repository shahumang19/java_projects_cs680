package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.util.*;
import edu.umb.cs680.hw13.Authentication.*;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = FileSystem.getFileSystem();

        Directory root = new Directory(null, "root"); 
        fs.appendRootDirectory(root);
        Directory home = new Directory(root, "home"); 
        Directory mydir = new Directory(home, "mydir"); 
        File file1 = new File(mydir, "file1.jpg", 20);
        File file2 = new File(home, "file2.xml", 30);
        File file2_copy = new File(root, "file2.xml", 30);
        File file3 = new File(root, "file3.txt", 10);

        Link file2_link = new Link(root, "file2_link", file2);

        System.out.println("Total size : "+root.getTotalSize());
        System.out.println("File1 size : "+file1.getSize());
        System.out.println("File2 a directory? : "+file2.getFileType().label);
        System.out.println("File3 parent name : "+file3.getParent().getName());
        System.out.println("File2 Link Test : "+file2_link.getTarget().getName());

        System.out.println("Searched Directory : "+Directory.searchAndReturnFirstDirectory(fs, "home").getName());

        User user1 = new User(1, "Sheldon Cooper", "scooper2003");
        SecurityContext ctx = new SecurityContext(user1);
        try {
            ctx.login(new EncryptedString(user1.getUsername(), "1234"));

            CountingVisitor cv = new CountingVisitor();
            root.accept(cv, ctx);

            System.out.println("Directory Number : "+cv.getDirNum());
            System.out.println("File Number : "+cv.getFileNum());
            System.out.println("Link Number : "+cv.getLinkNum());

            FileCrawlingVisitor fcv = new FileCrawlingVisitor();
            root.accept(fcv, ctx);
            System.out.println("Number of files in system : "+fcv.getFiles().size());

            FileSearchVisitor fsv = new FileSearchVisitor("file2.xml");
            root.accept(fsv, ctx);
            System.out.println("Searched number of files in system : "+fsv.getFoundFiles().size());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
