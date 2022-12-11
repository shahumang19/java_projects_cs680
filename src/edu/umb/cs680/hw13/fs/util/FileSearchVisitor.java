package edu.umb.cs680.hw13.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw13.fs.*;

public class FileSearchVisitor implements FSVisitor {

    String fileName;
    LinkedList<File> foundFiles;


    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
        this.foundFiles = new LinkedList<File>();
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
        if(file.getName().equals(fileName)){
            foundFiles.add(file); }
    }


    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LinkedList<File> getFoundFiles() {
        return this.foundFiles;
    }
    
}
