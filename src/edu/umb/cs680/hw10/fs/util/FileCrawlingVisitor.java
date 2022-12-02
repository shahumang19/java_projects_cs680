package edu.umb.cs680.hw10.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw10.fs.*;

public class FileCrawlingVisitor  implements FSVisitor{

    LinkedList<File> files;
    

    public FileCrawlingVisitor() {
        this.files = new LinkedList<File>();
    }

    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
       files.add(file);
    }
    

    public LinkedList<File> getFiles() {
        return this.files;
    }

}
