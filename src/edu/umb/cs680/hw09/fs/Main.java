package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.fs.util.CountingVisitor;
import edu.umb.cs680.hw09.fs.util.FileCrawlingVisitor;
import edu.umb.cs680.hw09.fs.util.FileSearchVisitor;

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
        System.out.println("File2 a directory? : "+file2.isDirectory());
        System.out.println("File3 parent name : "+file3.getParent().getName());
        System.out.println("File2 Link Test : "+file2_link.getTarget().getName());

        System.out.println("Searched Directory : "+Directory.searchAndReturnFirstDirectory(fs, "home").getName());

        CountingVisitor cv = new CountingVisitor();
        root.accept(cv);

        System.out.println("Directory Number : "+cv.getDirNum());
        System.out.println("File Number : "+cv.getFileNum());
        System.out.println("Link Number : "+cv.getLinkNum());

        FileCrawlingVisitor fcv = new FileCrawlingVisitor();
        root.accept(fcv);
        System.out.println("Number of files in system : "+fcv.getFiles().size());

        FileSearchVisitor fsv = new FileSearchVisitor("file2.xml");
        root.accept(fsv);
        System.out.println("Searched number of files in system : "+fsv.getFoundFiles().size());
    }
}
